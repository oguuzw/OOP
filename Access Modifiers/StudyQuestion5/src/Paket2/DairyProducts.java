package Paket2;

import java.util.ArrayList;

public class DairyProducts extends Urun{
    public DairyProducts(String adi, int kategoriIndex, String birimAgirlik, double birimFiyat, int stokMiktari) {
        super(adi, kategoriIndex, birimAgirlik, birimFiyat, stokMiktari);
    }
    public static ArrayList<DairyProducts> dairyProducts = new ArrayList<>();
}
