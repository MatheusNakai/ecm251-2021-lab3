package Nakai.company;

public class Main {
//Nome: Matheus Takahashi Nakai
//Ra: 19.01355-8
    public static void main(String[] args) {
	// write your code here
    Usuario Asmongold= new Usuario("Asmongold","Asmongol@twitch.tv","test123");
    Usuario Miskif= new Usuario("Miskif","Miskif@twitch.tv","senha123");
    Usuario XqC= new Usuario("XqC","XqC@twitch.tv","Poggers");
    //Criar Contas
        Conta contaAsmongold= new Conta(1000,Asmongold);
        Conta contaMiskif= new Conta(250,Miskif);
        Conta contaXqC= new Conta(3000,XqC);

        System.out.println(Asmongold);
        System.out.println(Miskif);
        System.out.println(XqC);
    //Transferir Valores
        System.out.println("Asmongol gera requisicao01 de tranferencia de 250");
        String requisicao01= Transferencia.gerarString(contaAsmongold,250);
        System.out.println("Requisicao: "+requisicao01);

        System.out.println("Valores iniciais:");
        System.out.println(contaAsmongold);
        System.out.println(contaMiskif);
        System.out.println(contaXqC);

        System.out.println("Miskif Paga requisicao01");
        boolean resultado = contaMiskif.transferirDinheiro(requisicao01);
        System.out.println(contaAsmongold);
        System.out.println(contaMiskif);
        System.out.println(contaXqC);
        System.out.println("Transferencia concluida: "+resultado);

        System.out.println("XqC paga requisicao01");
        resultado=contaXqC.transferirDinheiro(requisicao01);
        System.out.println(contaAsmongold);
        System.out.println(contaMiskif);
        System.out.println(contaXqC);
        System.out.println("Transferencia concluida: "+resultado);

        System.out.println("Miskif Paga requisicao01");
        resultado=contaMiskif.transferirDinheiro(requisicao01);
        System.out.println(contaAsmongold);
        System.out.println(contaMiskif);
        System.out.println(contaXqC);
        System.out.println("Transferencia concluida: "+resultado);

        System.out.println("Miskif cria requisicao02 de tranferencia (Miskif gera uma operacao de recebimento de 1000)");
        String requisicao02= Transferencia.gerarString(contaMiskif,1000);
        System.out.println("Requisicao: "+requisicao02);

        System.out.println("XqC paga requisicao02");
        resultado=contaXqC.transferirDinheiro(requisicao02);
        System.out.println("Miskif Paga requisicao01");
        System.out.println(contaAsmongold);
        System.out.println(contaMiskif);
        System.out.println(contaXqC);
        System.out.println("Transferencia concluida: "+resultado);

        System.out.println("-------------------------------------------------------------------------------");
        Sistema.run();
    }
}
