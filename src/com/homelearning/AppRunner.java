package com.homelearning;

public class AppRunner {

    public static void main(String[] args) {

        if (args.length == 1 && args[0].matches("[\\d]*")) {
            BotHelper.setAutoDelay(Integer.parseInt(args[0]));
        }

        if (args.length == 2){
            ClipboardHelper.setCodePageIn(args[0]);
            ClipboardHelper.setCodePageOut(args[1]);
        }

        new BotHelper().execute();
    }
}
