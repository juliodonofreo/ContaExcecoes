package modelos.excecoes;

public class DepositException extends RuntimeException{

    public DepositException(String mensagem) {
        super(mensagem);
    }
}
