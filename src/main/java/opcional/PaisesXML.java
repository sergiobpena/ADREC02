package opcional;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Date;
import java.util.HashMap;

/**
 * Clase para parsear a informacion do arquivo coronavirus.xml
 */
public class PaisesXML extends DefaultHandler{

    //Variable Hasmap co nome do continente e obxecto continente, onde quedara gardada a informacion de entrada
    private HashMap<String,Continente> continentes=new HashMap<String, Continente>();
    //Variable dummie para o reporte de cada rexistro
    private Reporte reporte;
    //Variable dummie para almacenamento dos datos do pais en cada rexistro
    private Pais pais;
    //Variable dummie para almacenar os datos do continente en cada rexistro
    private Continente continente;
    //Variable para o almacenmento do contido entre as etiquetas
    private String cadeaTexto;


    public PaisesXML(){
        super();
    }
    @Override
    public void startDocument()throws SAXException {

    }
    @Override
    public void endDocument() throws SAXException {}

    //Crea tres obxectos valeiros, Continente, reporte e pais
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (localName=="record"){
            this.reporte=new Reporte();
            this.pais=new Pais();
            this.continente=new Continente();
        }
    }
    //Por cada elemento , define cada un dos atributos dos obxectos pais , continente e reporte
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        if(localName == "cases"){
            this.reporte.setCases(Integer.valueOf(this.cadeaTexto));
        }
        else if(localName == "deaths"){
            this.reporte.setDeaths(Integer.valueOf(this.cadeaTexto));
        }
        else if(localName == "dateRep"){
           this.reporte.setDateRep(this.cadeaTexto);
        }else if(localName=="popData2018"){
            this.pais.setPopData2018(this.cadeaTexto);
        }else if (localName=="countriesAndTerritories"){
            this.pais.setCountriesAndTerritories(this.cadeaTexto);
        }else if(localName=="countryterritoryCode"){
            this.pais.setCountryterritoryCode(this.cadeaTexto);

        //Engade reporte o pais dummie , e logo engade o reporte o continente dummie encapsulado no pais dummie
        }else if(localName=="record"){
            this.pais.setR(this.reporte);
            this.continente.engadeReporte(this.pais);
            //Se existe o continente , busca este, e pasalle o pais do reporte o continente encapsulado nun obxecto pais
            //onde ali se xestiona este
            if(this.continentes.containsKey(this.continente.getContinentExp())){
                this.continentes.get(this.continente.getContinentExp()).engadeReporte(this.pais);

            }else{
                this.continentes.put(this.continente.getContinentExp(),this.continente);
            }
        }else if(localName=="continentExp"){
            this.continente.setContinentExp(this.cadeaTexto);

        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        this.cadeaTexto = new String(ch,start,length);
    }


    public HashMap<String, Continente> getContinentes() {
        return continentes;
    }
}
