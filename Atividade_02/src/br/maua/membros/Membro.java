package br.maua.membros;

import br.maua.enums.Funcao;
import br.maua.enums.Horario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

    public Horario getHorario() throws ParseException {
        Calendar C = new GregorianCalendar();
        //Armazena a hora do horario local
        int hour = C.get( Calendar.HOUR_OF_DAY );
        int minute = C.get( Calendar.MINUTE );

        if( (hour >=8 && minute >= 0) && (hour<=17 && minute<=59) )
            return Horario.REGULAR;
        else{
            return Horario.EXTRA;
        }
    }
}
