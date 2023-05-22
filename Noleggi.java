import java.util.HashMap;
class HashMapPiena extends Exception{
    
}
class HashMapVuota extends Exception{
    
}
class NoleggioInseistente extends Exception{
    
}
class VeicoloOccupato extends Exception{
    
}
class TargaInesitente extends Exception{
    
}
public class Noleggi{
    HashMap<Integer,Noleggio> noleggi;
    private static int NMAX=100;
    public Noleggi(){
        noleggi=new  HashMap<Integer,Noleggio>(NMAX);
    }
    public boolean cercaVeicolo(Noleggio n){
        for( Noleggio noleg:noleggi.values()){
            if(noleg.getVeicolo().equals(n.getVeicolo())){
                return true;
            }
        }
        return false;
    }
    public void aggiungi(Noleggio n) throws VeicoloOccupato, HashMapPiena {
        if(noleggi.size()>NMAX){
            throw new HashMapPiena();
        }else if(cercaVeicolo(n)){
            throw new VeicoloOccupato();
        }else{
            noleggi.put(n.getCodice(),n);
        }
    }
    public String visualizzaNoleggi() throws HashMapVuota {
        String stampa=" ";
        if(noleggi.isEmpty()){
            throw new HashMapVuota();
        }else{
            for(Noleggio n:noleggi.values()){
                stampa+=n.toStringSignificativo();
            }
            return stampa;
        }
    }
    public String visualizzaSchedaSpecifica(Noleggio n) throws NoleggioInseistente {
        if(noleggi.containsKey(n.getCodice())){
            return n.toStringApporofondito();
        }else{
            throw new NoleggioInseistente();
        }
    }
    public Noleggio cercaVeicoloTarga(String t) throws TargaInesitente {
        for(Noleggio n:noleggi.values()){
            if(n.getVeicolo().getTarga().equals(t)){
                return n;
            }
        }
        throw new TargaInesitente();
    }
    public String caloloDataTarga(String targa){
        try
        {
            Noleggio n=cercaVeicoloTarga(targa);
            return "\n per il noleggio :"+n.toStringApporofondito()+"\n il costo è di : "+n.getCosto();
        }
        catch (TargaInesitente ti)
        {
            System.out.println("TARGA NON PRESENTE NEL REGISTRO");
        }
        return null;
    }
    public Noleggio cercaVeicoloCf(String cf) throws TargaInesitente {
        for(Noleggio n:noleggi.values()){
            if(n.getCliente().getCodiceFiscale().equals(cf)){
                return n;
            }
        }
        throw new TargaInesitente();
    }
     public String caloloDatoCodiceFiscale(String cf){
        try
        {
            Noleggio n=cercaVeicoloCf(cf);
            return "\n per il noleggio :"+n.toStringApporofondito()+"\n il costo è di : "+n.getCosto();
        }
        catch (TargaInesitente ti)
        {
            System.out.println("CODICE FISCALE NON PRESENTE NEL REGISTRO");
        }
        return null;
    }
    
    public String totalePerAuto(){
        double costo=0;
        for(Noleggio n:noleggi.values()){
            if(n.getVeicolo() instanceof Automobile){
                costo+=n.getCosto();
            }
        }
        return "\n il costo in euro dei noleggi per auto è di "+costo+"€";
    }
}