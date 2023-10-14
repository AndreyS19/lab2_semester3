import java.util.regex.Pattern;
import java.util.Scanner;
import java.io.IOException;
public class task2 {
    public static void zad_2_var_6() {
            String s;
            Scanner scan=new Scanner(System.in);
            s = scan.nextLine();
            String regex = "(((0[1-9])|([1-2][1-9])|(3[0-1]))/((0[1-9])|(1[0-2]))/((1[6-9])|([2-9][0-9])[0-9][0-9]))";
            String[] data= s.split(", ");
            for(int i =0;i<data.length;i++)
            {
                boolean prov=false;
                if (Pattern.matches(regex, data[i]))
                {
                    prov=true;
                    String[] numbers=data[i].split("/");
                    int date= Integer.parseInt(numbers[0]);
                    int month= Integer.parseInt(numbers[1]);
                    int year= Integer.parseInt(numbers[2]);
                    if(month==2)
                    {
                        if(date>29)
                        {
                            prov = false;

                        }
                        if(date==29&&((year%400!=0 && year%100==0)||(year%400!=0 && year%4!=0)))
                            prov = false;
                    }
                    if((month==4 ||month==6 ||month==9 ||month==11)&&date>30)
                    {
                        prov = false;
                    }
                }
                if(prov==false)
                    err(i, "выражении");
                else
                    noerr(i, "выражении");
            }


    }
    public static void err(int i, String a )
    {
        System.out.println("Некорректные значения  в "+(i+1)+" "+a);
    }
    public static void noerr(int i, String a )
    {
        System.out.println("Значения корректны  в "+(i+1)+" "+a);
    }

}
