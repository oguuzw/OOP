public class Main {
    public static void main(String[] args) {
        //fibHesapla(5);
        //ikilikTabanaCevir(13);
        //onlukTabanaCevir(1111,1,0);
        //enBuyukUcuncuAsal(24);
        //asalCarpanlar(150);
        //harshadSayilar(13);
        //fermatSayi(2);
        //oruntu(5);
        kapkear(1234);
    }

    /*1. Döngü kullanarak bir fibonacci fonksiyonu (Fib_Hesapla(int sira)) yazınız ve istenilen sıradaki elemanı ekrana yazdırınız.*/
    static void fibHesapla(int sira) {
        int a = 1 , b =1 , temp = 0;
        int sayac = 1;
        for(int i = 0 ; i < sira ;i ++) {
            temp = a + b;
            sayac++;
            if(sayac == sira) {
                System.out.println(sira + ". sayi = " + temp);
            }
            a = b;
            b = temp;
        }
    }

    /*2.a) ikilik tabanda sayıyı gösteriniz.*/
    static void ikilikTabanaCevir(int sayi) {
        if(sayi < 1) return;
        ikilikTabanaCevir(sayi/2);
        System.out.print(sayi % 2);
    }

    /*2.b) ikilik tabanda yazılan sayıyı 10luk tabana ceviriniz.*/
    static void onlukTabanaCevir(int sayi,int ikilik,int toplam) {
        while(true) {
            if(sayi < 1) {
                System.out.print(toplam);
                break;
            }
            int binary = sayi % 2;
            if(binary == 1) {
                toplam += ikilik;
            }
            ikilik *= 2;
            sayi /= 10;
        }
    }

    /*3. Bir sayı serisi için serinin ilk elemanı, eleman sayısı ve artış miktarına göre serinin sonucunu hesaplayınız.*/
    static int seri(int ilkEleman,int elemanSayisi,int artisMiktari) {
        int sonTerim = ilkEleman + (elemanSayisi - 1) * artisMiktari;
        return (elemanSayisi /2) * (ilkEleman + sonTerim);
    }

    /*4. Girilen sayıdan küçük en büyük 3. Asal sayıyı bulunuz*/
    static void enBuyukUcuncuAsal(int sayi) {
        int sayac = 0;
        while(true) {
            boolean asalMi = true;
            sayi --;
            for(int i=2 ; i<=(sayi/2) ; i++) {
                if(sayi % i == 0) {
                    asalMi = false;
                    break;
                }
            }

            if(asalMi) {
                sayac++;
            }
            if(sayac == 3) {
                System.out.print(sayi);
                break;
            }
        }
    }

    /*6. Girilen sayının asal çarpanlarını bir kez olmak üzere yazdırıp kaç tane olduğu olduğunu bulunuz.*/
    static void asalCarpanlar (int sayi){
        int sayac = 0;
        for(int i = 2 ; i <= (sayi / 2) ; i ++){
            boolean asalMi = true;
            for(int j = 2 ; j <= (i / 2) ; j++){
                if(i % j == 0){
                    asalMi = false;
                    break;
                }
            }
            if(asalMi){
                if (sayi % i == 0) {
                    System.out.print(i + " ");
                    sayac ++;
                }
            }
        }
        System.out.print("\nsonuc : " + sayac);
    }

    /*7. Belirli bir tabanda rakamları toplamına tam bölünen sayılara Harshad sayısı denir. Girilen sayının Harshad sayı olup olmadığını bulunuz.*/
    static void harshadSayilar(int sayi){
        int rakamlarToplami = 0;
        int sayiTemp = sayi;
        while(sayiTemp >= 1){
            rakamlarToplami += (sayiTemp % 10);
            sayiTemp /= 10;
        }
        if((sayi % rakamlarToplami) == 0){
            System.out.print("harshad sayidir.");
        }else{
            System.out.print("harshad sayi degildir.");
        }
    }

    /*8. n pozitif sayı olmak üzere, Fn= 2 + 1 biçiminde ifade edilebilen sayılara Fermat sayısı denir. n. sıradaki Fermat Sayıyı bulan fonksiyonu yazınız.*/
    static void fermatSayi(int n){
        int F = 1 , us = 1 ;
        for(int j = 0 ; j < n ; j++){
            us *= 2 ;
        }
        for(int i = 1 ; i <= us ; i++){
            F *= 2;
        }

        F++;
        System.out.print("F(" + n + ") = " + F);
    }

    /*10. Aşağıdaki gibi sonuç üretiniz*/
    //1
    //2 3
    //4 5 6
    static void oruntu(int satirSayisi){
        int sayilar = 1;
        for(int i = 1 ; i <= satirSayisi ; i++){
            for(int j = 1 ; j <= i ; j++){
                System.out.print(sayilar++ + " ");
            }
            System.out.println();
        }
    }

    /*9. 6174 Sayısı: Kaprekar sabiti olarak da bilinen sayının özelliği, aşağıdaki adımları takip ettiğimizde en fazla 7 adımda 6174 sayısını elde etmemizdir. Kaprekar sabitini bulan fonksiyonu yazınız. Fonksiyonu 4 basamaklı sayılarla test ediniz.*/
    static void kapkear(int sayi){
        if((sayi / 1000 ) < 1 || (sayi / 1000) > 10){
            System.out.println("yanlıs giris lutfen tekrar calistirip 4 basamaklı bir sayi giriniz.");
            return;
        }

        while(true){
            int[] basamak = new int[4];
            int tempSayi = sayi;
            for(int i=0 ; i < 4 ; i++){
                basamak[i] = tempSayi % 10 ;
                tempSayi /= 10;
            }

            /*1. Tüm rakamları aynı olmayan (4444 gibi) herhangi bir dört basamaklı sayı alınır.*/
            for(int i = 0 ; i < 4 ; i++){
                for(int j = i+1 ; j < 4 ; j ++)
                    if(basamak[i] == basamak[j]){
                        System.out.println("tum rakamlar aynı olamaz.");
                        return;
                    }
            }

            /*2. Sayının rakamları büyükten küçüğe ve küçükten büyüğe sıralanarak iki yeni dört basamaklı sayı elde edilir.*/

            int[] buyuk = basamak;
            int[] kucuk = basamak;

            if(buyuktenKucuge(buyuk) - kucuktenBuyuge(kucuk) == sayi){
                System.out.print("sonuc = " + sayi);
                break;
            }else{
                sayi = buyuktenKucuge(buyuk) - kucuktenBuyuge(kucuk);
            }
        }

    }

    static int buyuktenKucuge(int buyuk[]){
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < (3 - i) ; j++){
                if(buyuk[j] < buyuk[j+1]){
                    int tempBuyuk = buyuk[j];
                    buyuk[j] = buyuk[j+1];
                    buyuk[j+1] = tempBuyuk;
                }
            }
        }

        int basamakBuyuk = 1;
        int buyukSayi = 0 ;
        for(int i = 3 ; i >= 0 ; i--){
            buyukSayi += buyuk[i]*basamakBuyuk;
            basamakBuyuk *= 10;
        }
        return buyukSayi;
    }

    static int kucuktenBuyuge(int kucuk[]){
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < (3 - i) ; j++){
                if(kucuk[j] > kucuk[j+1]){
                    int tempKucuk = kucuk[j];
                    kucuk[j] = kucuk[j+1];
                    kucuk[j+1] = tempKucuk;
                }
            }
        }

        int basamakKucuk = 1;
        int kucukSayi = 0 ;
        for(int i = 3 ; i >= 0 ; i--){
            kucukSayi += kucuk[i]*basamakKucuk;
            basamakKucuk *= 10;
        }

        return kucukSayi;
    }

}
