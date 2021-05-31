package br.maua.model;

public class Item {
    final public String nome;
    final public double preco;


    public Item(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }


    @Override
    public String toString() {
        return "Item{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
    public static Item pegaItem(String dados){
        return new Item(dados.split(",")[0],
                Double.parseDouble(dados.split(",")[1]));
    }



}
