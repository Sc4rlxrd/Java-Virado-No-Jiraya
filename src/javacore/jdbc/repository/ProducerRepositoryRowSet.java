package javacore.jdbc.repository;

import javacore.jdbc.conn.ConnectionFactory;
import javacore.jdbc.dominio.Producer;
import javacore.jdbc.listener.CustomRowSetListener;
import lombok.extern.log4j.Log4j2;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Log4j2
public class ProducerRepositoryRowSet {

    public static List<Producer> findByNameJdbcRowSet(String name) {
        String sql = "SELECT * FROM anime_store.producer where name like ?;";
        List<Producer> producers = new ArrayList<>();
        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()) {
            jrs.addRowSetListener(new CustomRowSetListener());
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

    public static void updateJdbcRowSet(Producer producer) {
        String sql = "SELECT * FROM anime_store.producer WHERE (`id` = ?);";
        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()) {
            // RowSetListener serve para ter mais informações de rowset sobrescrevendo três metodos
            jrs.addRowSetListener(new CustomRowSetListener());
            jrs.setCommand(sql);
            jrs.setInt(1, producer.getId());
            jrs.execute();
            if (!jrs.next()) return;
            jrs.updateString("name", producer.getName());
            jrs.updateRow();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void updateCachedRowSet(Producer producer) {
        // obs. lembrar que remover a referencia do anime_store é deixar somente a table que vai mudar
        String sql = "SELECT * FROM producer WHERE (`id` = ?);";
        try (CachedRowSet crs = ConnectionFactory.getCacheRowSet(); Connection connection = ConnectionFactory.getConnection()) {
            connection.setAutoCommit(false);   // esse autoCommit para ele lançar um erro de sql invalid
            crs.setCommand(sql);
            crs.setInt(1, producer.getId());
            crs.execute(connection);
            if (!crs.next()) return;
            crs.updateString("name", producer.getName());
            crs.updateRow();     // somente o updateRow não é o suficiente precisar lembrar de colocar no final de tudo o acceptChanges para lançar as mudanças ao banco de dados.
            crs.acceptChanges();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


