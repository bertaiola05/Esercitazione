public abstract class Veicolo implements Comparable<Veicolo>{
    private String targa;
    private String modello;
    private double tariffa;
    public Veicolo(String targa,String modello,double tariffa){
        this.targa=targa;
        this.modello=modello;
        this.tariffa=tariffa;
    }
    public Veicolo(){
        this.targa=" ";
        this.modello=" ";
        this.tariffa=0;
    }
    public Veicolo(Veicolo v){
        this.targa=v.getTarga();
        this.modello=v.getModello();
        this.tariffa=v.getTariffa();
    }
    public boolean equals(Veicolo v){
        return v.getModello()==this.modello&&
                v.getTarga()==this.targa&&
                v.getTariffa()==this.tariffa;
    }
    public String getTarga(){return this.targa;}
    public String getModello(){return this.modello;}
    public double getTariffa(){return this.tariffa;}
    
    public void setTarga(String targa){this.targa=targa;}
    public void setModello(String modello){this.modello=modello;}
    public void setTariffa(double tariffa){this.tariffa=tariffa;}
    
    public int compareTo(Veicolo v){
        if(v.getTarga().equals(this.targa)){
            return 0;
        }else{
            return -1;
        }
    }
    public String toString(){
        return "\n targa: "+getTarga()+"\n modello: "+getModello()+"\n tariffa: "+getTariffa();
    }
}