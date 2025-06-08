// Get the modal
var modal = document.getElementById('login');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
function loginRedirect(event) {
  event.preventDefault();

  const username = document.querySelector('input[name="uname"]').value;
  const password = document.querySelector('input[name="psw"]').value;
  const userType = document.querySelector('input[name="userType"]:checked');

  if (!userType) {
    alert("Please select a user type.");
    return false;
  }

  if (username === "admin" && password === "1234") {
    alert("Login successful!");
    if (userType.value === "farmer") {
      window.location.href = "welcomeF";
    } else {
      window.location.href = "welcomeR";
    }
  } else {
    alert("Invalid credentials.");
  }

  return false;
}

function handleSignUp(event) {
    event.preventDefault();

    const username = document.querySelector('input[name="newUser"]').value;
    const email = document.querySelector('input[name="email"]').value;
    const password = document.querySelector('input[name="newPsw"]').value;
    const selectedType = document.querySelector('select[name="userType"]').value;

    if (username && email && password) {
        alert("Sign-up successful!");
        document.getElementById('signupModal').style.display = 'none';

        if (selectedType === "farmer") {
            window.location.href = "welcomeF";
        } else {
            window.location.href = "welcomeR";
        }
    } else {
        alert("Please fill in all fields.");
    }
}

