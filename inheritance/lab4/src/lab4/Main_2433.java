import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main_2433 {

    public static ArrayList<YapiMalzemesi> yapiliste = new ArrayList<>();
    public static ArrayList<InsaatMalzemesi> insaatliste = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        

        listesiOlustur("envanter.txt");
        yapiliste.get(0).enPahaliStokGuncelle(yapiliste, 25);
    }

    public static void listesiOlustur(String dosyaAdi)throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(dosyaAdi));

        String satir;
        while((satir = bufferedReader.readLine()) != null){
            String dizi[] = satir.split(",");

            String ad = dizi[0];
            int kategoriIndex = Integer.valueOf(dizi[1]);
            double birimAgirlik = Double.valueOf(dizi[2]);
            double birimFiyat = Double.valueOf(dizi[3]);
            int stokMiktari = Integer.valueOf(dizi[4]);
             
            if(kategoriIndex == 2){
                yapiliste.add(new YapiMalzemesi(ad, kategoriIndex, birimAgirlik, birimFiyat, stokMiktari));
            }else if(kategoriIndex == 3){
                insaatliste.add(new InsaatMalzemesi(ad, kategoriIndex, birimAgirlik, birimFiyat, stokMiktari));
            }
        }
    }
}
