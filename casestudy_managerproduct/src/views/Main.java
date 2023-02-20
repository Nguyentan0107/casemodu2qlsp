package views;

import controller.MaterialManager;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        MaterialManager materialManager = new MaterialManager();
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        menu.logIn();

    }
}