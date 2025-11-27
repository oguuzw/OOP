package Paket;

import java.util.ArrayList;

public class TemelBilimler extends Ders{
    public static ArrayList<TemelBilimler> temelBilimler = new ArrayList<TemelBilimler>();

    public TemelBilimler(String ad ,String ogretimUyesi, int donemYili, double kredi, int kontenjan, int turKodu) {
        super(ogretimUyesi, ad, donemYili, kredi, kontenjan, turKodu);
    }

    private void temelBilimlerDersiEkle(String ad, String ogretimUyesi, int donemYili, double kredi, int kontenjan){
        TemelBilimler yeniDers = new TemelBilimler(ad,ogretimUyesi,donemYili,kredi,kontenjan,0);
        temelBilimler.add(yeniDers);
    }


}
