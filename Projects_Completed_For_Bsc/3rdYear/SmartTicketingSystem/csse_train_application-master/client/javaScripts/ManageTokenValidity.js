// calculate fine as chaining of addition
class CumulativeSum {
  constructor(intialValue = 0) {
    this.sum = intialValue;
  }
  add(value) {
    this.sum += value;
    return this;
  }
}

// defining chart data
var preferedtype_bar = "bar";
var preferedtype_line = "line";
var preferedtype_pie = "pie";
var ipreferedbackgroundColor_bar = [
  "rgba(54, 162, 235, 0.2)",
  "rgba(54, 162, 235, 0.2)",
  "rgba(54, 162, 235, 0.2)",
  "rgba(54, 162, 235, 0.2)",
  "rgba(54, 162, 235, 0.2)",
  "rgba(54, 162, 235, 0.2)",
  "rgba(54, 162, 235, 0.2)"
];
var ipreferedborderColor_bar = [
  "rgba(54, 162, 235, 1)",
  "rgba(54, 162, 235, 1)",
  "rgba(54, 162, 235, 1)",
  "rgba(54, 162, 235, 1)",
  "rgba(54, 162, 235, 1)",
  "rgba(54, 162, 235, 1)",
  "rgba(54, 162, 235, 1)"
];

var ipreferedbackgroundColor_line = [
  "rgba(255, 99, 132, 0.2)",
  "rgba(255, 99, 132, 0.2)",
  "rgba(255, 99, 132, 0.2)",
  "rgba(255, 99, 132, 0.2)",
  "rgba(255, 99, 132, 0.2)",
  "rgba(255, 99, 132, 0.2)",
  "rgba(255, 99, 132, 0.2)"
];
var ipreferedborderColor_line = [
  "rgba(255, 99, 132, 1)",
  "rgba(255, 99, 132, 1)",
  "rgba(255, 99, 132, 1)",
  "rgba(255, 99, 132, 1)",
  "rgba(255, 99, 132, 1)",
  "rgba(255, 99, 132, 1)",
  "rgba(255, 99, 132, 1)"
];

var ipreferedbackgroundColor_pie = [
  "rgba(255, 99, 132, 0.2)",
  "rgba(54, 162, 235, 0.2)",
  "rgba(255, 206, 86, 0.2)",
  "rgba(75, 192, 192, 0.2)",
  "rgba(153, 102, 255, 0.2)",
  "rgba(255, 159, 64, 0.2)",
  "rgba(128, 128, 128, 0.2)"
];
var ipreferedborderColor_pie = [
  "rgba(255, 99, 132, 1)",
  "rgba(54, 162, 235, 1)",
  "rgba(255, 206, 86, 1)",
  "rgba(75, 192, 192, 1)",
  "rgba(153, 102, 255, 1)",
  "rgba(255, 159, 64, 1)",
  "rgba(128, 128, 128, 0.2)"
];

// main application logic
$(function() {
  var $showinvalidjourneycount = $("#showinvalidjourneycount");
  var $addinspectorform = $("#add-inspector-form");
  var $invalidjourney = $("#invalidjourney");
  var $localusrs = $("#localusers");
  var jday = [];
  var jfare = [];
  var uniquejday = [];
  var daycounts = {};
  var passengerNumOccr = {};
  var countar = [];
  var countarfare = [];
  var monfare = [];
  var tuefare = [];
  var wedfare = [];
  var thufare = [];
  var frifare = [];
  var satfare = [];
  var sunfare = [];
  var totalmonfare;
  var totaltuefare;
  var totalwedfare;
  var totalthufare;
  var totalfrifare;
  var totalsatfare;
  var totalsunfare;
  var localuserID;
  var invalidjourneytemplate = $("#invalidjourney-template").html();
  var localusertemplate = $("#localuser-template").html();
  var updatedfine;
  var newFine;
  var $inputstartinglocation = $("#inputstartinglocation");
  var $inputstartinglocationinvalid = $("#inputstartinglocationinvalid");
  var $inputstartinglocationfare = $("#inputstartinglocationfare");

  function addinvalidjourney(invalidjourney) {
    $invalidjourney.append(
      Mustache.render(invalidjourneytemplate, invalidjourney)
    );
  }

  function addlocalusers(localuser) {
    $localusrs.append(Mustache.render(localusertemplate, localuser));
  }

  //Manage Token Validity : GET invalid journey info
  $.ajax({
    type: "GET",
    url: "http://localhost:3000/api/invalidjourneydetails",
    success: function(invalidjourneydetails) {
      $showinvalidjourneycount.append(
        Object.keys(invalidjourneydetails).length
      );
      var voilatedpassengercount = $showinvalidjourneycount.text();
      if (voilatedpassengercount < 20) {
        $addinspectorform.css("display", "none");
      }
      $.each(invalidjourneydetails, function(i, invalidjourneydetail) {
        addinvalidjourney(invalidjourneydetail);
      });
    },
    error: function() {
      // calling show function of ErrorFactory and calling showloadingalert function of UILoadingError subclass
      alert(uiloadingerror.show() + uiloadingerror.showloadingalert());
    }
  });

  // get available train details
  $.ajax({
    type: "GET",
    url: "http://localhost:3000/train/availabletrains",
    success: function(trains) {
      $.each(trains, function(i, train) {
        $inputstartinglocation.append(
          "<option>" + train.startstation + "</option>"
        );
      });
      $.each(trains, function(i, train) {
        $inputstartinglocationinvalid.append(
          "<option>" + train.startstation + "</option>"
        );
      });
      $.each(trains, function(i, train) {
        $inputstartinglocationfare.append(
          "<option>" + train.startstation + "</option>"
        );
      });
    },
    error: function() {
      alert(uiloadingerror.show() + uiloadingerror.showloadingalert());
    }
  });

  // get user details
  $.ajax({
    type: "GET",
    url: "http://localhost:3000/applyloan/localusers",
    success: function(localusers) {
      $.each(localusers, function(i, localuser) {
        addlocalusers(localuser);
      });
    },
    error: function() {
      alert(uiloadingerror.show() + uiloadingerror.showloadingalert());
    }
  });

  //Pay fine via inspector - calc fine
  $localusrs.delegate(".addfine", "click", function() {
    var amt;
    var $li = $(this).closest("li");
    $li.find("input._id").val($li.find("span._id").html());
    $li
      .find("input.lPassengerName")
      .val($li.find("span.lPassengerName").html());
    $li.find("input.fineamount").val($li.find("span.fineamount").html());

    /***
usses class CumulativeSum, which  instantiated with available fare as initialValue. 
the add method adds the passed values, here: twise of journey fare and tax 
to the sum attribute of the object 
and returns the object itself 
to allow chaining of add method calls.
*/
    var available = parseInt($li.find("span.fineamount").html());
    var fixed = 500;
    var tax = parseInt((fixed * 10) / 100.0);
    var amtObj = new CumulativeSum();
    amtObj
      .add(fixed)
      .add(available)
      .add(tax).amtObj;

    for (key in amtObj) {
      if (amtObj.hasOwnProperty(key)) {
        updatedfine = amtObj[key];
      }
    }
    newFine = fixed + tax;
    console.log(updatedfine);
    //var amt = $li.find("span.fare").html() * 2;
    $li.find("input.fineamount").val(updatedfine);
    $li.addClass("edit");
  });

  //Cancel
  $localusrs.delegate(".cancelEdit", "click", function() {
    $(this)
      .closest("li")
      .removeClass("edit");
  });

  //Update fine amount via inspector
  $localusrs.delegate(".payFine", "click", function() {
    var $li = $(this).closest("li");
    var finedata = {
      assignedroute: $li.find("input.assignedroute").val(),
      fineamount: updatedfine,
      finestatus: 1
    };
    $.ajax({
      type: "PUT",
      contentType: "application/json",
      url: "http://localhost:3000/applyloan/id/" + $li.attr("data-id"),
      data: JSON.stringify(finedata),
      dataType: "json",
      success: function(newFineData) {
        $li.find("span.fineamount").html(finedata.fineamount);
        $li.removeClass("edit");
      },
      error: function() {
        // calling show function of ErrorFactory and calling showupdatingalert function of UIUpdatingError subclass
        alert(uiupdatingerror.show() + uiupdatingerror.showupdatingalert());
      }
    });

    // decorator implementation to show added fine alert
    class Fine {
      constructor(user, fine) {
        this._user = user;
        this.fine = fine;
      }
      getDetails() {
        return `${this._user}`;
      }
    }

    // fine decorator
    function addFineAmount(user) {
      user.isAddedFineAmount = true;
      user.fine;
      return user;
    }
    // using decorator
    const user1 = addFineAmount(new Fine("Fine amount", newFine));
    alert("Added Fine Amount : " + user1.fine);
  });

  //Add Fine
  $invalidjourney.delegate(".addfine", "click", function() {
    var amt;
    var $li = $(this).closest("li");
    $li.find("input.userID").val($li.find("span.userID").html());
    $li.find("input.journeryDate").val($li.find("span.journeryDate").html());
    $li
      .find("input.startingLocation")
      .val($li.find("span.startingLocation").html());
    $li
      .find("input.destinationLocation")
      .val($li.find("span.destinationLocation").html());
    $li.find("input.distance").val($li.find("span.distance").html());
    $li.find("input.fare").val($li.find("span.fare").html());
    $li.find("input.routeName").val($li.find("span.routeName").html());
    $li.find("input.day").val($li.find("span.day").html());
    $li.find("input.hour").val($li.find("span.hour").html());

    /***
 usses class CumulativeSum, which  instantiated with available fare as initialValue. 
 the add method adds the passed values, here: twise of journey fare and tax 
 to the sum attribute of the object 
 and returns the object itself 
 to allow chaining of add method calls.
 */

    var availablefare = parseInt($li.find("span.fare").html());
    var sum = parseInt(availablefare * 2);
    var tax = parseInt((availablefare * 10) / 100.0);
    var amtObj = new CumulativeSum();
    amtObj
      .add(availablefare)
      .add(sum)
      .add(tax).amtObj;

    for (key in amtObj) {
      if (amtObj.hasOwnProperty(key)) {
        amt = amtObj[key];
      }
    }

    console.log(amt);
    //var amt = $li.find("span.fare").html() * 2;
    $li.find("input.fine").val(amt);
    $li.addClass("edit");
  });

  //Cancel
  $invalidjourney.delegate(".cancelEdit", "click", function() {
    $(this)
      .closest("li")
      .removeClass("edit");
  });

  //Remove invalid journey info
  $invalidjourney.delegate(".remove", "click", function() {
    var $li = $(this).closest("li");
    $.ajax({
      type: "DELETE",
      url:
        "http://localhost:3000/api/invalidjourneydetails/" +
        $(this).attr("data-id"),
      success: function() {
        $li.fadeOut(300, function() {
          $(this).remove();
        });
      }
    });
  });

  //Save Fine
  $invalidjourney.delegate(".saveEdit", "click", function() {
    var $li = $(this).closest("li");
    var finedata = {
      userID: $li.find("input.userID").val(),
      journeryDate: $li.find("input.journeryDate").val(),
      startingLocation: $li.find("input.startingLocation").val(),
      destinationLocation: $li.find("input.destinationLocation").val(),
      distance: $li.find("input.distance").val(),
      fare: $li.find("input.fare").val(),
      routeName: $li.find("input.routeName").val(),
      day: $li.find("input.day").val(),
      hour: $li.find("input.hour").val(),
      fine: $li.find("input.fine").val(),
      emaila: $li.find("input.emaila").val()
    };

    $.ajax({
      type: "POST",
      contentType: "application/json",
      url: "http://localhost:3000/api/fineinformation",
      data: JSON.stringify(finedata),
      dataType: "json",
      success: function(newFinedata) {
        alert("Fine added !");
        $li.removeClass("edit");
      },
      error: function() {
        // calling show function of ErrorFactory and calling showsavingalert function of UISavingError subclass
        alert(uisavingerror.show() + uisavingerror.showsavingalert());
      }
    });
  });

  /*
  
  $invalidjourney.delegate(".payFine", "click", function() {
    var $li = $(this).closest("li");
    var finedata = {
      userID: $li.find("input.userID").val(),
      fine: $li.find("input.fine").val(),
      status: 1
    };

    $.ajax({
      type: "POST",
      contentType: "application/json",
      url: "http://localhost:3000/api/fineinformation",
      data: JSON.stringify(finedata),
      dataType: "json",
      success: function(newFinedata) {
        alert("Fine added !");
      },
      error: function() {
        // calling show function of ErrorFactory and calling showsavingalert function of UISavingError subclass
        alert(uisavingerror.show() + uisavingerror.showsavingalert());
      }
    });
  });
*/

  //*** */

  var voilatedpassengercount = $showinvalidjourneycount.text();
  if (voilatedpassengercount > 2) {
    $addinspectorform.css("display", "none");
  }

  /// ********Generate Statistics *******************
  //Generate network traffic stats
  $("#displaytravelinfo").click(function() {
    var location = $("#inputstartinglocation :selected").text();
    var hour = $("#inputfrom :selected").text();
    // create initial empty chart
    var chartnetworktraffic = document.getElementById("chartnetworktraffic");
    var networktrafficchart = new Chart(chartnetworktraffic, {
      type: preferedtype_bar,
      data: {
        labels: [],
        datasets: [
          {
            label:
              "# of Passengers use different parts of the network at different times of day and on different days of the week",
            data: [],
            backgroundColor: ipreferedbackgroundColor_bar,
            borderColor: ipreferedborderColor_bar,
            borderWidth: 1
          }
        ]
      },
      options: {
        scales: {
          yAxes: [
            {
              ticks: {
                beginAtZero: true
              }
            }
          ]
        }
      }
    });

    // logic to get new data
    var getData = function() {
      $.ajax({
        type: "GET",
        url:
          "http://localhost:3000/api/journeydetails/" + location + "/" + hour,
        success: function(journeydetails) {
          $.each(journeydetails, function(i, journeydetail) {
            jcount = Object.keys(journeydetails).length;
            jday.push(journeydetail.day);
          });
          uniquejday = jday.filter(function(itm, i, jday) {
            return i == jday.indexOf(itm);
          });
          console.log(jday);
          $.each(jday, function(key, value) {
            passengerNumOccr = $.grep(jday, function(elem) {
              return elem === value;
            }).length;
            daycounts[value] = passengerNumOccr;
          });
          console.log(daycounts);
          countar = [];
          $.each(daycounts, function(key, value) {
            countar.push(value);
          });
          console.log(countar);
          networktrafficchart.data.datasets[0].data = countar;
          networktrafficchart.data.labels = uniquejday.slice(",");
          // re-render the chart
          networktrafficchart.update();
        }
      });
    };
    getData();
  });

  //Generate invalid journey details stats
  $("#displayinvalidjourneydetails").click(function() {
    var location = $("#inputstartinglocationinvalid :selected").text();
    var hour = $("#inputfrominvalid :selected").text();
    // create initial empty chart
    var chartnetinvalidjurneydetails = document.getElementById(
      "chartnetinvalidjurneydetails"
    );
    var inetinvalidjurneydetailschart = new Chart(
      chartnetinvalidjurneydetails,
      {
        type: preferedtype_line,
        data: {
          labels: [],
          datasets: [
            {
              label:
                "Frequency of ticket inspectors discovering people travelling without a valid ticket",
              data: [],
              backgroundColor: ipreferedbackgroundColor_line,
              borderColor: ipreferedborderColor_line,
              borderWidth: 1
            }
          ]
        },
        options: {
          scales: {
            yAxes: [
              {
                ticks: {
                  beginAtZero: true
                }
              }
            ]
          }
        }
      }
    );

    // logic to get new data
    var getData = function() {
      $.ajax({
        type: "GET",
        url:
          "http://localhost:3000/api/invalidjourneydetails/" +
          location +
          "/" +
          hour,
        success: function(journeydetails) {
          $.each(journeydetails, function(i, journeydetail) {
            jcount = Object.keys(journeydetails).length;
            jday.push(journeydetail.day);
          });
          uniquejday = jday.filter(function(itm, i, jday) {
            return i == jday.indexOf(itm);
          });
          console.log(jday);
          $.each(jday, function(key, value) {
            passengerNumOccr = $.grep(jday, function(elem) {
              return elem === value;
            }).length;
            daycounts[value] = passengerNumOccr;
          });
          console.log(daycounts);
          countar = [];
          $.each(daycounts, function(key, value) {
            countar.push(value);
          });
          console.log(countar);
          inetinvalidjurneydetailschart.data.datasets[0].data = countar;
          inetinvalidjurneydetailschart.data.labels = uniquejday.slice(",");
          // re-render the chart
          inetinvalidjurneydetailschart.update();
        }
      });
    };
    getData();
  });

  //Generate fare details stats
  $("#displayfaredetails").click(function() {
    var location = $("#inputstartinglocationfare :selected").text();
    var hour = $("#inputfromfare :selected").text();
    // create initial empty chart
    var chartfaredetails = document.getElementById("chartfaredetails");
    var faredetailschart = new Chart(chartfaredetails, {
      type: preferedtype_pie,
      data: {
        labels: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"],
        datasets: [
          {
            label:
              "Fares collected from passengers within journeys that have been taken",
            data: [],
            backgroundColor: ipreferedbackgroundColor_pie,
            borderColor: ipreferedborderColor_pie,
            borderWidth: 1
          }
        ]
      },
      options: {
        scales: {
          yAxes: [
            {
              ticks: {
                beginAtZero: true
              }
            }
          ]
        }
      }
    });

    // logic to get new data
    var getData = function() {
      $.ajax({
        type: "GET",
        url:
          "http://localhost:3000/api/journeydetails/" + location + "/" + hour,
        success: function(journeydetails) {
          $.each(journeydetails, function(i, journeydetail) {
            jday.push(journeydetail.day);
            jfare.push(journeydetail.fare);

            if (jQuery.inArray("Mon", jday) !== -1)
              monfare.push(journeydetail.fare);
            else if (jQuery.inArray("Tue", jday) !== -1)
              tuefare.push(journeydetail.fare);
            else if (jQuery.inArray("Wed", jday) !== -1)
              wedfare.push(journeydetail.fare);
            else if (jQuery.inArray("Thu", jday) !== -1)
              thufare.push(journeydetail.fare);
            else if (jQuery.inArray("Fri", jday) !== -1)
              frifare.push(journeydetail.fare);
            else if (jQuery.inArray("Sat", jday) !== -1)
              satfare.push(journeydetail.fare);
            else if (jQuery.inArray("Sun", jday) !== -1)
              sunfare.push(journeydetail.fare);
          });
          uniquejday = jday.filter(function(itm, i, jday) {
            return i == jday.indexOf(itm);
          });
          console.log(jday);
          console.log(jfare);
          var result = {};
          for (i = 0; i < jday.length; i++) {
            result[jday[i]]
              ? result[jday[i]].push(jfare[i])
              : (result[jday[i]] = [jfare[i]]);
          }
          console.log(result);
          //Mon
          totalmonfare = 0;
          for (var i = 0; i < result.Mon.length; i++) {
            totalmonfare += result.Mon[i];
          }
          console.log(totalmonfare);
          //Tue
          totaltuefare = 0;
          for (var i = 0; i < result.Tue.length; i++) {
            totaltuefare += result.Tue[i];
          }
          console.log(totaltuefare);
          //Wed
          totalwedfare = 0;
          for (var i = 0; i < result.Wed.length; i++) {
            totalwedfare += result.Wed[i];
          }
          console.log(totalwedfare);
          //Thu
          totalthufare = 0;
          for (var i = 0; i < result.Thu.length; i++) {
            totalthufare += result.Thu[i];
          }
          console.log(totalthufare);
          //Fri
          totalfrifare = 0;
          for (var i = 0; i < result.Fri.length; i++) {
            totalfrifare += result.Fri[i];
          }
          console.log(totalfrifare);
          //Sat
          totalsatfare = 0;
          for (var i = 0; i < result.Sat.length; i++) {
            totalsatfare += result.Sat[i];
          }
          console.log(totalsatfare);
          //Sun
          totalsunfare = 0;
          for (var i = 0; i < result.Sun.length; i++) {
            totalsunfare += result.Sun[i];
          }
          console.log(totalsunfare);
          countarfare = [];
          countarfare.push(
            totalmonfare,
            totaltuefare,
            totalwedfare,
            totalthufare,
            totalfrifare,
            totalsatfare,
            totalsunfare
          );
          console.log(countarfare);
          //faredetailschart.data.labels = uniquejday.slice(",");
          faredetailschart.data.datasets[0].data = countarfare;
          // re-render the chart
          faredetailschart.update();
        }
      });
    };
    getData();
  });
});
