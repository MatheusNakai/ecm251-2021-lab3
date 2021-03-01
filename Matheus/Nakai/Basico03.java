package Matheus.Nakai;

import java.util.Random;

public class Basico03 {
    //estrutura de repeticoes
    public static void main(String[] args) {
        int limite =10;
        int contador ;
        for (contador=0;contador<limite;contador++){
            System.out.println("contagem:"+contador);
        }

        
        //quebrador de senha ruim!!
        int senha=123456;

        //gerdor de chutes
        Random gerador=new Random();
        int chute=gerador.nextInt(999999);
        System.out.println("Chute:"+chute);
        int tentativa=0;
        while(chute!=senha){
            System.out.println("Tentativa: "+tentativa);
            //System.out.println("Chute: "+chute);
            tentativa++;
            chute=gerador.nextInt(999999);
        }
    }
    
}
