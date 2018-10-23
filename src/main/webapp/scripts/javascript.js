// this method will be used to call the insertData servlet using Ajax
function insertFilmData(address,id){
	// it will get all the input values and put them nicely in the variables  
    var filmName  = document.getElementById('filmName').value;
    var filmGenre   = document.getElementById('filmGenre').value;
    var filmCredits = document.getElementById('filmCredits').value;
    var filmYear=document.getElementById('filmYear').value;
    var filmGross= document.getElementById('filmGross').value;
    var filmCountry= document.getElementById('filmCountry').value;
    // this is the parameter that will be sent in the request
    var parameter = "?filmName="+filmName+"&filmGenre="+filmGenre+"&filmCredits="+filmCredits+"&filmYear="+filmYear+"&filmGross="+filmGross+"&filmCountry="+filmCountry;
    
    // it will create a new variable of XMLHTTPRequest
	 var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
		  // once everything is fine it will call this method when it receives 200 status
	    if (this.readyState == 4 && this.status == 200) {
	    	// it will update the innerHTML of the given div with the responseText
	     document.getElementById(id).innerHTML = this.responseText;
	    }
	  };
	  // it will request the servlet using GET request and pass the parameter variable which we created earlier
	  xhttp.open("GET", address + parameter, true);
	  // and send the request
	  xhttp.send();
	
}

// this method will be used to call getAllFilms Servlet which will return all the films
function getAllFilmsData(address,id){
	// will assign the selectAllFilmsBox id to a variable  
    var selectBox = document.getElementById("selectAllFilmsBox");
    // will assign the value of selectBox to variable
    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
    // will call the getOutputDiv which will return the div where we need to insert the responseText
    var outputDiv = getOutputDivId(selectedValue);
 // it will create a new variable of XMLHTTPRequest
	 var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
		  // once everything is fine it will call this method when it receives 200 status
	    if (this.readyState == 4 && this.status == 200) {
	    	// it will update the innerHTML of the given div with the responseText
	     document.getElementById(outputDiv).innerHTML = this.responseText;
	    }
	  };
	// it will request the servlet using GET request and pass the parameter variable which we created earlier
	  xhttp.open("GET", address + "?format="+selectedValue, true);
	  // and send the request
	  xhttp.send();	
}
// this method will be used call getFilm Servlet which will return the searched film
function getSearchedFilmData(address,id){
	// will assign the selectSearchFilmBox id to a variable  
    var selectBox = document.getElementById("selectSearchFilmBox");
    // will assign the value of selectBox to variable
    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
    // this will get the value of search field which we need to send in the request
    var search = document.getElementById('searchFilmName').value;
    // we will call the method to get the div id of where responseText needed to be placed
    var outputDiv = getOutputDivId(selectedValue);
	 var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	     document.getElementById(outputDiv).innerHTML = this.responseText;
	    }
           if (this.readyState != 4 && this.status == 204) {
        	   // if the status code is 204 no content this will be executed
	     document.getElementById(id).innerHTML = this.responseText;
	    }
	  };
	// it will request the servlet using GET request and pass the parameter variable which we created earlier
	  xhttp.open("GET", address + "?format="+selectedValue+"&search="+search, true);
	  // and send the request
	  xhttp.send();
	
}

// this method will insert the 'Output1' in the string and return it 
function getOutputDivId(format){

    var outputDiv = format+"Output1";
    
    return outputDiv;
    
    
}





