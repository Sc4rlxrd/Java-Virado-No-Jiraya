package javacore.jdbc.repository;

import javacore.jdbc.conn.ConnectionFactory;
import javacore.jdbc.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ProducerRepository {
    // O para executar qualquer código sql lembrar de sempre criar um Statement e usar o metodo execute.
    // O ResultSet encapsula os dados retornados pela consulta SQL num formato que pode ser manipulado pela aplicação Java

    public static void save(Producer producer) {
        log.info("Creating producer");
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s');".formatted(producer.getName());
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Inserted producer '{}' in the database, rows affected '{}'", producer.getName(), rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to insert producer '{}'", producer.getName(), e);
        }
    }

    public static void delete(int id) {
        log.info("Deleting producer");
        String sql = "DELETE FROM `anime_store`. `producer` WHERE (`id` = '%d');".formatted(id);
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Delete producer '{}' from the database, rows affected '{}'", id, rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to insert producer '{}'", id, e);
        }
    }

    public static void update(Producer producer) {
        log.info("Updating producer");
        String sql = "UPDATE `anime_store`.`producer` SET `name` = '%s ' WHERE (`id` = '%d');".formatted(producer.getName(), producer.getId());
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Updated producer '{}' , rows affected '{}'", producer.getId(), rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to update producer '{}'", producer.getId(), e);
        }
    }

    public static List<Producer> findAll() {
        log.info("Finding all Producers");
        String sql = "SELECT id, name FROM anime_store . producer;";
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Producer producer = Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all  producer ", e);
        }
        return producers;
    }

    public static List<Producer> findByName(String name) {
        log.info("Finding Producer by name ");
        String sql = "SELECT * FROM anime_store . producer where name like '%%%s%%';".formatted(name);
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Producer producer = Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            log.error("Error while trying to find producer by name ", e);
        }
        return producers;
    }

    public static void showProducerMetaData() {
        log.info("Showing Producer MetaData");
        String sql = "SELECT * FROM anime_store . producer";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            ResultSetMetaData rsMetaData = rs.getMetaData();
            rs.next();
            int columnCount = rsMetaData.getColumnCount();
            log.info("Columns count '{}'", columnCount);
            for (int i = 1; i <= columnCount; i++) {
                log.info("Table name '{}'", rsMetaData.getTableName(i));
                log.info("Column name '{}'", rsMetaData.getColumnName(i));
                log.info("Column size '{}'", rsMetaData.getColumnDisplaySize(i));
                log.info("Column type '{}'", rsMetaData.getColumnTypeName(i));
            }
        } catch (SQLException e) {
            log.error("Error trying to fetch metadata. ", e);
        }
    }

    public static void showDriverMetaData() {
        log.info("Showing Driver MetaData");
        String sql = "SELECT * FROM anime_store . producer";
        try (Connection conn = ConnectionFactory.getConnection()) {
            DatabaseMetaData dbMetaData = conn.getMetaData();
            if (dbMetaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                log.info("Supports TYPE_FORWARD_ONLY");
                if (dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("And Supports CONCUR_UPDATABLE");
                }
            }
            if (dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                log.info("Supports TYPE_SCROLL_INSENSITIVE ");
                if (dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("And Supports CONCUR_UPDATABLE  ");
                }
            }
            if (dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                log.info("Supports TYPE_SCROLL_SENSITIVE ");
                if (dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("And Supports CONCUR_UPDATABLE ");
                }
            }
        } catch (SQLException e) {
            log.error("Error trying to fetch metadata. ", e);
        }
    }

    public static void showTypeScrollWorking() {
        log.info("Show Type Scroll Working");
        String sql = "SELECT * FROM anime_store . producer";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            // vai para o último
            log.info("Last row? '{}'", rs.last());
            log.info("Row number '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
            log.info("------------------");
            // vai para o primeiro
            log.info("First row? '{}'", rs.first());
            log.info("Row number '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
            log.info("------------------");
            // absolute seria qual posição que gostaria que o result comece
            log.info("Row absolute? '{}'", rs.absolute(2));
            log.info("Row number '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
            log.info("------------------");
            // o relative seria voltar uma posição, tipo estou no absolute 2 quero voltar para 1 passa o parâmetro -1 nele
            log.info("Row relative? '{}'", rs.relative(-1));
            log.info("Row number '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
            log.info("------------------ TESTANDO O isAfterLast ------------------");
            // O isAfterLast e isBeforeFirst têm o mesmo objetivo, tipo, quero começar do último para o primeiro.
            // Ele vai ignorar a última linha mesmo ela com valor, agora se eu usar o isAfterLast ele vai uma casa a mais,
            // assim ele vai mostrar todos os conteúdos. O mesmo se aplica no isBeforeFirst,
            // só que ele aplica no primeiro elemento da query.
            log.info("is last? '{}'", rs.isLast());
            log.info("Row number '{}'", rs.getRow());
            log.info("--");
            log.info("is first? '{}'", rs.isFirst());
            log.info("Row number '{}'", rs.getRow());
            log.info("--");
            log.info("Last row? '{}'", rs.last());
            log.info("---");
            rs.next();
            log.info("After last row? '{}'", rs.isAfterLast());
            while (rs.previous()) {
                log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
            }
        } catch (SQLException e) {
            log.error("Error when playing showing scroll type working. ", e);
        }
    }

    public static List<Producer> findByNameAndToUpperCase(String name) {
        log.info("Updating the offered name to uppercase.");
        String sql = "SELECT * FROM anime_store . producer where name like '%%%s%%';".formatted(name);
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                // Lembrando que o resultset salva tudo que traz na memória.
                // Obs. Sempre que usar o updateString ou ‘update’ alguma coisa atualizar a célula/ row.
                // Caso esqueça de atualizar a row ele sempre vai retornar o valor antigo da row.
                // toLowerCase funciona da mesma forma que toUpperCase.
                rs.updateString("name", rs.getString("name").toUpperCase());
                rs.updateRow();
                Producer producer = Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            log.error("Error while trying to find producer by name ", e);
        }
        return producers;
    }

    public static void findByNameAndDelete(String name) {
        log.info("Finding Producer to deleting");
        String sql = "SELECT * FROM anime_store . producer where name like '%%%s%%';".formatted(name);
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                log.info("Deleting '{}'", rs.getString("name"));
                rs.deleteRow();
                // o deleteRow não precisar de persistência de dados.
            }
        } catch (SQLException e) {
            log.error("Error while trying to find producer by name ", e);
        }
    }

    public static List<Producer> findByNameAndInsertWhenNotFound(String name) {
        log.info("Finding Producer ");
        String sql = "SELECT * FROM anime_store . producer where name like '%%%s%%';".formatted(name);
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            if (!rs.next()) {
                rs.moveToInsertRow();
                rs.updateString("name", name);
                rs.insertRow();
                rs.beforeFirst();
                rs.next();
                Producer producer = Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            log.error("Error while trying to find producer by name ", e);
        }
        return findByNameAndToUpperCase(name);
    }

    public static List<Producer> findByNamePreparedStatement(String name) {
        log.info("Searching by name using prepared statement with pre-compiled sql.");
        String sql = "SELECT * FROM anime_store.producer where name like ?;";
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createdPreparedStatement(conn, sql, name);
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

    private static PreparedStatement createdPreparedStatement(Connection conn, String sql, String name) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(sql);
        // dessa forma o ‘like’ para de funcionar → ‘like’ seria ele procurar o nome dados as iniciais do nome
//        ps.setString(1, name);
        // esse com concat funciona o ‘like’ perfeitamente.
        ps.setString(1, "%" + name + "%");
        return ps;
    }

    public static void updatePreparedStatement(Producer producer) {
        log.info("Update Prepared Statement ");
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createdPreparedStatementUpdate(conn,producer);) {
            int rowsAffected = ps.executeUpdate();
            log.info("Update producer '{}' , rows affected '{}'", producer.getId(), rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to update producer '{}'", producer.getId(), e);
        }
    }
    private static PreparedStatement createdPreparedStatementUpdate(Connection conn, Producer producer) throws SQLException {
        String sql = "UPDATE `anime_store`.`producer` SET `name` = ? WHERE (`id` = ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, producer.getName());
        ps.setInt(2, producer.getId());
        return ps;
    }
}
