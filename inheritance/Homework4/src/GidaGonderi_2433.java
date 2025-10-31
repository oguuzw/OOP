import java.util.ArrayList;

public class GidaGonderi_2433 extends Gonderi_2433 {
    public String kategoriAdi;
    public String detay;

    public GidaGonderi_2433(String gonderiAdi, int kategoriIndex, double agirlik, double kargoUcreti, int teslimSuresi) {
        super(gonderiAdi, kategoriIndex, agirlik, kargoUcreti, teslimSuresi);
    }

    public static ArrayList<GidaGonderi_2433> list = new ArrayList<>();

    public static void gidaGonderisiEkle(String adi, double agirlik, double ucret, int teslimSuresi){
        GidaGonderi_2433 yeniGonderi = new GidaGonderi_2433(adi,5,agirlik,ucret,teslimSuresi);

        list.add(yeniGonderi);

        System.out.println("------------- yeni gonderi eklenmis liste -----------");
        for(GidaGonderi_2433 gida : list){
            System.out.println(gida.gonderiAdi + "\t" + gida.kategoriIndex + "\t" + gida.agirlik + "\t" + gida.kargoUcreti + "\t" + gida.teslimSuresi);
        }
    }
}
