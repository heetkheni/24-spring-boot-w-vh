<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Box Cricket Registration</h1>
	
	<form action="savereg" method = "post">
	
	Name : <input type = "text" name = "studentName" value = "${playerNameValue}"><span style = "color:red">${studentNameError}</span><br><Br>
	
	Player Type : 		Batsman <input type="radio" name="playerType" value="Batsman"   ${playerTypeValue != null && playerTypeValue.equals("Batsman") ? "checked" : ""} />
						Bowller <input type="radio" name="playerType" value="Bowller" ${playerTypeValue != null && playerTypeValue.equals("Bowller") ? "checked" : ""} />
						AllRounder 	 <input type="radio" name="playerType" value="AllRounder" ${playerTypeValue != null && playerTypeValue.equals("AllRounder") ? "checked" : ""} />
						<span style = "color:red">${playerTypeError}</span>
						<br><br> 
						
	Food Preference : 
		
					<select name="foodPreference">
						<option value="-1">---Select Your Food Preference---</option>
						<option value="Regular" ${foodPreferenceValue != null && foodPreferenceValue.equals("Regular") ? "selected" : ""}  >Regular</option>
						<option value="Jain" ${foodPreferenceValue != null && foodPreferenceValue.equals("Jain") ? "selected" : ""} >Jain</option>
					</select>	
					<span style = "color:red">${foodPreferenceError}</span>
					<br><br>
		Drink : 
				RB	<input type="checkbox" name="drink" value="rb" ${drinkValue.contains("rb") ? "checked" : ""} /> 
				MD<input type="checkbox" name="drink" value="md"${drinkValue.contains("md") ? "checked" : ""}/>
				TH<input type="checkbox" name="drink" value="th"${drinkValue.contains("th") ? "checked" : ""}/>
				LJ<input type="checkbox" name="drink" value="lj"${drinkValue.contains("lj") ? "checked" : ""}/>
				Co <input type="checkbox" name="drink" value="co"${drinkValue.contains("co") ? "checked" : ""}/>
				
				<span style = "color:red">${drinkError}</span>
				
				<br><Br>
				<input type="submit" value="Register"/>
				
				
	
	
	</form>
</body>
</html>