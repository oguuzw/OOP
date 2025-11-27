package Paket2;

import java.util.ArrayList;

public class OfisGonderi_2433 extends Gonderi_2433 {
    private String kategoriAdi;
    private String detay;

    public OfisGonderi_2433(String gonderiAdi, int kategoriIndex, double agirlik, double kargoUcreti, int teslimSuresi) {
        super(gonderiAdi, kategoriIndex, agirlik, kargoUcreti, teslimSuresi);
    }

    private static ArrayList<OfisGonderi_2433> list = new ArrayList<>();

    protected static void ofisGonderileriniSil(double minUcret, double maxUcret){

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

    public static ArrayList<OfisGonderi_2433> getList() {
        return list;
    }

    public static void setList(ArrayList<OfisGonderi_2433> list) {
        OfisGonderi_2433.list = list;
    }
}

