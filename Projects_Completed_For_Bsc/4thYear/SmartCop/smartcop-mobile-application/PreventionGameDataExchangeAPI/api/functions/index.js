const functions = require('firebase-functions');

var admin = require("firebase-admin");

var serviceAccount = require("./permissions.json");

admin.initializeApp({
  credential: admin.credential.cert(serviceAccount),
  databaseURL: "https://road-accident-response-game.firebaseio.com"
});



const express = require('express');

const app = express();
const db = admin.firestore();

const cors = require('cors');
app.use(cors({origin:true}));

//Routes

app.get('/hello',(req,res)=>{
    return res.status(200).send('K');
});

//Get all
app.get('/api/read',(req,res)=>{
    (async () => {
        try{
            let query = db.collection('progressData');
            let response = [];
            await query.get().then(querySnapshot => {
                let docs = querySnapshot.docs;

                for(let doc of docs){
                    const selectedItem = {
                        id:doc.id,
                        attempt:doc.data().attempt,
                        colorVal:doc.data().colorVal,
                        email:doc.data().email,
                        score:doc.data().score
                    };
                    response.push(selectedItem);
                }
                return response;
            })
            return res.status(200).send(response);
        }
        catch(error){
            console.log(error);
            return res.status(500).send(error);
        }
    })();
});




app.get('/api/leaderboard',(req,res)=>{
    (async () => {
        try{
            let query = db.collection('progressData')
            .where("attempt", '==', "Attempt 1")
            .orderBy("score", "desc")
            let response = [];
            await query.get().then(querySnapshot => {
                let docs = querySnapshot.docs;

                for(let doc of docs){
                    const selectedItem = {
                        id:doc.id,
                        attempt:doc.data().attempt,
                        colorVal:doc.data().colorVal,
                        email:doc.data().email,
                        score:doc.data().score
                    };
                    response.push(selectedItem);
                }
                return response;
            })
            return res.status(200).send(response);
        }
        catch(error){
            console.log(error);
            return res.status(500).send(error);
        }
    })();
});



exports.app = functions.https.onRequest(app);
