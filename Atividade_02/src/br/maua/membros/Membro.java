package br.maua.membros;

import br.maua.enums.Funcao;
import br.maua.enums.Horario;
import br.maua.interfaces.Apresentacao;
import br.maua.interfaces.PostarMensagem;


import java.util.Calendar;


public abstract class Membro implements PostarMensagem, Apresentacao {
    // Atributos compartilhados por todos os Membros

    protected String nickname;
    protected String senha;
    protected String email;
    protected Funcao funcao;
    protected String assinaturaRegular;
    protected String assinaturaExtra;
    public int id;

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

        //Adiciona mais um ao contador para cada Membro criado
        this.id=Membro.contador;
        Membro.contador++;
    }


}
