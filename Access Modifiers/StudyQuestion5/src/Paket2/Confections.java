package Paket2;

import java.util.ArrayList;

public class Confections extends Urun{
    public Confections(String adi, int kategoriIndex, String birimAgirlik, double birimFiyat, int stokMiktari) {
        super(adi, kategoriIndex, birimAgirlik, birimFiyat, stokMiktari);
    }
    public static ArrayList<Confections> confections = new ArrayList<>();
}
