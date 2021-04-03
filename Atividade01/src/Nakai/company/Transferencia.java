package Nakai.company;
//Matheus Takahashi Nakai
//19.01355-8
import java.util.Random;

public class Transferencia {
    public static String gerarString(Conta recebedora, double valor){
        return "" + recebedora.idConta + ";" + recebedora.getNomeDono() + ";"+ valor + ";" + getRandomNumberInRange(1000, 9999);
    }

    public static boolean Transacao(Conta pagadora, String QR){
        return pagadora.transferirDinheiro(QR);
    }

    public static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static boolean validarString(String string){ //Source: Bruno Villardi
        //Verifica o número de ';'
        int numeroDeSeparador = string.length() - string.replace(";", "").length(); //Char total = char sem ';' = numero de ';'
        if (numeroDeSeparador != 3){ //Não tem o número correto de ';', logo é inválido
            System.out.println("Erro com numero de ';' - esperado: 3 / recebido: " + numeroDeSeparador);
            return false;
        }

        String[] dados = string.split(";"); //Dados: "idConta;nomeUsuario;valor;numeroAleatorio"

        //Verifica se os tipos de dado são coerentes
        int idContaDestino;
        try {
            idContaDestino = Integer.parseInt(dados[0]);
        } catch(Exception e) { //id da conta não pode ser convertido para int
            System.out.println("Erro com conversão do id da conta");
            return false;
        }

        try {
            double valor = Double.parseDouble(dados[2]);
        } catch(Exception e) { //valor não pode ser convertido para double
            System.out.println("Erro com conversão do valor da transferencia");
            return false;
        }

        int idTransacao;
        try {
            idTransacao = Integer.parseInt(dados[3]);
        } catch(Exception e) { //id da transação não pode ser convertido para int
            System.out.println("Erro com conversão do id da transferencia");
            return false;
        }

        String nomeUsuarioContaDestino = dados[1];

        //Verifica se existe o usuario recebedor pussui a conta destino
        if (!Conta.compararId(idContaDestino, nomeUsuarioContaDestino)){
            System.out.println("Usuario destino não possui conta com esse id");
            return false;
        }
        //Verifica se valor aleatório está entre 1000 e 9999
        if ((idTransacao<1000) || (idTransacao>9999)){
            System.out.println("Id da transação fora do range - esperado 1000 > id > 9999 / recebido: " + idTransacao);
            return false;
        }

        return true; //Passou por todas as validações
    }

}
