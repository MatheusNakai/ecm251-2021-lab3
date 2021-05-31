package br.maua.estudo_excecoes.LinkedList_Test;

import br.maua.estudo_excecoes.Models.Conta;
import br.maua.estudo_excecoes.Models.Pessoa;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Pessoa> pessoas = new LinkedList<>();
        pessoas.add(new Pessoa("Midoria","999"));
        pessoas.add(new Pessoa("Bakugou","998"));
        pessoas.add(new Pessoa("Todoroki","997"));
        pessoas.add(0,new Pessoa("Uraraka","1000"));
        pessoas.addFirst(new Pessoa("All Might","001"));

        System.out.println("Pessoas:");
        pessoas.forEach(pessoa -> System.out.println(pessoa));

        LinkedList<Conta> contas = new LinkedList<>();
        contas.addAll(Arrays.asList(new Conta(10),new Conta(20),new Conta(25)));

        System.out.println("Passa pela lista de contas:");
        contas.forEach(conta -> System.out.println(conta));

        System.out.println("Passando pelos elementos com o iteretor");
        Iterator<Conta> iterator = contas.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }
}
