package io.github.Nog022.SpringBootExpert.exception;

public class PedidoNaoEncontradoException extends RuntimeException {
    public PedidoNaoEncontradoException() {
        super("Pedido Não encontrado");
    }
}
