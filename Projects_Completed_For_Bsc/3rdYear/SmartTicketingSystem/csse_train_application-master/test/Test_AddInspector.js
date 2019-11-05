
const assert = require("assert");
const { inspectorData } = require("./InspectorTestData");
const Inspector = require("../model/transportManager/inspectors");
// Describe  test
describe("Saving records", function() {
  // Create tests
  it("Saves a record to the database", function(done) {
    const char = new Inspector({
      username: inspectorData.username,
      password: inspectorData.password,
      username: inspectorData.username,
      name: inspectorData.name,
      emailaddress: inspectorData.emailaddress,
      phone: inspectorData.phone,
      assignedroute: inspectorData.assignedroute
    });
    char.save().then(function() {
      assert(!char.isNew);
      done();
    });
  });
});

