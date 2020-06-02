package opcional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporte {
    private Date dateRep;
    private int cases;
    private int deaths;

    public Date getDateRep() {
        return dateRep;
    }

    public void setDateRep(String dateRep) {
        try {
            this.dateRep = new SimpleDateFormat("dd/MM/yyyy").parse(dateRep);
        } catch (ParseException e) {
            System.out.println("Erro no formato de data");
            this.dateRep=null;
        }
    }

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }
}
