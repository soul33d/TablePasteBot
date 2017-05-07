package com.homelearning;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class ClipboardHelper {
    private static final DataFlavor byteFlavor = new DataFlavor(String.class, "String Flavor");

    private static String codePageIn;
    private static String codePageOut;

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
        result = transformCodePage(result);
        return result;
    }

    private static String transformCodePage(String in) {
        String result = in;
        if (codePageIn != null && codePageOut != null){
            try {
                result = new String(result.getBytes(codePageIn), codePageOut);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public static void setCodePageIn(String codePageIn) {
        ClipboardHelper.codePageIn = codePageIn;
    }

    public static void setCodePageOut(String codePageOut) {
        ClipboardHelper.codePageOut = codePageOut;
    }
}