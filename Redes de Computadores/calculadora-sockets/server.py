import socket

HOST = 'localhost'
PORT = 5000

def calcular(operacao, num1, num2):
    if operacao == 'soma':
        return num1 + num2
    elif operacao == 'subtracao':
        return num1 - num2
    else:
        return 'Operação inválida'

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as servidor:
    servidor.bind((HOST, PORT))
    servidor.listen()
    print(f"Servidor ouvindo em {HOST}:{PORT}...")

    while True:
        conexao, endereco = servidor.accept()
        with conexao:
            print(f"Conectado por {endereco}")
            dados = conexao.recv(1024).decode()
            if not dados:
                break

            partes = dados.split(',')
            if len(partes) != 3:
                conexao.sendall("Erro: dados inválidos".encode())
                continue

            operacao, num1, num2 = partes
            try:
                num1 = float(num1)
                num2 = float(num2)
                resultado = calcular(operacao.strip(), num1, num2)
                conexao.sendall(str(resultado).encode())
            except ValueError:
                conexao.sendall("Erro: números inválidos".encode())
