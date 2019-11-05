const assert = require("assert");
const Assignment = require("../model/instructor/addassignment");

describe("Saving Data", function() {
    it("Addding Assignment", function(done) {
        var assignment = new Assignment({
            cname: "TestAssignment",
            subname: "Subject1",
            assignmentNumber: "15",
            assignment: "Report",
            date: "27/05/2020"
        });
        assignment.save().then(function() {
            assert(assignment.isNew === false);
            done();
        });
    });
});