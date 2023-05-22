public class Cliente{
    private String coidceFiscale;
    private String nome;
    private String cognome;
    public Cliente(String codiceFiscale,String nome,String cognome){
        this.coidceFiscale=codiceFiscale;
        this.nome=nome;
        this.cognome=cognome;
    }
    public Cliente(){
        this.coidceFiscale=" ";
        this.nome=" ";
        this.cognome=" ";
    }
    public Cliente(Cliente c){
        this.coidceFiscale=c.getCodiceFiscale();
        this.nome=c.getNome();
        this.cognome=c.getCognome();
    }
    public Cliente clone(Cliente c) throws CloneNotSupportedException {
        return (Cliente)super.clone();
    }
    public String getNome(){return this.nome;}
    public String getCognome(){return this.cognome;}
    public String getCodiceFiscale(){return this.coidceFiscale;}
    
    public String toString(){
        return "\n Nome: "+getNome()+"\n Cognome: "+getCognome()+"\n codice fiscale: "+getCodiceFiscale();
    }
}