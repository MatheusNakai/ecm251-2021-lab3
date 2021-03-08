package Nakai.company;

public class Conta {
    int numero;
    double saldo;
    Cliente cliente;

    void visualizarSaldo(){
        double saldo=this.saldo;
        System.out.println("Saldo da conta: R$"+this.saldo);
        /*while(saldo>0){
            System.out.println("Gastando!!!"+saldo);
            saldo=saldo-10;
        }*/
    }
    void depositar(double valor){
        this.saldo+=valor;
    }
    boolean sacar(double valor){

            if (this.saldo >= valor) {
                this.saldo -= valor;
                return true;
            }
            return false;
        }

    boolean transferirPara(double valor, Conta destino){

        if (sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numero=" + numero +
                ", saldo=" + saldo +
                ", cliente=" + cliente.toString() +
                '}';
    }
}
