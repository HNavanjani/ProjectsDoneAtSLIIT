// create ErrorFactory class as generic error handling class
class ErrorFactory {
  constructor() {
    this.createError = function(type) {
      let error;
      if (type === "updating") error = new UIUpdatingError();
      else if (type === "loading") error = new UILoadingError();
      else if (type === "saving") error = new UISavingError();
      error.show = function() {
        return `While ${this._type} an error occured....`;
      };
      return error;
    };
  }
}
// create subclass UILoadingError to handle loading errors
class UILoadingError {
  constructor() {
    this._type = "loading";
    this.showloadingalert = function() {
      return "Unable to Load Required Data";
    };
  }
}
// create subclass UISavingError to handle saving errors
class UISavingError {
  constructor() {
    this._type = "saving";
    this.showsavingalert = function() {
      return "Unable to Save Data";
    };
  }
}
// create subclass UIUpdatingError to handle updating errors
class UIUpdatingError {
  constructor() {
    this._type = "updating";
    this.showupdatingalert = function() {
      return "Unable to Update Modified Data";
    };
  }
}
// create ErrorFactory instance
const errorfactory = new ErrorFactory();
// calling createError function of ErrorFactory class to create instances from ErrorFactory class
const uiloadingerror = errorfactory.createError("loading");
const uisavingerror = errorfactory.createError("saving");
const uiupdatingerror = errorfactory.createError("updating");

//****************************** */

//************************** */

$(function() {
  var $inspectors = $("#inspectors");
  var $assignedroute = $("#assignedroute");
  var $username = $("#username");
  var $password = $("#password");
  var $name = $("#name");
  var $emailaddress = $("#emailaddress");
  var $phone = $("#phone");
  var inspectorTemplate = $("#inspector-template").html();

  function addInspector(inspector) {
    $inspectors.append(Mustache.render(inspectorTemplate, inspector));
  }

  //Get Inspectors
  $.ajax({
    type: "GET",
    url: "http://localhost:3000/api/inspectors",
    success: function(inspectors) {
      $.each(inspectors, function(i, inspector) {
        addInspector(inspector);
      });
    },
    error: function() {
      // calling show function of ErrorFactory and calling showloadingalert function of UILoadingError subclass
      alert(uiloadingerror.show() + uiloadingerror.showloadingalert());
    }
  });

  //Add Inspector
  $("#add-inspector").on("click", function() {
    var inspector = {
      assignedroute: $assignedroute.val(),
      username: $username.val(),
      password: $password.val(),
      name: $name.val(),
      emailaddress: $emailaddress.val(),
      phone: $phone.val()
    };
    $.ajax({
      type: "POST",
      contentType: "application/json",
      url: "http://localhost:3000/api/inspectors",
      data: JSON.stringify(inspector),
      dataType: "json",
      success: function(newInspector) {
        addInspector(newInspector);
      },
      error: function() {
        // calling show function of ErrorFactory and calling showsavingalert function of UISavingError subclass
        alert(uisavingerror.show() + uisavingerror.showsavingalert());
      }
    });
  });

  //Delete Inspector
  $inspectors.delegate(".remove", "click", function() {
    var $li = $(this).closest("li");
    $.ajax({
      type: "DELETE",
      url: "http://localhost:3000/api/inspectors/" + $(this).attr("data-id"),
      success: function() {
        $li.fadeOut(300, function() {
          $(this).remove();
        });
      }
    });
  });

  //Edit
  $inspectors.delegate(".editInspector", "click", function() {
    var $li = $(this).closest("li");
    $li.find("input.assignedroute").val($li.find("span.assignedroute").html());
    $li.find("input.username").val($li.find("span.username").html());
    $li.find("input.password").val($li.find("span.password").html());
    $li.find("input.name").val($li.find("span.name").html());
    $li.find("input.emailaddress").val($li.find("span.emailaddress").html());
    $li.find("input.phone").val($li.find("span.phone").html());
    $li.addClass("edit");
  });

  //Cancel
  $inspectors.delegate(".cancelEdit", "click", function() {
    $(this)
      .closest("li")
      .removeClass("edit");
  });

  //Save Edit
  $inspectors.delegate(".saveEdit", "click", function() {
    var $li = $(this).closest("li");
    var inspector = {
      assignedroute: $li.find("input.assignedroute").val(),
      username: $li.find("input.username").val(),
      password: $li.find("input.password").val(),
      name: $li.find("input.name").val(),
      emailaddress: $li.find("input.emailaddress").val(),
      phone: $li.find("input.phone").val()
    };
    $.ajax({
      type: "PUT",
      contentType: "application/json",
      url: "http://localhost:3000/api/inspectors/" + $li.attr("data-id"),
      data: JSON.stringify(inspector),
      dataType: "json",
      success: function(newInspector) {
        $li.find("span.assignedroute").html(inspector.assignedroute);
        $li.find("span.username").html(inspector.username);
        $li.find("span.password").html(inspector.password);
        $li.find("span.name").html(inspector.name);
        $li.find("span.emailaddress").html(inspector.emailaddress);
        $li.find("span.phone").html(inspector.phone);
        $li.removeClass("edit");
      },
      error: function() {
        // calling show function of ErrorFactory and calling showupdatingalert function of UIUpdatingError subclass
        alert(uiupdatingerror.show() + uiupdatingerror.showupdatingalert());
      }
    });
  });
});
