package Paket2;

import java.util.ArrayList;

public class Cereals extends Urun{
    public Cereals(String adi, int kategoriIndex, String birimAgirlik, double birimFiyat, int stokMiktari) {
        super(adi, kategoriIndex, birimAgirlik, birimFiyat, stokMiktari);
    }
    public static ArrayList<Cereals> cereals = new ArrayList<>();
}
