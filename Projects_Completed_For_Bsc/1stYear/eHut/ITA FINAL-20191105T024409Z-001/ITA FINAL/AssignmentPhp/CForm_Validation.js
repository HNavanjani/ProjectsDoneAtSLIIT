

		
	function formValidate()
	{
		var firstname = document.forms["myForm"]["fname"].value;
		var lastname = document.forms["myForm"]["lname"].value;
		var address = document.forms["myForm"]["address"].value;
		var zip = document.forms["myForm"]["zip"].value;
		var state = document.forms["myForm"]["state"].value;
		var username = document.forms["myForm"]["username"].value;
		var email = document.forms["myForm"]["email"].value;
	
		

	if (isAlphebatic(firstname))	
	if (isAlphebatic(lastname))
		if (isAlphaNumeric(address))
			if (isNumeric(zip))
				if (selectedState(state))
					if (userValidation(username, 6, 8))
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
				alert("Enter only text for your First Name");
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
				alert("Enter only text for your Last Name");
				return false;
			}
		}
		else
		return false;
	}
	
	
	
	function isAlphaNumeric(address)
	{
		var exp = /^[0-9a-zA-Z]+$/;
		if (!isEmpty(address, "Address"))
		{
			if (address.match(exp))
			return true;
		else 
		{
			alert("Enter only letters and numbers for the address");
			return false;
		}
		}
		else
	return false;
	}
	
	
	function isNumeric(zip) {
		if (!isEmpty(zip,"Zip Code")) 
		{
			var exp = /^[0-9]+$/;
			
			if (zip.match(exp))
				return true;
			else {
					alert("Enter a valid Zip Code,Only numbers..");
					return false;
				}
		} 
		else
		return false;
	}


	function selectedState(state) 
	{
		if (state == "Select state") 
		{
			alert("Choose a state");
			return false;
		} 
		else
			return true;
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
	
	
	