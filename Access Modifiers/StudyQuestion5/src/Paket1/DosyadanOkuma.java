package Paket1;

import Paket2.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DosyadanOkuma {

    public static void dosyayiOku(String dosyaAdi) throws IOException {
        FileReader fileReader = new FileReader(dosyaAdi);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String satir;
        boolean ilkMi=true;
        while((satir = bufferedReader.readLine()) != null){
            if(ilkMi){
                ilkMi = false;
                continue;
            }

            String dizi[] = satir.split("\t");
            String  adi = dizi[0];
            int kategoriIndex = Integer.valueOf(dizi[1]);
            String birimAgirlik = dizi[2];
            double birimFiyat = Double.valueOf(dizi[3]);
            int stokMiktari = Integer.valueOf(dizi[4]);

            switch (kategoriIndex){
                case 1 : Beverages.beverages.add(new Beverages(adi,kategoriIndex,birimAgirlik,birimFiyat,stokMiktari));
                break;
                case 2 :Cereals.cereals.add(new Cereals(adi,kategoriIndex,birimAgirlik,birimFiyat,stokMiktari));
                break;
                case 3 : Condiments.condiments.add(new Condiments(adi,kategoriIndex,birimAgirlik,birimFiyat,stokMiktari));
                break;
                case 4 : Confections.confections.add(new Confections(adi,kategoriIndex,birimAgirlik,birimFiyat,stokMiktari));
                break;
                case 5 : DairyProducts.dairyProducts.add(new DairyProducts(adi,kategoriIndex,birimAgirlik,birimFiyat,stokMiktari));
                break;
            }
        }
    }
}
