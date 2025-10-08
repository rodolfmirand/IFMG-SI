import rpyc
import uuid
import random
import threading
import socket
from rpyc.utils.server import ThreadedServer

def get_ip_address():
    s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    try:
        s.connect(('8.8.8.8', 1))
        IP = s.getsockname()[0]
    except Exception:
        IP = '127.0.0.1'
    finally:
        s.close()
    return IP

DEFAULT_PORT = 18861
port_input = input(f"Digite a porta para o servidor (pressione Enter para usar a padrão: {DEFAULT_PORT}): ")

try:
    if port_input == "":
        SERVER_PORT = DEFAULT_PORT
    else:
        SERVER_PORT = int(port_input)
    
except ValueError as e:
    print(f"Erro: Entrada inválida. {e}. Usando a porta padrão {DEFAULT_PORT}.")
    SERVER_PORT = DEFAULT_PORT

class GameService(rpyc.Service):
    players = {}
    lock = threading.Lock()

    def on_connect(self, conn):
        print(f"Conexão recebida de: {conn}")

    def on_disconnect(self, conn):
        print(f"Cliente desconectado: {conn}")

    def exposed_register_player(self):
        # registra um novo jogador e retorna um ID único e um estado inicial
        with self.lock:
            player_id = str(uuid.uuid4())
            colors = ["red", "blue", "yellow", "orange", "purple", "white", "cyan"]
            player_state = {
                'x': random.randint(-200, 200),
                'y': random.randint(-200, 200),
                'color': random.choice(colors)
            }
            self.players[player_id] = player_state
            print(f"Novo jogador registrado: {player_id}. Total de jogadores: {len(self.players)}")
            return player_id, player_state

    def exposed_publish_move(self, player_id, x, y):
        # atualiza a posição do jogador
        with self.lock:
            if player_id in self.players:
                self.players[player_id]['x'] = x
                self.players[player_id]['y'] = y
                return True
            return False

    def exposed_get_game_state(self):
        # retorna o estado de todos os jogadores
        with self.lock:
            return dict(self.players)
        
if __name__ == "__main__":
    local_ip = get_ip_address()
    
    print("\nIniciando o servidor do jogo...")
    print("=========================================================")
    print("Servidor pronto!")
    print(f"\n  - Para jogadores na MESMA máquina, use o IP: 127.0.0.1")
    print(f"  - Para jogadores em OUTRAS máquinas na rede, use o IP: {local_ip}")
    print(f"\n  - Porta: {SERVER_PORT}")
    print("=========================================================")
    
    t = ThreadedServer(GameService, port=SERVER_PORT, protocol_config={'allow_public_attrs': True})
    t.start()