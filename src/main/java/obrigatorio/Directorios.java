package obrigatorio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Directorios {
    private String directorio_orixe="";
    private String directorio_backup="";

    public ArrayList<Arquivos> getListaArchivos() {
        return listaArchivos;
    }

    private transient ArrayList<Arquivos> listaArchivos=new ArrayList<Arquivos>();

    public Directorios(){

    }

    public Directorios(String directorio_orixe, String directorio_backup) {
        this.directorio_orixe = directorio_orixe;
        this.directorio_backup = directorio_backup;

    }

    public String getDirectorio_orixe() {
        return directorio_orixe;
    }

    public void setDirectorio_orixe(String directorio_orixe) {
        this.directorio_orixe = directorio_orixe;
    }

    public String getDirectorio_backup() {
        return directorio_backup;
    }
    public void contido_directorio(){
        File dir_or=new File(this.directorio_orixe);
        for (String i : dir_or.list()){
            File aux= new File(this.directorio_orixe);
            File arch_aux=new File(aux,i);
            if (arch_aux.isFile()){
                Arquivos a = new Arquivos(this,i);
                this.listaArchivos.add(a);
            }

        }

    }
    public void backup() throws IOException {
        for (Arquivos a : this.listaArchivos){
            a.respalda();
        }
    }
    public void setDirectorio_backup(String directorio_backup) {
        this.directorio_backup = directorio_backup;
    }
}
