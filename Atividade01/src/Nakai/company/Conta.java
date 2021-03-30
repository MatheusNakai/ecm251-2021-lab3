package Nakai.company;

import java.util.ArrayList;

public class Conta {
    public int idConta;
    private double saldo;
    private static int controlador=1; //gerencia o id de contas
    private static ArrayList<Conta> contas = new ArrayList<>(); //Armazena Contas criadas
    private Usuario Dono;



    private void depositar(double valor){
        this.saldo+=valor;
    }

    private boolean sacar(double valor){
        if(valor<=this.saldo){
            this.saldo-=valor;
            return true;
        }
        return false;
    }

    public static Conta getContaPorId (int id){
        for (Conta i:Conta.contas){
            if (i.idConta==id){
                return i;
            }
        }
        return null;
    }
}
