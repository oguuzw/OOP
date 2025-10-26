import java.util.ArrayList;

public class Cereals extends Urun{

    public static ArrayList<Cereals> list = new ArrayList<>();

    public Cereals(String adi,int kategoriIndex,String birimAgirligi,double birimFiyati,int stokMiktari){
        super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
    }

    public void tahilMinStokEkle(int miktar){
        int minStok = 0;
        int minStokIndex = 0;
        for(int i = 0 ; i < list.size() ; i++){
            if(i == 0){
                minStok = list.get(i).stokMiktari;
                minStokIndex = i;
            }else if(list.get(i).stokMiktari < minStok){
                minStok = list.get(i).stokMiktari;
                minStokIndex = i;
            }
        }

        list.get(minStokIndex).stokMiktari += miktar;
    }

}