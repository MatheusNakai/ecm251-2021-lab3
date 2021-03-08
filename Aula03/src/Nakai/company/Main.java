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

        c1.visualizarSaldo();

        Conta c2=new Conta();
        c2.cliente= new Cliente();
        c2.cliente.titular="Seuchoumaru";
        c2.saldo = 1000;
        c2.visualizarSaldo();

        c1.depositar(20);
        c2.depositar(300);

        c1.visualizarSaldo();
        c2.visualizarSaldo();

        c1.sacar(200);
        c2.sacar(100);

        c1.visualizarSaldo();
        c2.visualizarSaldo();

        if (c1.sacar(500)){
            System.out.println("Deu bom!");
        }
        else
        {
            System.out.println("Deu ruim!");
        }
        c1.visualizarSaldo();

        if(c1.transferirPara(300,c2)){
            System.out.println("Deu bom! Transferiu");
        }
        else{
            System.out.println("Deu ruim! nao foi");
        }
        c1.visualizarSaldo();
        c2.visualizarSaldo();

        System.out.println("C1"+c1.toString());
        System.out.println("C2"+c2.toString());
    }
}
