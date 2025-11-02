import java.util.ArrayList;

public class KitapGonderi_2433 extends Gonderi_2433 {
    public String kategoriAdi;
    public String detay;

    public KitapGonderi_2433(String gonderiAdi, int kategoriIndex, double agirlik, double kargoUcreti, int teslimSuresi) {
        super(gonderiAdi, kategoriIndex, agirlik, kargoUcreti, teslimSuresi);
    }

    public static ArrayList<KitapGonderi_2433> list = new ArrayList<>();

    public static void kitapGonderiSuresiGuncelle(int index, int yeniSure){

        list.get(index).teslimSuresi = yeniSure;
        System.out.println("---------- yeni teslim suresi ----------");
        for(KitapGonderi_2433 kitap : list){
            System.out.println(kitap.gonderiAdi + "\tteslim suresi : " + kitap.teslimSuresi);
        }
    }
}
