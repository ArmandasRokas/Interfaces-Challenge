package com.rokas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// The importance of the Saveable interface, that only object which could be saved has the Saveable interface
// in order to standardize write/read methods, so it could be used in other methods in Main class
// without any restrictions
public class Main {

    public static void main(String[] args) {

        Monster monster = new Monster("snake", 99);
        System.out.println(monster);
        loadObject(monster);
        saveObject(monster);

        Saveable player = new Player("Hero", 99);
        System.out.println(((Player) player).getName()); // Casting Saveable object to play in order to use .getName() method
        System.out.println(player);
        loadObject(player);
        System.out.println(player);
        saveObject(player);


    }

    public static void saveObject(Saveable saveable){ // we can use any object that using Saveble interace
        // automatically cast for parameters in the methods
        // Method in main. Alle som har ssaveables interface, må meget gerne bruge denne method fordi
        // jeg ved at de har den rigtige struktur
        List<String> values = saveable.write();
        for(int i = 0; i<values.size(); i++){
            System.out.print(values.get(i) + " ");
        }
    }
    public static void loadObject(Saveable saveable){
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        saveable.read(values);
    }
}
