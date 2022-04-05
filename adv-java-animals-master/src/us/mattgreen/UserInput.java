package us.mattgreen;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInput {

    private Scanner sc = new Scanner(System.in);
    public ArrayList<Talkable> zoo;

    public UserInput(ArrayList<Talkable> zoo) {
        this.zoo = zoo;
    }

    public boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }

    private String askUserForInput(String prompt) {
      System.out.println(prompt);
      return sc.nextLine();
    };

    private void makeDog() {
        try {
            boolean friendly = Boolean.parseBoolean(askUserForInput("Is the dog friendly? True or False"));
            String name = askUserForInput("Please name the dog.");

            if(isAlpha(name)) {
                this.zoo.add(new Dog(friendly, name));
            } else {
                System.out.println("Must be a name with only letters");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void makeCat() {
        try {
            int mousesKilled = Integer.parseInt(askUserForInput("How many mice has the cat killed"));
            String name = askUserForInput("Please name the cat.");

            if(isAlpha(name)) {
                this.zoo.add(new Cat(mousesKilled, name));
            } else {
                System.out.println("Must be a name with only letters");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void run() {

        String input = "";
        while(!input.equals("Q")) {
            input = askUserForInput("What Animal would you like to create?\n Cat - Dog - Teacher\nQ to quit");
            if (input.equals("Dog")) {
                makeDog();
            } else if (input.equals("Cat")) {
                makeCat();
            } else {
                System.out.println("Bad Input");
            }
        }
    }


}
