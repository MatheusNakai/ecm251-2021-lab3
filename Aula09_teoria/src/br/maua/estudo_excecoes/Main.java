package br.maua.estudo_excecoes;

public class Main {

    public static void main(String[] args) {
        System.out.println("Inicio da Main");
        metodo1();
        System.out.println("Fim da Main");
    }
    private static void metodo1(){
        System.out.println("Inicio do metodo1");
        metodo2();
        System.out.println("Fim do metodo1");
    }
    private static void metodo2(){
        System.out.println("inicio do metodo2");
        int [] array= new int [10];
        for (int i = 0 ; i<=15;i++){
            try {
                array[i] = i;
            }
            catch (ArrayIndexOutOfBoundsException exception){
                exception.printStackTrace();
            }
            System.out.println(i);
        }
        System.out.println("Fim do metodo2");
    }
}
