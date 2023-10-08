package org.example.menu;

public class MenuOption {

    private int option;
    private String text;
    private Runnable action;

    public MenuOption(int option, String text, Runnable action) {
        this.option = option;
        this.text = text;
        this.action = action;
    }

    public int getOption() {
        return option;
    }

    public String getText() {
        return text;
    }

    public void run() {
        action.run();
    }
}
