package br.maua.membros;

import br.maua.enums.Funcao;
import br.maua.enums.Horario;

public class Mobile_Members extends Membro{
    String assinaturaRegular = "Happy Coding!";
    String assinaturaExtra = "MAsK_S0c13ty";


    public Mobile_Members(String nickname, Funcao funcao, String email) {
        super(nickname, funcao, email);
    }


    @Override
    public String apresentar() {
        return "Ola eu sou o "+nickname+" da MAsK_S0c13ty, sou um dos Mobile Members.";
    }

    @Override
    public String postarMensagem(Horario horario) {
        if(horario == Horario.REGULAR){
            return assinaturaRegular;
        }
        else{return assinaturaExtra;}
    }
}
