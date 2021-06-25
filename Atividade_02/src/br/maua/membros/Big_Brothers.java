package br.maua.membros;

import br.maua.enums.Funcao;
import br.maua.enums.Horario;

public class Big_Brothers extends Membro{
    private String assinaturaRegular = "Sempre ajudando as pessoas membros ou não S2!";
    private String assinaturaExtra = "...";


    public Big_Brothers(String nickname, String senha, Funcao funcao) {
        super(nickname, senha, funcao);
    }

    @Override
    public String apresentar() {
        return "Ola eu sou o "+nickname+" da MAsK_S0c13ty, sou um dos Big Brothers.";
    }

    @Override
    public String postarMensagem(Horario horario) {
        if(horario == Horario.REGULAR){
            return assinaturaRegular;
        }
        else{return assinaturaExtra;}
    }
}
