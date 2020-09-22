function previewFile1(input) {

  var file = $(input).get(0).files[0];

  if (file) {
    var reader = new FileReader();

    reader.onload = function() {
      $("#previewImg1").attr("src", reader.result);
    }

    reader.readAsDataURL(file);
  }
}

function previewFile2(input) {

  var file = $(input).get(0).files[0];

  if (file) {
    var reader = new FileReader();

    reader.onload = function() {
      $("#previewImg2").attr("src", reader.result);
    }

    reader.readAsDataURL(file);
  }
}
