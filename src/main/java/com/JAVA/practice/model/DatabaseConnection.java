package com.JAVA.practice.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class DatabaseConnection implements Serializable {

  //Required
  private String url;
  private String userName;
  private String pass;

  //Optional
  private Integer poolSize;
  private boolean sslEnable;
  private Integer retries;

  private DatabaseConnection(DatabaseConnectionBuilder builder) {
    this.url = builder.getUrl();
    this.userName = builder.getUserName();
    this.pass = builder.getPass();
    this.retries = builder.retries;
    this.sslEnable = builder.sslEnable;
    this.poolSize = builder.poolSize;
  }

  @Data
  public static class DatabaseConnectionBuilder {

    private String url;
    private String userName;
    private String pass;

    //Optional
    private Integer poolSize;
    private boolean sslEnable;
    private Integer retries;


    public DatabaseConnectionBuilder (String url, String userName, String pass) {
      this.url = url;
      this.userName = userName;
      this.pass = pass;
    }


    public DatabaseConnectionBuilder setPoolSize(Integer poolSize) {
      this.poolSize = poolSize;
      return this;
    }

    public DatabaseConnectionBuilder setPoolSslEnable(boolean sslEnable) {
      this.sslEnable = sslEnable;
      return this;
    }

    public DatabaseConnectionBuilder setRetries(Integer retries) {
      this.retries = retries;
      return this;
    }


    public DatabaseConnection build() {
      return new DatabaseConnection(this);
    }

  }


}
