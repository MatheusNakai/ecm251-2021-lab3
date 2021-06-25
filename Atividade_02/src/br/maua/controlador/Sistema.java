package br.maua.controlador;

import br.maua.enums.Funcao;
import br.maua.enums.Horario;
import br.maua.membros.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Sistema {
    public Horario horaSistema;
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

    public boolean removerMembro(){
        System.out.println("Selecione o tipo de membro que deseja remover: (1 - Mobile Member), (2 - Big Brother), (3 - Heavy Lifter), (4 - Script Guy)");
        String role = scanner.next();
        Funcao funcao = tipodeMembro(role);
        int cont = 1;
        if(funcao ==null){
            return false;
        }
        Membro membro;
        switch (funcao){
            case BIG_BROTHER:
                for(Membro membro1 :listaBigBrothers){
                    System.out.println(cont+" - "+membro1);
                    cont++;
                }
                System.out.println("Selecione a posicao do membro (Comeca em 1):");
                int posicao = Integer.parseInt(scanner.next());
                if(posicao<listaBigBrothers.size()){
                    posicao-=1;
                    listaBigBrothers.remove(posicao);
                    return true;
                }else{
                    System.out.println("Posicao invalida!");
                    return false;
                }


            case HEAVY_LIFTER:
                for(Membro membro1 :listaHeavyLifters){
                    System.out.println(cont+" - "+membro1);
                    cont++;
                }
                System.out.println("Selecione a posicao do membro (Comeca em 1):");
                posicao = Integer.parseInt(scanner.next());
                if(posicao<listaHeavyLifters.size()){
                    posicao-=1;
                    listaHeavyLifters.remove(posicao);
                    return true;
                }else{
                    System.out.println("Posicao invalida!");
                    return false;
                }


            case SCRIPT_GUY:
                for(Membro membro1 :listaScriptGuys){
                    System.out.println(cont+" - "+membro1);
                    cont++;
                }
                System.out.println("Selecione a posicao do membro (Comeca em 1):");
                posicao = Integer.parseInt(scanner.next());
                if(posicao<listaScriptGuys.size()){
                    posicao-=1;
                    listaScriptGuys.remove(posicao);
                    return true;
                }else{
                    System.out.println("Posicao invalida!");
                    return false;
                }


            case MOBILE_MEMBER:
                for(Membro membro1 :listaMobileMembers){
                    System.out.println(cont+" - "+membro1);
                    cont++;
                }
                System.out.println("Selecione a posicao do membro (Comeca em 1):");
                posicao = Integer.parseInt(scanner.next());
                if(posicao<listaMobileMembers.size()){
                    posicao-=1;
                    listaMobileMembers.remove(posicao);
                    return true;
                }else{
                    System.out.println("Posicao invalida!");
                    return false;
                }

            default:
                throw new IllegalStateException("Unexpected value: " + funcao);
        }
    }

    public void mensagemdosMembros(){
        System.out.println("-------------------Mobile Members-------------------");
        for(Membro membro : listaMobileMembers) {
            System.out.println(membro.postarMensagem(horaSistema));
        }
        System.out.println("-------------------Heavy Lifters--------------------");
        for(Membro membro : listaHeavyLifters) {
            System.out.println(membro.postarMensagem(horaSistema));
        }
        System.out.println("-------------------Script Guys----------------------");
        for(Membro membro : listaScriptGuys) {
            System.out.println(membro.postarMensagem(horaSistema));
        }
        System.out.println("-------------------Big Brothers---------------------");
        for(Membro membro : listaBigBrothers) {
            System.out.println(membro.postarMensagem(horaSistema));
        }

    }

    public void apresentacaodosMembros(){
        System.out.println("-------------------Mobile Members-------------------");
        for(Membro membro : listaMobileMembers) {
            System.out.println(membro.apresentar());
        }
        System.out.println("-------------------Heavy Lifters--------------------");
        for(Membro membro : listaHeavyLifters) {
            System.out.println(membro.apresentar());
        }
        System.out.println("-------------------Script Guys----------------------");
        for(Membro membro : listaScriptGuys) {
            System.out.println(membro.apresentar());
        }
        System.out.println("-------------------Big Brothers---------------------");
        for(Membro membro : listaBigBrothers) {
            System.out.println(membro.apresentar());
        }

    }
}
