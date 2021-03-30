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

}
