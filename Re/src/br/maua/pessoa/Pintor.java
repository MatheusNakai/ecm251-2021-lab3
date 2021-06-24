package br.maua.pessoa;

import br.maua.pessoa.Interface;

/*
Apenas os
 */
public class Pintor implements Interface {
    protected String nome;
    protected double salario;
    protected String telefone;

    public Pintor(String nome, double salario, String telefone) {
        this.nome = nome;
        this.salario = salario;
        this.telefone = telefone;
    }
    @Override
    public String descricao(){
        String descricao= "Nome: "+this.nome+"\nSalario:"+this.salario+"\nTelefone:"+this.telefone;

        return (descricao);
    }



    @Override
    public boolean executarTrabalho() {
        return true;
    }
}
