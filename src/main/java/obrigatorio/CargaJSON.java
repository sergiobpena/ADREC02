package obrigatorio;

import com.google.gson.Gson;

import java.io.*;
import java.util.HashMap;

public class CargaJSON {
    private HashMap<String,String> directorios;
    private File configuracion;

    public Directorios getDirectorio() {
        return directorio;
    }

    private Directorios directorio;

    public CargaJSON(File conf) throws IOException {
        this.configuracion=conf;
        parseaJson();
    }
    private String leeJson() throws IOException {
        FileReader fr = new FileReader(this.configuracion);
        BufferedReader br = new BufferedReader(fr);
        StringBuilder jsonBuilder= new StringBuilder();
        String lina;
        while ((lina=br.readLine())!=null){
            jsonBuilder.append(lina).append("\n");
        }
        br.close();
        return  jsonBuilder.toString();
    }
    private void parseaJson() throws IOException {
        Gson gx= new Gson();
        Directorios d = gx.fromJson(leeJson(),Directorios.class);
        File directorio= new File(d.getDirectorio_orixe());
        if(!directorio.exists()){
            throw new IllegalArgumentException();
        }else{
            this.directorio=d;
        }

    }
}
