package Paket2;

import java.util.ArrayList;

public class GidaGonderi_2433 extends Gonderi_2433 {
    private String kategoriAdi;
    private String detay;

    public GidaGonderi_2433(String gonderiAdi, int kategoriIndex, double agirlik, double kargoUcreti, int teslimSuresi) {
        super(gonderiAdi, kategoriIndex, agirlik, kargoUcreti, teslimSuresi);
    }

    private static ArrayList<GidaGonderi_2433> list = new ArrayList<>();

    protected static void gidaGonderisiEkle(String adi, double agirlik, double ucret, int teslimSuresi){
        GidaGonderi_2433 yeniGonderi = new GidaGonderi_2433(adi,5,agirlik,ucret,teslimSuresi);

        list.add(yeniGonderi);

        System.out.println("------------- yeni gonderi eklenmis liste -----------");
        for(GidaGonderi_2433 gida : list){
            System.out.println(gida.gonderiAdi + "\t" + gida.kategoriIndex + "\t" + gida.agirlik + "\t" + gida.kargoUcreti + "\t" + gida.teslimSuresi);
        }
    }

    public String getKategoriAdi() {
        return kategoriAdi;
    }

    public void setKategoriAdi(String kategoriAdi) {
        this.kategoriAdi = kategoriAdi;
    }

    public String getDetay() {
        return detay;
    }

    public void setDetay(String detay) {
        this.detay = detay;
    }

    public static ArrayList<GidaGonderi_2433> getList() {
        return list;
    }

    public static void setList(ArrayList<GidaGonderi_2433> list) {
        GidaGonderi_2433.list = list;
    }
}

