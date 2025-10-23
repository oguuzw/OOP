import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        //ucgenAlaniHesapla();
        //dorduncuSoru();
        //poligonAlani();
        //kacKezTekrarEdiyor();
        //palindrom();
        //palindromYap();
        //sayiSiralamaVeEkleme();
        //dokuzuncuSoru();
        //onuncuSoru();
        //onBirinciSoru();
        //onIkinciSoru();

    }

    /*  1. x,y şeklinde koordinatları verilen bir üçgenin alanını aşağıdaki denkleme göre hesaplayınız.
    Alan(ABC)=1/2 |x1.y2+x2.y3+x3.y1−(y1.x2+y2.x3+y3.x1)|  */
    static void ucgenAlaniHesapla(){

        double[][] arr = new double[3][2];
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 2 ; j++){
                System.out.print((i + 1) + ". kordinatın "  + (j + 1) + ".degerini giriniz.");
                arr[i][j] = scan.nextDouble();
            }
            System.out.println();
        }
        double alan = (1/2)*(arr[0][0]*arr[1][1] + arr[1][0]*arr[2][1] + arr[2][0]*arr[0][1]) - (arr[0][1]*arr[1][0] + arr[1][1]*arr[2][0] + arr[2][1]*arr[0][0]);
        if(alan < 0) alan = - alan;

        System.out.println("alan = " + alan);
    }

    /*4. 𝜋√𝑥∗𝑦>𝑥∗𝐿𝑜𝑔𝑦 eşitsizliğine uygun x, y > 10 olacak şekilde 10 adet x, y ikilisi bulunuz.*/
    static void dorduncuSoru(){
        int x = 11,y=11;
        double pi = 3.14;
        int sayac = 1 ;
        while(sayac <= 10){
            int xCarpiY = x * y;
            if(pi * Math.sqrt(xCarpiY) > x * Math.log(y)){
                System.out.println(sayac + ". "+ "x = " + x + " y = " + y);
                sayac++;
                y++;
            }
        }
    }

    /*5. Girilen bir metin içindeki her bir harfin kaç kez tekrar ettiğini bulunuz.*/
    static void kacKezTekrarEdiyor(){
        System.out.println("metin giriniz");
        String metin = scan.nextLine();

        ArrayList<Character> characterArrayList = new ArrayList<>();
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        for(int i = 0 ; i < metin.length() ; i++){
            characterArrayList.add(metin.charAt(i));
        }

        ArrayList<Boolean> sayildiMi = new ArrayList<>();
        for(int i = 0 ; i < characterArrayList.size() ; i++) sayildiMi.add(false);

        for(int i = 0 ; i < characterArrayList.size() ;i++){
            if(sayildiMi.get(i)) continue;
            integerArrayList.add(1);
            sayildiMi.set(i,true);
            for(int j = i + 1 ; j < characterArrayList.size() ; j++){
                if(characterArrayList.get(i) == characterArrayList.get(j)){
                    sayildiMi.set(j,true);
                    integerArrayList.set(i,(integerArrayList.get(i) + 1));
                }
            }
        }

        for (int i = 0; i < integerArrayList.size(); i++) {
            System.out.println(characterArrayList.get(i) + " --> " + integerArrayList.get(i));
        }
    }

    /*6. Bir metnin palindrom olup/olmadığını kontrol ediniz. Örnek: “adanada” kelimesi baştan ve sondan aynı şekilde okunur.*/
    static void palindrom(){
        System.out.println("metin giriniz");
        String metin = scan.nextLine();

        ArrayList<Character> characterArrayList = new ArrayList<>();
        for(int i = 0 ; i < metin.length() ; i++){
            characterArrayList.add(metin.charAt(i));
        }

        int bastan = 0, sondan = metin.length() - 1;
        while(bastan < sondan){
            if(characterArrayList.get(bastan) != characterArrayList.get(sondan)){
                System.out.println("palindrom degildir.");
                return;
            }
            bastan ++;
            sondan --;
        }
        System.out.println("palindromdur");
    }

    /*7. Palindrom olmayan bir kelimeyi palindrom yapınız. Örnek: “45abcxcba36_” 4 ve 5 sonda olmadığı için silinir. Baştan her silme işleminde sondan da silme gerçekleştiriniz. “abcxcba” elde ediniz.*/
    static void palindromYap(){
        System.out.println("metin giriniz");
        String metin = scan.nextLine();

        ArrayList<Character> characterArrayList = new ArrayList<>();

        for(int i = 0 ; i < metin.length() ; i++){
            characterArrayList.add(metin.charAt(i));
        }

        ArrayList<Integer> silinecekIndexler = new ArrayList<>();
        int bastan = 0;
        int sondan = metin.length() -1 ;
        while(bastan < sondan){
            if(characterArrayList.get(bastan) != characterArrayList.get(sondan)){
                silinecekIndexler.add(bastan);
                silinecekIndexler.add(sondan);
            }
            bastan++;
            sondan--;
        }
        System.out.println(silinecekIndexler);


        //buyukten kucuge sıralar
        for(int i = 0 ; i < silinecekIndexler.size() -1 ; i++){
            for (int j = 0 ; j < (silinecekIndexler.size()- 1 - i) ; j++){
                if(silinecekIndexler.get(j) < silinecekIndexler.get(j+1)){
                    int temp = silinecekIndexler.get(j);
                    silinecekIndexler.set(j,silinecekIndexler.get(j+1));
                    silinecekIndexler.set(j+1,temp);
                }
            }
        }
        System.out.println(silinecekIndexler);

        for(int silinecek : silinecekIndexler){
            characterArrayList.remove(silinecek);
        }

        System.out.println(characterArrayList);
    }

    /*8. 10 adet double sayıyı listeye ekleyiniz. Sayıları sıraladıktan sonra yeni gelen sayıyı sırayı bozmayacak şekilde ekleyiniz.*/
    static void sayiSiralamaVeEkleme() {
        ArrayList<Double> doubleArrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            doubleArrayList.add(random.nextDouble(10));
        }

        for (int i = 0; i < doubleArrayList.size() - 1; i++) {
            for (int j = 0; j < (doubleArrayList.size() - 1 - i); j++) {
                if (doubleArrayList.get(j) > doubleArrayList.get(j + 1)) {
                    double temp = doubleArrayList.get(j);
                    doubleArrayList.set(j, doubleArrayList.get(j + 1));
                    doubleArrayList.set(j + 1, temp);
                }
            }
        }

        System.out.println(doubleArrayList);

        System.out.println("double turunde yeni sayi ekleyiniz ");
        double sayi = scan.nextDouble();
        //basa ekleme
        if (sayi < doubleArrayList.get(0)) {
            doubleArrayList.add(0, sayi);
        } else if (sayi > doubleArrayList.get(doubleArrayList.size() - 1)) {  //sona ekleme
            doubleArrayList.add(sayi);
        } else {  //araya ekleme
            for (int i = 0; i < doubleArrayList.size() - 1; i++) {
                if (sayi > doubleArrayList.get(i) && sayi < doubleArrayList.get(i + 1)) {
                    doubleArrayList.add(i + 1, sayi);
                }
            }
        }
        System.out.println(doubleArrayList);
    }

    /*9. 10 tane isim giriniz. Oluşturduğunuz listede ‘a’ ile başlayıp “c” ile biten isimleri listeleyiniz.*/
    static void dokuzuncuSoru(){
        ArrayList<String> stringArrayList = new ArrayList<>();
        System.out.println("10 adet isism giriniz");
        for(int i = 0 ; i < 10; i++){
            stringArrayList.add(scan.nextLine());
        }

        for(String string : stringArrayList){
            if(string.charAt(0) == 'a' && string.charAt(string.length()-1) == 'c'){
                System.out.println(string + " ");
            }
        }
    }

    /*10. 10 adet isim içinden İsim bilgisinin orta karakteri ‘m’ olan isimleri gösteriniz. Örnek: cemal, sami (gösterilecek) vb. İsim Listesini ilk başta manuel oluşturunuz. “Ahmet”, “Ali”, “Veli” şeklinde.*/
    static void onuncuSoru(){
        ArrayList<String> stringArrayList = new ArrayList<>();

        System.out.println("listeye 10 tane isim ekleyiniz ");
        for(int i = 0 ; i < 1 ; i++){
            stringArrayList.add(scan.nextLine());
        }

        for(String isim : stringArrayList){
            if(isim.charAt((isim.length()/2)) == 'm'){
                System.out.print(isim + " ");
            }
        }
    }

    /*11. Girilen 10 adet stringden oluşan listede, içinde “yaz” geçen fakat ‘b’ içermeyen elemanları gösteriniz.*/
    static void onBirinciSoru(){
        ArrayList<String> stringArrayList = new ArrayList<>();
        System.out.println("10 adet string ifade giriniz ");
        for(int i = 0 ; i < 10 ; i++){
            stringArrayList.add(scan.nextLine());
        }

        for(String string : stringArrayList){
            if(string.contains("yaz") && !string.contains("b")){
                System.out.println(string + " ");
            }
        }

    }

    /*12. 10 adet ismi büyükten küçüğe sıralayınız. Sıralama işleminden sonra yeni gelen string ifadeyi sırayı bozmayacak şekilde ekleyiniz.*/
    static void onIkinciSoru() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        System.out.println("10 adet isim giriniz");

        for (int i = 0; i < 10; i++) {
            stringArrayList.add(scan.nextLine());
        }

        for(int i = 0 ; i < (stringArrayList.size() - 1) ; i ++){
            for(int j = 0 ; j < (stringArrayList.size() - 1 - i) ; j++){
                String string1 = stringArrayList.get(j);
                String string2 = stringArrayList.get(j+1);
                if(string1.compareTo(string2) < 0){
                    stringArrayList.set(j,string2);
                    stringArrayList.set(j+1,string1);
                }
            }
        }

        System.out.println(stringArrayList);
    }

}