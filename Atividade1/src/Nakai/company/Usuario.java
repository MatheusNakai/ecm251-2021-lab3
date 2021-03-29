package Nakai.company;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String usuario;
    private String cpf;
    private String senha;
    private String email;
    List<Conta> listaDeConta=new ArrayList<>();

    public Usuario(String usuario, String cpf, String senha, String email) {
        this.usuario = usuario;
        this.cpf = cpf;
        this.senha = senha;
        this.email = email;
    }
}
