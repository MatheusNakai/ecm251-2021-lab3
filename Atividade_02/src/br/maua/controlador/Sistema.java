package br.maua.controlador;

import br.maua.enums.Funcao;
import br.maua.enums.Horario;
import br.maua.membros.*;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;
import java.util.Scanner;

public class Sistema {
    public Horario horaSistema;
    private Scanner scanner= new Scanner(System.in);
    ArrayList<Membro> listaMobileMembers= new ArrayList<>();
    ArrayList<Membro> listaHeavyLifters = new ArrayList<>();
    ArrayList<Membro> listaScriptGuys = new ArrayList<>();
    ArrayList<Membro> listaBigBrothers = new ArrayList<>();

    public void executar(){
        int opMenu = 0;
        String emailUsuario;
        String nicknameUsuario;
        Funcao funcaoUsuario;
        String tipoUsuario;

        System.out.println("------Bem vindo ao gerenciador da MAsK_S0c13ty------");
        System.out.println("Insira seu nickname:");
        nicknameUsuario = scanner.next();
        System.out.println("Insira sua funcao (1 - Mobile Member), (2 - Big Brother), (3 - Heavy Lifter), (4 - Script Guy):");
        tipoUsuario = scanner.next();
        funcaoUsuario = tipodeMembro(tipoUsuario);
        System.out.println("Insira seu email");
        emailUsuario = scanner.next();

        Membro usuario;
        switch (Objects.requireNonNull(funcaoUsuario)){
            case BIG_BROTHER:
                usuario = new Big_Brothers(nicknameUsuario,funcaoUsuario,emailUsuario);
                listaBigBrothers.add(usuario);
                break;

            case HEAVY_LIFTER:
                usuario = new Heavy_Lifters(nicknameUsuario,funcaoUsuario,emailUsuario);
                listaHeavyLifters.add(usuario);
                break;

            case SCRIPT_GUY:
                usuario = new Script_Guys(nicknameUsuario,funcaoUsuario,emailUsuario);
                listaScriptGuys.add(usuario);
                break;

            case MOBILE_MEMBER:
                usuario = new Mobile_Members(nicknameUsuario,funcaoUsuario,emailUsuario);
                listaMobileMembers.add(usuario);
                break;


            default:
                throw new IllegalStateException("Unexpected value: " + funcaoUsuario);
        } //adicao do Usuario ao banco de dados

        try{
            criarArquivo(funcaoUsuario,nicknameUsuario, usuario.id);
        }
        catch (Exception exception){
            System.out.println("Falha ao tentar criar arquivo!");
        }
        Horario horarioSistema = getHorario();

        while(opMenu!=6){
            System.out.println("--------------------------Menu---------------------------");
            System.out.println("Horario de trabalho: "+horarioSistema);
            System.out.println("1 - Trocar horario");
            System.out.println("2 - Adicionar membros");
            System.out.println("3 - Remover membros");
            System.out.println("4 - Postar mensagens dos membros");
            System.out.println("5 - Apresentacao dos membros");
            System.out.println("6 - Sair do Programa");

            opMenu = scanner.nextInt();

            switch (opMenu){
                case (1):
                    horarioSistema = trocarHorario(horarioSistema);
                    break;

                case (2):
                    criarMemebro();
                    break;

                case (3):
                    if(removerMembro()){
                        System.out.println("Foi possivel remover o membro");
                    }
                    else {
                        System.out.println("Nao foi possivel remover o membro");
                    }
                    break;

                case (4):
                    mensagemdosMembros(horarioSistema);
                    break;

                case (5):
                    apresentacaodosMembros();
                    break;

                case (6):
                    System.out.println("Finalizando o sistema.");
                    break;

                default:
                    System.out.println("Funcao nao implementada");
                    break;
            }



        }
    }

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
        System.out.println("Criacao de Membros:\n");

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

    /**
     *          Verifica o horario local e dia da semana
     *          Horario Regular 8:00 - 17:59 de segunda a sexta
     * @return : Tipo de Horario (Regular, Extra)
     */
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

    /**
     *        Recebe o parametro do tipo Enum Horario (Regular, Extra) do sistema dependendo do horario local
     * @param horario : Tipo de Horario (Regular, Extra)
     * @return : O tipo de Horario trocado para que o usuario possa gerenciar todos os tipos de horarios para qualquer hora local que ele esteja
     */
    public Horario trocarHorario(Horario horario){
        if (horario==Horario.REGULAR){return Horario.EXTRA;}
        else{return Horario.REGULAR;}
    }

    /**
     *          Percorre e mostra os integrantes do tipo de membro escolhido, para que o usuario possa remover um membro a sua escolha
     * @return
     */
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
                int posicao = scanner.nextInt();
                posicao-=1;
                if(posicao<listaBigBrothers.size()){
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
                posicao = scanner.nextInt();
                posicao-=1;
                if(posicao<listaHeavyLifters.size()){
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
                posicao = scanner.nextInt();
                posicao-=1;
                if(posicao<listaScriptGuys.size()){

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
                posicao = scanner.nextInt();
                posicao-=1;
                if(posicao<listaMobileMembers.size()){

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

    /**
     *                      Manda mensagem de todos os membros dependendo do tipo de horario
     * @param horaSistema:  Tipo de enum (Extra ou regular)
     */
    public void mensagemdosMembros(Horario horaSistema){
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

    /**
     * Executa o metodo apresentar das classes filhas de Membro.
     * Apresentrando o nickname de todos os membros separados por tipo de membro
     */
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

    /**
     *                  Abre um arquivo do tipo csv, caso nao tenha um arquivo na pasta do projeto ele ira criar um,
     *                  escrevendo no arquivo a funcao do usuario, o nickname, e seu id
     * @param funcao
     * @param nome
     * @param id
     * @throws Exception
     */
    public void criarArquivo(Funcao funcao, String nome, int id) throws Exception {

        FileWriter escreveArquivo = new FileWriter("arquivo_super_Secreto_nao_abrir.csv");
        String dadosUsuario = funcao + ";" + nome + ";" + id;
        escreveArquivo.append(dadosUsuario);
        escreveArquivo.close();
    }

}
