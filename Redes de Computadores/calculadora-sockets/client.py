import socket

HOST = 'localhost'
PORT = 5000

print("Operações disponíveis: soma, subtracao")
operacao = input("Digite a operação desejada: ").strip()
num1 = input("Digite o primeiro número: ").strip()
num2 = input("Digite o segundo número: ").strip()

mensagem = f"{operacao},{num1},{num2}"

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as cliente:
    cliente.connect((HOST, PORT))
    cliente.sendall(mensagem.encode())
    resultado = cliente.recv(1024).decode()
    print(f"Resultado: {resultado}")
