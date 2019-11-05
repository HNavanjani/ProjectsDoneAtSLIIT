const assert = require("assert");
const { inspectorData } = require("./InspectorTestData");
const Inspector = require("../model/transportManager/inspectors");
// Describe our tests
describe("Finding records", function() {
  var char;
  // Add a inspector to the db before each tests
  beforeEach(function(done) {
    char = new Inspector({
      username: inspectorData.username,
      password: inspectorData.password,
      username: inspectorData.username,
      name: inspectorData.name,
      emailaddress: inspectorData.emailaddress,
      phone: inspectorData.phone,
      assignedroute: inspectorData.assignedroute
    });
    char.save().then(function() {
      done();
    });
  });
  // Create tests
  it("Finds a record from the database", function(done) {
    Inspector.findOne({ name: "TestInspector_Himashi" }).then(function(result) {
      assert(result.name === "TestInspector_Himashi");
      done();
    });
  });
  it("Finds a record by unique id", function(done) {
    Inspector.findOne({ _id: char._id }).then(function(result) {
      assert(result._id.toString() === char._id.toString());
      done();
    });
  });
});
