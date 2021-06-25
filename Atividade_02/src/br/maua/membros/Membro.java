package br.maua.membros;

import br.maua.enums.Funcao;

public abstract class Membro {
    // Atributos compartilhados por todos os Membros

    protected String nickname;
    protected String senha;
    public static int id;
    protected Funcao funcao;

    // Controlador do id dos Membros
    private static int contador = 1;


}
