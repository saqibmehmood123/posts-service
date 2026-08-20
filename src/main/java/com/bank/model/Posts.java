package com.bank.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;


@Entity
///@Table(name = "CUSTOMERS") // Oracle prefers uppercase table names
@Table(name = "posts")

@Data // Lombok annotation (generates getters/setters)

public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    private String title;
    private String body;
    private String author;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /*
    id: 10 ,
    title: 'Going to Pakistan',
    body: ' ramzan ',
    author: 'Nasir Mehmood',
    createdAt: "2026-02-01",
*/


}