package Paket2;

import java.util.ArrayList;

public class GiyimGonderi_2433 extends Gonderi_2433 {
    private String kategoriAdi;
    private String detay;

    public GiyimGonderi_2433(String gonderiAdi, int kategoriIndex, double agirlik, double kargoUcreti, int teslimSuresi) {
        super(gonderiAdi, kategoriIndex, agirlik, kargoUcreti, teslimSuresi);
    }

    private static ArrayList<GiyimGonderi_2433> list = new ArrayList<>();

    protected static void giyimGonderiDetayEkle(String adi, String yeniDetay){

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

    public static ArrayList<GiyimGonderi_2433> getList() {
        return list;
    }

    public static void setList(ArrayList<GiyimGonderi_2433> list) {
        GiyimGonderi_2433.list = list;
    }
}

