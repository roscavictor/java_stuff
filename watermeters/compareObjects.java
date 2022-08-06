package com.company;



import java.util.Comparator;

public class compareObjects implements Comparator<reading> {

    @Override
    public int compare(reading obj1, reading obj2) {
        reading myObj1 = (reading)obj1;
        reading myObj2 = (reading)obj2;
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
