package Nakai.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    Usuario Asmongold= new Usuario("Asmongold","Asmongol@twitch.tv","test123");
    Usuario Miskif= new Usuario("Miskif","Miskif@twitch.tv","senha123");
    Usuario XqC= new Usuario("XqC","XqC@twitch.tv","Poggers");
    //Criar Contas
        Conta contaAsmongold= new Conta(1000,Asmongold);
        Conta contaMiskif= new Conta(250,Miskif);
        Conta contaXqC= new Conta(3000,XqC);
    }
}
