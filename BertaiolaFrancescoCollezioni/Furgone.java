public class Furgone extends Veicolo{
    private double capacitaCarico;
    public Furgone(String targa,String modello,double tariffa,double capacitaCarico){
        super(targa,modello,tariffa);
        this.capacitaCarico=capacitaCarico;
    }
    public Furgone(){
        super();
        this.capacitaCarico=0;
    }
    public double getCarico(){return this.capacitaCarico;}
    public void setCarico(double carico){
        this.capacitaCarico=carico;
    }
    
    public String toString(){
        return super.toString()+"\n capacità carico: "+getCarico()+"Kg";
    }
}