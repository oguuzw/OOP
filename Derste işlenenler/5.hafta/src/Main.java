import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException{
        ArrayList<Musteri> musteriArrayList = new ArrayList<>();

        musteriListeOlustur();
    }


    /*
    public static void listeyiSirala(ArrayList<Musteri> musteriList){
        Collection.sort(musteriList, new Comparator() {
            public int compare(Object object1, Object object2){
                return ((musteri) object1).adi.compareTo(musteri)
                        compareTo(())
            }
        }
    }
    */

    public static void musteriBulveAktifYap(ArrayList<Musteri> musteriList){
        Scanner scanner = new Scanner(System.in);
        String adi = scanner.nextLine();
        String soyadi = scanner.nextLine();

        for(Musteri musteri : musteriList){
            if(musteri.adi.equals(adi) && musteri.soyadi.equals(soyadi)){
                musteri.aktifMi = true;
                musteri.faturaMiktari = 1000000;
                //tekMusteriYaz(musteri);
                break;
            }
        }
    }

    public static void puanGuncelle(ArrayList<Musteri> musteriList){
        for(Musteri musteri : musteriList){
            if(musteri.puan < 50 ){
                musteri.puan *= 1.25;
            }
        }
    }

    public  static void aktifMusterileriGoster(ArrayList<Musteri> musteriList){
        for(Musteri musteri : musteriList){
            if(musteri.aktifMi ){

            }
        }
    }

    /*
    public static void maxFatura(ArrayList<Musteri> musteriList){
        Musteri enYuksek = new Musteri();

        for(Musteri musteri : musteriList){
            if(musteri.faturaMiktari ){

            }
        }
    }

    public static void tekMusteriYaz(Musteri musteri){

    }
    */
    public static void listeyiYazdir(ArrayList<Musteri> musteriArrayList){
        for(Musteri musteri : musteriArrayList){
            System.out.println(musteri.adi + " \n" + musteri.soyadi + " \n" + musteri.faturaMiktari + " \n");

        }
    }

    public static void musteriListeOlustur()  throws IOException {
        FileReader fileReader = new FileReader("Musteri.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        System.out.print(bufferedReader.readLine());

        ArrayList<Musteri> musteriArrayList = new ArrayList<>();

        String musteriInfo = bufferedReader.readLine();



        while(musteriInfo != null){
            System.out.println(musteriInfo);
            musteriInfo = bufferedReader.readLine();

            String dizi[] = musteriInfo.split(" ");
            Musteri yeniMusteri = new Musteri();

            yeniMusteri.adi = dizi[0];
            yeniMusteri.soyadi = dizi[1];
            yeniMusteri.puan = Integer.valueOf(dizi[2]);
            yeniMusteri.faturaMiktari = Double.valueOf(dizi[3]);
            yeniMusteri.aktifMi = dizi[4].equals("E");
            yeniMusteri.sehir = dizi[5];

            musteriArrayList.add(yeniMusteri);
            yeniMusteri = null;

        }
        return;
    }
}