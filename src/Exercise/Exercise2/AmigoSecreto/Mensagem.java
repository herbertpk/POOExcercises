package Exercise.Exercise2.AmigoSecreto;

public class Mensagem {
    protected String texto;
    protected String emailRemetente;
    protected boolean anonima;


    public Mensagem(String texto, String emailRemetente, boolean anonima) {
        this.texto = texto;
        this.emailRemetente = emailRemetente;
        this.anonima = anonima;
    }

    public Mensagem(){this("","",false);}


    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getEmailRemetente() {
        return emailRemetente;
    }

    public void setEmailRemetente(String emailRemetente) {
        this.emailRemetente = emailRemetente;
    }

    public boolean ehAnonima() {
        return anonima;
    }

    public void setAnonima(boolean anonima) {
        this.anonima = anonima;
    }

    public String getTextoCompletoAExibir(){
        if(this.ehAnonima()){
            return "Mensagem Anonima"+" Para todos "+"\n"+" Texto: "+this.texto;
        }
        return "Mensagem de: "+this.emailRemetente+" Para todos,"+"\n"+" Texto: "+this.texto;
    }
}

