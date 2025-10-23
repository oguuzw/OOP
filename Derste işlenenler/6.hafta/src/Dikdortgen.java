public class Dikdortgen extends Sekil {
    int kenar1 ;
    int kenar2 ;
    public Dikdortgen(String renk,int a , int b){
        super(renk);
        kenar1 = a;
        kenar2 = b;
    }

    public double alanHesapla(int kenar1 , int kenar2){
        this.alan = kenar1 * kenar2;
        return this.alan ;
    }

    public void cevreHesapla(int kenar1 , int kenar2 ){
        this.cevre = 2 * (kenar1 + kenar2);
    }
}
