document.addEventListener("DOMContentLoaded", function () {
    const burger = document.getElementById("burger");
    const nav = document.querySelector("nav");

    nav.classList.remove("showNav"); // hide on load

    burger.addEventListener("click", () => {
        nav.classList.toggle("showNav");
    });
});

