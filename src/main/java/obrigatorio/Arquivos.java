package obrigatorio;

import org.omg.CORBA.portable.OutputStream;

import java.io.*;

public class Arquivos {
    private Directorios direct;
    private String orixe;
    private String destino;

    public Arquivos(){}

    public Arquivos(Directorios direct, String orixe) {
        this.direct = direct;
        this.orixe = orixe;
//        this.destino = destino;
    }
    public void  respalda() throws IOException {
        File d_o=new File (this.direct.getDirectorio_orixe());
        File d_d= new File(this.direct.getDirectorio_backup());
        System.out.println(this.direct.getDirectorio_backup());
        if (!d_d.exists()){
            d_d.mkdir();
        }
        File a_o=new File(d_o,this.orixe);
        String destino=this.orixe.split("\\.")[0]+"_backup"+"."+this.orixe.split("\\.")[1];
        File a_d=new File(d_d,destino);
        if(!a_d.exists()){
            a_d.createNewFile();
        }

        FileInputStream is= new FileInputStream(a_o);
        FileOutputStream os= new FileOutputStream(a_d);
        byte[] buffer= new byte[1024];
        int len;
        while((len=is.read(buffer))>0){
            os.write(buffer,0,len);
        }
    }
    public Directorios getDirect() {
        return direct;
    }

    public void setDirect(Directorios direct) {
        this.direct = direct;
    }

    public String getOrixe() {
        return orixe;
    }

    public void setOrixe(String orixe) {
        this.orixe = orixe;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
