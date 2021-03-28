package Nakai.company;

public class Conta {
    private int numero;
    private double saldo;
    private Usuario usuario;

    public Conta(int numero, double saldo, Usuario usuario) {
        this.numero = numero;
        this.saldo = saldo;
        this.usuario = usuario;
    }
    public double getSaldo(){
        return this.saldo;
    }
    public void depositar(double valor){
        this.saldo+=valor;
    }
    public boolean sacar(double valor){
        if (this.saldo>=valor){
            this.saldo-=valor;
            return true;
        }
        return false;
    }
}
