package Nakai.company;

public class Jogador {
    private String nome;
    private boolean ehHumano;
    private Jogada jogada;

    public Jogador(String nome, boolean ehHumano) {
        this.nome = nome;
        this.ehHumano = ehHumano;
    }

    public Jogador(String nome) {
        this.nome = nome;
        ehHumano=false;
    }

    public String getNome() {
        if (isEhHumano())
            return nome;
        return "(BOT)"+nome;
    }

    public boolean isEhHumano() {
        return ehHumano;
    }

    @Override
    public String toString() {
        return getNome();
    }

    public Jogada getJogada() {
        return jogada;
    }
}
