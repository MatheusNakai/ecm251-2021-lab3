package br.maua.membros;

import br.maua.enums.Funcao;
import br.maua.enums.Horario;

public class Script_Guys extends Membro{
    private String assinaturaRegular = "Prazer em ajudar novos amigos de código!";
    private String assinaturaExtra = "QU3Ro_S3us_r3curs0s.py";


    public Script_Guys(String nickname, Funcao funcao, String email) {
        super(nickname,  funcao, email);
    }





    @Override
    public String apresentar() {
        return "Ola eu sou o "+nickname+" da MAsK_S0c13ty, sou um dos Script Guys.";
    }

    @Override
    public String postarMensagem(Horario horario) {
        if(horario.equals(Horario.REGULAR)){
            return assinaturaRegular;
        }
        else{return assinaturaExtra;}
    }
}
