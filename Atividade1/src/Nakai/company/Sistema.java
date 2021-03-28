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

        }
    }
}

