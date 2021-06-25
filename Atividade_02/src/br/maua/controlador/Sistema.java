package br.maua.controlador;

import br.maua.enums.Funcao;
import br.maua.enums.Horario;
import br.maua.membros.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Sistema {
    private Scanner scanner= new Scanner(System.in);
    ArrayList<Membro> listaMobileMembers= new ArrayList<>();
    ArrayList<Membro> listaHeavyLifters = new ArrayList<>();
    ArrayList<Membro> listaScriptGuys = new ArrayList<>();
    ArrayList<Membro> listaBigBrothers = new ArrayList<>();

    /**
     *
     * @param funcao: String para o auxilio de definir a funcao do funcionario que ira ser criado
     * @return Um tipo de Funcao dentro do Enum Funcao
     */
    private Funcao tipodeMembro(String funcao){
        switch (funcao){
            case "1":
                return Funcao.MOBILE_MEMBER;

            case "2":
                return Funcao.BIG_BROTHER;


            case "3":
                return Funcao.HEAVY_LIFTER;


            case "4":
                return Funcao.SCRIPT_GUY;


        }
        return null;
    }

    /**
     * Pega as informacoes do usuario para criar um novo membro
     * @return Um membro pertencente a uma das classes filhas de Membro
     */
    private Membro criarMemebro(){
        System.out.println("Criacao de Membros:\n"+"");

        System.out.println("Digite um nickname que deseje utilizar:");
        String nickname = scanner.next();

        System.out.println("Digite o email:");
        String email = scanner.next();

        System.out.println("Digite a Funcao do novo membro:\n(1 - Mobile Member), (2 - Big Brother), (3 - Heavy Lifter), (4 - Script Guy)");
        String role = scanner.next();
        Funcao funcao = tipodeMembro(role);
        
        if(funcao ==null){
            return null;
        }
        Membro membro;
        switch (funcao){
            case BIG_BROTHER:
                membro = new Big_Brothers(nickname,funcao,email);
                listaBigBrothers.add(membro);
                break;
                
            case HEAVY_LIFTER:
                membro = new Heavy_Lifters(nickname,funcao,email);
                listaHeavyLifters.add(membro);
                break;
            
            case SCRIPT_GUY:
                membro = new Script_Guys(nickname,funcao,email);
                listaScriptGuys.add(membro);
                break;
                
            case MOBILE_MEMBER:
                membro = new Mobile_Members(nickname,funcao,email);
                listaMobileMembers.add(membro);
                break;


            default:
                throw new IllegalStateException("Unexpected value: " + funcao);
        }
        return membro;

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

    public Horario trocarHorario(Horario horario){
        if (horario==Horario.REGULAR){return Horario.EXTRA;}
        else{return Horario.REGULAR;}
    }
}
