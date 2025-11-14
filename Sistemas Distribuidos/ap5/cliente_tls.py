import socket
import ssl
import hashlib
import time

# Configuração do Contexto SSL do Cliente
context = ssl.create_default_context()

context.check_hostname = False
context.verify_mode = ssl.CERT_NONE

ssl_client = None
for i in range(3): # Tenta 3 vezes
    try:
        # Cria o socket e faz o "wrap" antes de conectar
        client = socket.socket()
        ssl_client = context.wrap_socket(client, server_hostname='localhost')
        
        print(f"Tentativa {i+1}: Conectando ao servidor SSL...")
        ssl_client.connect(('servidor', 5000))
        print("Conexão SSL estabelecida.")
        break
        
    except Exception as e:
        print(f"Tentativa {i+1} falhou: {e}")
        time.sleep(1)
else:
    print("Falha ao conectar após 3 tentativas. Abortando.")
    exit()

try:
    print("\n[CONTROLE DE TESTE DE FALHAS SSL]")    
    print(" 1: Simular Timeout (atraso de 5s)")
    print(" 2: Simular Falha Bizantina (enviar resposta corrompida)")
    print(" 3: Simular Falha de Parada (desligar antes de responder)")
    print("Enter: Comportamento normal (sem falhas)")

    escolha = input("Escolha a falha a simular: ")

    msg = input("Digite a mensagem para o servidor: ")

    # Define o timeout para 3 segundos
    ssl_client.settimeout(3.0)

    token = hashlib.sha256("segredo_comp".encode()).hexdigest()
    
    ssl_client.send(f"{escolha}|{msg}|{token}".encode())
    print("Mensagem enviada. Aguardando resposta...")

    # Tenta receber a resposta
    try:
        data = ssl_client.recv(1024).decode()
        print("Resposta:", data)
        
    except socket.timeout:
        print("TIMEOUT: Servidor não respondeu em 3 segundos.")
    except Exception as e:
        print(f"Erro ao receber dados: {e}")

finally:
    print("Fechando conexão com o cliente.")
    if ssl_client:
        ssl_client.close()