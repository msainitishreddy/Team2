const addToCartBtn = document.querySelector('button');

addToCartBtn.addEventListener('click', () => {
  // get the product name and price
  const productName = document.querySelector('h1').textContent.trim();
  const productPrice = document.querySelector('p').textContent.trim().replace('£', '');

  const xhr = new XMLHttpRequest();

  xhr.open('POST', 'cart.php');

  xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

  // set the request body with the product name and price
  const requestBody = `product_name=${productName}&product_price=${productPrice}`;
  
  xhr.send(requestBody);

  window.location.href = 'cart.html';
});
