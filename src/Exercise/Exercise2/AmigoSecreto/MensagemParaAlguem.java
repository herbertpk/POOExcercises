package Exercise.Exercise2.AmigoSecreto;

public class MensagemParaAlguem extends Mensagem{
   private String emailDestinatario;

    public MensagemParaAlguem(String texto,String emailRemetente,String emailDestinatario,boolean anonima) {
        this.emailDestinatario = emailDestinatario;
        super.emailRemetente = emailRemetente;
        super.anonima = anonima;
        super.texto = texto;
    }
    public MensagemParaAlguem(){this("","", "",false);}

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    @Override
    public String getTextoCompletoAExibir(){
        if(this.ehAnonima()){
            return "Mensagem Anonima Para: "+this.emailDestinatario+"\n"+" Texto: "+this.texto;
        }
        return "Mensagem de: "+this.emailRemetente+" Para: "+this.emailDestinatario+"\n"+" Texto:"+this.texto;
    }
}
