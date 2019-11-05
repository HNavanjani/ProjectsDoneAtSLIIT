
const assert = require("assert");
const Inspector = require("../model/transportManager/inspectors");
const { inspectorData } = require("./InspectorTestData");
const idToUpdate = inspectorData._id;
// Describe  test
describe("Deleting records", function() {
  // Create tests
  it("Deletes a record from the database", function(done) {
    Inspector.findByIdAndRemove({ _id: idToUpdate }).then(function() {
      Inspector.findById({ _id: idToUpdate }).then(function(result) {
        assert(result === null);
        done();
      });
    });
  });
});

