package Nakai.company;

import java.util.Scanner;

public class Sistema {
    public static int MainMenu=0;
    public static int LogedMenu=0;
    public static Usuario usuarioLogado=null;

    public static void run(){
        System.out.println("");
    }

    public static void mostrarMainMenu(Scanner scanner){
        System.out.println("Por favor, escolha uma opção:");
        System.out.println("1 - Criar Usuario.");
        System.out.println("2 - Login como usuário.");
        System.out.println("3 - Terminar programa.");
        
    }
}
