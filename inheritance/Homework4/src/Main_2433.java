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
        menu();
    }

    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("----------------------------------------");
            System.out.println("1: TeslimSuresineGoreKargoUcretiGuncelle");
            System.out.println("2: EnHafifGonderiyeEkUcretUygula");
            System.out.println("3: ElektronikGonderiAgirlikGuncelle");
            System.out.println("4: KitapGonderiSuresiGuncelle");
            System.out.println("5: GiyimGonderiDetayEkle");
            System.out.println("6: OfisGonderileriniSil");
            System.out.println("7: GidaGonderisiEkle");
            System.out.println("8: Çıkış");
            System.out.println("-----------------------------------------");

            switch (scanner.nextInt()){
                case 1 :

                    System.out.println("sure giriniz (girilen sureden buyuk gonderilerin ucreti guncellenecek) : ");
                    int sure = scanner.nextInt();
                    System.out.println("guncel ucret giriniz : ");
                    double guncelUcret = scanner.nextDouble();

                    Gonderi_2433.teslimSuresineGoreKargoUcretiGuncelle(sure,guncelUcret);
                    break;

                case 2 :
                    System.out.println("ek ucret uygulamak icin oran degeri giriniz : ");
                    int oran = scanner.nextInt();
                    Gonderi_2433.enHafifGonderiyeEkUcretUygula(oran);

                    break;

                case 3 :

                    System.out.println("miktar giriniz : ");
                    ElektronikGonderi_2433.elektronikGonderiAgirlikGuncelle(scanner.nextDouble());
                    break;

                case 4 :

                    System.out.println("index degeri giriniz : ");
                    int index = scanner.nextInt();
                    System.out.println("yeni sure degeri giriniz : ");
                    int yeniSure = scanner.nextInt();

                    KitapGonderi_2433.kitapGonderiSuresiGuncelle(index
                    ,yeniSure);
                    break;

                case 5 :

                    for(GiyimGonderi_2433 giyim : GiyimGonderi_2433.list){
                        System.out.println(giyim.gonderiAdi + " --> " + giyim.detay);
                    }

                    Scanner scanner1 = new Scanner(System.in);
                    Scanner scanner2 = new Scanner(System.in);

                    System.out.println("ad giriniz : ");
                    String ad = scanner1.nextLine();

                    System.out.println("Detay giriniz : ");
                    String detay = scanner2.nextLine();

                    GiyimGonderi_2433.giyimGonderiDetayEkle(ad,detay);
                    break;

                case 6 :

                    for(OfisGonderi_2433 ofis : OfisGonderi_2433.list){
                        System.out.println(ofis.gonderiAdi + " --> " + ofis.kargoUcreti);
                    }

                    System.out.println("min ucreti giriniz : ");
                    double max = scanner.nextDouble();

                    System.out.println("max ucreti giriniz : ");
                    double min = scanner.nextDouble();

                    OfisGonderi_2433.ofisGonderileriniSil(max,min);
                    break;

                case 7 :

                    Scanner scanner3 = new Scanner(System.in);

                    System.out.println("ad giriniz : ");
                    String adi = scanner3.nextLine();
                    System.out.println("agirlik giriniz : ");
                    double agirlik = scanner3.nextDouble();
                    System.out.println("ucret giriniz : ");
                    double ucret = scanner3.nextDouble();
                    System.out.println("teslim suresi giriniz : ");
                    int teslimSuresi = scanner3.nextInt();

                    GidaGonderi_2433.gidaGonderisiEkle(adi,agirlik,ucret,teslimSuresi);
                    break;

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
                case 1 : ElektronikGonderi_2433.list.add(new ElektronikGonderi_2433(dizi[0],Integer.valueOf(dizi[1]),Double.valueOf(dizi[2]),Double.valueOf(dizi[3]),Integer.valueOf(dizi[4])));
                    break;
                case 2 : KitapGonderi_2433.list.add(new KitapGonderi_2433(dizi[0],Integer.valueOf(dizi[1]),Double.valueOf(dizi[2]),Double.valueOf(dizi[3]),Integer.valueOf(dizi[4])));
                    break;
                case 3 : GiyimGonderi_2433.list.add(new GiyimGonderi_2433(dizi[0],Integer.valueOf(dizi[1]),Double.valueOf(dizi[2]),Double.valueOf(dizi[3]),Integer.valueOf(dizi[4])));
                    break;
                case 4 : OfisGonderi_2433.list.add(new OfisGonderi_2433(dizi[0],Integer.valueOf(dizi[1]),Double.valueOf(dizi[2]),Double.valueOf(dizi[3]),Integer.valueOf(dizi[4])));;
                    break;
                case 5 : GidaGonderi_2433.list.add(new GidaGonderi_2433(dizi[0],Integer.valueOf(dizi[1]),Double.valueOf(dizi[2]),Double.valueOf(dizi[3]),Integer.valueOf(dizi[4])));
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
                    for(ElektronikGonderi_2433 elektronik : ElektronikGonderi_2433.list){
                        elektronik.kategoriAdi = dizi[1];
                        elektronik.detay = dizi[2];
                    }
                    break;
                case 2 :
                    for(KitapGonderi_2433 kitap : KitapGonderi_2433.list){
                        kitap.kategoriAdi = dizi[1];
                        kitap.detay = dizi[2];
                    }
                    break;
                case 3 :
                    for(GiyimGonderi_2433 giyim : GiyimGonderi_2433.list){
                        giyim.kategoriAdi = dizi[1];
                        giyim.detay = dizi[2];
                    }
                    break;
                case 4 :
                    for(OfisGonderi_2433 ofis : OfisGonderi_2433.list){
                        ofis.kategoriAdi = dizi[1];
                        ofis.detay = dizi[2];
                    }
                    break;
                case 5 :
                    for(GidaGonderi_2433 gida : GidaGonderi_2433.list){
                        gida.kategoriAdi = dizi[1];
                        gida.detay = dizi[2];
                    }
                    break;
            }
        }
    }
}
