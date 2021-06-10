package br.maua;
import static java.lang.Math.pow;

/**
 * Classe da maquina de estados finita que reconhece cadeias de numeros reais
 */
public class Recognizer {
    // Estados Relevantes
    public static final int INICIAL = 0;
    public static final int[] FINAL = {2, 3, 5};
    public static final int ERRO = 6;

    // Simbolos Constantes
    public static final int DIGITO = 0;
    public static final int SINAL = 1;
    public static final int PONTO = 2;
    public static final int E = 3;
    public static final int e = 4;
    public static final int OUTRO = 5;

    // Tabela de relações
    private int[][] tabela = {
            {2, 1, 6, 6, 6, 6},
            {2, 6, 6, 6, 6, 6},
            {2, 6, 3, 4, 4, 6},
            {3, 6, 6, 4, 4, 6},
            {5, 5, 6, 6, 6, 6},
            {5, 6, 6, 6, 6, 6},
            {6, 6, 6, 6, 6, 6}
    };

    // Variavel auxiliar
    private int estadoAtual;

    /**
     * Construtor vazio
     */
    public Recognizer() {    }

    /**
     * Retorna o símbolo equivalente do caractere
     */
    private int getSimbolo(char caractere){
        // Alfabeto de entrada definido
        char[] digitos = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] sinais = {'+', '-'};
        char ponto = '.';
        char el_maiusculo = 'E';
        char el_minusculo = 'e';

        // Verificação do caractere inserido
        for (int i = 0; i < digitos.length; i++) if (caractere == digitos[i]) return DIGITO;
        for (int i = 0; i < sinais.length; i++) if (caractere == sinais[i]) return SINAL;
        if (caractere == ponto) return PONTO;
        if (caractere == el_maiusculo) return E;
        if (caractere == el_minusculo) return e;
        return OUTRO;
    }

    /**
     * Verifica se o estado inserido é final
     * @param estado estado que se deseja saber se é final
     * @return true caso o estado seja final, false caso contrário
     */
    private boolean isFinal(int estado){
        for(int i = 0; i < FINAL.length; i++) if (estado == FINAL[i]) return true;
        return false;
    }

    /**
     * Reconhece (ou não) se a cadeia inserida é um número real
     * @param cadeia cadeia que se deseja reconhecer
     * @return o número reconhecido ou NumberFormatException, caso não seja reconhecido
     */
    public double reconhecer(String cadeia) throws NumberFormatException{
        int indice = 0;                                         // Percorre a cadeia
        double numero = 0;                                      // Vai armazenando o numero para retorno futuro
        double ordemGrandeza = 0;                               // Vai armazenando o valor de E
        boolean decimalStatus = false;                          // Verifica se os numeros contabilizados são decimais
        int decimalCounter = 0;                                 // Numero de casas decimais
        int sinalNumero = 1;                                    // Binário para alterar o sinal do numero no final
        int sinalOrdemGranzeda = 1;                             // Binário para alterar o sinal da ordem de grandeza no final
        boolean eStatus = false;                                // Verifica se os numeros contabilizados são da porcão E^N
        estadoAtual = INICIAL;                                  // Inicia no estado inicial

        while(indice < cadeia.length()){
            char caractereAtual = cadeia.charAt(indice);            // Armazena caracteres individuais da cadeia
            int simboloEquivalente = getSimbolo(caractereAtual);    // Recupera o simbolo equivalente ao caractere
            estadoAtual = tabela[estadoAtual][simboloEquivalente];  // Realiza a mudança de estado referente à tabela

            if (estadoAtual == ERRO) throw new NumberFormatException(cadeia + " não é um número!");

            // Construção do número
            if (simboloEquivalente == DIGITO && !decimalStatus && !eStatus) numero = numero * 10 + (caractereAtual - '0');
            if (simboloEquivalente == DIGITO && decimalStatus && !eStatus){
                decimalCounter--;
                numero += (caractereAtual - '0') * pow(10d, (decimalCounter * 1.0));
            }
            if (simboloEquivalente == SINAL && !eStatus) sinalNumero = sinalNumero * (caractereAtual == '+' ? 1 : -1);

            // Construção do 10 ^ expoente
            if (simboloEquivalente == DIGITO && eStatus) ordemGrandeza = ordemGrandeza * 10 + (caractereAtual - '0');
            if (simboloEquivalente == SINAL && eStatus) sinalOrdemGranzeda = sinalOrdemGranzeda * (caractereAtual == '+' ? 1 : -1);

            // Verificação se já foi inserido um E ou e
            if (simboloEquivalente == E || simboloEquivalente == e) eStatus = true;
            if (simboloEquivalente == PONTO) decimalStatus = true;

            indice++;
        }
        if (isFinal(estadoAtual)){
            numero = numero * sinalNumero * pow(10d, ordemGrandeza * sinalOrdemGranzeda);
            return numero;
        }
        else throw new NumberFormatException(cadeia + "não é um número!");
    }

}
