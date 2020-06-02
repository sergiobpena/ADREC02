package opcional;

import java.util.Date;
import java.util.HashMap;

/**
 * Clase que almacena a informacion por continentes
 */
public class Continente {
    //Hasmap con clave nome do pais e obxecto pais asociado
    private HashMap<String,Pais> paises=new HashMap<String, Pais>();
    //Nome do continente
    private String continentExp;



    public HashMap<String, Pais> getPaises() {
        return paises;
    }
    /**
     * Engade un reporte encapsulado nun pais
     * @param p pais extraido do rexistro do arquivo xml
     */
    public void engadeReporte(Pais p){
        if (this.paises.containsKey(p.getCountriesAndTerritories())){
            this.paises.get(p.getCountriesAndTerritories()).engadeReporte(p);
        }else{
            Pais x= new Pais(p);
            this.paises.put(x.getCountriesAndTerritories(),x);
        }
    }

    /**
     * Metodo que devolve os casos por dia do continente
     * @param data data en formato dd/MM/YYYY
     * @return Numero de casos no dia especificado
     */
    public int casosDia(String data){
        int casos=0;
        for (Pais p : this.paises.values()){
            casos=casos+p.casosDia(data);
        }
        return casos;
    }

    /**
     * Metodo que devolve o numero de mortes no continente
     * @param data data en formato dd/MM/YYYY
     * @return Numero de mortes no dia especificado
     */
    public int mortesDia(String data){
        int mortes=0;
        for(Pais p:this.paises.values()){
            mortes=mortes+p.mortesDia(data);
        }
        return mortes;
    }

    public void setPaises(HashMap<String, Pais> paises) {
        this.paises = paises;
    }

    public String getContinentExp() {
        return continentExp;
    }

    public void setContinentExp(String continentExp) {
        this.continentExp = continentExp;
    }
}
