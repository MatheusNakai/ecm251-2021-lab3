package br.maua.membros;

import br.maua.enums.Funcao;

public class Script_Guys extends Membro{
    private String assinaturaRegular = "Prazer em ajudar novos amigos de código!";
    private String assinaturaExtra = "QU3Ro_S3us_r3curs0s.py";


    public Script_Guys(String nickname, String senha, Funcao funcao) {
        super(nickname, senha, funcao);
    }
}
