# NoSQL Zeitreihendatenbanken
## Beispielcode

In diesem Verzeichnis finden Sie Beispielcode zum Arbeiten mit Zeitreihendatenbanken.

Bei dem Beispiel handelt es sich um ein Jupyter-Notebook, welches Python-Code enthält, der mit einer konfigurierten InfluxDB-Instanz verbindet. Der Code liest Messwerte zum Stromverbrauch aus einer CSV-Datei aus und trägt die Werte in einen Bucket der InfluxDB ein. Anschließend wird unter Verwendung der `fbprophet` Bibliothek eine Prognose über die zukünftige Entwicklung des Stromverbrauchs erstellt.

## Abhängigkeiten
- Jupyter Labs Instanz mit Python 3 Kernel
- InfluxDB 2 OSS Instanz
- `D202.csv` Datei (Beispieldaten von kaggle.com: https://www.kaggle.com/datasets/jaganadhg/house-hold-energy-data)

## Installation
- Git-Repo klonen
- Platzhalterwerte in der `config.ini` ersetzen (Adresse der InfluxDB, Token)
- ggf. Bucket und Organisation im Code anpassen
- `D202.csv` Datei von kaggle.com laden und im selben Verzeichnis ablegen
- Verzeichnis in Jupyter Labs öffnen
- Die `pip install` Befehle in den ersten Zeilen des Notebooks ausführen, anschließend den Kernel neu starten

## Quellen
https://www.influxdata.com/blog/python-time-series-forecasting-tutorial/
