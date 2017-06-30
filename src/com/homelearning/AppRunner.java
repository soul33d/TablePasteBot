package com.homelearning;

public class AppRunner {

    public static void main(String[] args) {

        if (args.length == 1 && args[0].matches("[\\d]*")) {
            try {
                BotHelper.setAutoDelay(Integer.parseInt(args[0]));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Wrong auto delay argument, must be an integer!");
                System.out.println("Program will use default value: " + BotHelper.getAutoDelay());
            }
        }

        new BotHelper().execute();
    }
}
