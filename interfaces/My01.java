package biz.markov.thinking.interfaces;

class My01_Class {
    public String toString() {
        return "My01_SubLists";
    }
}

public class My01 {
    public static void main(String args[]) {
        My01_Class my = new My01_Class();
        String str;

        //! str = (String)my;
        str = my.toString();
        System.out.println(my + "\n" + str);
    }
}
