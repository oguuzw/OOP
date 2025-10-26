import java.util.ArrayList;

public class Condiments extends Urun {

    public static ArrayList<Condiments> list = new ArrayList<>();

    public Condiments(String adi,int kategoriIndex,String birimAgirligi,double birimFiyati,int stokMiktari){
        super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
    }

    public void cesniBirimFiyatGuncelle(double yeniFiyat){
        this.birimFiyati = yeniFiyat;
    }
    
}
