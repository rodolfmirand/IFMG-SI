<?php
$peso = $_POST['peso'];
$altura = $_POST['altura'];

if(empty($altura) || empty($peso)){
    echo json_encode(['status' => 'error', 'message' => 'Campos inválidos!']);
    exit;
} 

$imc = $peso/($altura * $altura);
$message = null;
if ($imc < 18.5) {
    $message =  'Abaixo do normal';
} elseif ($imc >= 18.5 && $imc <= 24.9) {
    $message = 'message' => 'Normal';
} elseif ($imc >= 25 && $imc <= 29.9) {
    $message = 'Sobrepeso';
} elseif ($imc >= 30 && $imc <= 34.9) {
    $message = 'Obesidade grau I';
} elseif ($imc >= 35 && $imc <= 39.9) {
    $message = 'message' => 'Obesidade grau II';
} else {
    $message = 'Obesidade grau III';
}


echo json_encode(['status' => 'success', 'message' => $message]);
