package com.tutorial;

import java.util.*;

public class EncryptionProgram {

    private Scanner scanner;
    private Random random;
    private ArrayList<Character> list;
    private ArrayList<Character> shuffledList;
    private char character;
    private char[] letters;

    EncryptionProgram(){
        scanner = new Scanner(System.in);
        random = new Random();
        list = new ArrayList<>();
        shuffledList = new ArrayList<>();
        character = ' ';

        newKey();
        askQuestions();
    }

    private void askQuestions(){
        while (true){
            System.out.println("*************************************************");
            System.out.println("What do you want to do?");
            System.out.println("(E)ncrypt, (N)ewkey, (G)etkey, (D)ecrypt, (Q)uit");
            char respons = Character.toUpperCase(scanner.nextLine().charAt(0));

            switch (respons){
                case 'E' -> encrypt();
                case 'N' -> newKey();
                case 'G' -> getKey();
                case 'D' -> decrypt();
                case 'Q' -> quit();
                default -> System.out.println("Invalid a input :(");
            }
        }

    }

    private void newKey(){
        character = ' ';
        list.clear();
        shuffledList.clear();

        for (int i=32; i<127; i++){
            list.add(Character.valueOf(character));
            character++;
        }

        shuffledList = new ArrayList<>(list);
        Collections.shuffle(shuffledList);
        System.out.println("*A new key has been generated*");
    }

    private void getKey(){
        System.out.println("Keys: ");
        for (Character list : list) {
            System.out.print(list);
        }
        System.out.println();
        for (Character shuffle : shuffledList) {
            System.out.print(shuffle);
        }
        System.out.println();
    }

    private void encrypt(){
        System.out.print("Enter a message to be encrypt: ");
        String message = scanner.nextLine();

        letters = message.toCharArray();

        for (int i=0; i<letters.length; i++){
            for (int j=0; j<list.size(); j++ ){
                if (letters[i]== list.get(j)){
                    letters[i]= shuffledList.get(j);
                    break;
                }
            }
        }

        System.out.println("Encrypted..");
        for (char letter : letters) {
            System.out.print(letter);
        }
        System.out.println();
    }

    private void decrypt(){
        System.out.print("Enter a message to be Decrypt: ");
        String message = scanner.nextLine();

        letters = message.toCharArray();

        for (int i=0; i<letters.length; i++){
            for (int j=0; j<shuffledList.size(); j++ ){
                if (letters[i]== shuffledList.get(j)){
                    letters[i]= list.get(j);
                    break;
                }
            }
        }

        System.out.println("Decrypted..");
        for (char letter : letters) {
            System.out.print(letter);
        }
        System.out.println();
    }

    private void quit(){
        System.out.println("Thnx! Have a nice day bro..");
        System.exit(0);
    }
}
