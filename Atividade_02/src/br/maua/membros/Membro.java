package br.maua.membros;

import br.maua.enums.Funcao;

public abstract class Membro {
    // Atributos compartilhados por todos os Membros

    protected String nickname;
    protected String senha;
    public static int id;
    protected Funcao funcao;
    protected String assinaturaRegular;
    protected String assinaturaExtra;
    // Controlador do id dos Membros
    private static int contador = 1;

    /**
     * Contrutor do Memebro
     * @param nickname: Nome do Membro
     * @param senha: Senha do Membro
     * @param funcao: Funcao do Memebro
     */

    public Membro(String nickname, String senha, Funcao funcao) {

        this.nickname = nickname;
        this.senha = senha;
        this.funcao = funcao;

        this.id=Membro.contador;
        Membro.contador++;                                                                                              //Adiciona mais um ao contador para cada Membro criado
    }
}
