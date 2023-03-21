package modelos.excecoes;

public class WithdrawException extends RuntimeException{

    public WithdrawException(String mensagem){
        super(mensagem);
    }
}
