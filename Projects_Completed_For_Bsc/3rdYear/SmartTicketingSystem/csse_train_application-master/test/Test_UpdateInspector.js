
const assert = require("assert");
const Inspector = require("../model/transportManager/inspectors");
const { inspectorData } = require("./InspectorTestData");
const idToUpdate = inspectorData._id;
// Describe  test
describe("Updating records", function() {
  // Create tests
  it("Updates the assignedroute of a inspector", function(done) {
    Inspector.findByIdAndUpdate(
      { _id: idToUpdate },
      { assignedroute: "route 154" }
    ).then(function() {
      Inspector.findOne({ _id: idToUpdate }).then(function(result) {
        assert(result.assignedroute === "route 154");
        done();
      });
    });
  });
});

