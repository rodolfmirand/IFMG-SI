import socket
client = socket.socket()
for i in range(3):
    try:
        client.connect(('localhost', 5000))
        break
    except Exception as e:
        print("Tentando reconexão...", i+1)

client.send("Olá servidor!".encode())
client.settimeout(3)
try:
    data = client.recv(1024).decode()
except socket.timeout:
    print("Timeout: servidor não respondeu.")

print("Resposta:", data)
client.close()
