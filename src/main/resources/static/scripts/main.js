let burger = document.querySelector('#burger');
function shownav(){
    document.querySelector('nav ul').classList.toggle('showNav');
}
if(burger){
    burger.addEventListener('click', shownav);
}

