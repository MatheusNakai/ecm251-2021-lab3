package br.maua.membros;

import br.maua.enums.Funcao;

public class Heavy_Lifters extends Membro{
    private String assinaturaRegular = "Podem contar conosco!";
    private String assinaturaExtra = "N00b_qu3_n_Se_r3pita.bat";


    public Heavy_Lifters(String nickname, String senha, Funcao funcao) {
        super(nickname, senha, funcao);
    }
}
