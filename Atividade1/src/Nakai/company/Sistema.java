package Nakai.company;

import java.util.Scanner;

public class Sistema {
    private boolean continuarExecucao = true;
    private Scanner scanner;
    private Conta conta;

    public Sistema(){
        this.continuarExecucao=true;
        this.scanner = new Scanner(System.in);
    }
    public void executar{

        while(continuarExecucao){
            int opcao =scanner.nextInt();
            avaliarOpcao(opcao);
        }
    }

    private void avaliarOpcao(int opcao) {
        switch (opcao){
            case 1:
                System.out.println("Insira seu nome:");
                String name= scanner.nextLine();
                System.out.println("Insira seu cpf(apenas os digitos):");
                String cpf= scanner.nextLine();
                System.out.println("Insira seu E-mail:");
                String email= scanner.nextLine();
                System.out.println("Insira uma senha:");
                String senha= scanner.nextLine();
                new Usuario(name,cpf,senha,email);
        }
    }
    public void exibirMenu{
        System.out.println("1 - Para criar Usuario.");
    }
}

