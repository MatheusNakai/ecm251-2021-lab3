package Nakai.company;

import java.util.Random;

public class Transferencia {
    public static String gerarString(Conta recebedora, double valor){
        return "" + recebedora.idConta + ";" + recebedora.getNomeDono() + ";"+ valor + ";" + getRandomNumberInRange(1000, 9999);
    }

    

    public static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
