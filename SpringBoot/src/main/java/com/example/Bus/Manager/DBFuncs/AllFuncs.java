package com.example.Bus.Manager.DBFuncs;

import javax.sql.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.sql.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.SynchronousQueue;

import com.example.Bus.Manager.LocksFuncs.LockFuncs;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;


@RestController
@SpringBootApplication
public class AllFuncs implements CommandLineRunner {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    private DataSource dataSource;

    @RequestMapping(value = "/locks", method = RequestMethod.GET)
    public String locks() {
        Connection con = null;
        ResultSet res = null;
        Statement st = null;
        String result = "";
        try {
            con = dataSource.getConnection();
            st = con.createStatement();
            res = st.executeQuery("SELECT * FROM locks");
        }
        catch (SQLException e) { return "connection failed";}
        try {
            while (res.next()) {
                int id = res.getInt("id");
                String str = res.getString("name");
                result += "ID: " + id + " Name: " + str + "<br>";
            }
        } catch (SQLException e) {
            return "execution failed";
        }
        return result;
    }

    @RequestMapping(value = "/unlocks", method = RequestMethod.GET)
    public String selectUnl() {
        Connection con = null;
        ResultSet res = null;
        Statement st = null;
        String result = "";
        try {
            con = dataSource.getConnection();
            st = con.createStatement();
            res = st.executeQuery("SELECT * FROM unlocks");
        }
        catch (SQLException e) { return "connection failed";}
        try {
            while (res.next()) {
                int id = res.getInt("lo_id");
                Timestamp ts = res.getTimestamp("time_");
                String time = ts.toString();
                result += "ID: " + id + " Time: " + time +"<br>";
            }
        } catch (SQLException e) {
            return "execution failed";
        }
        return result;
    }

    @RequestMapping(value = "/uttbs", method = RequestMethod.GET)
    public String selectUttb() {
        Connection con = null;
        ResultSet res = null;
        Statement st = null;
        String result = "";
        try {
            con = dataSource.getConnection();
            st = con.createStatement();
            res = st.executeQuery("SELECT * FROM uttb");
        }
        catch (SQLException e) { return "connection failed";}
        try {
            while (res.next()) {
                int id = res.getInt("l_id");
                Timestamp ts = res.getTimestamp("time");
                String time = ts.toString();
                int ucode = res.getInt("uncorrect_code");
                result += "ID: " + id + " Time: " + time + " Incorrect code: " + ucode + "<br>";
            }
        } catch (SQLException e) {
            return "execution failed";
        }
        return result;
    }

   // @RequestMapping(value = "/test", method = RequestMethod.GET)
    @Override
    public void run(String... args) throws Exception {
        LockFuncs lf = new LockFuncs();
        System.out.println(lf.newUnlock(1));
        System.out.println(lf.newUttb(2,1111));
        System.out.println(lf.newLock(4,5959,"Candy closet"));
        //LocalTime time = LocalTime.now();
       // String sql = "INSERT INTO uttb (time, l_id, uncorrect_code) VALUES ('2023-05-22 10:10:11', 1, 3214);";
      //  int result = jdbcTemplate.update(sql );

       // if (result > 0) {
       //     System.out.println("Insert successfully.");
       // }
    }
}
