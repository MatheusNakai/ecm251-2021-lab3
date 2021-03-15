package Nakai.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Quase 5 temporada ai!!");
        //criar uma referencia para conta
        Conta c1;
        //instanciar um objeto Conta
        c1= new Conta();
        c1.cliente=new Cliente();
        c1.cliente.titular="Inuyasha";
        c1.saldo=399.99;

        Conta c2=new Conta();
        c2.cliente= new Cliente();
        c2.cliente.titular="Seuchoumaru";
        c2.saldo = 1000;
    }
}
