public class Automobile extends Veicolo{
    private int posti;
    public Automobile(String targa,String modello,double tariffa,int posti){
        super(targa,modello,tariffa);
        this.posti=posti;
    }
    public Automobile(){
        super();
        this.posti=0;
    }
    public int getPosti(){return this.posti;}
    public void setPosti(int posti){
        this.posti=posti;
    }
    
    public String toString(){
        return super.toString()+"\n posti: "+getPosti();
    }
}