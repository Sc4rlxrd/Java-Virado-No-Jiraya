package javacore.crud.repository;

import javacore.crud.conn.ConnectionFactory;
import javacore.crud.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
public class ProducerRepository {
    public static List<Producer> findByName(String name) {
        log.info("Searching by name using prepared statement with pre-compiled sql from the crud paste.");
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createdPreparedStatement(conn, name);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Producer producer = Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            log.error("Error while trying to find producer by name ", e);
        }
        return producers;
    }

    private static PreparedStatement createdPreparedStatement(Connection conn, String name) throws SQLException {
        String sql = "SELECT * FROM anime_store.producer where name like ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, String.format("%%%s%%", name));
        return ps;
    }

    public static void delete(int id) {
        log.info("Deleting producer");
        try (Connection conn = javacore.jdbc.conn.ConnectionFactory.getConnection();
             PreparedStatement ps = PreparedStatementDelete(conn, id)) {
            ps.execute();
            log.info("Delete producer '{}' from the database'", id);
        } catch (SQLException e) {
            log.error("Error while trying to insert producer '{}'", id, e);
        }
    }

    private static PreparedStatement PreparedStatementDelete(Connection conn, Integer id) throws SQLException {
        String sql = "DELETE FROM `anime_store`. `producer` WHERE (`id` = ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }

    public static void save(Producer producer) {
        log.info("Saving producer");
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = PreparedStatementSave(conn, producer)) {
            ps.execute();
        } catch (SQLException e) {
            log.error("Error while trying to insert producer ", e);
        }
    }

    private static PreparedStatement PreparedStatementSave(Connection conn, Producer producer) throws SQLException {
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES (?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, producer.getName());
        return ps;
    }

    public static Optional<Producer> findById(Integer id) {
        log.info("looking for producer id");
        try (Connection conn = javacore.jdbc.conn.ConnectionFactory.getConnection();
             PreparedStatement ps = PreparedStatementFindById(conn, id)) {
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) return Optional.empty();
            return Optional.of(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
        } catch (SQLException e) {
            log.error("Error while trying to finding producer '{}'", id, e);
        }
        return Optional.empty();
    }

    private static PreparedStatement PreparedStatementFindById(Connection conn, Integer id) throws SQLException {
        String sql = "SELECT *  FROM `anime_store`. `producer` WHERE (`id` = ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }

    public static void update(Producer producer) {
        log.info("updating producer '{}'", producer);
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = PreparedStatemenUpdate(conn, producer)) {
            ps.execute();
        } catch (SQLException e) {
            log.error("Error while trying to update producer ", e);
        }
    }

    private static PreparedStatement PreparedStatemenUpdate(Connection conn, Producer producer) throws SQLException {
        String sql = "UPDATE `anime_store`.`producer` SET `name` = ? WHERE (`id` = ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, producer.getName());
        ps.setInt(2, producer.getId());
        return ps;
    }
}
