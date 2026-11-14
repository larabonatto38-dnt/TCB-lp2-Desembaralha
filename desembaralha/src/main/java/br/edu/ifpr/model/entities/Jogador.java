package br.edu.ifpr.model.entities;

public class Jogador {
    private int idJogador;
    private String nome;

    public Jogador(){
    }

    public int getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(int idJogador) {
        this.idJogador = idJogador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}