package modelos.validacoes;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Validacoes {
    private static Scanner sc = new Scanner(System.in);

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
}
