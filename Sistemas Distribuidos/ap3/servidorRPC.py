import rpyc
import uuid
import random
import threading
from rpyc.utils.server import ThreadedServer

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
    print("Iniciando o servidor do jogo na porta 18861...")
    t = ThreadedServer(GameService, port=18861, protocol_config={'allow_public_attrs': True})
    t.start()