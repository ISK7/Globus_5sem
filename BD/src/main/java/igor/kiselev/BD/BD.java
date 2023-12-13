package igor.kiselev.BD;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class BD {
    private Statement stmt;


//    @Autowired
//    private JdbcTemplate jdbcTemplate;
    private Connection c;

    public void run(String url, String user, String password, String args) throws Exception {
        c = DriverManager.getConnection(url, user, password);
        stmt = c.createStatement();

        write(args);
        read();
    }

    private void write(String str) throws Exception {
        //String sql = "SELECT * FROM test";
        stmt.execute(str);
    }
    private void read() throws Exception {
        String sql = "SELECT * FROM test";
        ResultSet resultSet = stmt.executeQuery(sql);
        while (resultSet.next()) {
            int first = resultSet.getInt("first");
            String second = resultSet.getString("second");
            System.out.println(first + " | " + second);
        }
    }
}
