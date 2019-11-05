//Kavindi

const assert = require("assert");
const User = require("../model/user/user");

describe("Saving Data", function() {
    it("Addding User", function(done) {
        var user = new User({
            name: "MochaTestStudent1",
            password: "12369",
            type: "3"
        });
        user.save().then(function() {
            assert(user.isNew === false);
            done();
        });
    });
});

