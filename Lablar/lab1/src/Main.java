import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int boslukSayisi = 0;
        for(int i = n ; i >= 0 ;i--) {
            for(int k = 0 ; k < boslukSayisi ; k++) {
                System.out.print(" ");
            }
            for(int j = 1 ; j <= (2 * i  - 1 ) ; j++) {
                System.out.print("*");
            }
            System.out.println();
            boslukSayisi++;
        }
    }

}
