package br.maua.pessoa;

public abstract class Pessoa{
    protected String nome;
    protected double salario;
    protected String telefone;

    public String descricao(){
        String descricao= "Nome: "+this.nome+"\nSalario:"+this.salario+"\nTelefone:"+this.telefone;

        return (descricao);
    }
    public boolean executarTrabalho(){
        return true;
    }

    public Pessoa(String nome, double salario, String telefone) {
        this.nome = nome;
        this.salario = salario;
        this.telefone = telefone;
    }
}
