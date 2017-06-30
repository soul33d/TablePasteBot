package com.homelearning;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class ClipboardHelper {
    private static final DataFlavor byteFlavor = new DataFlavor(String.class, "String Flavor");

    public static void putValueToClipboard(String value){
        StringSelection stringSelection = new StringSelection(value);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    public static String getValueFromClipboard(){
        String result = "";
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);
        if (contents != null && contents.isDataFlavorSupported(byteFlavor)){
            try {
                result = (String) contents.getTransferData(byteFlavor);
            } catch (UnsupportedFlavorException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}