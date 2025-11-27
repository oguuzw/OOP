package Paket2;

import java.util.ArrayList;
import java.util.Random;

public class ElektronikGonderi_2433 extends Gonderi_2433 {
    private String kategoriAdi;
    private String detay;

    public ElektronikGonderi_2433(String gonderiAdi, int kategoriIndex, double agirlik, double kargoUcreti, int teslimSuresi) {
        super(gonderiAdi, kategoriIndex, agirlik, kargoUcreti, teslimSuresi);
    }

    private static ArrayList<ElektronikGonderi_2433> list = new ArrayList<>();

    protected static void elektronikGonderiAgirlikGuncelle(double miktar){
        Random random = new Random();

        System.out.println("---------- onceki agirliklar ---------");
        for(ElektronikGonderi_2433 elektronik : list){
            System.out.println(elektronik.gonderiAdi + "\t" + elektronik.agirlik);
        }

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

        System.out.println("---------- sonraki agirliklar ---------");
        for(ElektronikGonderi_2433 elektronik : list){
            System.out.println(elektronik.gonderiAdi + "\t" + elektronik.agirlik);
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

    public static ArrayList<ElektronikGonderi_2433> getList() {
        return list;
    }

    public static void setList(ArrayList<ElektronikGonderi_2433> list) {
        ElektronikGonderi_2433.list = list;
    }
}

