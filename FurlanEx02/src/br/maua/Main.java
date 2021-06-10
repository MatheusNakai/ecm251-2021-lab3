package br.maua;
/*
Gustavo Zamboni do Carmo 19.01266-7

Fernando Oliveira de Souza 19.00617-9

Raphael Marchetti Calciolari 19.00828-7

Matheus Takahashi Nakai 19.01355-8
 */


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Recognizer rec = new Recognizer();
        Scanner reader = new Scanner(System.in);
        String cadeia = "entraNoLoop";
        System.out.println("Entre com 001SAIR para sair do programa.");
        while (!cadeia.equals("001SAIR")){
            System.out.printf("\nInsira a cadeia: "); cadeia = reader.nextLine();
            if (!cadeia.equals("001SAIR")) {
                try {
                    System.out.println("Resultado ao reconhecer a cadeia '" + cadeia + "': " + rec.reconhecer(cadeia));
                } catch (NumberFormatException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}