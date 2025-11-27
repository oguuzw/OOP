package Paket2;

import java.util.ArrayList;

public class KitapGonderi_2433 extends Gonderi_2433 {
    private String kategoriAdi;
    private String detay;

    public KitapGonderi_2433(String gonderiAdi, int kategoriIndex, double agirlik, double kargoUcreti, int teslimSuresi) {
        super(gonderiAdi, kategoriIndex, agirlik, kargoUcreti, teslimSuresi);
    }

    private static ArrayList<KitapGonderi_2433> list = new ArrayList<>();

    protected static void kitapGonderiSuresiGuncelle(int index, int yeniSure){

        list.get(index).teslimSuresi = yeniSure;
        System.out.println("---------- yeni teslim suresi ----------");
        for(KitapGonderi_2433 kitap : list){
            System.out.println(kitap.gonderiAdi + " -->\tteslim suresi : " + kitap.teslimSuresi);
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

    public static ArrayList<KitapGonderi_2433> getList() {
        return list;
    }

    public static void setList(ArrayList<KitapGonderi_2433> list) {
        KitapGonderi_2433.list = list;
    }
}

