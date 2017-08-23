function formvalidation()
{
	var UFirstName = document.valid.FirstName;
	var ULastName = document.valid.LastName;
	var UEmailId = document.valid.EmailId;
	var Upassword = document.valid.password;
	var Uphonenumber = document.valid.phoneNumber;
	var Urepassword = document.valid.repassword;
	var Uname = document.valid.name;
	var Ulocation = document.valid.location;
	var Ucity = document.valid.city;
	var UpostalCode = document.valid.postalCode;
	var Ustate = document.valid.state;
	var Ucountry = document.valid.country;
	var UuserName = document.valid.userName;
	var Ucomments = document.valid.comments;
	var Urateing = document.valid.rateing;
	var Udate = document.valid.date;
	var Ucuisineid = document.valid.cuisineid; //radio 
	var Ubranchid = document.valid.branchid; //radio
	var Udescription = document.valid.description;
	var Uprice = document.valid.price;
	var Uisveg = document.valid.isveg;//dropdown
	
	if(Firstname_validation(UFirstname))
	{
		if(LastName_validation(ULastName))
		{
			if(EmailId_validation(UEmailId))
			{
				if(password_validation(Upassword))
				{
					if(phonenumber_validation(Uphonenumber))
					{
						if(repassword_validation(Urepassword))
						{
							if(name_validation(Uname))
							{
								if(location_validation(Ulocation))
								{
									if(city_validation(Ucity))
									{
										if(postalCode_validation(UpostalCode))
										{
											if(state_validation(Ustate))
											{
												if(country_validation(Ucountry))
												{
													if(userName_validation(UuserName))
													{
														if(comments_validation(Ucomments))
														{
															if(rateing_validation(Urateing))
															{
																if(date_validation(Udate))
																{
																	if(cuisineid_validation(Ucuisineid))
																	{
																		if(branchid_validation(Ubranchid))
																		{
																			if(description_validation(Udescription))
																			{
																				if(price_validation(Uprice))
																				{
																					if(isveg_validation(Uisveg))
																					{
																						return true;
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	return false;
}


function Firstname_validation(UFirstname)
{
	var letter=/^[A-Za-z]+$/;
	if(UFirstname.value.match(letter))
	{
		return true;
	}
	else
	{
		alert("First Name Must be in Alphabetic or special characters only");
		UFirstname.focus();
		return false;

	}
}
function LastName_validation(ULastName)
{
	var letter=/^[A-Za-z]+$/;
	if(ULastName.value.match(letter))
		{
		return true;
		}
	else
		{
		alert("Last Name must be in Alphabetic or special characters only");
		ULastName.focus();
		return false;
		}
}
function name_validation(Uname)
{
	var letter=/^[A-Za-z]+$/;
	if(Uname.value.match(letter))
		{
		return true;
		}
	else
		{
		alert("Name must be in Alphabetic or special characters only");
		Uname.focus();
		return false;
		}
}
function location_validation(Ulocation)
{
	var letter=/^[A-Za-z]+$/;
	if(Ulocation.value.match(letter))
		{
		return true;
		}
	else
		{
		alert("Location must be in Alphabetic characters only");
		Ulocation.focus();
		return false;
		}
}
function city_validation(Ucity)
{
	var letter=/^[A-Za-z]+$/;
	if(Ucity.value.match(letter))
		{
		return true;
		}
	else
		{
		alert("City must be in Alphabetic characters only");
		ULastName.focus();
		return false;
		}
}
function state_validation(Ustate)
{
	var letter=/^[A-Za-z]+$/;
	if(Ustate.value.match(letter))
		{
		return true;
		}
	else
		{
		alert("State must be in Alphabetic or special characters only");
		Ustate.focus();
		return false;
		}
}
function country_validation(Ucountry)
{
	var letter=/^[A-Za-z]+$/;
	if(Ucountry.value.match(letter))
		{
		return true;
		}
	else
		{
		alert("Country must be in Alphabetic or special characters only");
		Ucountry.focus();
		return false;
		}
}
function userName_validation(UuserName)
{
	var letter=/^[A-Za-z]+$/;
	if(UuserName.value.match(letter))
		{
		return true;
		}
	else
		{
		alert("User name must be in Alphabetic or special characters only");
		UuserName.focus();
		return false;
		}
}
function description_validation(Udescription)
{
	var letter=/^[A-Za-z]+$/;
	if(Udescription.value.match(letter))
		{
		return true;
		}
	else
		{
		alert("Description must be in Alphabetic or special characters only");
		Udescription.focus();
		return false;
		}
}

function EmailId_validation(UEmailId)
{
	var letter=/^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9])+\.([A-Za-z0-9]{2,4})+$/;	
	if(UEmailId.value.match(letter))
	{
		return true;	
	}
	else
	{
		alert("Please enter a valid emailid");
		UEmailId.focus();
		return false;
	}
}


function phonenumber_validation(Uphonenumber)
{
	var phonenumber_len=Uphonenumber.value.length;
	if(phonenumber_len==10)
	{
		var number=/^[0-9]+$/;
		if(Uphonenumber.value.match(number))
		{
			return true;
		}
		else
		{
			alert("mobile number must be Numeric Only");
			Uphonenumber.focus();
			return false;
		}

	}
	else
	{
		alert("mobile number must be 10 digits only");
		Uphonenumber.focus();
		return false;
	}
}
