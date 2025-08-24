package javacore.crud.repository;

import javacore.crud.conn.ConnectionFactory;
import javacore.crud.dominio.Anime;
import javacore.crud.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
public class AnimeRepository {

    public static List<Anime> findByName(String name) {
        log.info("Finding Anime by name '{}'", name);
        List<Anime> animes = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement ps = createPrepareStatementFindByName(conn, name); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Producer producer = Producer.builder().name(rs.getString("producer_name")).id(rs.getInt("producer_id")).build();
                Anime anime = Anime.builder().id(rs.getInt("id")).name(rs.getString("name")).episodes(rs.getInt("episodes")).producer(producer).build();
                animes.add(anime);
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all animes", e);
        }
        return animes;
    }

    private static PreparedStatement createPrepareStatementFindByName(Connection conn, String name) throws SQLException {
        String sql = """
                SELECT a.id, a.name, a.episodes, a.producer_id, p.name as 'producer_name' FROM anime_store.anime a inner join
                anime_store.producer p on a.producer_id = p.id
                where a.name like ?;
                """;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, String.format("%%%s%%", name));
        return ps;
    }


    public static void delete(int id) {
        log.info("Deleting anime");
        try (Connection conn = javacore.jdbc.conn.ConnectionFactory.getConnection(); PreparedStatement ps = PreparedStatementDelete(conn, id)) {
            ps.execute();
            log.info("Delete anime '{}' from the database'", id);
        } catch (SQLException e) {
            log.error("Error while trying to delete anime '{}'", id, e);
        }
    }

    private static PreparedStatement PreparedStatementDelete(Connection conn, Integer id) throws SQLException {
        String sql = "DELETE FROM `anime_store`. `anime` WHERE (`id` = ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }

    public static void save(Anime anime) {
        log.info("Saving anime");
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement ps = PreparedStatementSave(conn, anime)) {
            ps.execute();
        } catch (SQLException e) {
            log.error("Error while trying to insert anime ", e);
        }
    }

    private static PreparedStatement PreparedStatementSave(Connection conn, Anime anime) throws SQLException {
        String sql = "INSERT INTO `anime_store`.`anime` (`name`, `episodes`, `producer_id`) VALUES ( ?, ?, ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, anime.getName());
        ps.setInt(2, anime.getEpisodes());
        ps.setInt(3, anime.getProducer().getId());
        return ps;
    }

    public static Optional<Anime> findById(Integer id) {
        log.info("looking for anime id");
        try (Connection conn = javacore.jdbc.conn.ConnectionFactory.getConnection(); PreparedStatement ps = PreparedStatementFindById(conn, id)) {
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) return Optional.empty();
            Producer producer = Producer.builder().name(rs.getString("producer_name")).id(rs.getInt("producer_id")).build();
            Anime anime = Anime.builder().id(rs.getInt("id")).name(rs.getString("name")).episodes(rs.getInt("episodes")).producer(producer).build();
            return Optional.of(anime);
        } catch (SQLException e) {
            log.error("Error while trying to finding anime '{}'", id, e);
        }
        return Optional.empty();
    }

    private static PreparedStatement PreparedStatementFindById(Connection conn, Integer id) throws SQLException {
        String sql = """
                SELECT a.id, a.name, a.episodes, a.producer_id, p.name as 'producer_name' FROM anime_store.anime a inner join
                anime_store.producer p on a.producer_id = p.id
                where a.id = ?;
                """;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }

    public static void update(Anime anime) {
        log.info("updating anime '{}'", anime);
        try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement ps = PreparedStatemenUpdate(conn, anime)) {
            ps.execute();
        } catch (SQLException e) {
            log.error("Error while trying to update anime ", e);
        }
    }

    private static PreparedStatement PreparedStatemenUpdate(Connection conn, Anime anime) throws SQLException {
        String sql = "UPDATE `anime_store`.`anime` SET `name` = ?, `episodes` = ? WHERE (`id` = ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, anime.getName());
        ps.setInt(2, anime.getEpisodes());
        ps.setInt(3, anime.getId());
        return ps;
    }
}
