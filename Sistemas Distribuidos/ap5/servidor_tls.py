import socket
import ssl
import hashlib
import time

# Configuração do Contexto SSL
context = ssl.SSLContext(ssl.PROTOCOL_TLS_SERVER)
context.load_cert_chain('cert.pem', 'key.pem')

# Configuração do Servidor
server = socket.socket()
server.bind(('0.0.0.0', 5000))
server.listen(1)
print("Servidor SSL aguardando conexão na porta 5000...")

conn, addr = server.accept()
print(f"Cliente {addr} conectado. Estabelecendo SSL...")

# "Envelopa" a conexão com SSL
ssl_conn = context.wrap_socket(conn, server_side=True)
print("Conexão SSL estabelecida.")

try:
    # Receber os dados (já criptografados)
    data = ssl_conn.recv(1024).decode()
    escolha, msg, token = data.split('|')
    print(f"Recebido: {msg}")

    # Processar a escolha da falha
    if escolha == '1':
        print("Simulando FALHA DE TEMPO... (dormindo 5s)")
        time.sleep(5)
    
    elif escolha == '3':
        print("Simulando FALHA DE PARADA... (fechando conexão)")
        ssl_conn.close()
        raise ConnectionAbortedError("Simulação de falha de parada")

    # Processar a lógica de autenticação (normal)
    esperado = hashlib.sha256("segredo_comp".encode()).hexdigest()

    if token == esperado:
        if escolha == '2':
            print("Simulando FALHA BIZANTINA... (enviando lixo)")
            ssl_conn.send("## D4#o#s Cor~#p1#dos ##".encode())
        else:
            print("Enviando resposta normal...")
            ssl_conn.send("Autenticação bem-sucedida (via SSL)".encode())
    else:
        ssl_conn.send("Acesso negado (via SSL).".encode())

except Exception as e:
    print(f"Erro simulado ou real: {e}")

finally:
    print("Fechando conexão segura.")
    if 'ssl_conn' in locals():
        ssl_conn.close()
    server.close()