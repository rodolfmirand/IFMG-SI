document.querySelector("#calcular").addEventListener("click", async () => {
    const peso = parseFloat(document.querySelector("#peso").value);
    const altura = parseFloat(document.querySelector("#altura").value);

    if (isNaN(peso) || isNaN(altura)) {
        alert("Por favor, insira valores válidos.");
        return;
    }

    const response = await fetch("index.php", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({ peso, altura }),
    });

    const data = await response.json();

    if (data.error) {
        alert(data.error);
    } else {
        document.querySelector('.popup').style.display = 'block';
        document.querySelector("#resultado-imc").textContent =
            `${data.imc}`;
        document.querySelector("#resultado-classificacao").textContent =
            `${data.status}`;
    }
});

document.querySelector('#close-popup').addEventListener('click', () => {
    document.querySelector('.popup').style.display = 'none';
});