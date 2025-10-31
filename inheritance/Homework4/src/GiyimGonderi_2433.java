import java.util.ArrayList;

public class GiyimGonderi_2433 extends Gonderi_2433 {
    public String kategoriAdi;
    public String detay;

    public GiyimGonderi_2433(String gonderiAdi, int kategoriIndex, double agirlik, double kargoUcreti, int teslimSuresi) {
        super(gonderiAdi, kategoriIndex, agirlik, kargoUcreti, teslimSuresi);
    }

    public static ArrayList<GiyimGonderi_2433> list = new ArrayList<>();

    public static void giyimGonderiDetayEkle(String adi, String yeniDetay){

        for(GiyimGonderi_2433 giyim : list){
            if(giyim.gonderiAdi.equals(adi)){
                giyim.detay = giyim.detay + " | "+ yeniDetay;
            }
        }

        System.out.println("-------------------------------------------------");
        for(GiyimGonderi_2433 giyim : list){
            System.out.println(giyim.gonderiAdi + " --> " + giyim.detay);
        }

    }

}
