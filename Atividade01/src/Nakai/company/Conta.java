package Nakai.company;

import java.util.ArrayList;

public class Conta {
    public int idConta;
    private double saldo;
    private static int controlador=1; //gerencia o id de contas
    private static ArrayList<Conta> contas = new ArrayList<>(); //Armazena Contas criadas
    private Usuario Dono;

    public Conta(double saldo, Usuario dono) {
        this.idConta = controlador;
        this.saldo = saldo;
        Dono = dono;
        Dono.atribuirCOnta(this);
        controlador++;
        System.out.println("Nova Conta ("+idConta+") de "+Dono.nomeInteiro+" criada com sucesso.");
    }

    private  void depositar(double valor){
        this.saldo+=valor;
    }

    private boolean sacar(double valor){
        if(valor<=this.saldo){
            this.saldo-=valor;
            return true;
        }
        return false;
    }

    public static Conta getConta (int id){
        for (Conta i:Conta.contas){
            if (i.idConta==id){
                return i;
            }
            else{
                return null;
            }
        }
        return null;

    }

    public static boolean compararId(int id, String nome){
        Conta conta = getConta(id);
        if(conta==null){
            return false;
        }
        return conta.Dono.nomeInteiro.equals(nome);
    }

    public String getNomeDono(){
        return this.Dono.nomeInteiro;
    }

    public boolean transferirDinheiro(String s){
        String[] dados=s.split(";");
        int idContaDestino= Integer.parseInt(dados[0]);
        String UsuarioDestino = dados[1];
        double valor = Double.parseDouble(dados[2]);
        int idTransacao = Integer.parseInt(dados[3]);

        if (this.sacar(valor)){
            Conta.getConta(idContaDestino).depositar(valor);
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "Conta{" +
                "idConta=" + idConta +
                ", saldo=" + saldo +
                ", Dono=" + Dono.nomeInteiro +
                '}';
    }
}
