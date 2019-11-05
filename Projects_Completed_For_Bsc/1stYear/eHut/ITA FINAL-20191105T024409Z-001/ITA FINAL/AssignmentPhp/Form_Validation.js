

		
	function formValidate()
	{
		var firstname = document.forms["myForm"]["fname"].value;
		var lastname = document.forms["myForm"]["lname"].value;
		var username = document.forms["myForm"]["username"].value;
				var passwordd = document.forms["myForm"]["password"].value;

		var email = document.forms["myForm"]["email"].value;

	
		

	if (isAlphebatic(firstname))	
	if (isAlphebatic(lastname))
	if (userValidation(username, 6, 8))
	if (passwordValidation(passwordd, 6, 8))
	if (emailValidation(email))
		return true;
			else
			 return true;
					
		else
			return false;
		else
			return false;
	else
		return false;
	
	
	
	
	
	}

			
		
		
	

	function isEmpty(firstname,field) 
	{
		if(firstname ==" " || firstname == null) 
		{
			alert("You cannot have " + field + "field empty");
			
			return true;
		} 
		
		else
		return false;
	}
	
	
	function isAlphebatic(firstname)
	{
		var exp = /^[a-zA-Z()]+$/;
		
		if (!isEmpty(firstname,"First Name"))
		{
			if (firstname.match(exp)) 
			{
				return true;
		    }
		    else 
		    {
				alert("Enter only text for your  Name");
				return false;
			}
		}
		else
		return false;
	}
	
	
	
	
	
	function isAlphebatic(lastname)
	{
		var exp = /^[a-zA-Z()]+$/;
		
		if (!isEmpty(lastname,"Last Name"))
		{
			if (lastname.match(exp)) 
			{
				return true;
		    }
		    else 
		    {
				alert("Enter only text for your  Name");
				return false;
			}
		}
		else
		return false;
	}
	
	
	
	
		function userValidation(username, min, max) 
		{
		if (!isEmpty(username, "UserName"))
		{
			if (username.length >= min && username.length <= max) 
			{
				return true;
			}
		else 
		{
			alert("Enter a username in between " + 6 + " and " + 8 + " characters");
			return false;
		}
		}
		else
		return false;
	}

	
	
	
	
	function passwordValidation(passwordd, min, max) 
		{
		if (!isEmpty(passwordd, "Password"))
		{
			if (passwordd.length >= min && passwordd.length <= max) 
			{
				return true;
			}
		else 
		{
			alert("Enter a Password in between " + 6 + " and " + 8 + " characters");
			return false;
		}
		}
		else
		return false;
	}
	

	function emailValidation(email)
	 {
	if (!isEmpty(email, "Email"))
	{
	var atpos = email.indexOf("@");
	var dotpos = email.indexOf(".");
		if (atpos < 1 || dotpos + 2 >= elem.length || atpos + 2 > dotpos)
		{
			alert("Enter a valid email address");
			return false;
		}
		else
			return true;
		}
	else
	return false;
	}
	
	
	
	
	
	
	
	