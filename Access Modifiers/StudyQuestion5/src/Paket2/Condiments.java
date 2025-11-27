package Paket2;

import java.util.ArrayList;

public class Condiments extends Urun{
    public Condiments(String adi, int kategoriIndex, String birimAgirlik, double birimFiyat, int stokMiktari) {
        super(adi, kategoriIndex, birimAgirlik, birimFiyat, stokMiktari);
    }
    public static ArrayList<Condiments> condiments = new ArrayList<>();
}
