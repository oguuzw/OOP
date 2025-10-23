import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Ogrenci> arrayList = new ArrayList();
        soruBir(arrayList);
        soruIki(arrayList);
        soruUc(arrayList);
        soruDort(arrayList);
        soruBes(arrayList);
        soruAlti(arrayList);
        soruYedi(arrayList,true,10);
        soruSekiz(arrayList,241229033,"oğuz",81,90);
        soruDokuz(arrayList,241229001,"yeniEleman",100,100);
        soruOn(arrayList);
    }

    /*1. Öğrenci numarası, Adı, Vize ve Final notu verilen txt dosyasındaki tüm kayıtları Ogrenci sınıfı kullanarak listeyi oluşturunuz/gösteriniz.*/
    public static void soruBir(ArrayList<Ogrenci> arrayList) throws IOException {
        FileReader fileReader = new FileReader("ogrenciler.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String satir ;
        while((satir = bufferedReader.readLine()) != null ){
            String dizi[] = satir.split(" ");
            Ogrenci yeniOgrenci = new Ogrenci();

            yeniOgrenci.ogrenciNumarasi = Integer.valueOf(dizi[0]);
            yeniOgrenci.adi = dizi[1];
            yeniOgrenci.vizeNotu = Integer.valueOf(dizi[2]);
            yeniOgrenci.finalNotu = Integer.valueOf(dizi[3]);

            arrayList.add(yeniOgrenci);
        }

        for(Ogrenci liste : arrayList) {
            System.out.println(liste.ogrenciNumarasi + " " + liste.adi + " " + liste.vizeNotu + " " + liste.finalNotu);
        }
    }

    /*2. Ortalama bilgisini sınıf özelliğine dahil ederek, ortalama sonuçları gösteriniz. Ort= Vize*0.4+Final*0.6 */
    public static void soruIki(ArrayList<Ogrenci> arrayList){
        for(Ogrenci ogrenci : arrayList){
            ogrenci.ortalama = ogrenci.vizeNotu * 0.4 + ogrenci.finalNotu * 0.6;
        }

        System.out.println("----------ORTALAMALAR----------");
        for(Ogrenci ogrenci : arrayList){
            System.out.println(ogrenci.adi + " --> " + ogrenci.ortalama);
        }
        System.out.println("-------------------------------");
    }

    /*3. Sınıfın ortalamasından büyük/küçük olma durumuna göre iki grubu ayrı ayrı gösteriniz*/
    public static void soruUc(ArrayList<Ogrenci> arrayList){
        double toplam = 0;
        for(Ogrenci ogrenci : arrayList){
            toplam += ogrenci.ortalama;
        }
        double sinifOrtalamasi = toplam / arrayList.size() ;

        System.out.println("sınıf ortalamasi : " + sinifOrtalamasi);

        System.out.println("----- Ortalamadan kucuk olanlar -----");
        for(Ogrenci ogrenci : arrayList){
            if(ogrenci.ortalama < sinifOrtalamasi){
                System.out.println(ogrenci.adi + " -->  ortalamasi : " + ogrenci.ortalama);
            }
        }

        System.out.println("----- Ortalamadan buyuk olanlar -----");
        for(Ogrenci ogrenci : arrayList){
            if(ogrenci.ortalama >= sinifOrtalamasi){
                System.out.println(ogrenci.adi + " -->  ortalamasi " + ogrenci.ortalama);
            }
        }
    }

    /*4. Geçme notu 50 olan bir sistemde dersten geçenleri ve kalanları ayrı ayrı gösteriniz. Gectimi değişkenini kullanınız.*/
    public static void soruDort(ArrayList<Ogrenci> arrayList){
        System.out.println("----- Gecenler -----");
        for(Ogrenci ogrenci : arrayList){
            if(ogrenci.ortalama >= 50){
                System.out.println(ogrenci.adi + " --> " + ogrenci.ortalama);
            }
        }

        System.out.println("----- Kalanlar -----");
        for(Ogrenci ogrenci : arrayList){
            if(ogrenci.ortalama < 50){
                System.out.println(ogrenci.adi + " --> " + ogrenci.ortalama);
            }
        }
    }

    /*5. Harf notlarını (HarfNotu) hesaplayınız/gösteriniz. 0-40:FF, 40-49:DD, 50-69:CC, 70-79:BB, 80-100: AA olarak hesaplanacaktır.*/
    public static void soruBes(ArrayList<Ogrenci> arrayList){
        System.out.println("---------- Harf Notu ----------");
        for(Ogrenci ogrenci : arrayList){
            String harfNotu = "";
            if(ogrenci.ortalama <= 40){
                harfNotu = "FF";
            }else if(ogrenci.ortalama > 40 && ogrenci.ortalama <= 50){
                harfNotu = "DD";
            }else if(ogrenci.ortalama > 50 && ogrenci.ortalama <= 69){
                harfNotu = "CC";
            }else if(ogrenci.ortalama >= 70 && ogrenci.ortalama <= 79){
                harfNotu = "BB";
            }else if(ogrenci.ortalama >= 80 && ogrenci.ortalama <= 100){
                harfNotu = "AA";
            }
            System.out.println(ogrenci.adi + " -- > " + harfNotu);
        }
    }

    /*6. Tek/Çift numaralı öğrencileri gösteriniz. TekCiftGoster(boolean Tekmi)*/
    public static void soruAlti(ArrayList<Ogrenci> arrayList){
        boolean tekCift = false;
        System.out.println("------------- Tek mi Çift mi ---------------");

        for(Ogrenci ogrenci : arrayList){
            if(ogrenci.ogrenciNumarasi % 2 == 0){
                tekCift = false;
            }else {
                tekCift = true ;
            }
            System.out.println(ogrenci.adi + " --> " + (tekCift ? "tek" : "çift"));
        }
    }

    /*7. En düşük ortalamaya sahip olan öğrencinin vize veya finaline %x kadar puan ekleyin/gösteriniz. PuanEkle(boolean VizeMi, int x )*/
    public static void soruYedi(ArrayList<Ogrenci> arrayList,boolean vizeMi , int x){
        System.out.println("-----------------------------------");
        double enDusukOrtalama = 0;
        int enDusukKisiIndex = 0;

        for(int i = 0 ; i < arrayList.size() ; i++){
            Ogrenci ogrenci = arrayList.get(i);
            if(ogrenci.ortalama < enDusukOrtalama || i == 0){
                enDusukOrtalama = ogrenci.ortalama;
                enDusukKisiIndex = i;
            }
        }

        double yuzdelikSayi = x;
        yuzdelikSayi += 100;
        yuzdelikSayi /= 100;
        for(int i = 0 ; i < arrayList.size() ; i++){
            Ogrenci ogrenci = arrayList.get(i);
            if(i == enDusukKisiIndex){
                System.out.println("ortalaması en dusuk olan kisi " + ogrenci.adi + " --> " + ogrenci.ortalama + " vize : " + ogrenci.vizeNotu + " final : " + ogrenci.finalNotu);
                if(vizeMi){
                    ogrenci.vizeNotu *= yuzdelikSayi;
                    System.out.println(" yeni vize notu " + ogrenci.vizeNotu);

                }else{
                    ogrenci.finalNotu *= yuzdelikSayi;
                    System.out.println(" yeni final notu " + ogrenci.finalNotu);
                }
            }
        }
    }

    /*8. Öğrencileri Ort değerine göre sıralayınız. Yeni öğrenciyi sırayı bozmayacak şekilde ekleyiniz.*/
    public static void soruSekiz(ArrayList<Ogrenci> arrayList,int ogrenciNumara,String adi ,int vizeNotu , int finalNotu){
        Ogrenci yeniogrenci = new Ogrenci();
        yeniogrenci.ogrenciNumarasi = ogrenciNumara;
        yeniogrenci.adi = adi;
        yeniogrenci.vizeNotu = vizeNotu;
        yeniogrenci.finalNotu = finalNotu;
        yeniogrenci.ortalama = vizeNotu * 0.4 + finalNotu * 0.6;
        arrayList.add(yeniogrenci);

        for(int i = 0 ; i < arrayList.size() - 1 ; i++){
            for(int j = 0 ; j < (arrayList.size() - i - 1) ; j++){
                Ogrenci ogrenci1 = arrayList.get(j);
                Ogrenci ogrenci2 = arrayList.get(j+1);
                if(ogrenci1.ortalama < ogrenci2.ortalama){
                    Ogrenci tempOgrenci = ogrenci1;
                    arrayList.set(j,arrayList.get(j+1));
                    arrayList.set(j+1,tempOgrenci);
                }
            }
        }

        System.out.println("ortalamaya gore siralanmis liste");
        for(Ogrenci ogrenci : arrayList){
            System.out.println(ogrenci.adi + " --> " + ogrenci.ortalama);
        }
    }

    /*9. Öğrenci numarasına göre sıralı şekilde yeni bir öğrenciyi ekleyiniz.*/
    public static void soruDokuz(ArrayList<Ogrenci> arrayList,int ogrenciNumara,String adi ,int vizeNotu , int finalNotu){
        System.out.println("------------ SORU DOKUZ ------------------");

        Ogrenci yeniogrenci = new Ogrenci();
        yeniogrenci.ogrenciNumarasi = ogrenciNumara;
        yeniogrenci.adi = adi;
        yeniogrenci.vizeNotu = vizeNotu;
        yeniogrenci.finalNotu = finalNotu;
        yeniogrenci.ortalama = vizeNotu * 0.4 + finalNotu * 0.6;
        arrayList.add(yeniogrenci);

        //kucukten buyuge siralandi(bubble sort algoritmasiyla siralandi)
        for(int i = 0 ; i < arrayList.size() - 1 ; i++){
            for(int j = 0 ; j < (arrayList.size() - i - 1) ; j++){
                Ogrenci ogrenci1 = arrayList.get(j);
                Ogrenci ogrenci2 = arrayList.get(j+1);
                if(ogrenci1.ogrenciNumarasi > ogrenci2.ogrenciNumarasi){
                    Ogrenci tempOgrenci = ogrenci1;
                    arrayList.set(j,arrayList.get(j+1));
                    arrayList.set(j+1,tempOgrenci);
                }
            }
        }

        System.out.println("numaralara gore siralanmis liste");
        for(Ogrenci ogrenci : arrayList){
            System.out.println(ogrenci.adi + " --> " + ogrenci.ogrenciNumarasi);
        }
    }

    /*10. Ort değerine göre Tek ve çift en başarılı öğrencilerin yerlerini değiştiriniz (swap yapınız).*/
    public static void soruOn(ArrayList<Ogrenci> arrayList){
        System.out.println("--------------- SORU ON ------------------");
        double tekEnBasariliOrtalamasi = 0;
        int tekEnBasariliIndex = 0;
        double ciftEnBasariliOrtalamasi = 0;
        int ciftEnBasariliIndex = 0;

        for(int i = 0 ; i < arrayList.size() ; i++){
            Ogrenci ogrenci = arrayList.get(i);
            if(ogrenci.ogrenciNumarasi % 2 == 0 && (ogrenci.ortalama > ciftEnBasariliOrtalamasi)){
                ciftEnBasariliOrtalamasi = ogrenci.ortalama;
                ciftEnBasariliIndex = i ;
            }else if (ogrenci.ortalama > tekEnBasariliOrtalamasi){
                tekEnBasariliOrtalamasi = ogrenci.ortalama ;
                tekEnBasariliIndex = i ;
            }
        }

        for(Ogrenci ogrenci : arrayList){
            System.out.println(ogrenci.adi + " " + ogrenci.ogrenciNumarasi + " " + ogrenci.ortalama);
        }
        System.out.println();
        System.out.println("Tek index : " + tekEnBasariliIndex  + " Tek ortalama " + tekEnBasariliOrtalamasi);
        System.out.println("Cift index : " + ciftEnBasariliIndex  + " Cift ortalama " + ciftEnBasariliOrtalamasi);

        System.out.println("-------------swap sonrasi liste--------------");
        Ogrenci tekTemp = arrayList.get(tekEnBasariliIndex);
        arrayList.set(tekEnBasariliIndex,arrayList.get(ciftEnBasariliIndex));
        arrayList.set(ciftEnBasariliIndex,tekTemp);
        for(Ogrenci ogrenci : arrayList){
            System.out.println(ogrenci.adi + " " + ogrenci.ogrenciNumarasi + " " + ogrenci.ortalama);
        }
    }
}
