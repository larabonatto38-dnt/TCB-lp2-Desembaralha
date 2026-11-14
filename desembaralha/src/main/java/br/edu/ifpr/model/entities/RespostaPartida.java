package br.edu.ifpr.model.entities;

public class RespostaPartida {
    private int idResposta;
    private String respostaDigitada;
    private boolean correta;
    private int idPar;

    public RespostaPartida(){
    }

    public int getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(int idResposta) {
        this.idResposta = idResposta;
    }

    public String getRespostaDigitada() {
        return respostaDigitada;
    }

    public void setRespostaDigitada(String respostaDigitada) {
        this.respostaDigitada = respostaDigitada;
    }

    public boolean isCorreta() {
        return correta;
    }

    public void setCorreta(boolean correta) {
        this.correta = correta;
    }

    public int getIdPar() {
        return idPar;
    }

    public void setIdPar(int idPar) {
        this.idPar = idPar;
    }
    
}