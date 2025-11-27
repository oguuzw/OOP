package Paket2;

public class Urun {
    protected String adi;
    protected int kategoriIndex;
    protected String birimAgirlik;
    protected double birimFiyat;
    protected int stokMiktari;

    public Urun(String adi,int kategoriIndex,String birimAgirlik,double birimFiyat,int stokMiktari){
        this.adi = adi;
        this.kategoriIndex = kategoriIndex;
        this.birimAgirlik = birimAgirlik;
        this.birimFiyat = birimFiyat;
        this.stokMiktari = stokMiktari;
    }

    protected void urunStokGuncelle(String urunAdi,boolean satisMi,int adet){

    }
}
