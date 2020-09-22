$(document).ready(function(){
    $(".company").hide();    
    $(".iscompany").click(function(){
      if(this.value == "true"){
          $(".user").hide();
          $(".company").show();
      }
      else{
          $(".company").hide();
          $(".user").show();
      }
  });
});