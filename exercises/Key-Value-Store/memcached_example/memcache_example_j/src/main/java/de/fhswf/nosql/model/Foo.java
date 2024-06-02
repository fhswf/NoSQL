package de.fhswf.nosql.model;

import java.io.Serializable;
import java.util.Objects;

public class Foo implements Serializable {

  private Long id;
  private Double random;
  private String hash;


  public Foo(Long id, Double random, String hash) {
    this.id = id;
    this.random = random;
    this.hash = hash;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getRandom() {
    return random;
  }

  public void setRandom(Double random) {
    this.random = random;
  }

  public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Foo foo = (Foo) o;
    return Objects.equals(id, foo.id) && Objects.equals(random, foo.random) && Objects.equals(hash, foo.hash);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, random, hash);
  }
}
