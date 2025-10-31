import java.util.ArrayList;
import java.util.Random;

public class ElektronikGonderi_2433 extends Gonderi_2433 {
    public String kategoriAdi;
    public String detay;

    public ElektronikGonderi_2433(String gonderiAdi, int kategoriIndex, double agirlik, double kargoUcreti, int teslimSuresi) {
        super(gonderiAdi, kategoriIndex, agirlik, kargoUcreti, teslimSuresi);
    }

    public static ArrayList<ElektronikGonderi_2433> list = new ArrayList<>();

    public static void elektronikGonderiAgirlikGuncelle(double miktar){
        Random random = new Random();

        for(ElektronikGonderi_2433 elektronik : list){
            int arttirVeyaAzalt = random.nextInt(2);
            if(elektronik.agirlik - miktar < 0){
                elektronik.agirlik += miktar;
            }else if(arttirVeyaAzalt == 0){
                elektronik.agirlik += miktar;
            } else if(arttirVeyaAzalt == 1) {
                elektronik.agirlik -= miktar;
            }
        }
    }
}
