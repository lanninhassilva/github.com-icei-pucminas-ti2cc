package unidade01;

import java.util.Scanner;

public class SomarDoisNumero {

    public static void main(String[] args) {

     
        int num1, num2, soma;

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um número:");
        num1 = sc.nextInt();

        System.out.println("Digite outro número:");
        num2 = sc.nextInt();

        soma = num1 + num2;

        System.out.println("Soma: " + soma);

        sc.close();
    }
}