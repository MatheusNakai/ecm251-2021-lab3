package Nakai.company;

import java.util.Random;
import java.util.Scanner;

public class Sistema {
    private Jogador player1;
    private Jogador player2;
    private Scanner scanner;

    public Sistema() {
        this.scanner=new Scanner(System.in);
        inicializaPlayer();
    }
    private void inicializaPlayer(){
        System.out.println("Informe seu nome:");
        String nome = scanner.next();
        this.player1= new Jogador(nome, true);
        this.player2= new Jogador("Cynthia");
    }
    public void run(){
        while(true){
            System.out.println(player1 +" vs "+ player2);
            player1.setJogada(selecionarJogada());
            player2.setJogada(sortearJogada());
            System.out.println("Jogada:");
            System.out.println(player1+":"+player1.getJogada());
            System.out.println(player2+":"+player2.getJogada());
            System.out.println("Resultado"+player1.getJogada().verificaResultado(player2.getJogada()));
        }
    }



    private Jogada sortearJogada(){
        Jogada[] jogadas= new Jogada[]{new Pedra(),new Papel(), new Tesoura()};
        return jogadas[new Random().nextInt(jogadas.length)]
}

}