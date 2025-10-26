import java.util.ArrayList;

public class Beverages extends Urun {

    public static ArrayList<Beverages> list = new ArrayList<>();

    public Beverages(String adi,int kategoriIndex,String birimAgirligi,double birimFiyati,int stokMiktari){
        super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
    }

    public void icecekUrunuEkle(String adi,String birimAgirligi,double birimFiyati,int stokMiktari){
        list.add(new Beverages(adi, 1, birimAgirligi, birimFiyati, stokMiktari));
        for (Beverages beverages : list) {
            System.out.println(beverages.adi);
        }
    }
    
}
