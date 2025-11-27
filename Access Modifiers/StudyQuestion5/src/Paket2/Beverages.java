package Paket2;

import java.util.ArrayList;

public class Beverages extends Urun{
    public Beverages(String adi, int kategoriIndex, String birimAgirlik, double birimFiyat, int stokMiktari) {
        super(adi, kategoriIndex, birimAgirlik, birimFiyat, stokMiktari);
    }

    public static ArrayList<Beverages> beverages = new ArrayList<>();
}
