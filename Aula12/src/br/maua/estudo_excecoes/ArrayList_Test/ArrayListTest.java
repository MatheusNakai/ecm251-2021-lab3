package br.maua.estudo_excecoes.ArrayList_Test;

import br.maua.estudo_excecoes.Models.Conta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        //Cria um ArrayList com Contas
        ArrayList<Conta> contas = new ArrayList <>();

        contas.add(new Conta(89));
        contas.add(new Conta());
        contas.add(1, new Conta(55));
        contas.addAll(Arrays.asList((new Conta()),new Conta(58)));

        System.out.println("Exibi o ArrayList de Contas:");
        contas.forEach((conta)-> System.out.println(conta));

        //retira um elemento do ArrayList
        contas.remove(3);
        System.out.println("Exibi o ArrayList de Contas:");
        contas.forEach((conta)-> System.out.println(conta));

    }
}
