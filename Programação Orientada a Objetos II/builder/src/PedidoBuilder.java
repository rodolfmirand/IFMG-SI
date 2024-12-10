public class PedidoBuilder {
    private Pedido pedido;

    public PedidoBuilder() {
        pedido = new Pedido();
    }

    public PedidoBuilder adicionarHamburguer() {
        pedido.adicionarDentroDaCaixa("Hamburguer");
        return this;
    }

    public PedidoBuilder adicionarCheeseburger() {
        pedido.adicionarDentroDaCaixa("Cheeseburger");
        return this;
    }

    public PedidoBuilder adicionarBatataPequena() {
        pedido.adicionarDentroDaCaixa("Batata Pequena");
        return this;
    }

    public PedidoBuilder adicionarBatataMedia() {
        pedido.adicionarDentroDaCaixa("Batata Média");
        return this;
    }

    public PedidoBuilder adicionarBatataGrande() {
        pedido.adicionarDentroDaCaixa("Batata Grande");
        return this;
    }

    public PedidoBuilder adicionarCarrinho() {
        pedido.adicionarDentroDaCaixa("Carrinho");
        return this;
    }

    public PedidoBuilder adicionarBonequinha() {
        pedido.adicionarDentroDaCaixa("Bonequinha");
        return this;
    }

    public PedidoBuilder adicionarCoca() {
        pedido.adicionarForaDaCaixa("Coca");
        return this;
    }

    public PedidoBuilder adicionarGuarana() {
        pedido.adicionarForaDaCaixa("Guaraná");
        return this;
    }

    public Pedido build() {
        return pedido;
    }
}
