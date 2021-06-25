package br.maua.membros;

import br.maua.enums.Funcao;
import br.maua.enums.Horario;

public class Heavy_Lifters extends Membro{
    private String assinaturaRegular = "Podem contar conosco!";
    private String assinaturaExtra = "N00b_qu3_n_Se_r3pita.bat";


    public Heavy_Lifters(String nickname, String senha, Funcao funcao) {
        super(nickname, senha, funcao);
    }

    @Override
    public String apresentar() {
        return "Ola eu sou o "+nickname+" da MAsK_S0c13ty, sou um dos Heavy Lifters.";
    }

    @Override
    public String postarMensagem(Horario horario) {
        if(horario == Horario.REGULAR){
            return assinaturaRegular;
        }
        else{return assinaturaExtra;}
    }
}
