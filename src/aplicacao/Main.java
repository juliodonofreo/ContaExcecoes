package aplicacao;

import modelos.entidades.Conta;
import modelos.entidades.Titular;
import modelos.excecoes.DepositException;
import modelos.excecoes.WithdrawException;
import modelos.validacoes.Validacoes;

import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static Titular criarTitular() {
        Titular titular = null;

        do {
            try {
                System.out.print("Digite o nome do titular: ");
                String nome = sc.nextLine();
                int idade = Validacoes.validarInteiro("Digite a idade do titular: ");
                titular = new Titular(nome, idade);
            }
            catch (IllegalArgumentException e) {
                System.out.println("FALHA NO ACESSO DO TITULAR " + e.getMessage());
            }
            catch (Exception e) {
                System.out.println("Exceção inesperada: " + e.getMessage());
            }
            finally {
                System.out.println();
            }
        } while (titular == null);

        return  titular;
    }

    public static Conta criarConta(Titular titular){
        Conta conta = null;

        do {
            try {
                int numeroConta = Validacoes.validarInteiro("Digite o numero da conta: ");
                double saldo = Validacoes.validarDouble("Digite o valor do saldo inicial: ");
                double limite = Validacoes.validarDouble("Digite o limite de saque: ");
                conta = new Conta(numeroConta, titular, saldo, limite);
            }
            catch (IllegalArgumentException e) {
                System.out.println("FALHA NO ACESSO À CONTA: " + e.getMessage());
            }
            catch (DepositException e) {
                System.out.println("FALHA NO DEPÓSITO: " + e.getMessage());
            }
            catch (Exception e) {
                System.out.println("Erro inesperado: " + e);
            }
            finally {
                System.out.println();
            }

        }while (conta == null);

        return conta;
    }

    public static void main(String[] args) {

        Titular titular = criarTitular();
        Conta conta = criarConta(titular);

        double valorSaque = Validacoes.validarDouble("Digite um valor para sacar: ");

        try{
            conta.saque(valorSaque);
            System.out.println("Novo saldo: " + conta.getSaldo());
        }
        catch (WithdrawException e) {
            System.out.println("ERRO NO SAQUE! " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Erro inesperado: " + e);
        }
        sc.close();
    }
}