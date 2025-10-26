public class Main {
    public static void main(String[] args) {

        //sekil daire dikdortgen sınıfları uret
        Sekil sekil = new Sekil("kirmizi");
        sekil.sekilCiz();


        System.out.println("---------------------------------------------");
        Daire daire = new Daire("siyah");
        daire.sekilCiz();
        daire.daireCiz();

        System.out.println("---------------------------------------------");
        Daire daire2 = new Daire("Beyaz");
        daire2.sekilCiz();

        System.out.println("---------------------------------------------");
        Dikdortgen dikdortgen = new Dikdortgen("sari",2,3);
        System.out.println("dikdortgen alan : " + dikdortgen.alanHesapla(0, 0));
        //System.out.println("dikdortgen cevre : " + dikdortgen.cevreHesapla(2, 3););

    }
}