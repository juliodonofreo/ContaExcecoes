package aplicacao;

import modelos.entidades.Conta;
import modelos.entidades.Titular;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Titular titular = criarTitular();
        Conta conta = criarConta(titular);
        sc.close();
    }

    public static int validarInteiro(String mensagem){
        Integer valor = null;

        do {
            try {
                System.out.print(mensagem);
                valor = sc.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.print("O valor inserido deve ser um número inteiro, digite novamente. ");
                sc.nextLine();
            }
        }while (valor == null);

        return valor;
    }

    public static double validarDouble(String mensagem) {
        Double valor = null;
        do {
            try {
                System.out.print(mensagem);
                valor = sc.nextDouble();
            }
            catch (InputMismatchException e) {
                System.out.print("O valor inserido deve ser um número, digite novamente. ");
                sc.nextLine();
            }
        } while (valor == null);

        return valor;
    }

    public static Titular criarTitular() {
        Titular titular = null;

        do {
            try {
                System.out.print("Digite o nome do titular: ");
                String nome = sc.nextLine();
                int idade = validarInteiro("Digite o valor da idade: ");
                titular = new Titular(nome, idade);
            }
            catch (IllegalArgumentException e) {
                System.out.println("FALHA NA CRIAÇÃO DO TITULAR: " + e.getMessage());
            }
            catch (Exception e) {
                System.out.println("Exceção inesperada: " + e.getMessage());
            }
        } while (titular == null);

        return  titular;
    }

    public static Conta criarConta(Titular titular){
        Conta conta = null;

        do {
            try {
                int numeroConta = validarInteiro("Digite o numero da conta: ");
                double saldo = validarDouble("Digite o valor do saldo: ");
                double limite = validarDouble("Digite o limite do usuário: ");
                conta = new Conta(numeroConta, titular, saldo, limite);
            }
            catch (IllegalArgumentException e) {
                System.out.println("FALHA NA CRIAÇÃO DA CONTA: " + e.getMessage());
            }
            catch (Exception e) {
                System.out.println("Erro inesperado: " + e);
            }

        }while (conta == null);

        return conta;
    }
}