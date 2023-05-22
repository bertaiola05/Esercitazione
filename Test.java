/**
 * gestione dei clienti di una stazione di rifornimento -->priority queue perchè si va in ordine di come si arriva quindi serve una FIFO 
 * libri di una bibblioteca -->hash map perchè facilita la ricerca e l'aggiunta di un prodotto 
 * gestione dei prodotti in un magazzino --> hashmap perchè facilita la ricerca e l'aggiunta di un prodotto 
 * hashmap --> gestione di un noleggio di bicilette
 * albero bianrio--> ricerca all interno di qualcosa che ha pochissime agigunte dato che è difficile ri blianciare sempre l'albero
 */
public class Test{
    public static void main(String[] args) throws NoleggioInseistente, HashMapVuota {
        Noleggi N= new Noleggi();
        Furgone f1=new Furgone("Az1239Pt","Fiorino a metano",10.2,300);
        Cliente c1=new Cliente("CRA183ABAUSR","Franco","jeans");
        Cliente c2=new Cliente("BRET123ASD","Giorgio","armadio");
        Automobile a1=new Automobile("Ca1237AV","pandino spaccato",10.2,5);
        Noleggio n1=new Noleggio((Veicolo)f1,c1,100,"20/11/2024","23/11/2024");
        Noleggio n2=new Noleggio((Veicolo)a1,c2,70,"24/01/2024","26/01/2024");
        try
        {
            try
            {
                N.aggiungi(n1);
                N.aggiungi(n2);
            }
            catch (VeicoloOccupato vo)
            {
                System.out.println("IL VEICOLO CHE VUOI NOLEGGIARE è OCCUAPTO ERRORE!!");
            }
        }
        catch (HashMapPiena hmp)
        {
            System.out.println("HASHMAP PIENA ERRORE!!");
        }
        try{
            System.out.println(N.visualizzaNoleggi());
           
        }catch(HashMapVuota hmv){
            System.out.println("HASHMAP VUOTA ERRORE!!");
        }
        try{
            System.out.println(N.visualizzaSchedaSpecifica(n1));
            System.out.println(N.visualizzaSchedaSpecifica(n2));

        }catch(NoleggioInseistente hmv){
            System.out.println("QUESTO NOLEGGIO NON ESITE ERRORE!");
        }
        System.out.println(N.caloloDataTarga(n1.getVeicolo().getTarga()));
        System.out.println(N.caloloDatoCodiceFiscale(n2.getCliente().getCodiceFiscale()));
        System.out.println(N.totalePerAuto());
    }
}