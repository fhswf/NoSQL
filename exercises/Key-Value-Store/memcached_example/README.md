# Memcached

Memcached ist ein Key-Value-Store, der als Cache verwendet wird. Der Store  hält seine Daten direkt im Arbeitespeicher weshalb man auch von einer In-Memory-Datenbank spricht.
Dadurch ist er sehr schnell, aber auch flüchtig. Zudem ist er auf mehrere Server skalierbar, wodurch sich die Kapazität des Stores erhöhen lässt.
Memcached wird häufig in Webanwendungen eingesetzt, um Datenbankzugriffe zu beschleunigen. Hierbei werden die Ergebnisse von Datenbankabfragen im Memcached gespeichert und 
bei Bedarf wieder ausgelesen.


## Beschreibung

In dieser Aufgabe soll eine kleine Anwendunge entwickelt werden, die Memcached verwendet. 
Die Anwendung soll die Ergebnisse von SQL-Abfragen in Memcached speichern und auch wieder auslesen können.


## Memcached API

Memcache besitze eine sehr einfache API, die nur aus wenigen Methoden besteht. Die wichtigsten Methoden sind:

- `memcached_set(key, value)`, `memcached_set(key, value, expiration_time)`: Speichert einen Wert unter einem Schlüssel. Ist `expiration_time` gesetzt wird er Wert nach der angegebenen Zeit gelöscht.
- `memcached_get(key)`: Liest den Wert unter einem Schlüssel aus.
- `memcached_delete(key)`: Löscht den Wert unter einem Schlüssel.
- `memcached_replace(key, value, expiration_time)`, `memcached_replace(key, value, expiration_time)`: Ersetzt den Wert unter einem Schlüssel durch einen neuen Wert. Ist `expiration_time` gesetzt wird er Wert nach der angegebenen Zeit gelöscht.
- `memcached_flush()`: Löscht alle Werte im Memcached.
- `memcached_increment(key, value)`: Inkrementiert den Wert unter einem Schlüssel um den angegebenen Wert. Funktioniert nur mit numerischen Werten.
- `memcached_decrement(key, value)`: Dekrementiert den Wert unter einem Schlüssel um den angegebenen Wert. Funktioniert nur mit numerischen Werten.
- `memcached_append(key, value)`: Hängt einen Wert an den Wert unter einem Schlüssel an. Funktioniert nur mit Zeichenketten.
- `memcached_prepend(key, value)`: Hängt einen Wert an den Wert unter einem Schlüssel an. Funktioniert nur mit Zeichenketten.
- `memcached_add(key, value, expiration_time)`: Fügt einen Wert unter einem Schlüssel hinzu, wenn dieser noch nicht existiert.
- `memcached_cas(key, value, expiration_time)`: Fügt einen Wert unter einem Schlüssel hinzu, wenn dieser noch nicht existiert und der Wert noch nicht geändert wurde.
- `memcached_gets(key)`: Liest den Wert unter einem Schlüssel aus und gibt die Version des Wertes zurück.
- `memcached_touch(key, expiration_time)`: Setzt die Ablaufzeit eines Wertes unter einem Schlüssel neu.


## Vorbereitungen

### MySQL

Als Datenhaltung der Anwendung soll eine MySQL Datenbank verwendet werden. Hierzu wurde ein Docker Image vorbereitet das zunächst einmal gebaut werden muss. Dazu muss ein Terminal im Verzeichnis `database` in diesem Projekt gestartet und folgender Befehl ausgeführt werden

```docker build -t 'mysql_test' . ```

Anschließend kann mit dem folgenden Befehl der Docker Container gestartet werden.

```docker run -d --name mysql -p 3306:3306 mysql_test```

### Memcached

Die Anwendung benötigt zusätzlich einen Memcached-Server. Dieser kann ebenfalls mit einem Docker Container gestartet werden:

```docker run -d --name memcached -p 11211:11211 memcached:1.6.27```

## Arbeitsanweisung

Im Verzeichnis `memcache_example_j` finden Sie ein Java Projekt. Hier müssen die Methoden `selectAllFoos` und `selectFooById` in der Klasse `FooRepository` erweitert werden.

Die Methode `selectAllFoos` soll eine Liste mit allen in der Datenbank verfügbaren Foos ausgeben. Die Datenbank kann über das Attribut `mySqlConnection` angesprochen werden. Eine entsprechende Abfrage ist als Konstante `SELECT_ALL_FOOS` ebenfalls vorhanden.
Anschließend sollen die Ergebnisse in Memcached für eine bestimmte Zeit, z.B. 5 Minuten, gespeichert werden. Memcached kann über das Attribut `memcachedClient` angesprochen werden. Beachte, dass bei wiederholten Aufrufen der Methode die Daten aus dem Cache und nicht aus der Datenbank geladen werden sollten.
Dasselbe ist auch für die Methode `selectFooById` umzusetzen, wobei hier zu beachten ist, dass ein bestimmtes Foo mit einer ID zu identifizieren ist.

Überprüfen können Sie Ihre Lösung mit den Test in der Testklasse `FooRepositoryTest`.