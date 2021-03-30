package Nakai.company;

import java.util.ArrayList;

public class Conta {
    public int idConta;
    private double saldo;
    private static int controlador=1; //gerencia o id de contas
    private static ArrayList<Conta> contas = new ArrayList<>(); //Armazena Contas criadas
    private Usuario Dono;

    public Conta(int idConta, double saldo, Usuario dono) {
        this.idConta = idConta;
        this.saldo = saldo;
        Dono = dono;
        Dono.atribuirCOnta(this);
        controlador++;
        System.out.println("Nova Conta ("+idConta+") de "+dono.nomeInteiro+"criada com sucesso.");
    }

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

    public static boolean compararId(int id, String nome){
        Conta conta = getContaPorId(id);
        if(conta==null){
            return false;
        }
        return conta.Dono.nomeInteiro.equals(nome);
    }

    public String getNomeDono(){
        return this.Dono.nomeInteiro;
    }


}
