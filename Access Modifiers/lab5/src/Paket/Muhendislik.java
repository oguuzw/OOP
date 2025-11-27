package Paket;

import java.util.ArrayList;

public class Muhendislik extends Ders{
    public static ArrayList<Muhendislik> muhendislik = new ArrayList<Muhendislik>();

    public Muhendislik( String ad ,String ogretimUyesi, int donemYili, double kredi, int kontenjan, int turKodu) {
        super(ogretimUyesi, ad, donemYili, kredi, kontenjan, turKodu);
    }

    private void MuhendislikKrediArtir(double oran){
        for(Muhendislik muhendislikDers : muhendislik){
            muhendislikDers.kredi *= oran;
        }

        for(Muhendislik muhendislik1 : muhendislik){
            System.out.println(muhendislik1.ad + "dersinin yeni kredisi --> " + muhendislik1.kredi);
        }
    }
}

