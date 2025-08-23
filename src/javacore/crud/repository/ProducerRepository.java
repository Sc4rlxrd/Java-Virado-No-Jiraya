package javacore.crud.repository;

import javacore.crud.conn.ConnectionFactory;
import javacore.crud.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        ps.setString(1, String.format("%%%s%%",name));
        return ps;
    }
}
