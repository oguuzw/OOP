package Paket;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ders {
    protected String ad;
    protected String ogretimUyesi;
    protected int donemYili;
    protected double kredi;
    protected int kontenjan;
    protected int turKodu;

    public Ders( String ad,String ogretimUyesi, int donemYili, double kredi, int kontenjan, int turKodu) {
        this.ad = ad;
        this.ogretimUyesi = ogretimUyesi;
        this.donemYili = donemYili;
        this.kredi = kredi;
        this.kontenjan = kontenjan;
        this.turKodu = turKodu;
    }

    public static void listeleriOlustur(String dosyaAdi) throws IOException {
        FileReader fileReader = new FileReader(dosyaAdi);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String satir;
        while((satir = bufferedReader.readLine()) != null){
            String dizi[] = satir.split(",");

            String ad = dizi[0];
            String ogretimUyesi = dizi[1];
            int donemYili = Integer.valueOf(dizi[2]);
            double kredi = Double.valueOf(dizi[3]);
            int kontenjan = Integer.valueOf(dizi[4]);
            int turKodu = Integer.valueOf(dizi[5]);

            if(turKodu == 1){
                Muhendislik.muhendislik.add(new Muhendislik(ad,ogretimUyesi,donemYili,kredi,kontenjan,turKodu));
            }else if(turKodu == 0){
                TemelBilimler.temelBilimler.add(new TemelBilimler(ad,ogretimUyesi,donemYili,kredi,kontenjan,turKodu));
            }
        }
    }

    protected void dersKontenjanGuncelle(String dersAdi, boolean kayitMi, int sayi){
        for(TemelBilimler temelBilimler : TemelBilimler.temelBilimler){
            if(temelBilimler.ad == dersAdi){
                if(kayitMi){
                    temelBilimler.kontenjan -= sayi;
                    System.out.println(temelBilimler.ad + " kontenjani " + temelBilimler.kontenjan + " a dusmustur");
                }else{
                    temelBilimler.kontenjan += sayi;
                    System.out.println(temelBilimler.ad + " kontenjani " + temelBilimler.kontenjan + " a yukselmistir");
                }
            }
        }
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getOgretimUyesi() {
        return ogretimUyesi;
    }

    public void setOgretimUyesi(String ogretimUyesi) {
        this.ogretimUyesi = ogretimUyesi;
    }

    public int getDonemYili() {
        return donemYili;
    }

    public void setDonemYili(int donemYili) {
        this.donemYili = donemYili;
    }

    public double getKredi() {
        return kredi;
    }

    public void setKredi(double kredi) {
        this.kredi = kredi;
    }

    public int getKontenjan() {
        return kontenjan;
    }

    public void setKontenjan(int kontenjan) {
        this.kontenjan = kontenjan;
    }

    public int getTurKodu() {
        return turKodu;
    }

    public void setTurKodu(int turKodu) {
        this.turKodu = turKodu;
    }
}
