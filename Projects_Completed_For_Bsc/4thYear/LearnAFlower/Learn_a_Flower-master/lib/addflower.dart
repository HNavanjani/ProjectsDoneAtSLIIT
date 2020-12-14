import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:image_picker/image_picker.dart'; //To pick image from gallery and camera
import 'package:flutter/material.dart';
import 'api.dart';
import 'dart:io';
import 'dart:async';
import 'package:firebase_storage/firebase_storage.dart'; // to store images in firebase storage
import 'package:shared_preferences/shared_preferences.dart'; // to store loggeg user detail

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: AddFlowerPage(),
    );
  }
}

class AddFlowerPage extends StatefulWidget {
  @override
  AddFlowerPage() : super();
  AddFlowerPageState createState() => AddFlowerPageState();
}

class AddFlowerPageState extends State<AddFlowerPage> {
  double screenHeight;
  bool showTextField = false;
  //Initialize controllers
  TextEditingController controllerFlowerName = TextEditingController();
  TextEditingController controllerDescription = TextEditingController();
  TextEditingController controllerSunlight = TextEditingController();
  TextEditingController controllerBlooms = TextEditingController();
  TextEditingController controllerSoil = TextEditingController();
  TextEditingController controllerMoreDetail = TextEditingController();

  Future<File> imageFile;
  String url, searchKey, loggedUser;

/*Title:Shared Preferences in Flutter-shared preferences to keep user logged?
 *Author:R Palankar
 * Date:2020
 * Availability:https://protocoderspoint.com/shared-preferences-in-flutter-how-to-keep-user-logged/
 */
  SharedPreferences logindata;
  String loggedEmail;

  @override
  void initState() {
    super.initState();
    initial();
  }
  //Store logged user's username(email)
  void initial() async {
    logindata = await SharedPreferences.getInstance();
    setState(() {
      loggedEmail = logindata.getString('email');
    });
  }

  addFlower()
  {
 try{
    addNewFlower(controllerFlowerName.text,controllerDescription.text,url,controllerSunlight.text,controllerBlooms.text,controllerSoil.text,controllerMoreDetail.text,loggedEmail, controllerFlowerName.text[0]);
    showMessage(context);
    controllerFlowerName.text='';
    controllerDescription.text='';
    controllerSunlight.text='';
    controllerBlooms.text='';
    controllerSoil.text='';
    controllerMoreDetail.text='';
    }
    catch(e)
    {
      showErrorMessage2();
    }

  }
/*Title:Upload Image File To Firebase Storage Using Flutter
 *Author:P Patel
 *Date:2019
 *Availability:https://www.c-sharpcorner.com/article/upload-image-file-to-firebase-storage-using-flutter/
*/

  File sampleImage;
  Future getImage() async {
    var tempImage = await ImagePicker.pickImage(source: ImageSource.gallery);

    setState(() {
      sampleImage = tempImage;
    });
  }
  /*Title: Flutter-Import Camera and Gallery Image|Best Ways
   * Date:2019
   * Availability:https://www.youtube.com/watch?v=cyhuPzAlgUU&feature=youtu.be
   */
  Future<void> _selectionDialog(BuildContext context){
    return showDialog(context:context,builder: (BuildContext context)
    {
      return AlertDialog(
        title: Text("Make a choice"),
        content: SingleChildScrollView(
          child: ListBody(
            children: <Widget>[
              GestureDetector(
                child: Text("Gallery"),
                onTap: (){
                  pickImageFromGallery(ImageSource.gallery,context);
                },
              ),
              Padding(padding: EdgeInsets.all(8.0)),
              GestureDetector(
                child: Text("Camera"),
                onTap: (){
                  pickImageFromCamera(ImageSource.camera,context);
                },
              )
            ],
          ),
        ),
      );
    });
  }
  Widget buildBody(BuildContext context) {
    return StreamBuilder<QuerySnapshot>(
      builder: (context, snapshot) {
        if(snapshot.hasError) {
          return Text('Error ${snapshot.error}');
        }
        return CircularProgressIndicator();
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    screenHeight = MediaQuery.of(context).size.height;
    return Scaffold(
      appBar: AppBar(
        elevation: 5.0,
        backgroundColor: Color.fromRGBO(61, 212, 125, 100),
        title: Row(
          children: <Widget>[
            SizedBox(
              width: 15,
            ),
            Container(
                margin: EdgeInsets.fromLTRB(0, 8, 10, 8),
                child: CircleAvatar(
                  backgroundImage: ExactAssetImage('images/logo.png'),
                  radius: 25.0,
                ),
                decoration: new BoxDecoration(
                  border: new Border.all(
                    color: Colors.pink,
                    width: 1.0,
                  ),
                  borderRadius: new BorderRadius.all(new Radius.circular(50.0)),
                )),
            Container(
              //margin: EdgeInsets.fromLTRB(0, 0, 130, 0),
              child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: <Widget>[
                    Container(
                      child: Text(
                        'FlowerSnap',
                        style: TextStyle(fontSize: 25.0, fontFamily: 'Lobster'),
                      ),
                    ),
                    SizedBox(height: 4.0),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.start,
                      children: <Widget>[
                        Icon(
                          Icons.arrow_forward_ios,
                          color: Colors.white,
                          size: 12.0,
                        ),
                        SizedBox(width: 4.0),
                        Text('Learn Flower Details',
                            style: TextStyle(fontSize: 12.0))
                      ],
                    ),
                  ]),
            )
          ],
        ),

      ),
      body: SingleChildScrollView(
        child: Stack(
          children: <Widget>[
            lowerSection(context),
            upperSection(context),
            addFlowerSection(context)
          ],
        ),
      ),
    );
  }
  //Design for top section of add flower screen
  Widget upperSection(BuildContext context) {
    return Container(
      height: screenHeight / 2,
      child: Image.asset(
        'images/flower2.jpg',
        fit: BoxFit.cover,
      ),
    );
  }
  //Design for bottom section of add flower screen
  Widget lowerSection(BuildContext context) {
    return Align(
      alignment: Alignment.bottomCenter,
      child: Container(
        height: screenHeight / 2,
        color: Color(0xFFECF0F3),
      ),
    );
  }
  //add flower detail form design
  Widget addFlowerSection(BuildContext context) {
    return Column(
      children: <Widget>[
        Container(
          margin: EdgeInsets.only(top: screenHeight / 4),
          padding: EdgeInsets.only(left: 10, right: 10),
          child: Card(
            shape: RoundedRectangleBorder(
              borderRadius: BorderRadius.circular(10),
            ),
            elevation: 8,
            child: Padding(
              padding: const EdgeInsets.fromLTRB(30.0, 30.0, 30.0, 10.0),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.center,
                children: <Widget>[
                  showImage(),
                  Align(
                    child: ListTile(
                      title: IconButton(
                        icon: Icon(Icons.camera_alt),
                        iconSize: 40,
                        onPressed: () {
                          //pickImageFromGallery(ImageSource.gallery);
                          _selectionDialog(context);
                        },
                      ),
                    ),
                  ),

                  TextFormField(
                    controller: controllerFlowerName,
                    decoration: InputDecoration(
                        labelText: "Flower Name", hasFloatingPlaceholder: true,
                        border: OutlineInputBorder(borderRadius: BorderRadius.circular(10.0)),
                        contentPadding: EdgeInsets.fromLTRB(20.0, 15.0, 20.0, 15.0),
                    ),
                  ),
                  SizedBox(
                    height: 20,
                  ),
                  TextFormField(
                    controller: controllerDescription,
                    decoration: InputDecoration(
                        labelText: "Description", hasFloatingPlaceholder: true,
                        border: OutlineInputBorder(borderRadius: BorderRadius.circular(10.0)),
                        contentPadding: EdgeInsets.fromLTRB(20.0, 15.0, 20.0, 15.0),
                    ),
                  ),
                  SizedBox(
                    height: 20,
                  ),
                  TextFormField(
                    controller: controllerSunlight,
                    decoration: InputDecoration(
                      labelText: "Sunlight", hasFloatingPlaceholder: true,
                      border: OutlineInputBorder(borderRadius: BorderRadius.circular(10.0)),
                      contentPadding: EdgeInsets.fromLTRB(20.0, 15.0, 20.0, 15.0),
                    ),
                  ),
                  SizedBox(
                    height: 20,
                  ),
                  TextFormField(
                    controller: controllerBlooms,
                    decoration: InputDecoration(
                      labelText: "Blooms", hasFloatingPlaceholder: true,
                      border: OutlineInputBorder(borderRadius: BorderRadius.circular(10.0)),
                      contentPadding: EdgeInsets.fromLTRB(20.0, 15.0, 20.0, 15.0),
                    ),
                  ),
                  SizedBox(
                    height: 20,
                  ),
                  TextFormField(
                    controller: controllerSoil,
                    decoration: InputDecoration(
                      labelText: "Soil", hasFloatingPlaceholder: true,
                      border: OutlineInputBorder(borderRadius: BorderRadius.circular(10.0)),
                      contentPadding: EdgeInsets.fromLTRB(20.0, 15.0, 20.0, 15.0),
                    ),
                  ),
                  SizedBox(
                    height: 20,
                  ),
                  TextFormField(
                    controller: controllerMoreDetail,
                    decoration: InputDecoration(
                      labelText: "Url for more details", hasFloatingPlaceholder: true,
                      border: OutlineInputBorder(borderRadius: BorderRadius.circular(10.0)),
                      contentPadding: EdgeInsets.fromLTRB(20.0, 15.0, 20.0, 15.0),
                    ),
                  ),
                  SizedBox(
                    height: 20,
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: <Widget>[
                      RaisedButton(
                        child: Text("UPLOAD"),
                        color: Color.fromRGBO(61, 212, 125, 100),
                        textColor: Colors.white,
                        padding: EdgeInsets.only(
                            left: 38, right: 38, top: 15, bottom: 15),
                        shape: RoundedRectangleBorder(
                            borderRadius: BorderRadius.circular(5)),
                        /*Title:Upload Image File To Firebase Storage Using Flutter
                         *Author:P Patel
                         *Date:2019
                         *Availability:https://www.c-sharpcorner.com/article/upload-image-file-to-firebase-storage-using-flutter/
                        */
                        onPressed: () async{
                          try {
                            //Define the firebase storage link
                            final FirebaseStorage _storage = FirebaseStorage(storageBucket: 'gs://lab4-db.appspot.com');
                            //Define file path and use current datetime as image name
                            String filePath = 'images/${DateTime.now()}.png';
                            //Store the image to firebase storage
                            StorageUploadTask _uploadTask = _storage.ref().child(filePath).putFile(sampleImage);
                            //Get the url of the uploaded image
                            var dowurl = await (await _uploadTask.onComplete).ref.getDownloadURL();
                            //store the uploaded image url as string for further usage
                            url = dowurl.toString();
                            addFlower();
                            print(url);
                            setState(() {
                              showTextField = false;
                            });
                          }
                          catch(e)
                          {
                            showErrorMessage(context);
                          }
                        },
                      )
                    ],
                  )
                ],
              ),
            ),
          ),
        ),
      ],
    );
  }
  //Display an alert message
  /*Title: How to make an AlertDialog in Flutter
   * Date:2019
   * Availability:https://stackoverflow.com/questions/53844052/how-to-make-an-alertdialog-in-flutter
   */
  showMessage(BuildContext context) {
    // set up the button
    Widget okButton = FlatButton(
      child: Text("OK"),
      onPressed: () {
        Navigator.pop(context);
      },
    );
    // set up the SuccessDialog
    AlertDialog alert = AlertDialog(
      title: Text("FlowerSnap"),
      content: Text("Flower detail is uploaded successfully!"),
      actions: [
        okButton,
      ],
    );

    // show the dialog
    showDialog(
      context: context,
      builder: (BuildContext context) {
        return alert;
      },
    );
  }

  //Display an alert message
  /*Title: How to make an AlertDialog in Flutter
   * Date:2019
   * Availability:https://stackoverflow.com/questions/53844052/how-to-make-an-alertdialog-in-flutter
   */
  showErrorMessage(BuildContext context) {
    // set up the button
    Widget okButton = FlatButton(
      child: Text("OK"),
      onPressed: () {
        Navigator.pop(context);
      },
    );
    // set up the ErrorDialog
    AlertDialog alert = AlertDialog(
      title: Text("FlowerSnap"),
      content: Text("Image is not inserted. Please insert the image!"),
      actions: [
        okButton,
      ],
    );

    // show the dialog
    showDialog(
      context: context,
      builder: (BuildContext context) {
        return alert;
      },
    );
  }

  //Display an alert message
  /*Title: How to make an AlertDialog in Flutter
   * Date:2019
   * Availability:https://stackoverflow.com/questions/53844052/how-to-make-an-alertdialog-in-flutter
   */
  showErrorMessage2() {
    // set up the button
    Widget okButton = FlatButton(
      child: Text("OK"),
      onPressed: () {
        Navigator.pop(context);
      },
    );
    // set up the ErrorDialog
    AlertDialog alert = AlertDialog(
      title: Text("FlowerSnap"),
      content: Text("Please fill all the fields!"),
      actions: [
        okButton,
      ],
    );

    // show the dialog
    showDialog(
      context: context,
      builder: (BuildContext context) {
        return alert;
      },
    );
  }

  //Select image from gallery
  /*Title: Flutter Tutorial-Select an image from Gallery and show in Imageview
   *Author:James
   * Date:2019
   * Availability:http://www.coderzheaven.com/2019/01/08/flutter-tutorial-select-an-image-from-gallery-and-show-in-imageview/
   */
 pickImageFromGallery(ImageSource source, BuildContext context) async{
    setState(() {
      imageFile = ImagePicker.pickImage(source: source);
    });
    Navigator.of(context).pop();
  }

  //Capture image using camera
  /*Title: Flutter-Import Camera and Gallery Image|Best Ways
   * Date:2019
   * Availability:https://www.youtube.com/watch?v=cyhuPzAlgUU&feature=youtu.be
   */
  pickImageFromCamera(ImageSource source, BuildContext context) async{
    setState(() {
      imageFile = ImagePicker.pickImage(source: source);
    });
    Navigator.of(context).pop();
  }

  //show the selected or captured image in the screen
  /*Title: Flutter Tutorial-Select an image from Gallery and show in Imageview
   *Author:James
   * Date:2019
   * Availability:http://www.coderzheaven.com/2019/01/08/flutter-tutorial-select-an-image-from-gallery-and-show-in-imageview/
   */
  Widget showImage() {
    return FutureBuilder<File>(
      future: imageFile,
      builder: (BuildContext context, AsyncSnapshot<File> snapshot) {
        sampleImage = snapshot.data;
        if (snapshot.connectionState == ConnectionState.done &&
            snapshot.data != null) {
          return Image.file(
            snapshot.data,
            width: 200,
            height: 200,
          );
        }
        else {
          sampleImage = snapshot.data;
          return const Text(
            'Upload your flower image here',
            textAlign: TextAlign.center,
          );
        }

      },
    );
  }
}