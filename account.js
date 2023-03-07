const loginForm = document.getElementById('login-form');
const loginButton = document.getElementById('login-button');

loginForm.addEventListener('submit', function(event) {
  event.preventDefault(); 
  
  const email = document.getElementById('email').value;
  const password = document.getElementById('password').value;
  
  const xhr = new XMLHttpRequest();
  xhr.open('POST', 'login.php');
  xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
  xhr.onload = function() {
    if (xhr.status === 200) {
      const response = JSON.parse(xhr.responseText);
      
      if (response.success) {
        // Redirect to homepage with success message
        window.location.href = 'homepage.html?message=success';
      } else {
        // Show error message
        alert('Invalid email or password');
      }
    } else {
      alert('An error occurred');
    }
  };
  xhr.send(`email=${email}&password=${password}`);
});
