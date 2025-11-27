package Paket1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import Paket2.*;

public class VerileriDosyadanOkuma {

    public static void listeleriOlustur(String dosyaAdi) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(dosyaAdi));
        String satir;

        boolean ilkSatirMi = true;
        while((satir = bufferedReader.readLine())!=null){
            if(ilkSatirMi){
                ilkSatirMi = false;
                continue;
            }
            String dizi[] = satir.split("\t");
            switch (Integer.valueOf(dizi[1])){
                case 1 : ElektronikGonderi_2433.getList().add(new ElektronikGonderi_2433(dizi[0],Integer.valueOf(dizi[1]),Double.valueOf(dizi[2]),Double.valueOf(dizi[3]),Integer.valueOf(dizi[4])));
                    break;
                case 2 : KitapGonderi_2433.getList().add(new KitapGonderi_2433(dizi[0],Integer.valueOf(dizi[1]),Double.valueOf(dizi[2]),Double.valueOf(dizi[3]),Integer.valueOf(dizi[4])));
                    break;
                case 3 : GiyimGonderi_2433.getList().add(new GiyimGonderi_2433(dizi[0],Integer.valueOf(dizi[1]),Double.valueOf(dizi[2]),Double.valueOf(dizi[3]),Integer.valueOf(dizi[4])));
                    break;
                case 4 : OfisGonderi_2433.getList().add(new OfisGonderi_2433(dizi[0],Integer.valueOf(dizi[1]),Double.valueOf(dizi[2]),Double.valueOf(dizi[3]),Integer.valueOf(dizi[4])));;
                    break;
                case 5 : GidaGonderi_2433.getList().add(new GidaGonderi_2433(dizi[0],Integer.valueOf(dizi[1]),Double.valueOf(dizi[2]),Double.valueOf(dizi[3]),Integer.valueOf(dizi[4])));
                    break;
            }
        }
    }

    public static void kargoGrubuEkle(String dosyaAdi) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(dosyaAdi));
        String satir;

        int sayacElektronik = 0,sayacKitap = 0,sayacGiyim = 0,sayacOfis = 0,sayacGida = 0;

        boolean ilkSatirMi = true;
        while((satir = bufferedReader.readLine()) != null){
            if(ilkSatirMi){
                ilkSatirMi = false;
                continue;
            }

            String dizi[] = satir.split("\t");
            switch (Integer.valueOf(dizi[0])){
                case 1 :
                    for(ElektronikGonderi_2433 elektronik : ElektronikGonderi_2433.getList()){
                        elektronik.setKategoriAdi(dizi[1]);
                        elektronik.setDetay(dizi[2]);
                    }
                break;

                case 2 :
                    for(KitapGonderi_2433 kitap : KitapGonderi_2433.getList()){
                        kitap.setKategoriAdi(dizi[1]);
                        kitap.setDetay(dizi[2]);
                    }
                break;

                case 3 :
                    for(GiyimGonderi_2433 giyim : GiyimGonderi_2433.getList()){
                        giyim.setKategoriAdi(dizi[1]);
                        giyim.setDetay(dizi[2]);
                    }
                break;

                case 4 :
                    for(OfisGonderi_2433 ofis : OfisGonderi_2433.getList()){
                        ofis.setKategoriAdi(dizi[1]);
                        ofis.setDetay(dizi[2]);
                    }
                break;

                case 5 :
                    for(GidaGonderi_2433 gida : GidaGonderi_2433.getList()){
                        gida.setKategoriAdi(dizi[1]);
                        gida.setDetay(dizi[2]);
                    }
                break;
            }
        }
    }
}
