package modelos.entidades;

public class Conta {

    private static int contador = 1000;

    private Integer numeroConta;
    private Titular titular;
    private Double saldo;;
    private Double limiteSaque;

    public Conta() {

    }

    public Conta(Titular titular, Double saldo, Double limiteSaque) {

        this.numeroConta = Conta.contador;
        this.titular = titular;
        this.saldo = saldo;
        this.limiteSaque = limiteSaque;
        Conta.contador += 1;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getLimiteSaque() {
        return limiteSaque;
    }

    public void setLimiteSaque(Double limiteSaque) {
        this.limiteSaque = limiteSaque;
    }
}
