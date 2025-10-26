import java.util.ArrayList;

public class DairyProducts extends Urun{

    public static ArrayList<DairyProducts> list = new ArrayList<>();

    public DairyProducts(String adi,int kategoriIndex,String birimAgirligi,double birimFiyati,int stokMiktari){
        super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
    }

    public void sutUrunuSil(){
        double toplam = 0;
        for(DairyProducts dairyProducts : list){
            toplam += dairyProducts.birimFiyati;
        }
        double ortalama = toplam / list.size();
        System.out.println("ortalama : " + ortalama);

        for(DairyProducts dairyProducts : list){
            if(dairyProducts.birimFiyati > ortalama){
                System.out.println(dairyProducts.adi + " silindi");
                list.remove(dairyProducts);
                break;
            }
        }

        System.out.println("----------- silindikten sonraki liste --------------");
        for(DairyProducts dairyProducts : list){
            System.out.println(dairyProducts.adi);
        }
    }
    
}
