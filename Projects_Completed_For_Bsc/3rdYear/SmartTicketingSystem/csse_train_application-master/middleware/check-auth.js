const jwt = require('jsonwebtoken');

module.exports = (req, res, next) => {
    try {
        const token = req.headers.authorization.split(" ")[1];
        console.log(token);
        const decoded = jwt.verify(token, process.env.JWT_KEY);//because verify method will come as decoded if succeed or else prompt error
        res.userData = decoded;
        next();
    }catch (e) {
        return res.status(401).json({
            message: "Authentication is failed"
        });
    }
};