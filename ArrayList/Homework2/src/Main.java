import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        menu(arrayList);
    }

    public static void menu(ArrayList<Integer> arrayList){
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("-----------------------------------------");
            System.out.println("1: Sayı Listesi Oluştur");
            System.out.println("2. Sayıların Standart Sapmasını Hesapla");
            System.out.println("3. Tekrar Eden Sayilari Guncelle");
            System.out.println("4. Ortanca Degere Gore Sil");
            System.out.println("5. Ortalamadan Buyuk Sayıyı Listeye Ekle");
            System.out.println("6. Cıkış");
            System.out.println("-----------------------------------------");

            switch (scanner.nextInt()){
                case 1 : sayiListesiOlustur(arrayList);
                    break;
                case 2 : sayilarinStandartSapmasiniHesapla(arrayList);
                    break;
                case 3 : tekrarEdenSayilariGuncelle(arrayList);
                    break;
                case 4 : ortancaDegereGoreSil(arrayList);
                    break;
                case 5 : ortalamadanBuyukSayiyiListeyeEkle(arrayList);
                    break;
                case 6 :
                    return;
            }
        }
    }

    public static void yaz(ArrayList<Integer> arrayList){
        for(Integer sayi : arrayList) System.out.print(sayi + " ");
        System.out.println();
    }

    public static  void sayiListesiOlustur(ArrayList<Integer> arrayList){
        Random random = new Random();

        for(int i = 0 ; i < 20 ; i++){
            arrayList.add(random.nextInt(9) + 1);
        }

        yaz(arrayList);
    }

    public static void sayilarinStandartSapmasiniHesapla(ArrayList<Integer> arrayList){
        int toplam = 0;
        for(Integer sayi : arrayList){
            toplam += sayi;
        }
        double mu = toplam / arrayList.size();

        double varyans = 0;
        for(int i = 0 ; i < arrayList.size() ; i++){
            varyans += (arrayList.get(i) - mu)*(arrayList.get(i) - mu);
        }
        varyans /= arrayList.size();
        yaz(arrayList);
        System.out.println("sayıların standart sapması : " + Math.sqrt(varyans));
    }

    public static void tekrarEdenSayilariGuncelle(ArrayList<Integer> arrayList){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0 ; i < arrayList.size() ; i++){
            for(int j = 0 ; j < arrayList.size() ; j++){
                if(i == j) continue;
                if(arrayList.get(i) == arrayList.get(j)){
                    System.out.println(arrayList.get(i) + " sayisini guncellemek icin yeni bir deger giriniz");
                    arrayList.set(i,scanner.nextInt());
                    System.out.print("yeni liste --> ");
                    yaz(arrayList);
                    return;
                }
            }
        }
    }

    public static void ortancaDegereGoreSil(ArrayList<Integer> arrayList){
        for(int i = 0 ; i < arrayList.size() - 1 ; i++){
            for(int j = 0 ; j < (arrayList.size() - i - 1) ; j++){
                if(arrayList.get(j) > arrayList.get(j + 1)){
                    int temp = arrayList.get(j);
                    arrayList.set(j,arrayList.get(j+1));
                    arrayList.set(j+1,temp);
                }
            }
        }
        System.out.print("küçükten büyüğe sıralanmış liste ");
        yaz(arrayList);
        if(arrayList.size() % 2 == 0){
            arrayList.remove((arrayList.size() / 2 - 1));
            arrayList.remove(arrayList.size() / 2);
        }else{
            arrayList.remove(arrayList.size() / 2);
            arrayList.remove((arrayList.size() / 2 - 1));
        }
        yaz(arrayList);
    }

    public static void ortalamadanBuyukSayiyiListeyeEkle(ArrayList<Integer> arrayList){
        int toplam = 0;
        for(Integer sayi : arrayList){
            toplam += sayi;
        }
        int ortalama = toplam / arrayList.size();
        System.out.println( "ortalama : " + ortalama);

        Random random = new Random();
        arrayList.add(random.nextInt(10 - ortalama) + ortalama + 1);
        yaz(arrayList);
    }
}