import java.util.ArrayList;

public class Confections extends Urun{

    public static ArrayList<Confections> list = new ArrayList<>();


    public Confections(String adi,int kategoriIndex,String birimAgirligi,double birimFiyati,int stokMiktari){
        super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
        
    }

    public void sekerlemeDetaySil(){
        
    }
    
}
