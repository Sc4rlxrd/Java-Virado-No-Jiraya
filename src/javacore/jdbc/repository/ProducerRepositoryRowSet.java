package javacore.jdbc.repository;

import javacore.jdbc.conn.ConnectionFactory;
import javacore.jdbc.dominio.Producer;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.rowset.JdbcRowSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ProducerRepositoryRowSet {

    public static List<Producer> findByNameJdbcRowSet(String name) {
        String sql = "SELECT * FROM anime_store.producer where name like ?;";
        List<Producer> producers = new ArrayList<>();
        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()) {
            jrs.setCommand(sql);
            // essa parte melhorou porque não precisar criar outro metodo para transaformar  ? no valor oferecido na classe main
            jrs.setString(1, String.format("%%%s%%", name));
            // o execute só tem a função de trazer/ mostras dados nada mais
            jrs.execute();
            while (jrs.next()) {
                Producer producer = Producer.builder().id(jrs.getInt("id")).name(jrs.getString("name")).build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            log.info("Erro ", e);
        }
        return producers;
    }
    public static List<Producer> findAll() {
        String sql = "SELECT id, name FROM anime_store . producer;;";
        List<Producer> producers = new ArrayList<>();
        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()) {
            jrs.setCommand(sql);
            jrs.execute();
            while (jrs.next()) {
                Producer producer = Producer.builder().id(jrs.getInt("id")).name(jrs.getString("name")).build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            log.info("Erro ", e);
        }
        return producers;
    }
}
