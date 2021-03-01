package Matheus.Nakai;

public class Basico {
    public static void main(String[] args) {
        int numero;
        float hp;
        double atk;
        boolean gigantamax;
        String nome;

        //Atribuicao para as variaveis
        numero=25;
        hp=155.0f;
        atk=255.0;
        gigantamax=true;
        nome="Pikachu";

        //exibe os valores das variaveis
        System.out.println("Nome:" + nome+"\n"+"Pokemon Id: "+ numero);
        System.out.println("Gigantamax: "+ gigantamax);
        System.out.println("Hp: " +hp+ "\n" + "Atk: "+ atk);
    }
}
