package br.edu.ifpr.model.entities;

import java.time.LocalDateTime;

public class Partida {
    private int idPartida;
    private char dificuldade;
    private LocalDateTime dataHora;
    private int pontuacao;
    private boolean estatus;
    private int idJog;
    private int idPal;

    public Partida(){
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public char getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(char dificuldade) {
        this.dificuldade = dificuldade;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    public int getIdJog() {
        return idJog;
    }

    public void setIdJog(int idJog) {
        this.idJog = idJog;
    }

    public int getIdPal() {
        return idPal;
    }

    public void setIdPal(int idPal) {
        this.idPal = idPal;
    }
    
}