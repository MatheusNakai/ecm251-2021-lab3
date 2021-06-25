package br.maua.membros;

import br.maua.enums.Funcao;
import br.maua.enums.Horario;


import java.util.Calendar;


public abstract class Membro {
    // Atributos compartilhados por todos os Membros

    protected String nickname;
    protected String senha;
    public int id;
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

    public Horario getHorario(){
        //Armazena horario e dia da semana
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        if((2<=day && day<=6) && ((8<=hour)  )&&(hour<=17 )){
            return Horario.REGULAR;
        }
        else{return Horario.EXTRA;}
    }
}
