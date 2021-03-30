package Nakai.company;

import java.util.ArrayList;

public class Usuario {
    private static ArrayList<Usuario> usuarios= new ArrayList<>(); //armazena usuarios criados
    public String nomeInteiro;
    public String email;
    private String senha;
    private ArrayList<Conta> contas=new ArrayList<>();

    public Usuario(String nomeInteiro, String email, String senha) {
        if(UsuarioExistente(nomeInteiro)){
            this.nomeInteiro = nomeInteiro;
            this.email = email;
            this.senha = senha;
            
        }

    }

    public boolean UsuarioExistente(String nome){ //auxilio de Bruno Villardi
        for (Usuario i : Usuario.usuarios){
            if(i.nomeInteiro.equals(nome)){
                return false;
            }
        }
        return true;
    }
    public static Usuario getNomedoUsuario (String nome){
        for (Usuario i:Usuario.usuarios){
            if(i.nomeInteiro.equals(nome)){
                return i;
            }
        }
        return null;
    }

    public static boolean login(String nome, String senha){
        Usuario u=Usuario.getNomedoUsuario(nome);
        if(u==null){
            return false;
        }
        if (senha.equals(u.senha)){
            Sistema.usuarioLogado=u;
            return true;
        }
        return false;
    }

    public boolean atribuirCOnta(Conta conta){
        this.contas.add(conta);
        return true;
    }

    public static ArrayList<Conta> getContas(Usuario usuarioLogado){
        return usuarioLogado.contas;
    }
    public boolean verificacaContaId(int idContaRecebedora){//Verifica se usuario possui tal conta
        for (Conta i:this.contas){
            if(i.idConta==idContaRecebedora){
                return true;
            }

        }
        return false;
    }
}
