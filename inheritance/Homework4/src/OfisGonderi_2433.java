import java.util.ArrayList;

public class OfisGonderi_2433 extends Gonderi_2433 {
    public String kategoriAdi;
    public String detay;

    public OfisGonderi_2433(String gonderiAdi, int kategoriIndex, double agirlik, double kargoUcreti, int teslimSuresi) {
        super(gonderiAdi, kategoriIndex, agirlik, kargoUcreti, teslimSuresi);
    }

    public static ArrayList<OfisGonderi_2433> list = new ArrayList<>();

    public static void ofisGonderileriniSil(double minUcret, double maxUcret){

        for(int i = list.size() - 1 ; i >= 0 ; i--){
            if(list.get(i).kargoUcreti > minUcret && list.get(i).kargoUcreti < maxUcret){
                list.remove(list.get(i));
            }
        }

        System.out.println("--------------- silme sonrasi liste ----------------");
        for(OfisGonderi_2433 ofis : list){
            System.out.println(ofis.gonderiAdi + " --> " + ofis.kargoUcreti);
        }
    }
}
