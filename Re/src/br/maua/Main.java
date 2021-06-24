package br.maua;

import br.maua.pessoa.Pintor;

public class Main {

    public static void main(String[] args) {

        Pintor pintor=new Pintor("antonio",123,"312");
        System.out.printf(pintor.descricao());
    }
}
