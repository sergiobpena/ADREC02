package obrigatorio;

public class Informe {
    private int numero_de_arquivos_copiados;
    private double tempo_utilizado_en_segundos;
    public Informe(Directorios d,Double tempo) {
        this.numero_de_arquivos_copiados=d.getListaArchivos().size();
        this.tempo_utilizado_en_segundos=tempo;

    }
    public Informe(){}

    public int getNumero_de_arquivos_copiados() {
        return numero_de_arquivos_copiados;
    }

    public void setNumero_de_arquivos_copiados(int numero_de_arquivos_copiados) {
        this.numero_de_arquivos_copiados = numero_de_arquivos_copiados;
    }

    public double getTempo_utilizado_en_segundos() {
        return tempo_utilizado_en_segundos;
    }

    public void setTempo_utilizado_en_segundos(double tempo_utilizado_en_segundos) {
        this.tempo_utilizado_en_segundos = tempo_utilizado_en_segundos;
    }
}
