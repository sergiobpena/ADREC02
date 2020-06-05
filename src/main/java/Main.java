import com.google.gson.Gson;
import obrigatorio.CargaJSON;
import obrigatorio.Directorios;
import obrigatorio.Informe;
import opcional.Continente;
import opcional.ContinenteJSON;
import opcional.ContinentesJSON;
import opcional.PaisesXML;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Main {


    public static void main(String[] args) {

        exercicio_obrigatorio();
        exercicio_opcional();
    }

    private static void exercicio_opcional() {
        XMLReader procedadorXML=null;
        String data="05/05/2020";
        try{

            HashMap<String, Continente> continentes = getStringContinenteHashMap();

            opcional_1(data, continentes);
//            opcional_2(data, continentes);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void opcional_2(String data, HashMap<String, Continente> continentes) {
        ContinentesJSON continentesJSON=new ContinentesJSON();

        for (Continente c : continentes.values()){
            ContinenteJSON cjson=new ContinenteJSON(c,data);
            continentesJSON.engadeContinente(cjson);
        }
        File inf = new File("coronavirus.json");
        if (inf.exists()){
            inf.delete();
        }
        xeraJSON(inf,continentesJSON);
    }

    private static void opcional_1(String data, HashMap<String, Continente> continentes) {
        System.out.println("Numero de casos no dia : " + data);
        for (Continente c : continentes.values()){
            System.out.println(c.getContinentExp()+ " : " + c.casosDia(data));

        }
    }

    private static HashMap<String, Continente> getStringContinenteHashMap() throws SAXException, IOException {
        XMLReader procedadorXML;
        procedadorXML= XMLReaderFactory.createXMLReader();
        PaisesXML paisesXML=new PaisesXML();
        procedadorXML.setContentHandler(paisesXML);
        InputSource arquivo=new InputSource("./src/main/resources/coronavirus.xml");
        procedadorXML.parse(arquivo);
        return paisesXML.getContinentes();
    }

    private static void exercicio_obrigatorio() {
        long inicio=System.currentTimeMillis();
        File f = new File("config.json");
        File inf = new File("informe.json");
        if (inf.exists()){
            inf.delete();
        }

        Directorios d=null;

        try {
            CargaJSON c = new CargaJSON(f);
            d= c.getDirectorio();
            d.contido_directorio();
            d.backup();

        } catch (IOException e) {
            e.printStackTrace();
        }
        long fin=System.currentTimeMillis();
        Double total= (double)((fin - inicio)/1000);
        Informe i = new Informe(d,total);
        xeraJSON(inf, i);

        System.out.println(total);
    }

    private static void xeraJSON(File inf, Object i) {
        Gson gson = new Gson();
        String inf_json= gson.toJson(i);
        FileWriter fw= null;
        try {
            fw = new FileWriter(inf);
            BufferedWriter bw= new BufferedWriter(fw);
            bw.write(inf_json);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
