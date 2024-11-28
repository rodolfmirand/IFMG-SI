const counter = document.getElementById('counter')
var clicks = 0

function addClick(){
    clicks++
    counter.textContent = clicks
}