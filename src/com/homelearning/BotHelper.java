package com.homelearning;

import java.awt.*;
import java.awt.event.InputEvent;

import static com.homelearning.ClipboardHelper.getValueFromClipboard;
import static com.homelearning.ClipboardHelper.putValueToClipboard;
import static java.awt.event.KeyEvent.*;

public class BotHelper {
    private Robot robot;
    private TableHolder table;

    private static int autoDelay = 100;

    public BotHelper() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.setAutoDelay(autoDelay);
        table = new TableHolder(getValueFromClipboard());
    }

    public void execute(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        multipleLeftMouseClick(table.getSize()/2 - 1);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0, j = 0; i < table.getSize(); i++) {
            putValueToClipboard(table.get(i));
            pasteValueFromClipboard();
            if (table.get(i).equals("")) System.err.println("Empty value");
            if (i%2 != 0) {
                System.out.println(++j);
                nextRow();
            } else nextColumn();
        }
    }

    private void multipleLeftMouseClick(int repeat){
        for (int i = 0; i < repeat; i++) {
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
    }

    private void nextColumn() {
        robot.keyPress(VK_TAB);
        robot.keyRelease(VK_TAB);
    }

    private void previousColumn() {
        robot.keyPress(VK_SHIFT);
        robot.keyPress(VK_TAB);
        robot.keyRelease(VK_TAB);
        robot.keyRelease(VK_SHIFT);
    }

    private void pasteValueFromClipboard() {
        robot.keyPress(VK_CONTROL);
        robot.keyPress(VK_V);
        robot.keyRelease(VK_V);
        robot.keyRelease(VK_CONTROL);
    }

    private void nextRow() {
        robot.keyPress(VK_CONTROL);
        robot.keyPress(VK_DOWN);
        robot.keyRelease(VK_DOWN);
        robot.keyRelease(VK_CONTROL);
        previousColumn();
    }

    public static void setAutoDelay(int autoDelay) {
        BotHelper.autoDelay = autoDelay;
    }
}