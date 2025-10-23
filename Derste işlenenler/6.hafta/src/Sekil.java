public class Sekil {
    public double alan;
    public double cevre;
    public String renk;

    //kurucu metot
    public Sekil(String renk){
        this.renk = renk;
        System.out.println("Sekil kurucu metott caliti");
    }


    public void sekilCiz(){
        System.out.println("Renk : " + this.renk + " " + this.getClass() + "sekil.sekilCiz()");
    }
}