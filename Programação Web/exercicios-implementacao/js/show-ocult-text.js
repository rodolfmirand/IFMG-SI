const text = document.getElementById('text')
const image = document.getElementById('image')
var visible = true

function changeText() {
    if(visible){
        text.textContent = ""
        image.src = '/images/closed-eye.png'
        visible = false
    } else {
        text.textContent = "Hello World!"
        image.src = '/images/opened-eye.png'
        visible = true
    }
}