package Paket2;

public class Gonderi_2433 {

    protected String gonderiAdi;
    protected int kategoriIndex;
    protected   double agirlik;
    protected double kargoUcreti;
    protected int teslimSuresi;

    public Gonderi_2433(String gonderiAdi, int kategoriIndex, double agirlik, double kargoUcreti, int teslimSuresi) {
        this.gonderiAdi = gonderiAdi;
        this.kategoriIndex = kategoriIndex;
        this.agirlik = agirlik;
        this.kargoUcreti = kargoUcreti;
        this.teslimSuresi = teslimSuresi;
    }

    protected static void teslimSuresineGoreKargoUcretiGuncelle(int sure, double guncelUcret){

        for(ElektronikGonderi_2433 elektronik : ElektronikGonderi_2433.getList()){
            if(elektronik.teslimSuresi > sure){
                double eskiUcret = elektronik.kargoUcreti;
                elektronik.kargoUcreti = guncelUcret * (1 + (elektronik.teslimSuresi - sure) / 10.0);

                System.out.println(elektronik.gonderiAdi + " --> teslimSuresi : " + elektronik.teslimSuresi + "\teski ucret : " + eskiUcret +"\tyeni ucret : " + elektronik.kargoUcreti);
            }
        }

        for(KitapGonderi_2433 kitap : KitapGonderi_2433.getList()){
            if(kitap.teslimSuresi > sure){
                kitap.kargoUcreti = guncelUcret * (1 + (kitap.teslimSuresi - sure) / 10.0);

                System.out.println(kitap.gonderiAdi + " --> teslimSuresi : " + kitap.teslimSuresi + "\tyeni ucret : " + kitap.kargoUcreti);
            }
        }

        for(GiyimGonderi_2433 giyim : GiyimGonderi_2433.getList()){
            if(giyim.teslimSuresi > sure){
                giyim.kargoUcreti = guncelUcret * (1 + (giyim.teslimSuresi - sure) / 10.0);

                System.out.println(giyim.gonderiAdi + " --> teslimSuresi : " + giyim.teslimSuresi + "\tyeni ucret : " + giyim.kargoUcreti);
            }
        }

        for(OfisGonderi_2433 ofis : OfisGonderi_2433.getList()){
            if(ofis.teslimSuresi > sure){
                ofis.kargoUcreti = guncelUcret * (1 + (ofis.teslimSuresi - sure) / 10.0);

                System.out.println(ofis.gonderiAdi + " --> teslimSuresi : " + ofis.teslimSuresi + "\tyeni ucret : " + ofis.kargoUcreti);
            }

        }

        for(GidaGonderi_2433 gida : GidaGonderi_2433.getList()){
            if(gida.teslimSuresi > sure){
                gida.kargoUcreti = guncelUcret * (1 + (gida.teslimSuresi - sure) / 10.0);

                System.out.println(gida.gonderiAdi + " --> teslimSuresi : " + gida.teslimSuresi + "\tyeni ucret : " + gida.kargoUcreti);
            }
        }
    }

    protected static void enHafifGonderiyeEkUcretUygula(double oran){
        double enHafif = Double.MAX_VALUE;
        int enHafifIndex = 0;
        int enHafifKategori = 0;

        for(int i = 0 ; i < ElektronikGonderi_2433.getList().size()  ; i++){
            if(ElektronikGonderi_2433.getList().get(i).agirlik < enHafif){
                enHafif = ElektronikGonderi_2433.getList().get(i).agirlik;
                enHafifIndex = i;
                enHafifKategori = 1;
            }
        }

        for(int i = 0 ; i < KitapGonderi_2433.getList().size() ; i++){
            if(KitapGonderi_2433.getList().get(i).agirlik < enHafif){
                enHafif = KitapGonderi_2433.getList().get(i).agirlik;
                enHafifIndex = i;
                enHafifKategori = 2;
            }
        }

        for(int i = 0 ; i < GiyimGonderi_2433.getList().size() ; i++){
            if(GiyimGonderi_2433.getList().get(i).agirlik < enHafif){
                enHafif = GiyimGonderi_2433.getList().get(i).agirlik;
                enHafifIndex = i;
                enHafifKategori = 3;
            }
        }

        for(int i = 0 ; i < OfisGonderi_2433.getList().size() ; i++){
            if(OfisGonderi_2433.getList().get(i).agirlik < enHafif){
                enHafif = OfisGonderi_2433.getList().get(i).agirlik;
                enHafifIndex = i;
                enHafifKategori = 4;
            }
        }

        for(int i = 0 ; i < GidaGonderi_2433.getList().size() ; i++){
            if(GidaGonderi_2433.getList().get(i).agirlik < enHafif){
                enHafif = GidaGonderi_2433.getList().get(i).agirlik;
                enHafifIndex = i;
                enHafifKategori = 5;
            }
        }

        double oranBirlik = (oran / 100) + 1;
        String enHafifAd = "";
        double oncekiKargoUcreti = 0;
        double sonrakiKargoUcreti = 0;

        switch (enHafifKategori){
            case 1 :
                oncekiKargoUcreti = ElektronikGonderi_2433.getList().get(enHafifIndex).kargoUcreti;
                ElektronikGonderi_2433.getList().get(enHafifIndex).kargoUcreti *= oranBirlik;
                sonrakiKargoUcreti = ElektronikGonderi_2433.getList().get(enHafifIndex).kargoUcreti;
                enHafifAd = ElektronikGonderi_2433.getList().get(enHafifIndex).gonderiAdi;
                break;

            case 2 :
                oncekiKargoUcreti = KitapGonderi_2433.getList().get(enHafifIndex).kargoUcreti;
                KitapGonderi_2433.getList().get(enHafifIndex).kargoUcreti *= oranBirlik;
                sonrakiKargoUcreti = KitapGonderi_2433.getList().get(enHafifIndex).kargoUcreti;
                enHafifAd = KitapGonderi_2433.getList().get(enHafifIndex).gonderiAdi;
                break;

            case 3 :
                oncekiKargoUcreti = GidaGonderi_2433.getList().get(enHafifIndex).kargoUcreti;
                GiyimGonderi_2433.getList().get(enHafifIndex).kargoUcreti *= oranBirlik;
                sonrakiKargoUcreti = GidaGonderi_2433.getList().get(enHafifIndex).kargoUcreti;
                enHafifAd = GidaGonderi_2433.getList().get(enHafifIndex).gonderiAdi;
                break;

            case 4 :
                oncekiKargoUcreti = OfisGonderi_2433.getList().get(enHafifIndex).kargoUcreti;
                OfisGonderi_2433.getList().get(enHafifIndex).kargoUcreti *= oranBirlik;
                sonrakiKargoUcreti = OfisGonderi_2433.getList().get(enHafifIndex).kargoUcreti;
                enHafifAd = OfisGonderi_2433.getList().get(enHafifIndex).gonderiAdi;
                break;

            case 5 :
                oncekiKargoUcreti = GidaGonderi_2433.getList().get(enHafifIndex).kargoUcreti;
                GidaGonderi_2433.getList().get(enHafifIndex).kargoUcreti *= oranBirlik;
                sonrakiKargoUcreti = GidaGonderi_2433.getList().get(enHafifIndex).kargoUcreti;
                enHafifAd = GidaGonderi_2433.getList().get(enHafifIndex).gonderiAdi;
                break;
        }

        System.out.println("en hafif gonderi : " + enHafifAd + "\tonceki ucreti : " + oncekiKargoUcreti + "\tyeni ucreti : " + sonrakiKargoUcreti);
    }

    public String getGonderiAdi() {
        return gonderiAdi;
    }

    public void setGonderiAdi(String gonderiAdi) {
        this.gonderiAdi = gonderiAdi;
    }

    public int getKategoriIndex() {
        return kategoriIndex;
    }

    public void setKategoriIndex(int kategoriIndex) {
        this.kategoriIndex = kategoriIndex;
    }

    public double getAgirlik() {
        return agirlik;
    }

    public void setAgirlik(double agirlik) {
        this.agirlik = agirlik;
    }

    public double getKargoUcreti() {
        return kargoUcreti;
    }

    public void setKargoUcreti(double kargoUcreti) {
        this.kargoUcreti = kargoUcreti;
    }

    public int getTeslimSuresi() {
        return teslimSuresi;
    }

    public void setTeslimSuresi(int teslimSuresi) {
        this.teslimSuresi = teslimSuresi;
    }
}
