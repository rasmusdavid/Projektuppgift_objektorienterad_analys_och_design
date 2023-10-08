package org.example.menu;

import java.util.*;

import static org.example.Main.ANSI_RED;
import static org.example.Main.ANSI_RESET;

public abstract class Menu implements MenuState{

    protected String name;
    protected List<MenuOption> menuOptions;

    public Menu(String name) {
        this.name = name;
    }

    @Override
    public void execute() {
        displayMenuOptions();
        Scanner scanner = new Scanner(System.in);
        Set<Integer> validOptions = new HashSet<>();
        for (MenuOption menuOption : menuOptions) {
            validOptions.add(menuOption.getOption());
        }
        try {
            int option = scanner.nextInt();
            if (validOptions.contains(option)) {
                for (MenuOption menuOption : menuOptions) {
                    if (menuOption.getOption() == option) {
                        menuOption.run();
                    }
                }
            } else {
                System.out.println(ANSI_RED + "Error! Please enter a valid menu option." + ANSI_RESET);
            }
        } catch (InputMismatchException e) {
            System.out.println(ANSI_RED + "Error! Please enter a number." + ANSI_RESET);
        }
    }


    private void displayMenuOptions() {
        String menuText = name;
        for(MenuOption menuOption : menuOptions){
            menuText = menuText.concat("\n" + menuOption.getOption() + ". " + menuOption.getText());
        }
        System.out.println(menuText);
    }
}
