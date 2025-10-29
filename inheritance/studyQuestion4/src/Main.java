import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException{
        listeleriOlustur("C:\\Users\\oguuz\\OneDrive\\Desktop\\OOP\\inheritance\\studyQuestion4\\src\\urunler4.txt");
        /*
        Beverages.list.get(2).urunStokGuncelle(true,20);
        System.out.println(Beverages.list.get(0).adi);
        Beverages.list.get(0).urunAdiGuncelle("kahve");
        System.out.println(Beverages.list.get(0).adi);
        */

        /*
        Beverages beverages = new Beverages(null, 0, null, 0, 0) ;
        beverages.icecekUrunuEkle("cay","10 gr",10,20);
        System.out.println("---------");
        for(Beverages beverages2 : beverages.list){
            System.out.println(beverages2.adi);
        }
        

        /* 
        System.out.println("---------");
        for(Condiments condiments : Condiments.list){
            System.out.println(condiments.adi + " --> " + condiments.birimFiyati);
        }
        System.out.println("---------");
        Condiments.list.get(1).cesniBirimFiyatGuncelle(12);
        for(Condiments condiments : Condiments.list){
            System.out.println(condiments.adi + " --> " + condiments.birimFiyati);
        }
        */

        //DairyProducts.list.get(0).sutUrunuSil();

        /* 
        System.out.println("-------------------------");
        for(Cereals cereals : Cereals.list){
            System.out.println(cereals.adi + " --> " + cereals.stokMiktari);
        }
        Cereals.list.get(0).tahilMinStokEkle(10);
        System.out.println("-------------------------");
        for(Cereals cereals : Cereals.list){
            System.out.println(cereals.adi + " --> " + cereals.stokMiktari);
        }
        System.out.println("-------------------------");
        */

            }


    public static void listeleriOlustur(String dosyaAdi) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(dosyaAdi));
        String satir;
        boolean ilkMi = true;

        while((satir = bufferedReader.readLine()) != null){
            if(ilkMi){
                ilkMi = false;
                continue;
            }

            String dizi[] = satir.split("\t");
            
            switch(Integer.valueOf(dizi[1])){
                case 1 : Beverages.list.add(new Beverages(dizi[0], Integer.valueOf(dizi[1]), dizi[2], Double.valueOf(dizi[3]), Integer.valueOf(dizi[4])));
                    break;
                case 2 : Condiments.list.add(new Condiments(dizi[0], Integer.valueOf(dizi[1]), dizi[2], Double.valueOf(dizi[3]), Integer.valueOf(dizi[4])));
                    break;
                case 3 : Confections.list.add(new Confections(dizi[0], Integer.valueOf(dizi[1]), dizi[2], Double.valueOf(dizi[3]), Integer.valueOf(dizi[4])));
                    break;
                case 4 : DairyProducts.list.add(new DairyProducts(dizi[0], Integer.valueOf(dizi[1]), dizi[2], Double.valueOf(dizi[3]), Integer.valueOf(dizi[4])));
                    break;
                case 5 : Cereals.list.add(new Cereals(dizi[0], Integer.valueOf(dizi[1]), dizi[2], Double.valueOf(dizi[3]), Integer.valueOf(dizi[4])));
                    break;
                default : System.out.println("boyle bir kategori index degeri yoktur");
            }
        }
    }
}
