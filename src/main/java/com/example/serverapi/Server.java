package com.example.serverapi;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Data
@Document(collection = "servers")
public class Server {

    @Id
    private String id;
    private String name;
    private String language;
    private String framework;

    // Getters, setters, and constructors
}