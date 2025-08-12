package javacore.jdbc.repository;

import javacore.jdbc.conn.ConnectionFactory;
import javacore.jdbc.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
@Log4j2
public class ProducerRepository {
    // o para executar qualquer codigo sql lembrar de sempre criar um  Statement e usar o metodo execute
    public static void save(Producer producer) {
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s');".formatted(producer.getName());
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Inserted producer in the database, rows affected '{}'", rowsAffected);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
