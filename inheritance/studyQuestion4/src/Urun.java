public class Urun{
    public String adi;
    public int kategoriIndex;
    public String birimAgirligi;
    public double birimFiyati;
    public int stokMiktari;

    public Urun(String adi,int kategoriIndex,String birimAgirligi,double birimFiyati,int stokMiktari){
        this.adi = adi;
        this.kategoriIndex = kategoriIndex;
        this.birimAgirligi = birimAgirligi;
        this.birimFiyati = birimFiyati;
        this.stokMiktari = stokMiktari;
    }

    public void urunStokGuncelle(boolean satisMi,int adet){
        if(stokMiktari - adet < 0 ){
            System.out.println("yetersiz stok");
            return;
        } 
        
        System.out.println(adi + " eski stok miktari : " + stokMiktari);
        if(satisMi){
            stokMiktari -= adet;
        }else{
            stokMiktari += adet;
        }
        System.out.println(adi + " yeni stok miktari : " + stokMiktari);
    }

    public void urunAdiGuncelle(String yeniAdi){
        this.adi = yeniAdi;
    }
}