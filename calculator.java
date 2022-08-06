/*
Simple java calculator. 
Default value is 0. Can be set through command line parameter. 
Possible operations : + / * - and 
= (sets current value to said number)
After every operation, current value is displayed and code will wait for new input. 
 " > " symbol is displayed when input is expected.
 Displays "invalid operation" upon invalid input. 
*/
package com.company;

import java.util.Scanner;
public class Main{
    public static void input_and_math(int number, boolean condition)
    {

        System.out.println(number);
        System.out.print(">");
        Scanner scan= new Scanner(System.in);

        //For string

        String text= scan.nextLine();
        int textlength=text.length();
        char operator='%';
        if(textlength>0) //in case of blank inputs,  either string.substring(1)  or
            // string.charAt() will cause a crash
        {operator=text.charAt(0);

        text=text.substring(1);}
        else operator='%';
        //System.out.println(operator);
        //System.out.println(text);
        int secondnumber=0;
       if(textlength>1)
       {
            secondnumber=Integer.parseInt(text);
       }
       //doing this because for an improper input of a single-digit, the code will crash when using parseInt(text)
        //because text will be null, since i'm splitting a string into 2: the first char being the operator,2nd is number

        int result=0;
        if(text.length()==0)
            operator='%';
        if(operator=='+')
        {result=number+secondnumber;
            System.out.println(result);
            number=result;}
        else if(operator=='*'){
            result=number*secondnumber;
            System.out.println(result);
            number=result;}
         else if(operator=='-') {
            result = number - secondnumber;
            System.out.println(result);
            number=result;}
        else if(operator=='/'){
            result=number/secondnumber;System.out.println(result);
            number=result;}
        else if(operator=='='){
            result=secondnumber;
            System.out.println(result);
            number=result;
        }
        else if(operator=='x'){
            return;}
        else {
            System.out.println("Invalid operator");
            System.out.println(">");
        }
        while(condition==true)
        {
            System.out.print(">");
          text= scan.nextLine();
          textlength=text.length();
          if(textlength>0)
          {operator=text.charAt(0);

            text=text.substring(1);}
          else operator='%';
            //System.out.println(operator);
            //System.out.println(text);
            if(textlength>1)
            secondnumber=Integer.parseInt(text);
            if(text.length()==0)//checking if input was not just an operator
                // as in, entire input string was not just + or - etc
                operator='%';
            if(operator=='+')
            {result=number+secondnumber;
                System.out.println(result);
                number=result;}
            else if(operator=='*'){
                result=number*secondnumber;
                System.out.println(result);
                number=result;}
            else if(operator=='-') {
                result = number - secondnumber;
                System.out.println(result);
                number=result;}
            else if(operator=='/'){
                result=number/secondnumber;System.out.println(result);
                number=result;}
            else if(operator=='='){
                result=secondnumber;
                number=result;
                System.out.println(result);
                }
            else if(operator=='x'){
                return;}
            else {
                System.out.println("Invalid operator");
                System.out.print(">");
            }
        }


    }
    public static void main(String args[]){
        int number;
        boolean condition=true;
        if(args.length==0)
            number=0;
        else number=Integer.parseInt(args[0]);
       input_and_math(number,condition);
    }
}