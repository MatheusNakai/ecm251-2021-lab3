package Nakai.company;

import java.util.ArrayList;

public class Usuario {
    private static ArrayList<Usuario> usuarios= new ArrayList<>(); //armazena usuarios criados
    public String nomeInteiro;
    public String email;
    private String senha;



    public boolean UsuarioExistente(String nome){ //auxilio de Bruno Villardi
        for (Usuario i : Usuario.usuarios){
            if(i.nomeInteiro.equals(nome)){
                return false;
            }
        }
        return true;
    }
    public Usuario getNomedoUsuario (String nome){
        for (Usuario i:Usuario.usuarios){
            if(i.nomeInteiro.equals(nome)){
                return i;
            }
        }
        return null;
    }

}
