package modelos.entidades;

import modelos.excecoes.WithdrawException;

public class Conta {

    private static int contador = 1000;

    private Integer numeroConta;
    private Titular titular;
    private Double saldo;;
    private Double limiteSaque;

    public Conta() {

    }

    public Conta(Titular titular, Double saldo, Double limiteSaque) {
        if(limiteSaque < 0) {
            throw new IllegalArgumentException("O limite não pode ser um valor negativo. ");
        }

        this.numeroConta = Conta.contador;
        this.titular = titular;
        this.saldo = saldo;  // não há validação de saldo pois o saldo pode, de fato, ser negativo.
        this.limiteSaque = limiteSaque;
        Conta.contador += 1;
    }

    public Integer getNumeroConta() {
        return numeroConta;
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

    public void deposito(double valor) {
        if(valor < 0){
            throw new IllegalArgumentException("O valor a se depositar não pode ser negativo. Digite um valor válido. ");
        }else if(valor == 0) {
            throw new IllegalArgumentException("Não é possivel fazer um depósito nulo. Digite um valor válido. ");
        }

        saldo += valor;
    }

    public void saque(double valor) {
        if(valor < 0) {
            throw new IllegalArgumentException("O valor a se sacar não pode ser negativo. Digite um valor válido. ");
        }else if (valor == 0) {
            throw new IllegalArgumentException("Não é possivel fazer um saque nulo. Digite um valor válido. ");
        }

        double novoSaldo = saldo - valor;
        if (novoSaldo < 0) {
            throw new WithdrawException("Saldo insuficiente para concluir a operação. ");
        } else if (valor > limiteSaque) {
            throw new WithdrawException("Valor acima do limite de saque. ");
        }

        saldo = novoSaldo;
    }
}
