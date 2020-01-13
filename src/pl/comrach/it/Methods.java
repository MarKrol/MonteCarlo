package pl.comrach.it;

import java.util.Locale;
import java.util.Random;

public class Methods {

    private final int size=100;
    private final int n1step=15;
    private final int n2step=100;
    private final int n3step=1000;

    private int[] tab = new int[this.size];

    private boolean tabIsEmpty(){
        boolean isempty = true;
        for(int i: tab){
            if (i!=0){
                isempty = false;
                break;
            }else{
                isempty = true;
            }
        }
        return isempty;
    }

    //Metoda losująca liczbę
    private int randomLiczba(){
        return new Random().nextInt(1001);
    }

    //Metoda losująca element tablicy
    private int randomElementTab(){
        return new Random().nextInt(tab.length);
    }

    //Metoda wypełniająca losowymi liczbami tabelę
    private void insertTabRandomValue(){
        for(int i=0; i<tab.length; i++){
            tab[i] = randomLiczba();
        }
    }

    public void setInsertTabValue(){
        insertTabRandomValue();
    }

    //Metoda licząca śrenią algebraiczną elementów w tablicy
    private double sredniaElementowTab(){
        double srednia = 0;
        for(int temp: tab){
            srednia = srednia + (double) temp;
        }
        return (double) srednia/this.size;
    }

    private void showAverage(){
        System.out.print("\nŚrednia watość elementów tablicy to: "+ sredniaElementowTab()+"\n");
    }


    //Metoda zwracająca najmnieszą wartość w tablicy
    private int minLiczba(){
        int minliczba = tab[0];
        for (int i=1; i<tab.length; i++){
            if (minliczba > tab[i]){
                minliczba = tab[i];
            }
        }
        return minliczba;
    }

    private void showMinValue(){
        System.out.print("\nMinimalna watość w tablicy to: "+ minLiczba()+"\n");
    }

    //Metoda zwracająca min wartość w tablicy metodą Monte Carlo od ilości losowań
    private int returnMinValueMonteCarlo(int nstep){
        int minValueMonteCarlo = tab[randomElementTab()];
        while((nstep - 1) > 0){
            int value = tab[randomElementTab()];
            if ( value < minValueMonteCarlo){
                minValueMonteCarlo = value;
            }
            nstep--;
        }
        return minValueMonteCarlo;
    }

    private void showMinValueMonteCarlo(){

        System.out.print("\nMinimalna watość w tablicy dla "+n1step+" losowych powtórzeń to: "
                +returnMinValueMonteCarlo(n1step) +"\n");
        System.out.print("\nMinimalna watość w tablicy dla "+n2step+" losowych powtórzeń to: "
                + returnMinValueMonteCarlo(n2step)+"\n");
        System.out.print("\nMinimalna watość w tablicy dla "+n3step+" losowych powtórzeń to: "
                + returnMinValueMonteCarlo(n3step)+"\n");


    }

    //Metoda zwracająca średnią metodą MonteCarlo od ilości losowań
    private double returnAverageMonteCarlo(int nstep){
        int repeat = nstep;
        int average = 0;
        while(nstep > 0){
            average = average+tab[randomElementTab()];
            nstep--;
        }

        return (double) average/repeat;
    }

     private void showAverageMonteCarlo(){
         double averageMC = returnAverageMonteCarlo(n1step);

         System.out.format(Locale.US,"\nŚrednia wartość elementów tablicy dla %d losowych powtórzeń to: %.2f" +
                 "\t\t\t(Skuteczność: %d",n1step, averageMC, probabilitySuccess(averageMC));
         System.out.print("%)\n");

         averageMC = returnAverageMonteCarlo(n2step);
         System.out.format(Locale.US,"\nŚrednia wartość elementów tablicy dla %d losowych powtórzeń to: %.2f" +
                 "\t\t\t(Skuteczność: %d",n2step, averageMC, probabilitySuccess(averageMC));
         System.out.print("%)\n");

         averageMC = returnAverageMonteCarlo(n3step);
         System.out.format(Locale.US,"\nŚrednia wartość elementów tablicy dla %d losowych powtórzeń to: %.2f" +
                 "\t\t(Skuteczność: %d",n3step, averageMC, probabilitySuccess(averageMC));
         System.out.print("%)\n");
    }

    private int probabilitySuccess(double averageMC){
        return (int) ((Math.abs(sredniaElementowTab()-(Math.abs(sredniaElementowTab()-averageMC)))/sredniaElementowTab())*100);
    }

    //Metoda wypisująca tablicę
    public void showTab(){
        for (int i: tab){
            System.out.print(i+", ");
        }
    }

    public void showMin(){
        if (!tabIsEmpty()) {
            showMinValue();
            showMinValueMonteCarlo();
        } else {
            System.out.println("\nTablica pusta. Wybierz opcję 1 !!!");
        }
    }

    public void showAverageMain(){
        if (!tabIsEmpty()) {
            showAverage();
            showAverageMonteCarlo();
        } else {
            System.out.println("\nTablica pusta. Wybierz opcję 1 !!!");
        }
    }
}
