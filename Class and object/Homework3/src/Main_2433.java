import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main_2433 {
    public static void main(String[] args) throws Exception {
        menu();
    }

    public static void menu() throws IOException{

        Scanner scanner = new Scanner(System.in);
        ArrayList<Gonderi_2433> arrayList = null;
        while(true){
            System.out.println("-------------------------------------------------");
            System.out.println("1: Liste Olustur Goster");
            System.out.println("2. Uzun Teslimli Kargolari Sil");
            System.out.println("3. Kategori Bazli Say");
            System.out.println("4. Agirlik Bazli En Pahali Kargolari Araca Yukle ");
            System.out.println("5. Kargo Ucretlerini Guncelle");
            System.out.println("6. Cikis");
            System.out.println("-------------------------------------------------");

            switch(scanner.nextInt()){
                case 1 :
                    arrayList = listeOlusturGoster();
                    break;
                case 2 :
                    if(arrayList == null){
                        System.out.println("liste bos lutfen once 1 secenegi ile listeyi olusturun");
                    }else{
                        uzunTeslimliKargolariSil(arrayList);
                    }
                    break;
                case 3 :
                    if(arrayList == null){
                        System.out.println("liste bos lutfen once 1 secenegi ile listeyi olusturun");
                    }else{
                        kategoriBazliSay(arrayList);
                    }
                    break;
                case 4 :
                    if(arrayList == null){
                        System.out.println("liste bos lutfen once 1 secenegi ile listeyi olusturun");
                    }else{
                        agirlikBazliEnPahaliKargolariAracaYukle(arrayList);
                    }
                    break;
                case 5 :
                    if(arrayList == null){
                        System.out.println("liste bos lutfen once 1 secenegi ile listeyi olusturun");
                    }else{
                        kargoUcretleriniGuncelle(arrayList);
                    }
                    break;
                case 6 :
                    return;
            }
        }
    }


    public static ArrayList<Gonderi_2433> listeOlusturGoster() throws IOException{
        ArrayList<Gonderi_2433> arrayList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Kargo.txt"));

        String satir;
        boolean ilkSatirMi = true;
        while((satir = bufferedReader.readLine()) != null){
            if(ilkSatirMi){
                ilkSatirMi = false ;
                continue;
            }
            String dizi[] = satir.split("\t");
            if(dizi.length < 5) continue;
            Gonderi_2433 yeniGonderi = new Gonderi_2433();

            yeniGonderi.gonderiAdi = dizi[0];
            yeniGonderi.kategoriIndex = Integer.valueOf(dizi[1]);
            yeniGonderi.agirlik = Double.valueOf(dizi[2]);
            yeniGonderi.kargoUcreti = Double.valueOf(dizi[3]);
            yeniGonderi.teslimSuresi = Integer.valueOf(dizi[4]);

            arrayList.add(yeniGonderi);
        }
        listeyiYaz(arrayList);
        return arrayList;
    }

    public static void uzunTeslimliKargolariSil(ArrayList<Gonderi_2433> arrayList){
        ArrayList<Integer> silinecekIndexler = new ArrayList<>();
        for(int i = 0 ; i < arrayList.size() ; i++){
            if(arrayList.get(i).teslimSuresi == 5){
                silinecekIndexler.add(i);
            }
        }

        for(int i = arrayList.size() -1 ; i >= 0 ; i--){
            for(int j = 0 ; j < silinecekIndexler.size() ; j++){
                if(i == silinecekIndexler.get(j)){
                    arrayList.remove(i);
                }
            }
        }
        System.out.println("------- Teslim suresi 5 gun olanlar silindi -------");
        listeyiYaz(arrayList);
    }

    public static void listeyiYaz(ArrayList<Gonderi_2433> arrayList){
        System.out.println("|Gonderi Adi| |Kategori Index| |Agirlik| |Kargo Ucreti| |Teslim Suresi(gun)|");
        for(Gonderi_2433 gonderi : arrayList){
            System.out.println(gonderi.gonderiAdi + "\t" + gonderi.kategoriIndex + "\t" + gonderi.agirlik + "\t" + gonderi.kargoUcreti + "\t" + gonderi.teslimSuresi);
        }
    }

    public static void kategoriBazliSay(ArrayList<Gonderi_2433> arrayList){
        ArrayList<Integer> adetSayaci = new ArrayList<>();

        int maxIndex = 0;
        for(Gonderi_2433 gonderi : arrayList){
            if(gonderi.kategoriIndex > maxIndex){
                maxIndex = gonderi.kategoriIndex;
            }
        }

        for(int i = 0 ; i < maxIndex ; i++){
            adetSayaci.add(0);
        }

        for(int i = 0 ; i < arrayList.size() ;i++){
            adetSayaci.set(arrayList.get(i).kategoriIndex - 1,adetSayaci.get(arrayList.get(i).kategoriIndex - 1) + 1);
        }

        System.out.println("KategoriIndex   ---   Adet");
        for(int i = 0 ; i < maxIndex ; i++){
            System.out.println("\t" + (i+1) + "\t\t" +adetSayaci.get(i));
        }
    }

    public static void kargoUcretleriniGuncelle(ArrayList<Gonderi_2433> arrayList){
        double toplam = 0;
        for(Gonderi_2433 gonderi : arrayList){
            toplam += gonderi.kargoUcreti;
        }
        double ortalama = toplam / arrayList.size();

        int ortalamayaEnYakinIndexSoldan = 0;
        double enAzFarkSol = 0;
        boolean ilkMiSol = true;
        for(int i = 0 ; i < arrayList.size() ; i++){
            double fark = arrayList.get(i).kargoUcreti - ortalama ;
            if(ilkMiSol && fark <= 0){
                enAzFarkSol = fark;
                ilkMiSol = false;
            }
            if(fark <= 0 && enAzFarkSol < fark){
                enAzFarkSol = fark;
                ortalamayaEnYakinIndexSoldan = i;
            }
        }

        int ortalamayaEnYakinIndexSagdan = 0;
        double enAzFarkSag = 0;
        boolean ilkMiSag = true;
        for(int i = 0 ; i < arrayList.size() ; i++){
            double fark = arrayList.get(i).kargoUcreti - ortalama ;
            if(ilkMiSag && fark >= 0){
                enAzFarkSag = fark;
                ilkMiSag = false;
            }
            if(fark >= 0 && fark < enAzFarkSag){
                enAzFarkSag = fark;
                ortalamayaEnYakinIndexSagdan = i;
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("indirim miktarini giriniz ");
        double x = scanner.nextDouble();

        double indiriMiktariOndalik = x / 100;
        double yeniFiyatSol = arrayList.get(ortalamayaEnYakinIndexSoldan).kargoUcreti * indiriMiktariOndalik;
        double yeniFiyatSag = arrayList.get(ortalamayaEnYakinIndexSagdan).kargoUcreti * indiriMiktariOndalik;

        arrayList.get(ortalamayaEnYakinIndexSoldan).kargoUcreti = yeniFiyatSol;
        arrayList.get(ortalamayaEnYakinIndexSagdan).kargoUcreti = yeniFiyatSag;

        System.out.println((ortalamayaEnYakinIndexSoldan + 1) + ". ve " + (ortalamayaEnYakinIndexSagdan + 1) + ". satirlari guncellenmis liste ");
        listeyiYaz(arrayList);
    }

    public static void agirlikBazliEnPahaliKargolariAracaYukle(ArrayList<Gonderi_2433> arrayList){
        for(Gonderi_2433 gonderi : arrayList){
            gonderi.oncelikDegeri = gonderi.kargoUcreti / gonderi.agirlik;
        }

        for(int i = 0 ; i < arrayList.size() - 1 ; i++){
            for(int j = 0 ; j < arrayList.size() - i - 1 ; j++){
                if(arrayList.get(j).oncelikDegeri < arrayList.get(j+1).oncelikDegeri){
                    Gonderi_2433 temp = arrayList.get(j);
                    arrayList.set(j,arrayList.get(j+1));
                    arrayList.set(j+1,temp);
                }
            }
        }

        System.out.println("kargo listesi olusturmak icin X kg degeri giriniz ");
        System.out.print("X : ");
        Scanner scanner = new Scanner(System.in);
        double X = scanner.nextDouble();

        ArrayList<Gonderi_2433> kargoListesi = new ArrayList<>();

        double kgSayac = 0;
        for(Gonderi_2433 gonderi : arrayList){
            if(kgSayac < X ){
                kgSayac += gonderi.agirlik;
                if(kgSayac > X){
                    kgSayac -= gonderi.agirlik;
                    continue;
                }else{
                    kargoListesi.add(gonderi);
                }

            }
        }

        System.out.println("\n\n|Kargo Adi|\t|kategoriIndex|\t|teslim suresi|");
        for(Gonderi_2433 kargo : kargoListesi){
            System.out.println(kargo.gonderiAdi + "\t\t" + kargo.kategoriIndex + "\t\t" + kargo.teslimSuresi);
        }

        System.out.println("kargo listesi toplam agirligi : " + kgSayac);
    }

}