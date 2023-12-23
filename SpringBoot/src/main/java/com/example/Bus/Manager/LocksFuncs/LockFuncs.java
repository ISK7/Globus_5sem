package com.example.Bus.Manager.LocksFuncs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import org.apache.commons.dbcp.BasicDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

@SpringBootApplication
public class LockFuncs {
    private BasicDataSource dataSource = new BasicDataSource();

    public LockFuncs() {
        dataSource.setUrl("jdbc:postgresql://localhost:5432/lockmanager");
        dataSource.setUsername("postgres");
        dataSource.setPassword("1234");
    }

    public String newUnlock(int id) {
        Connection con = null;
        ResultSet res = null;
        Statement st = null;
        Date date= new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        try {
            con = dataSource.getConnection();
            st = con.createStatement();
            res = st.executeQuery("INSERT INTO public.unlocks(" +
                    "lo_id, time_)" +
            "VALUES ("+id+", '"+ts+"');");
        }
        catch (SQLException e) { return "execution failed " + e;}
        return "New unlock!";
    }

    public String newUttb(int id, int icode) {
        Connection con = null;
        ResultSet res = null;
        Statement st = null;
        Date date= new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        try {
            con = dataSource.getConnection();
            st = con.createStatement();
            res = st.executeQuery("INSERT INTO public.uttb(" +
                            "\"time\", l_id, uncorrect_code)" +
                    "VALUES ('"+ts+"', "+id+", " + icode + ");");
        }
        catch (SQLException e) { return "execution failed " + e;}
        return "New uttb!";
    }
    public String newLock(int id, int code, String name) {
        Connection con = null;
        ResultSet res = null;
        Statement st = null;
        Date date= new Date();
        try {
            con = dataSource.getConnection();
            st = con.createStatement();
            res = st.executeQuery("INSERT INTO public.locks(" +
                    " id, code, name)" +
                    "VALUES ( "+id+", " + code + ", '" + name +"');");
        }
        catch (SQLException e) { return "execution failed " + e;}
        return "New lock!";
    }
}
