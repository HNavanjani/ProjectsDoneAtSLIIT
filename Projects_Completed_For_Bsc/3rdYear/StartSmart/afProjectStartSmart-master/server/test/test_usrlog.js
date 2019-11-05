//poorna
const assert = require("assert");
const User = require("../model/User/UserlogModel");

describe("Saving Data", function() {
    it("loging User", function(done) {
        var user = new User({
            name: "praveen",
            password: "123",
            type: "student"
        });
        user.save().then(function() {
            assert(user.isNew === false);
            done();
        });
    });
});