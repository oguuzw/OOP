package Paket2;

import Paket1.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        VerileriDosyadanOkuma.listeleriOlustur("C:\\Users\\oguuz\\OneDrive\\Desktop\\OOP\\Access Modifiers\\homework5\\Kargo.txt");
        VerileriDosyadanOkuma.kargoGrubuEkle("C:\\Users\\oguuz\\OneDrive\\Desktop\\OOP\\Access Modifiers\\homework5\\KargoGrubu.txt");
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

                    System.out.println("agirlik miktari giriniz : ");
                    ElektronikGonderi_2433.elektronikGonderiAgirlikGuncelle(scanner.nextDouble());
                    break;

                case 4 :

                    for(KitapGonderi_2433 kitap : KitapGonderi_2433.getList()){
                        System.out.println(kitap.getGonderiAdi() + " -->\tteslim suresi : " + kitap.getTeslimSuresi());
                    }

                    System.out.println("index degeri giriniz : ");
                    int index = scanner.nextInt();
                    System.out.println("yeni sure degeri giriniz : ");
                    int yeniSure = scanner.nextInt();

                    KitapGonderi_2433.kitapGonderiSuresiGuncelle(index
                            ,yeniSure);
                    break;

                case 5 :

                    for(GiyimGonderi_2433 giyim : GiyimGonderi_2433.getList()){
                        System.out.println(giyim.getGonderiAdi() + " --> " + giyim.getDetay());
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

                    for(OfisGonderi_2433 ofis : OfisGonderi_2433.getList()){
                        System.out.println(ofis.getGonderiAdi() + " --> " + ofis.getKargoUcreti());
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
}
