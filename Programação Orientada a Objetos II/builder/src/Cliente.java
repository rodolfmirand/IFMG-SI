public class Cliente {
    public static void main(String[] args) {
        Atendente atendente = new Atendente();
        PedidoBuilder pedidoBuilder = atendente.iniciarPedido();

        pedidoBuilder.adicionarHamburguer()
                .adicionarBatataMedia()
                .adicionarCarrinho()
                .adicionarCoca();

        Funcionario funcionario = new Funcionario();
        Pedido pedido = funcionario.montarPedido(pedidoBuilder);

        System.out.println(pedido);
    }
}
