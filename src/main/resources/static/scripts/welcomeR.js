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
      window.location.href = "infoR";
    });
  }

  // Handle report cards
  const reports = document.getElementsByClassName("report");
  for (let i = 0; i < reports.length; i++) {
    reports[i].addEventListener("click", () => {
      window.location.href = "reportR";
    });
  }

  // Handle goals cards
  const goal = document.getElementsByClassName("goals");
  for (let i = 0; i < goal.length; i++) {
    goal[i].addEventListener("click", () => {
      window.location.href = "ourGoalR";
    });
  }
});

