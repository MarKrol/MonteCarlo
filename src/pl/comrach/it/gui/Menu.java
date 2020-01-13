package pl.comrach.it.gui;

import pl.comrach.it.Methods;

import java.util.Scanner;

public class Menu {

    private Methods methods = new Methods();

    private void printMenu(){
        System.out.println("\n------------------ MENU -----------------------");
        System.out.println("1. Losuj liczby do 100 elementowej.");
        System.out.println("2. Pokaż najmniejszy wylosowany element z tablicy.");
        System.out.println("3. Pokaż średnia z wylosowanych elementów tablicy.");
        System.out.println("4. Wyjście z programu.");
        System.out.println("-----------------------------------------------\n");
        System.out.print("Wybrano opcję: ");
    }

    private void Menu(){
        printMenu();
        switch(new Scanner(System.in).nextLine()){
            case "1":
                methods.setInsertTabValue();
                System.out.println("\nWylosowano liczby: ");
                methods.showTab();
                System.out.println();
                break;
            case "2":
                methods.showMin();
                break;
            case "3":
                methods.showAverageMain();
                break;
            case "4":
                System.exit(0);
                break;
            default:
                System.out.println("\nWprowadzono niepoprawną opcję MENU!!! Spróbuj jeszcze raz!!!");
                break;
        }
        Menu();
    }

    public void showMenu(){
        Menu();
    }
}
