package com.company;



import java.util.Comparator;

public class compareObjects implements Comparator<citire> {

    @Override
    public int compare(citire obj1, citire obj2) {
        citire myObj1 = (citire)obj1;
        citire myObj2 = (citire)obj2;
        int result = Integer.compare(myObj1.data%100,myObj2.data%100);
        if (result == 0) {
            // Strings are equal, sort by date
            return Integer.compare(myObj1.data/100,myObj2.data/100);
        }
        else {
            return result;
        }
    }
}
