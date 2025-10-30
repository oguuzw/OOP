import java.util.ArrayList;

public class ElektronikGonderi_2433 extends Gonderi_2433 {
    public String kategoriAdi;
    public String detay;

    public ElektronikGonderi_2433(String gonderiAdi, int kategoriIndex, String agirlik, double kargoUcreti, int teslimSuresi) {
        super(gonderiAdi, kategoriIndex, agirlik, kargoUcreti, teslimSuresi);
    }

    public static ArrayList<ElektronikGonderi_2433> list = new ArrayList<>();

}
