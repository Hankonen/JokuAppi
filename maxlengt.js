$('div').on('keydown', function(event) {
    $('span').text('Total chars:' + $(this).text().length);
    if($(this).text().length === 10 && event.keyCode != 8) {
        event.preventDefault();
    }
  });