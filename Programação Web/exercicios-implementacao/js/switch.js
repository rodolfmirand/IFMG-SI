const switchInput = document.getElementById('switch')
const light = document.getElementById('light')

switchInput.addEventListener('change', function () {
    if (switchInput.checked) {
        light.classList.remove('hidden');
    } else {
        light.classList.add('hidden');
    }
});