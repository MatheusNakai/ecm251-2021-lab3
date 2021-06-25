package br.maua.controlador;

import br.maua.enums.Funcao;
import br.maua.membros.Membro;

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





 }
}
