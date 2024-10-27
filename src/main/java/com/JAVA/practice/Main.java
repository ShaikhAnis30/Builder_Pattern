package com.JAVA.practice;

import com.JAVA.practice.model.DatabaseConnection;

public class Main {

  public static void main(String[] args) {
    DatabaseConnection connectionWithRequiredFields = new DatabaseConnection.DatabaseConnectionBuilder(
        "jdbc://localhost:4000", "root", "pass").build();

    DatabaseConnection connectionWithOptionalFields = new DatabaseConnection.DatabaseConnectionBuilder(
        "jdbc://localhost:4000", "root", "pass")
        .setPoolSize(10)
        .setRetries(3)
        .setPoolSslEnable(true)
        .build();

    System.out.println("Required ----->  " + connectionWithRequiredFields);

    System.out.println("Optional ----->  " + connectionWithOptionalFields);

  }
}