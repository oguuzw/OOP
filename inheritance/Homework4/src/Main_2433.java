import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_2433 {
    public static void main(String args[])throws IOException{
        listeleriOlustur("KargoOdev4.txt");
        kargoGrubuEkle("KargoGrubuOdev4.txt");
        
    }

    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("---------------------");
            System.out.println("1: TeslimSuresineGoreKargoUcretiGuncelle");
            System.out.println("2: EnHafifGonderiyeEkUcretUygula");
            System.out.println("3: ElektronikGonderiAgirlikGuncelle");
            System.out.println("4: KitapGonderiSuresiGuncelle");
            System.out.println("5: GiyimGonderiDetayEkle");
            System.out.println("6: OfisGonderileriniSil");
            System.out.println("7: GidaGonderisiEkle");
            System.out.println("8: Çıkış");
            System.out.println("---------------------");

            switch (scanner.nextInt()){
                case 1 : break;
                case 8 : return;
            }
        }
    }

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
                case 1 : ElektronikGonderi_2433.list.add(new ElektronikGonderi_2433(dizi[0],Integer.valueOf(dizi[1]),dizi[2],Double.valueOf(dizi[3]),Integer.valueOf(dizi[4])));
                    break;
                case 2 : KitapGonderi_2433.list.add(new KitapGonderi_2433(dizi[0],Integer.valueOf(dizi[1]),dizi[2],Double.valueOf(dizi[3]),Integer.valueOf(dizi[4])));
                    break;
                case 3 : GiyimGonderi_2433.list.add(new GiyimGonderi_2433(dizi[0],Integer.valueOf(dizi[1]),dizi[2],Double.valueOf(dizi[3]),Integer.valueOf(dizi[4])));
                    break;
                case 4 : OfisGonderi_2433.list.add(new OfisGonderi_2433(dizi[0],Integer.valueOf(dizi[1]),dizi[2],Double.valueOf(dizi[3]),Integer.valueOf(dizi[4])));;
                    break;
                case 5 : GidaGonderi_2433.list.add(new GidaGonderi_2433(dizi[0],Integer.valueOf(dizi[1]),dizi[2],Double.valueOf(dizi[3]),Integer.valueOf(dizi[4])));
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
                    ElektronikGonderi_2433.list.get(sayacElektronik).kategoriAdi = dizi[1];
                    ElektronikGonderi_2433.list.get(sayacElektronik++).detay = dizi[2];
                    break;
                case 2 :
                    KitapGonderi_2433.list.get(sayacKitap).kategoriAdi = dizi[1];
                    KitapGonderi_2433.list.get(sayacKitap++).detay = dizi[2];
                    break;
                case 3 :
                    GiyimGonderi_2433.list.get(sayacGiyim).kategoriAdi = dizi[1];
                    GiyimGonderi_2433.list.get(sayacGiyim++).detay = dizi[2];
                    break;
                case 4 :
                    OfisGonderi_2433.list.get(sayacOfis).kategoriAdi = dizi[1];
                    OfisGonderi_2433.list.get(sayacOfis++).detay = dizi[2];
                    break;
                case 5 :
                    GidaGonderi_2433.list.get(sayacGida).kategoriAdi = dizi[1];
                    GiyimGonderi_2433.list.get(sayacGida++).detay = dizi[2];
                    break;
            }
        }
    }
}
