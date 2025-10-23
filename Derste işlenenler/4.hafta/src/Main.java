import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        /*
        Scanner giris = new Scanner(System.in);
        int sonuc = giris.nextInt();
        double doubleSayi = giris.nextDouble();
        System.out.println("str gir");
        String str = giris.nextLine();
        System.out.println(sonuc);
        System.out.println(doubleSayi);
        System.out.println(str);
        */

        genericOrnekler();
        //nonGenericOrnekler();
        //stringOrnekListe();
        //math();

    }

    static void genericOrnekler(){
        ArrayList listem = new ArrayList<>();

        ArrayList<Integer> integerArrayList = new ArrayList<>();
        ArrayList<Double> doubleArrayList = new ArrayList<>();
        ArrayList<Boolean> booleanArrayList = new ArrayList<>();
        ArrayList<Character> characterArrayList = new ArrayList<>();

        listem.add("ali");
        listem.add(44);
        listem.add(1.1234567);
        listem.add(1.1234567f);
        listem.add('A');

        for(Object object : listem){
            System.out.println(object);
        }

        System.out.println();

        int[] intDizi1 = new int[] {1,2,3};
        int[] intDizi2 = new int[4];

        for(int i  = 0 ; i < intDizi1.length ; i++){
            System.out.println(intDizi1[i] + "\t");
        }

        System.out.println();

        for(int i  = 0 ; i < intDizi2.length ; i++){
            System.out.println(intDizi2[i] + "\t");
        }
    }

    static void nonGenericOrnekler(){
        ArrayList<Integer> intList = new ArrayList<Integer>();

        //ekleme
        Scanner tarayici = new Scanner(System.in);
        System.out.println("deger giriniz : ");
        for (int i = 0 ; i < 5 ; i++){
            intList.add(tarayici.nextInt());
        }
        intList.add(6);

        System.out.println("eklendi");

        for(Integer sayi : intList){
            System.out.print(sayi + "\t");

        }

        //silme
        intList.remove(0); //dizideki ilk elemanı sil(index)
        System.out.println();
        for(Integer sayi : intList){
            System.out.print(sayi + "\t");
        }
        System.out.println("ilk eleman silindi");

        System.out.println();
        intList.remove(intList.size() - 1 ); //son elemanı sil
        for(Integer sayi : intList){
            System.out.print(sayi + "\t");
        }
        System.out.println("son eleman silindi");

        System.out.println();
        Object object = 4; //bu degerli elemanı sil(4)
        intList.remove(object);
        for(Integer sayi : intList){
            System.out.print(sayi + "\t");
        }

        //guncelleme

        int guncellenecekSayi = 1;

        for(int i = 0 ; i < intList.size() ; i++){
            if(intList.get(i) == guncellenecekSayi){
                intList.set(i,777777777);
            }
        }
        for(Integer sayi : intList){
            System.out.print(sayi + "\t");
        }

        ArrayList<Integer> cloneList = new ArrayList<>();
        cloneList = (ArrayList<Integer>) intList.clone();
        cloneList.set(0,-666666);
        System.out.println("\nklon ");
        for(Integer sayi : cloneList){
            System.out.print(sayi + "\t");
        }
    }

    static void stringOrnekListe(){
        ArrayList<String> listem = new ArrayList<>();
        listem.add("ankara");
        listem.add("istanbul");
        listem.add("konya");

        String str = "hello ";
        String str2 = "world";
        String concatStr = str.concat(" ").concat(str2);


        String strCompare = "ABC";
        String strCompare2 = "abc" ;
        int sonuc = strCompare.compareTo(strCompare2);  //hangisi once gelir diye karsılastırır  str - str2
        System.out.println(sonuc);


        for(String sehir : listem){
            System.out.println(sehir + "length() : " + sehir.length());
            System.out.println(sehir + " index of() : " + sehir.indexOf("an"));  //an nerede baslıyor
            System.out.println(sehir + " char At() : " + sehir.charAt(0));  //indexteki karakter ne ?
            System.out.println(sehir + " " + sehir.toLowerCase());
            System.out.println();
        }
    }

    static void math(){
        Random random = new Random();
        ArrayList<Double> doubleList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            doubleList.add(-1 + 2 * random.nextDouble());
        }

        double doubleSayi = 123.23;
        for(Double sayi : doubleList){
            System.out.print(sayi + " \t");
            System.out.println("Math.abs(sayi) = " + Math.abs(sayi));
            System.out.println("Math.ceil(sayi) = " + Math.ceil(sayi));
            System.out.println("Math.round(sayi) = " + Math.round(sayi));

        }
    }
}