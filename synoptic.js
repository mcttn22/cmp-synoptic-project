document.addEventListener("DOMContentLoaded", function () {
    const burger = document.getElementById("burger");
    const nav = document.querySelector("nav");

    nav.classList.remove("showNav"); // hide on load

    burger.addEventListener("click", () => {
        nav.classList.toggle("showNav");
    });
});


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
      window.location.href = "welcomeF.html";
    } else {
      window.location.href = "welcomeR.html";
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
            window.location.href = "welcomeF.html";
        } else {
            window.location.href = "welcomeR.html";
        }
    } else {
        alert("Please fill in all fields.");
    }
}

if(document.URL.includes("welcomeF.html")){
let slideIndex = 1;

showSlides(slideIndex);

// Next/previous controls
function plusSlides(n) {
  showSlides(slideIndex += n);
}

// Thumbnail image controls
function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  let i;
  let slides = document.getElementsByClassName("mySlides");
  let dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " active";
}
document.addEventListener("DOMContentLoaded", () => {
  // Handle info cards
  const information = document.getElementsByClassName("info");
  for (let i = 0; i < information.length; i++) {
    information[i].addEventListener("click", () => {
      window.location.href = "infoF.html";
    });
  }

  // Handle report cards
  const reports = document.getElementsByClassName("report");
  for (let i = 0; i < reports.length; i++) {
    reports[i].addEventListener("click", () => {
      window.location.href = "reportF.html";
    });
  }

  // Handle goals cards
  const goal = document.getElementsByClassName("goals");
  for (let i = 0; i < goal.length; i++) {
    goal[i].addEventListener("click", () => {
      window.location.href = "ourGoalF.html";
    });
  }
});}
if(document.URL.includes("welcomeR.html")){
let slideIndex = 1;

showSlides(slideIndex);

// Next/previous controls
function plusSlides(n) {
  showSlides(slideIndex += n);
}

// Thumbnail image controls
function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  let i;
  let slides = document.getElementsByClassName("mySlides");
  let dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " active";
}
document.addEventListener("DOMContentLoaded", () => {
  // Handle info cards
  const information = document.getElementsByClassName("info");
  for (let i = 0; i < information.length; i++) {
    information[i].addEventListener("click", () => {
      window.location.href = "infoR.html";
    });
  }

  // Handle report cards
  const reports = document.getElementsByClassName("report");
  for (let i = 0; i < reports.length; i++) {
    reports[i].addEventListener("click", () => {
      window.location.href = "reportR.html";
    });
  }

  // Handle goals cards
  const goal = document.getElementsByClassName("goals");
  for (let i = 0; i < goal.length; i++) {
    goal[i].addEventListener("click", () => {
      window.location.href = "ourGoalR.html";
    });
  }
});}


let myForm = document.querySelector('form');  // Form element
let myName = document.querySelector('#nameSubmitted');  // Name input
let mySurname = document.querySelector('#surnameSubmitted'); //surname input 
let myEmail = document.querySelector('#emailSubmitted');  // Email input
let message = document.querySelector('#commentsSubmitted');  // Message display area
let submitBtn = document.querySelector('#registerButton');  // Submit button
let paragraphForm = document.querySelector('.formPara');

// only happens in the form is on the page 
if (myForm != null){
    // listen for the submit button to be pressed 
    myForm.addEventListener('submit',(e) =>{
        if (myName.value && myEmail.value) {
            e.preventDefault();
            e.stopImmediatePropagation()
            e.stopPropagation()
            const formBody = {
                name:myName.value,
                email:myEmail.value,
                message:message.value
            };
            const requestHeaders = {
                "Content-Type": "application/json"
                };
            fetch('http://localhost:3000/report.html', {
                method: 'POST',
                headers: requestHeaders,
                body: JSON.stringify(formBody),
                }
            ).then(response => response.json())
            .then((responsedata) => {
                console.log(responsedata);
                paragraphForm.textContent=`Hi ${responsedata.name}, your message has
                been received, we will contact you at ${responsedata.email}`;
            })
        } else {
            paragraphForm.textContent = "Error: Please fill in both fields!";
        }

    })
}