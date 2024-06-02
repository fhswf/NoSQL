# Lösungen

## Shipwreck Aufgaben

### Nächste 5 Schiffswracks zu New York City
```
db.shipwrecks.find({
  coordinates: {
      $near: {
          $geometry: {
              type: "Point",
              coordinates: [-74.0058, 40.7127]
          }
      }
  }
}).limit(5);
``` 

### Top 5 Schiffswracks im Umkreis von 0.05 Grad um New York City nach Wassertiefe sortiert
```
db.shipwrecks.find({
  coordinates: {
      $geoWithin: {
          $centerSphere: [[-74.0058, 40.7127], 0.05]
      }
  },
  depth: { $gt: 5, $lt: 20 }
}).sort({ depth: 1 }).limit(5);
```

### Alle Schiffswracks in einem größeren, quadratischen Bereich um New York City 
```
db.shipwrecks.find({
  coordinates: {
      $geoWithin: {
          $geometry: {
              type: "Polygon",
              coordinates: [[
                  [-75, 40],
                  [-73.5, 40],
                  [-73.5, 41],
                  [-75, 41],
                  [-75, 40]
              ]]
          }
      }
  }
});
```

### Volltextsuche nach dem Wort "dangerous"
```
// Erstellt einen Textindex für alle Felder
db.shipwrecks.createIndex({ "$**": "text" });

// Führt die Volltextsuche nach dem Wort "dangerous" durch
db.shipwrecks.find({ $text: { $search: "dangerous" } });
```