# Gruppenübung

Überlegen Sie in Gruppen für die im Folgenden beschriebenen Anwendungsszenarien, wie man diese mithilfe einer relationalen Datenbank umsetzt, und stellen Sie das Design 
anschließend im Plenum vor.

Diskutieren Sie insbesondere folgende Punkte:
- Wo sind die Eigenschaften einer relationalen Datenbank hilfreich, und wo sind sie eher hinderlich?
- Welches "Feature" würden Sie sich für den Anwendungsfall wünschen?


## Szenario 1: Genealogische Datenbank

In einer Datenbank sollen Personen mit den Attributen

- ID
- Name
- Geburtsdatum
- Geschlecht

gespeichert werden. Außerdem sollen in einer zweiten Tabelle Eltern-Kind-Beziehungen zwischen den Personen gespeichert werden.

Die Anwendung soll es ermöglichen, 
- zu einer Person alle Nachkommen und Vorfahren zu bestimmen,
- für zwei Personen zu entscheiden, ob sie verwandt sind.

## Szenario 2: Wetterdaten

Eine Anwendung soll Daten von Wetterstationen sammeln und auswerten.
Jede Station liefert dabei alle 15 Minuten folgende Daten:

- Stations-ID
- Zeitpunkt der Messung (UTC)
- Temperatur
- Luftdruck
- relative Luftfeuchtigkeit

Die Anwendung soll den Verlauf dieser Werte für die letzten fünf Tage als Graph darstellen können.
Zusätzlich soll Sie für das letzte Jahr einen Graphen der täglichen Höchst- und Tiefsttemperatur sowie des durchschnittlichen Luftdrucks anzeigen.

## Szenario 3: Session-Handling für einen Web-Shop

In einem Web-Shop sollen Session-Informationen in einer Datenbank gespeichert werden. 
Zu einer Session sollen dabei der angemeldete Benutzer und der Inhalt des Warenkorbs gespeichert werden. 

Das Backend der Webanwendung 
soll dabei *horizontal skalierbar* sein, d.h. laufen parallel mehrere Instanzen des Backends, und ein vorgeschalteter Load-Balancer verteilt 
Requests auf die einzelnen Instanzen.

## Szenario 4: Dokumentendatenbank für Retrieval Augmented Generation (RAG)

[Retrieval Augmented Generation](https://en.wikipedia.org/wiki/Prompt_engineering#Retrieval-augmented_generation) ist ein relativ 
neuer Ansatz, der es Sprachmodellen erlaubt, auf eine *Wissensbasis* zuzugreifen.

Dazu wird vorab zu den Dokumenten der Wissensbasis – etwa eine umfangreiche FAQ-Sammlung – mithilfe eines *Embedding Models* jeweils ein
(hochdimensionaler) Vektor berechnet und in einer Datenbank gespeicher. 
Gibt ein Benutzer eine Frage ein, so wird auch für diese ein entsprechender Vektor berechnet und in der Datenbank die "naheliegendsten" Dokumente
bestimmt. Mithilfe der zugehörigen Dokumente (und der Frage) wird dann ein Prompt für ein Sprachmodell gebildet, um die Frage zu beantworten.

Überlegen Sie, wie die Speicherung der Dokentenvektoren und die Suche mithilfe einer Datenbank implementiert werden kann.
