import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static int fark = 0;
    static int enYakinIlkSayi;
    static int enYakinIkinciSayi;


    public static void main(String[] args) {

        while(true){
            switch(menu()){
                case 1 : System.out.println(bolenlerToplaminiHesapla(284));
                    break;
                case 2 : arkadasSayilariBul(3);
                    break;
                case 3 : enYakinSayiCiftiVeBolenleriGoster();
                    break;
                case -1 :
                    System.out.print("çıkış yapılıyor.");
                    return;
                default : System.out.println("gecersiz deger.");
                    break;
            }
        }
    }

    static int menu(){
        System.out.println("\n----MENÜ----");
        System.out.println("1 : İşlem a) bölenler toplamı");
        System.out.println("2 : İşlem b) arkadaş sayı çiftleri");
        System.out.println("3 : İşlem c) birbirine en yakın sayı çifti");
        System.out.println("-1 : Çıkış");
        System.out.println("------------");
        Scanner scan = new Scanner(System.in);
        int secim = scan.nextInt();
        return secim;
    }

    static int bolenlerToplaminiHesapla(int n){
        int bolenlerToplami = 0;
        for(int i = 1 ; i < n ; i++){
            if(n % i == 0){
                bolenlerToplami += i;
            }
        }
        return bolenlerToplami;
    }

    static void arkadasSayilariBul(int N){
        if(N <= 2 ) {
            System.out.println("N sayisi ikiden buyuk olmali");
            return;
        }

        int nBasamakliEnKucukSayi = 1;
        int nBasamakliEnBuyukSayi = 9;

        for(int i = 1 ; i < N ; i++){
            nBasamakliEnKucukSayi *= 10;
            nBasamakliEnBuyukSayi *= 10;
            nBasamakliEnBuyukSayi += 9;
        }

        int tempFark = 0;
        for(int i = nBasamakliEnKucukSayi ; i <= nBasamakliEnBuyukSayi ; i++){
            for(int j = i + 1 ; j <= nBasamakliEnBuyukSayi ; j++){
                if(bolenlerToplaminiHesapla(i) == j && bolenlerToplaminiHesapla(j) == i){
                    System.out.println(i + " - " + j);
                    tempFark = j - i;
                    if(tempFark < fark || fark == 0){
                        fark = tempFark;
                        enYakinIlkSayi = i;
                        enYakinIkinciSayi = j;
                    }
                }
            }
        }

    }

    static void enYakinSayiCiftiVeBolenleriGoster(){
        System.out.println(enYakinIlkSayi + " - " + enYakinIkinciSayi);

        System.out.print(enYakinIlkSayi + " sayısının bolenleri = ");
        for(int i = 1 ; i < enYakinIlkSayi ; i++){
            if(enYakinIlkSayi % i == 0){
                System.out.print(i + " ");
            }
        }

        System.out.println();
        System.out.print(enYakinIkinciSayi + " sayısının bolenleri = ");
        for(int i = 1 ; i < enYakinIkinciSayi ; i++){
            if(enYakinIkinciSayi % i == 0){
                System.out.print(i + " ");
            }
        }
    }
}
