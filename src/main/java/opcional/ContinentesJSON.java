package opcional;

import java.util.ArrayList;

/**
 * Clases para parsear o arrayList de continenetes a JSON
 */
public class ContinentesJSON {


    private ArrayList<ContinenteJSON> continentes=new ArrayList<ContinenteJSON>();

    public ContinentesJSON() {
    }

    public void engadeContinente(ContinenteJSON c){
        this.continentes.add(c);
    }
    public ArrayList<ContinenteJSON> getContinentes() {
        return continentes;
    }

    public void setContinentes(ArrayList<ContinenteJSON> continentes) {
        this.continentes = continentes;
    }
}
