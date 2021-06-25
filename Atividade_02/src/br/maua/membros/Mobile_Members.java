package br.maua.membros;

import br.maua.enums.Funcao;

public class Mobile_Members extends Membro{
    String assinaturaRegular = "Happy Coding!";
    String assinaturaExtra = "MAsK_S0c13ty";



    public Mobile_Members(String nickname, String senha, Funcao funcao) {
        super(nickname, senha, funcao);
    }
}
