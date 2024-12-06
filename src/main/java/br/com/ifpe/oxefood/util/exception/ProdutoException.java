package br.com.ifpe.oxefood.util.exception;

public class ProdutoException extends RuntimeException {
    public static final String MSG_VALOR_MINIMO_PRODUTO = "Não é permitido inserir produtos com valores inferiores a R$ 10.";

    public ProdutoException(String msg) {

	super(String.format(msg));
    }

}
