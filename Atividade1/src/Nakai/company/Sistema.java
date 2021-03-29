package Nakai.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    private boolean continuarExecucao = true;
    private Scanner scanner;
    private Conta conta;
    List<Usuario> ListaDeUsuario = new ArrayList<>();

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
                Usuario usuario = new Usuario(name, cpf, senha, email);
                ListaDeUsuario.add(usuario);
            case 2:

        }
    }
    public void exibirMenu{
        System.out.println("1 - Para criar Usuario.");
        System.out.println("2 - Criar uma Conta.");
    }
}

