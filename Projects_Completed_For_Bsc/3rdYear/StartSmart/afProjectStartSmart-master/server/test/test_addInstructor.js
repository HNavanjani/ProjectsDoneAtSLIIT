const assert = require("assert");
const Instructor = require("../model/instructor/instructor");

describe("Saving Data", function() {
  it("Addding Instructor", function(done) {
    var instructor = new Instructor({
      name: "MochaTestInstructor1",
      email: "alpha.4spirits@gmail.com",
      password: "12369",
      username: "TestInstructor1"
    });
    instructor.save().then(function() {
      assert(instructor.isNew === false);
      done();
    });
  });
});