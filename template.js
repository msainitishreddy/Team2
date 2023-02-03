$('.account, .header-products a').click(function(e) {
    e.preventDefault();
    $(this).next('.account-details, .header-products ul').toggle();
    });

