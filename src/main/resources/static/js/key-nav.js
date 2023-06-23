$('document').ready(function () {
  var keyHiddenInput = $('.info-key-hidden');
  keyHiddenInput.val('4K')
  $('#4kbtn').addClass('red');

})

function keyValue(keyBtn) {
  var keyHiddenInput = $('.info-key-hidden');
  keyHiddenInput.val(keyBtn);
  resetRedClass();
  switch (keyBtn) {
    case '4K':
      $('#4kbtn').addClass('red');
      break;
    case '5K':
      $('#5kbtn').addClass('red');
      break;
    case '6K':
      $('#6kbtn').addClass('red');
      break;
    case '8K':
      $('#8kbtn').addClass('red');
      break;
  }
}

function resetRedClass() {
  $('#4kbtn').removeClass('red');
  $('#5kbtn').removeClass('red');
  $('#6kbtn').removeClass('red');
  $('#8kbtn').removeClass('red');
}

