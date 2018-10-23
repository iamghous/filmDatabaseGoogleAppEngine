$(document).ready(function() {
// we will use jquery library's methods in this jquery file
	/*
	 * it is same for all the div's but i will explain what is going on in the first one
	 */
	// when div with structuredOutput id is clicked this function will run
    $( "#structuredOutput" ).click(function() {
    	// if div with structuredOutput1 id is hidden it will slide down it and slide up the other 2 divs
  if ( $( "#structuredOutput1" ).is( ":hidden" ) ) {
	  // slide down the div
    $( "#structuredOutput1" ).slideDown( "slow" );
    // slide up the div
      $( "#xmlOutput1" ).slideUp( "slow" );
      // slide up the div
      $( "#jsonOutput1" ).slideUp( "slow" );
      
  } else {
	  // else if the div is already visible, it will just make it slide up and hidden
    $( "#structuredOutput1" ).slideUp();
  }
        });
    
    //////// Same as the First one
    
         $( "#xmlOutput" ).click(function() {
  if ( $( "#xmlOutput1" ).is( ":hidden" ) ) {
    $( "#xmlOutput1" ).slideDown( "slow" );
      $( "#structuredOutput1" ).slideUp( "slow" );
      $( "#jsonOutput1" ).slideUp( "slow" );
      
  } else {
    $( "#xmlOutput1" ).slideUp();
  }
         }); 
         
         // same as the first one
              $( "#jsonOutput" ).click(function() {
  if ( $( "#jsonOutput1" ).is( ":hidden" ) ) {
    $( "#jsonOutput1" ).slideDown( "slow" );
      $( "#xmlOutput1" ).slideUp( "slow" );
      $( "#structuredOutput1" ).slideUp( "slow" );
      
  } else {
    $( "#jsonOutput1" ).slideUp();
  }
        
        
});
    
 
});