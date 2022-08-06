package com.company;


import java.util.*;
import java.lang.reflect.Array;


public class Main {
    public static citire getObject(ArrayList<citire> array,int attribute)
    {
        for (citire elem : array) {
            if (attribute==elem.data) {
                return elem;
            }
        }
        return null;
    }
    public static boolean existsInList(ArrayList<citire> c, int datacitire) {
        for(citire o : c) {
            if(o != null && o.data==datacitire) {
                return true;
            }
        }
        return false;
    }
    public static String parseMonth(String luna)
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
   public static void input(ArrayList<citire> array)
   {
       Scanner in = new Scanner(System.in);
       System.out.print("Luna citirii:");
       String luna = in.nextLine();
       luna=luna.toLowerCase();
       luna=parseMonth(luna);
       if(luna.equals("invalid"))
       {
           System.out.println("Luna invalida");
           return;
       }
       System.out.println("Anul:");
       String an=in.nextLine();
       if(an.length()<=3 || an.length()>=5)
       {
           System.out.println("An invalid");
           return;
       }
       System.out.println("Apa rece:");
      int aparece=in.nextInt();
       System.out.println("Apa calda:");
       int apacalda=in.nextInt();
     // int luna_int=0;


       an=an.substring(2);
       int data=Integer.parseInt(luna+an);
      if(existsInList(array,data))
      {
          System.out.println("Aceasta luna deja are citire");
          return;
      }

      citire luna_anterioara=getObject(array,data-100);
      //since our dates are formatted like "318" for march 2018 or "1218" for dec 2018 as ints, a date-100 would give us
       //the previous month
       if(luna_anterioara!=null&&array.size()>1)
       {
           if(luna_anterioara.rece>aparece || luna_anterioara.calda>apacalda)
           {
               System.out.println("Citirea de luna anterioara este mai mare. Citire invalida.");
               return;
           }
       }

     array.add(new citire(data,aparece,apacalda));
       compareObjects comp=new compareObjects();
       Collections.sort(array,comp);
   }
   public static void delete(ArrayList<citire> array)
   {
       Scanner in = new Scanner(System.in);
       System.out.print("Luna citirii:");
       String luna = in.nextLine();
       luna=luna.toLowerCase();
       luna=parseMonth(luna);
       if(luna.equals("invalid"))
       {
           System.out.println("Luna invalida");
           return;
       }
       System.out.println("Anul:");
       String an=in.nextLine();
       if(an.length()<=3 || an.length()>=5)
       {
           System.out.println("An invalid");
           return;
       }
       an=an.substring(2);
       int id=Integer.parseInt(luna+an);
       citire elem=getObject(array,id);
       if(elem==null)
       {
           System.out.println("Aceasta citire nu exista");
           return;
       }
       else {
           array.remove(elem);
           System.out.println("Stergere efectuata");
       }
       // array.removeIf(t-> t.data==id);

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

   public static void afisare(ArrayList<citire> array)
   {

       String[] matrix=
               {
   "         ",    getDate(array.get(array.size()-2).data)        ,getDate(array.get(array.size()-1).data),       "consum",
   "apa calda",    String.valueOf(array.get(array.size()-2).calda),String.valueOf(array.get(array.size()-1).calda) ,String.valueOf(array.get(array.size()-1).calda-array.get(array.size()-2).calda),
   "apa rece",    String.valueOf(array.get(array.size()-2).rece),    String.valueOf(array.get(array.size()-1).rece) ,    String.valueOf(array.get(array.size()-1).rece-array.get(array.size()-2).rece),

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
	// write your code here
        ArrayList<citire> array=new ArrayList<citire>();

       System.out.println("Alegeti functionanlitatea:");
        System.out.println("1. Adaugare citire");
        System.out.println("2. Stergere citire");
        System.out.println("3. Afisare.");
        System.out.println("4.Iesire");
        Scanner scan = new Scanner(System.in);
        int num=scan.nextInt();
        while(num!=4)
        {
            if(num==1) {
                input(array);
                System.out.println("1. Adaugare citire");
                System.out.println("2. Stergere citire");
                System.out.println("3. Afisare.");
                System.out.println("4.Iesire");
                num=scan.nextInt();
            }
            if(num==2) {
                delete(array);
                System.out.println("1. Adaugare citire");
                System.out.println("2. Stergere citire");
                System.out.println("3. Afisare.");
                System.out.println("4.Iesire");
                num=scan.nextInt();
            }
            if(num==3){
                afisare(array);
                System.out.println("1. Adaugare citire");
                System.out.println("2. Stergere citire");
                System.out.println("3. Afisare.");
                System.out.println("4.Iesire");
                num=scan.nextInt();}
            if(num==4){
                return;}


        }
    }
}
