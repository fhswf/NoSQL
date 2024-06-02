package de.fhswf.nosql;

import de.fhswf.nosql.persistence.FooRepository;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ContextHolder {

  private static final Logger log = LoggerFactory.getLogger(ContextHolder.class);

  public static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/example";
  public static final String CONNECTION_USER = "root";
  public static final String CONNECTION_PASSWORD = "secret";

  private static Connection mySqlConnection;
  private static MemcachedClient memcachedClient;
  private static FooRepository fooRepository;

  public static Connection getSQLConnection() {
    if (mySqlConnection == null) {
      try {
        mySqlConnection = DriverManager.getConnection(CONNECTION_URL, CONNECTION_USER, CONNECTION_PASSWORD);
        log.debug("Connected to database");
      } catch (SQLException e) {
        log.error("Error connecting to database", e);
      }
    }
    return mySqlConnection;
  }

  public static MemcachedClient getMemcachedClient() {
    if (memcachedClient == null) {
      try {
        memcachedClient = new XMemcachedClient("localhost", 11211);
        log.debug("Connected to memcached");
      } catch (IOException e) {
        log.error("Error connecting to memcached", e);
      }
    }
    return memcachedClient;
  }

  public static FooRepository getFooRepository() {
    if (fooRepository == null) {
      fooRepository = new FooRepository(getSQLConnection(), getMemcachedClient());
    }
    return fooRepository;
  }

}
