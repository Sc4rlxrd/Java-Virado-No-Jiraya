package javacore.jdbc.listener;

import lombok.extern.log4j.Log4j2;

import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import java.sql.SQLException;

@Log4j2
public class CustomRowSetListener implements RowSetListener {
    @Override
    public void rowSetChanged(RowSetEvent rowSetEvent) {
        log.info("Command execute triggered");
    }

    @Override
    public void rowChanged(RowSetEvent rowSetEvent) {
            log.info("Row inserted, updated or deleted ");
        if (rowSetEvent.getSource() instanceof RowSet) {
            try {
                ((RowSet) rowSetEvent.getSource()).execute();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

    @Override
    public void cursorMoved(RowSetEvent rowSetEvent) {
            log.info("Cursor moved");
    }
}
