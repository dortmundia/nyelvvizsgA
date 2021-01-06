package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Lista>nyelvek;

    public static void main(String[] args) {

        try {
            beolvasas();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("sikertelen beolvasás!");
            return;
        }
            //2.feladat
        int i = 0;
        int top1=0;
        int top1szam=0;
        int top2szam=0;
        int top3szam=0;
        int top2=0;
        int top3=0;
        while (i<nyelvek.size())
        {
            int asd = nyelvek.get(i).getSikeresEv1()+ nyelvek.get(i).getSikeresEv2()+nyelvek.get(i).getSikeresEv3()+nyelvek.get(i).getSikeresEv4()+nyelvek.get(i).getSikeresEv5()+nyelvek.get(i).getSikeresEv6()+nyelvek.get(i).getSikeresEv7()+nyelvek.get(i).getSikeresEv8()+nyelvek.get(i).getSikeresEv9()+nyelvek.get(i).getSikeresEv10()+nyelvek.get(i).getSikertelenEv1()+nyelvek.get(i).getSikertelenEv2()+nyelvek.get(i).getSikertelenEv3()+nyelvek.get(i).getSikertelenEv4()+nyelvek.get(i).getSikertelenEv5()+nyelvek.get(i).getSikertelenEv6()+nyelvek.get(i).getSikertelenEv7()+nyelvek.get(i).getSikertelenEv8()+nyelvek.get(i).getSikertelenEv9()+nyelvek.get(i).getSikertelenEv10();
            if(asd>top1) // (Feltételezheti, hogy nem alakult ki holtverseny.)
            {
                top3=top2;
                top3szam=top2szam;
                top2szam=top1szam;
                top2=top1;
                top1=asd;
                top1szam=i;

            }
            else if (asd>top2)
            {
                top3=top2;
                top3szam=top2szam;
                top2szam=i;
                top2=asd;
            }
            else if (asd>top3)
            {
                top3=asd;
                top3szam=i;
            }

            i++;
        }

        System.out.println("A legnépszerűbb nyelvek:");
        System.out.println(nyelvek.get(top1szam).getNyelv());
        System.out.println(nyelvek.get(top2szam).getNyelv());
        System.out.println(nyelvek.get(top3szam).getNyelv());
        //Elnézést hogycsak  ennyi sikerült de ki jöttem a gépelésből illetve a github utál engem...


    }

    private static void beolvasas() throws FileNotFoundException {

        nyelvek = new ArrayList<>();

        Scanner sc = new Scanner(new File("sikeres.csv"));
        Scanner sc2 = new Scanner(new File("sikertelen.csv"));

        sc.nextLine();
        sc2.nextLine();

        while (sc.hasNext())
        {
            String[] sor = sc.nextLine().split(";");
            String[] sor2 = sc2.nextLine().split(";");
            String nyelv = sor[0];
            int ev1 = Integer.parseInt(sor[1]);
            int ev2 = Integer.parseInt(sor[2]);
            int ev3 = Integer.parseInt(sor[3]);
            int ev4 = Integer.parseInt(sor[4]);
            int ev5 = Integer.parseInt(sor[5]);
            int ev6 = Integer.parseInt( sor[6]);
            int ev7 = Integer.parseInt(sor[7]);
            int ev8 = Integer.parseInt( sor[8]);
            int ev9 = Integer.parseInt(sor[9]);
            int ev10 =Integer.parseInt( sor[10]);

            int SikertelenEv1 =Integer.parseInt(sor2[1]);
            int SikertelenEv2=Integer.parseInt(sor2[2]);
            int SikertelenEv3=Integer.parseInt(sor2[3]);
            int SikertelenEv4=Integer.parseInt(sor2[4]);
            int SikertelenEv5=Integer.parseInt(sor2[5]);
            int SikertelenEv6=Integer.parseInt(sor2[6]);
            int SikertelenEv7=Integer.parseInt(sor2[7]);
            int SikertelenEv8=Integer.parseInt(sor2[8]);
            int SikertelenEv9=Integer.parseInt(sor2[9]);
            int SikertelenEv10=Integer.parseInt(sor2[10]);

            Lista adottnyelv = new Lista(nyelv,ev1,ev2,ev3,ev4,ev5,ev6,ev7,ev8,ev9,ev10,SikertelenEv1,SikertelenEv2,SikertelenEv3,SikertelenEv4,SikertelenEv5,SikertelenEv6,SikertelenEv7,SikertelenEv8,SikertelenEv9,SikertelenEv10);

            nyelvek.add(adottnyelv);
        }

        sc.close();
        sc2.close();

    }



}
