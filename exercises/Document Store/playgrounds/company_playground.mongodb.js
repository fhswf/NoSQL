use('company_example');
db.employees.drop();
db.departments.drop();

db.employees.insertMany([
  {
    employee_id: 1,
    name: "John Doe",
    department_id: 101,
    position: "Software Engineer",
    salary: 80000
  },
  {
    employee_id: 2,
    name: "Jane Smith",
    department_id: 102,
    position: "Marketing Manager",
    salary: 90000
  },
  {
    employee_id: 3,
    name: "Michael Johnson",
    department_id: 101,
    position: "Database Administrator",
    salary: 85000
  },
  {
    employee_id: 4,
    name: "Emily Davis",
    department_id: 103,
    position: "HR Specialist",
    salary: 75000
  },
  {
    employee_id: 5,
    name: "David Brown",
    department_id: 102,
    position: "Sales Manager",
    salary: 95000
  }
]);

db.employees.find();

db.departments.insertMany([
    {
      department_id: 101,
      name: "Engineering",
      location: "New York"
    },
    {
      department_id: 102,
      name: "Marketing",
      location: "Los Angeles"
    },
    {
      department_id: 103,
      name: "Human Resources",
      location: "Chicago"
    },
    {
      department_id: 104,
      name: "Finance",
      location: "Houston"
    }
  ]);

//db.departments.find();

db.employees.insertOne({
  employee_id: 6,
  name: "Alice Johnson",
  department_id: 103,
  position: "HR Assistant",
  salary: 60000
});

db.employees.insertMany([
  {
    employee_id: 7,
    name: "Bob Williams",
    department_id: 102,
    position: "Marketing Coordinator",
    salary: 70000
  },
  {
    employee_id: 8,
    name: "Charlie Brown",
    department_id: 101,
    position: "Software Developer",
    salary: 80000
  }
])

db.employees.updateOne(
  { name: "Alice Johnson" },
  { $set: { salary: 65000 } }
)

db.employees.updateMany(
  { department_id: 101 },
  { $inc: { salary: 5000 } }
)

db.employees.deleteOne({ employee_id: 6 })

db.employees.deleteMany({ salary: { $lt: 70000 } })

// Daten ansehen
//db.employees.find();
//db.departments.find();

// GRUNDLEGENDE ABFRAGEN

//db.employees.find({}, {_id: 0, name: 1, position: 1, salary: 1})
//db.employees.find({ department_id: 101 })
//db.employees.find({ salary: { $gt: 80000 } })

//AGGREGATIONEN

/*
db.employees.aggregate([
  {
    $group: {
      _id: "$department_id",
      avgSalary: { $avg: "$salary" }
    }
  }
])
*/

/*
db.employees.aggregate([
  {
    $group: {
      _id: "$department_id",
      count: { $sum: 1 }
    }
  }
])
*/

//VERBINDEN VON COLLECTIONS

/*
db.employees.aggregate([
  {
    $lookup: {
      from: "departments",
      localField: "department_id",
      foreignField: "department_id",
      as: "department"
    }
  },
  {
    $unwind: "$department"
  },
  {
    $project: {
      _id: 0,
      employee_id: 1,
      name: 1,
      position: 1,
      salary: 1,
      department_name: "$department.name",
      location: "$department.location"
    }
  }
])
*/

/*
db.departments.aggregate([
  {
    $lookup: {
      from: "employees",
      localField: "department_id",
      foreignField: "department_id",
      as: "employees"
    }
  },
  {
    $project: {
      _id: 0,
      department_id: 1,
      name: 1,
      location: 1,
      employee_count: { $size: "$employees" }
    }
  }
])
*/