import java.util.List;

public class YapiMalzemesi extends Malzeme{

    public YapiMalzemesi(String adi,int kategoriIndex,double birimAgirlik,double birimFiyat,int stokMiktari){
        super(adi, kategoriIndex, birimAgirlik, birimFiyat, stokMiktari);
    }

    public void enPahaliStokGuncelle(List<YapiMalzemesi> liste, int yeniStok){

        double enPahaliFiyat = 0;
        int enPahaliIndex = 0;
        for(int i = 0 ; i < liste.size() ; i++){
            if(i == 0){
                enPahaliFiyat = liste.get(i).birimFiyat;
                enPahaliIndex = i;
            }else if(liste.get(i).birimFiyat > enPahaliFiyat){
                enPahaliFiyat = liste.get(i).birimFiyat;
                enPahaliIndex = i;
            }
        }

        
        liste.get(enPahaliIndex).stokMiktari = yeniStok;
        System.out.println(liste.get(enPahaliIndex).adi + "'nin stok miktari : " + liste.get(enPahaliIndex).stokMiktari + " olarak guncellenmistir.");
        
    }

    
}
