import java.util.List;

public class InsaatMalzemesi extends Malzeme{

    public InsaatMalzemesi(String adi,int kategoriIndex,double birimAgirlik,double birimFiyat,int stokMiktari){
        super(adi, kategoriIndex, birimAgirlik, birimFiyat, stokMiktari);
    }

    public void EnPahaliOlaniSil(List<InsaatMalzemesi> liste){

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

        System.out.println(liste.get(enPahaliIndex).adi + " silinmistir");
        liste.remove(enPahaliIndex);
    }
    
}
