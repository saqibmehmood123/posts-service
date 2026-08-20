package com.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@SpringBootApplication
public class PostsApplication {

	public static void main(String[] args) {

System.out.println("DB URL: " + System.getenv("SPRING_DATASOURCE_URL"));
    System.out.println("DB User: " + System.getenv("SPRING_DATASOURCE_USERNAME"));
    try (Connection conn = DriverManager.getConnection(
            System.getenv("SPRING_DATASOURCE_URL"),
            System.getenv("SPRING_DATASOURCE_USERNAME"),
            System.getenv("SPRING_DATASOURCE_PASSWORD"))) {
        System.out.println("DB connection successful!");
    } catch (Exception e) {
        System.err.println("DB connection failed: " + e.getMessage());
        e.printStackTrace();
    }



		SpringApplication.run(PostsApplication.class, args);
	}

}


/*
docker start my-mysql
docker exec -it my-mysql mysql -u root -p"mysecretpassword"
use myappdb
*/
