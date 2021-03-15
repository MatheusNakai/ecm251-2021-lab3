package Nakai.company;

import java.util.Random;
import java.util.Scanner;

public class Sistema {
    private boolean continuarExecucao;
    private Scanner scanner;
    private Conta conta;

    public Sistema() {
        this.continuarExecucao=true;
        this.scanner = new Scanner(System.in);
        this.conta=new Conta(1234,1000,"Toad");
    }

    public void executar() {

        while(continuarExecucao){
            exibirMenu();
            int opcao = scanner.nextInt();
            avaliarOpcao(opcao);
        }
    }

    private void avaliarOpcao(int opcao) {
        switch (opcao){
            case 0:
                System.out.println("Obrigado por ter utilizado nosso sistem!" );
                this.continuarExecucao=false;
                break;
            case 1:
                System.out.println("Saldo: R$"+this.conta.getSaldo());
                break;
            case 2:
                System.out.println("Informe o valor:");
                double valorParaDepositar = scanner.nextDouble();
                this.conta.depositar(valorParaDepositar);
                System.out.println("Operacao realizada com sucesso");
                break;
            case 3:
                System.out.println("Informe o valor:");
                double valorParaRetirar = scanner.nextDouble();
                if(this.conta.sacar(valorParaRetirar)){
                    System.out.println("Operacao realizada com sucesso!");
                }
                else {
                    System.out.println("Operacao falhou!");
                }
                break;
            case 5:
                System.out.println("Nome do Titulo:");
                String nomeTitulo = scanner.next();
                System.out.println("Informe o valor do titulo:");
                double valorTitulo = scanner.nextDouble();
                System.out.println("Informe o valor do juros por dia:");
                double valorJurosTitulo = scanner.nextDouble();
                System.out.println("Informe a data de vencimento (aaaa-mm-dd):");
                String dataValidade = scanner.next();
                Titulo titulo = new Titulo(valorTitulo,valorJurosTitulo,nomeTitulo, dataValidade);
                if(this.conta.sacar(titulo.getTotalPagamento())){
                    System.out.println("Pagamento realizado com sucesso!");
            }
                else {
                    System.out.println("Nao foi possivel realizar pagamento!");
                }
            default:
                System.out.println("Funcionalidade ainda nao implementada");
        }
    }

    private void exibirMenu() {
        System.out.println("Bem-vindo ao MauaBank");
        System.out.println("1 - Visualizar Saldo");
        System.out.println("2 - Depositar Dinheiro");
        System.out.println("3 - Sacar Dinheiro");
        System.out.println("4 - Transferir Dinheiro");
        System.out.println("5 - Pagar Titulo");
        System.out.println("0 - Sair do Sistema");
    }
}
