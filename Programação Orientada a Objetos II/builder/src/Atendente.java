public class Atendente {
    private PedidoBuilder pedidoBuilder;

    public Atendente() {
        pedidoBuilder = new PedidoBuilder();
    }

    public PedidoBuilder iniciarPedido() {
        return pedidoBuilder;
    }
}
