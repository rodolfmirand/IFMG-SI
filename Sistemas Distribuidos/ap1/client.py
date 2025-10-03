import socket, json, yaml, toml, time

host = '127.0.0.1'
port = 9009

dados = {
    "nome": "Rodolfo Oliveira Miranda", 
    "cpf": "123.456.789-00",
    "idade": 20,
    "mensagem": "Hello, World!"
}

mensagens = [
    ("CSV", "nome,cpf,idade,mensagem\n{nome},{cpf},{idade},{mensagem}".format(**dados)),
    ("JSON", json.dumps(dados)),
    ("XML", f"<dados><nome>{dados['nome']}</nome><cpf>{dados['cpf']}</cpf><idade>{dados['idade']}</idade><mensagem>{dados['mensagem']}</mensagem></dados>"),
    ("YAML", yaml.dump(dados)),
    ("TOML", toml.dumps(dados))
]

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client.connect((host, port))

for formato, msg in mensagens:
    mensagem_final = f"{formato}\n{msg}"
    client.sendall(mensagem_final.encode("utf-8"))
    time.sleep(0.5)

client.close()

# CSV
# nome,cpf,idade,mensagem
# Rodolfo Oliveira Miranda,123.456.789-00,20, Hello, World!

# JSON
# {
#   "nome": "Rodolfo Oliveira Miranda",
#   "cpf": "123.456.789-00",
#   "idade": 20,
#   "mensagem": "Hello, World!"
# }

# XML
# <dados>
#   <nome>Rodolfo Oliveira Miranda</nome>
#   <cpf>123.456.789-00</cpf>
#   <idade 20</idade>
#   <mensagem>Hello, World!"</mensagem>
# </dados>

# YAML
# nome: Rodolfo Oliveira Miranda
# cpf: 123.456.789-00
# idade: 20
# mensagem: Hello, World!"

# TOML
# nome = "Rodolfo Oliveira Miranda"
# cpf = "123.456.789-00"
# idade = 20
# mensagem = "Hello, World!"
