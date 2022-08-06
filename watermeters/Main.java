package com.company;


import java.util.*;
import java.lang.reflect.Array;


public class Main {
    public static reading getObject(ArrayList<reading> array,int attribute)
    {
        for (reading elem : array) {
            if (attribute==elem.date) {
                return elem;
            }
        }
        return null;
    }
    public static boolean existsInList(ArrayList<reading> c, int datereading) {
        for(reading o : c) {
            if(o != null && o.date==datereading) {
                return true;
            }
        }
        return false;
    }
    public static String parseMonth(String month)
    {
        if(luna.equals("ian"))
            luna="01";
        else if(luna.equals("feb"))
            luna="02";
        else if(luna.equals("mar"))
            luna="03";
        else if(luna.equals("apr"))
            luna="04";
        else if(luna.equals("mai"))
            luna="05";
        else if(luna.equals("iun"))
            luna="06";
        else if(luna.equals("iul"))
            luna="07";
        else if(luna.equals("aug"))
            luna="08";
        else if(luna.equals("sep"))
            luna="09";
        else if(luna.equals("oct"))
            luna="10";
        else if(luna.equals("noi"))
            luna="11";
        else if(luna.equals("dec"))
            luna="12";
        else
        {
            luna="invalid";
        }
        return luna;
    }
   public static void input(ArrayList<reading> array)
   {
       Scanner in = new Scanner(System.in);
       System.out.print("Reading month:");
       String month = in.nextLine();
       month=month.toLowerCase();
       month=parseMonth(month);
       if(month.equals("invalid"))
       {
           System.out.println("Invalid month");
           return;
       }
       System.out.println("Year:");
       String year=in.nextLine();
       if(year.length()<=3 || year.length()>=5) // if year is not 4 digit then its invalid 
       {
           System.out.println("invalid year");
           return;
       }
       System.out.println("Cold water:");
      int coldwater=in.nextInt();
       System.out.println("Warm water:");
       int warmwater=in.nextInt();
 

       year=year.substring(2); // trimming year since we only need last 2 years 
       int date=Integer.parseInt(luna+an);
      if(existsInList(array,date))
      {
          System.out.println("This month already has value read");
          return;
      }

      reading prevmonth=getObject(array,date-100);
      //since our dates are formatted like "318" for march 2018 or "1218" for dec 2018 as ints, a date-100 would give us
       //the previous month
       if(prevmonth!=null&&array.size()>1)
       {
           if(prevmonth.cold>coldwater || prevmonth.warm>warmwater)
           {
               System.out.println("Previous water values are bigger than current month's. Invalid.");
               return;
           }
       }

     array.add(new reading(date,coldwater,warmwater));
       compareObjects comp=new compareObjects();
       Collections.sort(array,comp);
   }
   public static void delete(ArrayList<reading> array)
   {
       Scanner in = new Scanner(System.in);
       System.out.print("Reading month:");
       String month = in.nextLine();
       month=month.toLowerCase();
       month=parseMonth(luna);
       if(month.equals("invalid"))
       {
           System.out.println("month invalid");
           return;
       }
       System.out.println("Year:");
       String year=in.nextLine();
       if(year.length()<=3 || year.length()>=5)
       {
           System.out.println("year invalid");
           return;
       }
       year=year.substring(2);
       int id=Integer.parseInt(luna+an);
       reading elem=getObject(array,id);
       if(elem==null)
       {
           System.out.println("THis reading value is not present .");
           return;
       }
       else {
           array.remove(elem);
           System.out.println("Succesful deletion.");
       }
       // array.removeIf(t-> t.date==id);

   }
   public static String getDate(int id)
   {
       String month="";
       String year="";
       if(id/100==1)
           month="ian";
       if(id/100==2)
           month="feb";
       if(id/100==3)
           month="mar";
       if(id/100==4)
           month="apr";
       if(id/100==5)
           month="mai";
       if(id/100==6)
           month="iun";
       if(id/100==7)
           month="iul";
       if(id/100==8)
           month="aug";
       if(id/100==9)
           month="sept";
       if(id/100==10)
           month="oct";
       if(id/100==11)
           month="noi";
       if(id/100==12)
           month="dec";
       year="20"+String.valueOf(id%100);
       return month+year;
   }

   public static void afisare(ArrayList<reading> array)
   {

       String[] matrix=
               {
   "         ",    getDate(array.get(array.size()-2).date)        ,getDate(array.get(array.size()-1).date),       "consumption",
   "warm water",    String.valueOf(array.get(array.size()-2).calda),String.valueOf(array.get(array.size()-1).calda) ,String.valueOf(array.get(array.size()-1).calda-array.get(array.size()-2).calda),
   "cold water",    String.valueOf(array.get(array.size()-2).rece),    String.valueOf(array.get(array.size()-1).rece) ,    String.valueOf(array.get(array.size()-1).rece-array.get(array.size()-2).rece),

               };


       for(int i=0;i<3;i++)
       {
           for (int j = 0; j < 4; j++)
           {
               //System.out.print(i*4+j);
                System.out.print("   "+ matrix[i*4+j]+"   ");

           }
           System.out.println();
       }
      /* matrix[1][array.size()+1]=String.valueOf(array.get(array.size()-1).rece-array.get(array.size()-2).rece);
       matrix[2][array.size()+1]=String.valueOf(array.get(array.size()-1).calda-array.get(array.size()-2).calda);
       System.out.println( matrix[0][array.size()+1]);
       System.out.println( matrix[1][array.size()+1]);
       System.out.println( matrix[2][array.size()+1]);*/
   }

    public static void main(String[] args) {

        ArrayList<reading> array=new ArrayList<reading>();

       System.out.println("Choose function:");
        System.out.println("1. Addd reading");
        System.out.println("2. Delete reading");
        System.out.println("3. Display.");
        System.out.println("4.Exit");
        Scanner scan = new Scanner(System.in);
        int num=scan.nextInt();
        while(num!=4)
        {
            if(num==1) {
                input(array);
                 System.out.println("1. Addd reading");
        System.out.println("2. Delete reading");
        System.out.println("3. Display.");
        System.out.println("4.Exit");
                num=scan.nextInt();
            }
            if(num==2) {
                delete(array);
                System.out.println("1. Addd reading");
        System.out.println("2. Delete reading");
        System.out.println("3. Display.");
        System.out.println("4.Exit");
                num=scan.nextInt();
            }
            if(num==3){
                afisare(array);
                 System.out.println("1. Addd reading");
        System.out.println("2. Delete reading");
        System.out.println("3. Display.");
        System.out.println("4.Exit");
                num=scan.nextInt();}
            if(num==4){
                return;}


        }
    }
}
