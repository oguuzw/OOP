import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //CarpimTalosu();
        //asalBul(20);
        //continueOrnekYap();
        //basamakSayisiBul(44313);
        //System.out.println(mukemmelMisinNesin(28));
        //NadetMukemmelBul();
        //haftaGunuBul();
        //foreachOrnekYap();

    }

    static void carpimTalosu(){
        System.out.println("Carpım tablosu");

        for(int i =1 ; i <= 10 ; i++){
            System.out.println();

            for(int j = 1 ; j <= 10 ; j++){
                System.out.println(i * j);

            }
        }
    }

    static void asalBul(int sayi){
        boolean asalMi=true;

        for (int i = 2 ; i < sayi/2 ; i++){
            if (sayi % i == 0 ){
                asalMi = false;
                break;
            }else{
                asalMi = true;
            }
        }

        if(asalMi){
            System.out.println("asal");

        }else{
            System.out.println("asal degil.");
        }
    }

    static void continueOrnekYap(){
        int sayi = 100;
        for (int i = 0 ; i < sayi ; i++){
            if(i % 5 == 0){
                continue;
            }
            System.out.print(i + "\t");
        }
    }

    static void basamakSayisiBul(int sayi){
        int adet = 0;
        while(sayi > 0){
            sayi /= 10;
            adet++;
        }
        System.out.println("basamak sayisi : " + adet);
    }

    static boolean mukemmelMisinNesin(int sayi){
        // 6 = 1 + 2 + 3
        int toplam = 1;
        for (int i = 2 ; i < sayi ; i++){
            if(sayi % i == 0){
                toplam += i;
            }
        }

        if (toplam == sayi ){
            return true ;
        }else{
            return false;
        }
    }

    static void NadetMukemmelBul(){
        System.out.println("sayi yaz : ");
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int sayi=2;
        do{
            sayi++;
            boolean mukemmelMi = mukemmelMisinNesin(sayi);

            if (mukemmelMi){
                System.out.println(sayi);
                N--;
            }
        }while(N > 0);

    }

    static void haftaGunuBul(){
        int index = 5;
        switch(index){
            case 1 :
                System.out.println("pazartesi");
                break;
            case 2 :
                System.out.println("sali");
                break;
            case 3 :
                System.out.println("carsamba");
                break;
            case 4 :
                System.out.println("persembe");
                break;
            case 5 :
                System.out.println("cuma");
                break;
            case 6 :
                System.out.println("cumartesi");
                break;
            case 7 :
                System.out.println("pazar");
                break;
            default:
                System.out.println("---");
        }
    }


    static void foreachOrnekYap(){

        char adi[] = {'a','b','c','d'};
        String[] isimDizisi = {"van","trabzon","ankara","konya","istanbul"};

        for(String isim : isimDizisi) System.out.println(isim);

        System.out.println();

        for (int i=0 ; i<adi.length ; i++) System.out.println(adi[i]);

    }
}