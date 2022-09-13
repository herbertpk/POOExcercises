package Exercise.Exercise3.AmigoSecretoMap;

public class MensagemParaTodos extends Mensagem {
    public MensagemParaTodos(String texto, String emailRemetente, boolean anonima){
        super.texto = texto;
        super.emailRemetente = emailRemetente;
        super.anonima = anonima;
    }
    public MensagemParaTodos(){this("","",false);}


    @Override
    public String getTextoCompletoAExibir(){
        if(this.ehAnonima()){
            return "Mensagem Anonima"+" Para todos "+"\n"+" Texto: "+this.texto;
        }
        return "Mensagem de: "+this.emailRemetente+" Para todos,"+"\n"+" Texto: "+this.texto;
    }
}
