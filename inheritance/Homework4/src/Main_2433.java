import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_2433 {
    public static void main(String args[])throws IOException{
        listeleriOlustur("KargoOdev4.txt");
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
        ArrayList<ElektronikGonderi_2433> elektronikList = new ArrayList<>();

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
                case 1 : elektronikList.add(new ElektronikGonderi_2433(dizi[0],Integer.valueOf(dizi[1]),dizi[2],Double.valueOf(dizi[3]),Integer.valueOf(dizi[4])));
                    break;
            }
        }
    }
}
