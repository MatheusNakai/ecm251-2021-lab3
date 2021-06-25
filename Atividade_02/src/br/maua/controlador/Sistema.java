package br.maua.controlador;

import br.maua.enums.Funcao;
import br.maua.membros.*;

import java.util.Scanner;

public class Sistema {
    private Scanner scanner= new Scanner(System.in);

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


            default:
                throw new IllegalStateException("Valor Invalido: "+funcao);
        }
    }

    private Membro criarMemebro(){
        System.out.println("Criacao de Membros:\n"+"");

        System.out.println("Digite um nickname que deseje utilizar:");
        String nickname = scanner.next();

        System.out.println("Digite a senha:");
        String senha = scanner.next();

        System.out.println("Digite a Funcao do novo membro:\n(1 - Mobile Member), (2 - Big Brother), (3 - Heavy Lifter), (4 - Script Guy)");
        String role = scanner.next();
        Funcao funcao = tipodeMembro(role);
        
        if(funcao ==null){
            return null;
        }
        Membro membro;
        switch (funcao){
            case BIG_BROTHER:
                membro = new Big_Brothers(nickname,senha,funcao);
                break;
                
            case HEAVY_LIFTER:
                membro = new Heavy_Lifters(nickname,senha,funcao);
                break;
            
            case SCRIPT_GUY:
                membro = new Script_Guys(nickname,senha,funcao);
                break;
                
            case MOBILE_MEMBER:
                membro = new Mobile_Members(nickname,senha,funcao);
                break;


            default:
                throw new IllegalStateException("Unexpected value: " + funcao);
        }
        return membro;

 }
}
