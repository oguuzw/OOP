import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main_2433 {

    public static void main(String[] args) throws IOException  {
        ArrayList<Urun_2433> arrayList = new ArrayList<>();
        dosyaOkuListeyeGonder(arrayList);
        swap(arrayList);
    }

    public static void dosyaOkuListeyeGonder(ArrayList<Urun_2433> arrayList) throws IOException {
        FileReader fileReader = new FileReader("urunler.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String satir;
        while((satir = bufferedReader.readLine()) != null) {
            String dizi[] = satir.split(" ");
            Urun_2433 yeniUrun = new Urun_2433();

            yeniUrun.no = Integer.valueOf(dizi[0]);
            yeniUrun.aletAdi = dizi[1];
            yeniUrun.fiyat = Double.valueOf(dizi[2]);
            yeniUrun.stok = Integer.valueOf(dizi[3]);
            yeniUrun.menseiUlke = dizi[4];
            yeniUrun.toplamDeger = (yeniUrun.fiyat * yeniUrun.stok) / 1000;

            arrayList.add(yeniUrun);
        }


        for(Urun_2433 urun : arrayList) {
            System.out.println(urun.no + " | " + urun.aletAdi + " | " + urun.fiyat + " | " + urun.stok + " | " + urun.menseiUlke + " | " + urun.toplamDeger);
        }
    }

    public static void swap(ArrayList<Urun_2433> arrayList) {
        double enYuksekToplamDeger = 0;
        double enDusukToplamDeger = 0;

        boolean ilkMiEnYuksek = true;
        boolean ilkMiEnDusuk = true;

        int enDusukIndex = 0;
        int enYuksekIndex = 0;

        for(Urun_2433 urun : arrayList) {
            if((enYuksekToplamDeger < urun.toplamDeger) || ilkMiEnYuksek) {
                enYuksekToplamDeger = urun.toplamDeger;
                enYuksekIndex = urun.no - 1;
                ilkMiEnYuksek = false;
            }
        }

        for(Urun_2433 urun : arrayList) {
            if((urun.toplamDeger < enDusukToplamDeger) || ilkMiEnDusuk) {
                enDusukToplamDeger = urun.toplamDeger;
                enDusukIndex = urun.no - 1;
                ilkMiEnDusuk = false;
            }
        }

        System.out.println(enYuksekToplamDeger + " "+ enYuksekIndex);
        System.out.println(enDusukToplamDeger + " "+ enDusukIndex);

        Urun_2433 tempYuksek = arrayList.get(enYuksekIndex);
        Urun_2433 tempDusuk = arrayList.get(enDusukIndex);

        arrayList.set(enYuksekIndex, tempDusuk);
        arrayList.set(enDusukIndex, tempYuksek);


        System.out.println("-------------------------- SWAP SONRASI LISTE -------------------------------");
        for(Urun_2433 urun : arrayList) {
            System.out.println(urun.no + " | " + urun.aletAdi + " | " + urun.fiyat + " | " + urun.stok + " | " + urun.menseiUlke + " | " + urun.toplamDeger);
        }



    }

}