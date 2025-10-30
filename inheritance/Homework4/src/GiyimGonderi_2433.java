import java.util.ArrayList;

public class GiyimGonderi_2433 extends Gonderi_2433 {
    public String kategoriAdi;
    public String detay;

    public GiyimGonderi_2433(String gonderiAdi, int kategoriIndex, String agirlik, double kargoUcreti, int teslimSuresi) {
        super(gonderiAdi, kategoriIndex, agirlik, kargoUcreti, teslimSuresi);
    }

    public static ArrayList<GiyimGonderi_2433> list = new ArrayList<>();
}
