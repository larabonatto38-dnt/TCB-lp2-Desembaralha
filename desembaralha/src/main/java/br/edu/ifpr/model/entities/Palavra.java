package br.edu.ifpr.model.entities;

public class Palavra {
    private int idPalavra;
    private String palavraCorreta;
    private String dica1;
    private String dica2;
    private int idCat;
    
    public Palavra(){
    }

    public int getIdPalavra() {
        return idPalavra;
    }

    public void setIdPalavra(int idPalavra) {
        this.idPalavra = idPalavra;
    }

    public String getPalavraCorreta() {
        return palavraCorreta;
    }

    public void setPalavraCorreta(String palavraCorreta) {
        this.palavraCorreta = palavraCorreta;
    }

    public String getDica1() {
        return dica1;
    }

    public void setDica1(String dica1) {
        this.dica1 = dica1;
    }

    public String getDica2() {
        return dica2;
    }

    public void setDica2(String dica2) {
        this.dica2 = dica2;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }
}