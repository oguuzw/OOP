// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package lab2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main_2433 {
    public Main_2433() {
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> dersler = new ArrayList();
        ArrayList<Integer> notlar = new ArrayList();

        int toplam;
        for(toplam = 0; toplam < 5; ++toplam) {
            System.out.println("Ders adı giriniz: ");
            dersler.add(scan.nextLine());
        }

        for(toplam = 0; toplam < 5; ++toplam) {
            System.out.println("Ders notu giriniz: ");
            notlar.add(scan.nextInt());
        }

        toplam = 0;

        Integer not;
        for(Iterator var6 = notlar.iterator(); var6.hasNext(); toplam += not) {
            not = (Integer)var6.next();
        }

        double ortalama = (double)(toplam / 5);
        System.out.println("Ortalamanın üzerinde olan dersler ");

        int enYuksekNot;
        for(enYuksekNot = 0; enYuksekNot < 5; ++enYuksekNot) {
            if ((double)(Integer)notlar.get(enYuksekNot) > ortalama) {
                System.out.println(((String)dersler.get(enYuksekNot)).toUpperCase());
            }
        }

        enYuksekNot = 0;

        int enDusukNot;
        for(enDusukNot = 0; enDusukNot < 5; ++enDusukNot) {
            if (enDusukNot == 0 || (Integer)notlar.get(enDusukNot) > enYuksekNot) {
                enYuksekNot = (Integer)notlar.get(enDusukNot);
            }
        }

        System.out.println("En yüksek Not : " + enYuksekNot);
        enDusukNot = 0;

        for(int i = 0; i < 5; ++i) {
            if (i == 0 || (Integer)notlar.get(i) < enDusukNot) {
                enDusukNot = (Integer)notlar.get(i);
            }
        }

        System.out.print("En yüksek Not : " + enDusukNot);
    }
}
