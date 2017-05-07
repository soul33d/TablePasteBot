package com.homelearning;

public class TableHolder {
    private String[] table;

    public TableHolder(String value) {
        table = value.split("[\t]");
        System.out.println(table.length);
    }

    public int getSize(){
        return table.length;
    }

    public String get(int index){
        String result = table[index];
        if (result.startsWith("\r") && result.length() > 1) result = result.substring(1, result.length());
        if (result.startsWith("\n") && result.length() > 1) result = result.substring(1, result.length());
        if (result.length() == 1 && result.matches("[\n\r]")) result = "";
        return result;
    }
}