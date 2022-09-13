package Exercise.Exercise1.Q8;

public class Pessoa {

    String corOlhos;
    String corPele;
    String tipoCabelo;
    double tamanho;

    public Pessoa(String corOlhos,String corPele, String tipoCabelo,double tamanho){
        this.corPele = corPele;
        this.corOlhos = corOlhos;
        this.tipoCabelo = tipoCabelo;
        this.tamanho = tamanho;
    }

    public Pessoa(){this("","","",0.0);}


    public String getCorPele() {
        return this.corPele;
    }
    public String getTipoCabelo(){
        return this.tipoCabelo;
    }
    public String getCorOlhos(){
        return this.tipoCabelo;
    }
    public double getTamanho(){
        return this.tamanho;
    }

    public void setCorOlhos(String corOlhos){
        this.corOlhos = corOlhos;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }
    public void setCorpele(String corPele){
        this.corPele = corPele;
    }
    public void setTipoCabelo(String tipoCabelo){
        this.tipoCabelo = tipoCabelo;
    }




}
