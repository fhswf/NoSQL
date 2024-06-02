package de.fhswf.nosql.persistence;

import de.fhswf.nosql.model.Foo;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class FooRepository {

  private static final Logger log = LoggerFactory.getLogger(FooRepository.class);

  private static final String SELECT_ALL_FOOS = "SELECT * FROM FOO";
  private static final String SELECT_FOO = "SELECT * FROM FOO WHERE id = ?";

  private final Connection mySqlConnection;
  private final MemcachedClient memcachedClient;

  public FooRepository(Connection mySqlConnection, MemcachedClient memcachedClient) {
    this.mySqlConnection = mySqlConnection;
    this.memcachedClient = memcachedClient;
  }

  public List<Foo> selectAllFoos() {
    List<Foo> foos = null;

    // TODO: Hier ist Platz für Ihre Lösung
    // Eine Beispiellösung finden Sie auskommentiert weiter untern








//    try {
//      // Lädt die Liste der Foos aus dem Cache
//      foos = memcachedClient.get("allFoos");
//
//      if(foos == null) {
//        // Falls die Liste der Foos nicht im Cache vorhanden ist, wird sie aus der Datenbank geladen
//        foos = new ArrayList<>();
//
//        PreparedStatement stmt = mySqlConnection.prepareStatement(SELECT_ALL_FOOS);
//        ResultSet rs = stmt.executeQuery();
//        while (rs.next()) {
//          foos.add(new Foo(rs.getLong("id"), Double.parseDouble(rs.getString("RANDOM")), rs.getString("HASH")));
//        }
//
//        // Speichert die Liste der Foos für 5 Minuten im Cache
//        memcachedClient.set("allFoos", 300, foos);
//      }
//    }catch (SQLException e) {
//      log.error("Error connecting to database", e);
//    } catch (MemcachedException | TimeoutException | InterruptedException e) {
//      log.error("Error connecting to memcached", e);
//    }

    return foos;
  }

  public Foo selectFooById(Long id) {
    Foo foo = null;

    // TODO: Hier ist Platz für Ihre Lösung
    // Eine Beispiellösung finden Sie auskommentiert weiter untern








//    try {
//      // Lädt ein Foo aus dem Cache
//      foo = memcachedClient.get(String.format("foo_%d", id));
//
//      if(foo == null) {
//        // Falls das Foo nicht im Cache vorhanden ist, wird es aus der Datenbank geladen
//        PreparedStatement stmt = mySqlConnection.prepareStatement(SELECT_FOO);
//        stmt.setLong(1, id);
//        ResultSet rs = stmt.executeQuery();
//        if (rs.next()) {
//          foo = new Foo(rs.getLong("id"), Double.parseDouble(rs.getString("RANDOM")), rs.getString("HASH"));
//
//          // Speichert das Foo für 5 Minuten im Cache
//          memcachedClient.set(String.format("foo_%d", id), 300, foo);
//        }
//      }
//    } catch (SQLException e) {
//      log.error("Error connecting to database", e);
//    } catch (MemcachedException | TimeoutException | InterruptedException e) {
//      log.error("Error connecting to memcached", e);
//    }

    return foo;
  }
}
