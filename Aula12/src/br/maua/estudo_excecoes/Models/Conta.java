package br.maua.estudo_excecoes.Models;

/*
    Classe que representa o objeto Conta
 */




   /*
    Construtor que inicializa o saldo da conta
    para saldo inicial da conta
     */

public class Conta {
    public double saldo;

    public Conta(double saldo) {
        this.saldo = saldo;
    }

    public Conta() {

    }

    @Override
    public String toString() {
        return "Conta{" +
                "saldo=" + saldo +
                '}';
    }
}
