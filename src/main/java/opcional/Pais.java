package opcional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * Clase que encapsula os resportes recollidos por pais
 */
public class Pais {
    //Hasmap con clave a data e o reporte asociado a esta
    HashMap<Date, Reporte> reportes=new HashMap<Date, Reporte>();
    //Campos recollidos no xml
    private String popData2018;
    private String countriesAndTerritories;
    private String countryterritoryCode;
    //variable reporte auxiliar
    private Reporte r;

    public Pais(){}

    public Pais(Pais p ){
        this.reportes.put(p.getR().getDateRep(),p.getR());
        this.popData2018=p.getPopData2018();
        this.countriesAndTerritories=p.getCountriesAndTerritories();
        this.countryterritoryCode=p.getCountryterritoryCode();
    }
    public Reporte getR() {
        return r;
    }

    public void setR(Reporte r) {
        this.r = r;
    }


    public HashMap<Date, Reporte> getReportes() {
        return reportes;
    }

    public void setReportes(Reporte r) {
        this.reportes.put(r.getDateRep(),r);
    }

    /**
     * Metodo para obter os casos por dia no pais
     * @param d data en formato dd/MM/YYYY
     * @return numero de casos no dia indicado
     */
    public int casosDia(String d){
        Date data= null;
        int casos=0;
        try {
            data = new SimpleDateFormat("dd/MM/yyyy").parse(d);
            casos=this.reportes.get(data).getCases();
        } catch (ParseException e) {
            System.out.println("Erro no formato da data");
        }catch (NullPointerException ex){
            casos=0;
        }
        return casos;
    }

    /**
     * Metodo para obter o numero de mortes nun dia no pais
     * @param d data en formato dd/MM/YYYY
     * @return numero de casos no dia indicado
     */
    public int mortesDia(String d ){
        Date data=null;
        int mortes=0;
        try {
            data=new SimpleDateFormat("dd/MM/yyyy").parse(d);
            mortes= this.reportes.get(data).getDeaths();
        } catch (ParseException e) {
            System.out.println("Erro no formato de data");
        }catch (NullPointerException ex){
            mortes=0;
        }
        return mortes;
    }

    public String getPopData2018() {
        return popData2018;
    }

    public void setPopData2018(String popData2018) {
        this.popData2018 = popData2018;
    }

    public String getCountriesAndTerritories() {
        return countriesAndTerritories;
    }

    public void setCountriesAndTerritories(String countriesAndTerritories) {
        this.countriesAndTerritories = countriesAndTerritories;
    }

    public String getCountryterritoryCode() {
        return countryterritoryCode;
    }

    public void setCountryterritoryCode(String countryterritoryCode) {
        this.countryterritoryCode = countryterritoryCode;
    }

    public void engadeReporte(Pais p) {
        this.reportes.put(p.getR().getDateRep(),p.getR());
    }
}
