package br.maua.membros;

import br.maua.enums.Funcao;

public class Big_Brothers extends Membro{
    private String assinaturaRegular = "Sempre ajudando as pessoas membros ou não S2!";
    private String assinaturaExtra = "...";


    public Big_Brothers(String nickname, String senha, Funcao funcao) {
        super(nickname, senha, funcao);
    }
}
