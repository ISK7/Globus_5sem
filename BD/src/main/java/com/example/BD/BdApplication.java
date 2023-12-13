package com.example.BD;
import igor.kiselev.BD.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@SpringBootApplication
public class BdApplication {

	public static void main(String[] args) {
		//String url = "jdbc:postgresql://localhost:5432/database";
		String url = "jdbc:postgresql://localhost:5432/database";
		String username = "postgres";
		String password = "1234";
		BD bd = new BD();

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String arg = br.readLine();
			bd.run(url, username, password, arg);

		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}
