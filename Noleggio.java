public class Noleggio{
    private Cliente c;
    private Veicolo v;
    private double costo;
    private int tempo;//in giorni
    private String dataInizio;
    private String dataFine;
    private int codice;
    private static int codiceUnivoco=0;
    public Noleggio(Veicolo v,Cliente c,int tempo,String dataInzio,String dataFine){
        this.codice=codiceUnivoco;
        codiceUnivoco++;
        this.c=new Cliente(c);
        this.v=v;
        this.tempo=tempo;
        this.costo=v.getTariffa()*this.tempo;
        this.dataInizio=dataInzio;
        this.dataFine=dataFine;
    }
    public int getCodice(){return this.codice;}
    public double getCosto(){
        return this.costo;
    }
     public Cliente getCliente(){
        return this.c;
    }
    public Veicolo getVeicolo(){
        return this.v;
    }
    public Noleggio(){
        
    }
    public String toStringApporofondito(){
        return "\n ID :"+getCodice()+"\n targa veicolo noleggiato: "+v.getTarga()+"\n codice fiscale: "+c.getCodiceFiscale()+"\n data inizio: "+this.dataInizio+"\n numero giorni: "+this.tempo+"\n costo: "+this.costo;
    }
    public String toStringSignificativo(){
        return "\n targa: "+v.getTarga()+"--> codice Fiscale: "+c.getCodiceFiscale();
    }
}