import turtle
import time
import rpyc

DEFAULT_HOST = 'localhost'
DEFAULT_PORT = 18861

host_input = input(f"Digite o IP do servidor (pressione Enter para '{DEFAULT_HOST}'): ")
SERVER_IP = host_input if host_input else DEFAULT_HOST

port_input = input(f"Digite a porta do servidor (pressione Enter para {DEFAULT_PORT}): ")
try:
    SERVER_PORT = int(port_input) if port_input else DEFAULT_PORT
except ValueError as e:
    print(f"Erro: Porta inválida. {e}. Usando a porta padrão {DEFAULT_PORT}.")
    SERVER_PORT = DEFAULT_PORT

try:
    print(f"Conectando ao servidor em {SERVER_IP}:{SERVER_PORT}...")
    proxy = rpyc.connect(SERVER_IP, SERVER_PORT, config={'allow_public_attrs': True})
    
    MY_ID, my_initial_state = proxy.root.register_player()
    print(f"Conectado com sucesso! Seu ID: {MY_ID[:8]}")

except ConnectionRefusedError:
    print("\nERRO: A conexão foi recusada. Verifique se:")
    print(f"1. O servidor está rodando no IP '{SERVER_IP}'.")
    print(f"2. A porta '{SERVER_PORT}' está correta e não está bloqueada por um firewall.")
    exit()
    
delay = 0.05

wn = turtle.Screen()
wn.title(f"Move Game - Jogador: {MY_ID[:8]}")
wn.bgcolor("green")
wn.setup(width=800, height=600)
wn.tracer(0)

head = turtle.Turtle()
head.speed(0)
head.shape("circle")
head.color(my_initial_state['color'])
head.penup()
head.goto(my_initial_state['x'], my_initial_state['y'])
head.direction = "stop"

# dicionário para rastrear outros jogadores
other_players_turtles = {}
last_pos = (head.xcor(), head.ycor())

def go_up():
    if head.direction != "down": head.direction = "up"
def go_down():
    if head.direction != "up": head.direction = "down"
def go_left():
    if head.direction != "right": head.direction = "left"
def go_right():
    if head.direction != "left": head.direction = "right"
def close():
    wn.bye()

def move():
    if head.direction == "up": head.sety(head.ycor() + 2)
    if head.direction == "down": head.sety(head.ycor() - 2)
    if head.direction == "left": head.setx(head.xcor() - 2)
    if head.direction == "right": head.setx(head.xcor() + 2)

wn.listen()
wn.onkeypress(go_up, "w")
wn.onkeypress(go_down, "s")
wn.onkeypress(go_left, "a")
wn.onkeypress(go_right, "d")
wn.onkeypress(close, "Escape")

while True:
    move()

    current_pos = (head.xcor(), head.ycor())
    if current_pos != last_pos:
        proxy.root.publish_move(MY_ID, current_pos[0], current_pos[1])
        last_pos = current_pos

    # obtém o estado do jogo do servidor
    game_state = proxy.root.get_game_state()
    print(f"Estado do jogo recebido: {game_state}")

    # atualiza a posição dos outros jogadores
    for player_id, state in game_state.items():
        if player_id == MY_ID:
            continue

        if player_id not in other_players_turtles:
            new_player_turtle = turtle.Turtle()
            new_player_turtle.speed(0)
            new_player_turtle.shape("circle")
            new_player_turtle.color(state['color'])
            new_player_turtle.penup()
            other_players_turtles[player_id] = new_player_turtle
            print(f"Novo jogador detectado: {player_id}")

        other_players_turtles[player_id].goto(state['x'], state['y'])

    wn.update()
    time.sleep(delay)