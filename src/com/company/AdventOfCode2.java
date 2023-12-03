package com.company;

import java.util.Scanner;

public class AdventOfCode2 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] strings=new String[100];
        for(int i=0;i<100;i++)
        {
            strings[i] = scanner.nextLine();
        }
        System.out.println(func(strings));
    }
    public static int func(String[] strings)
    {
        int sum=0;
        for(int i=0;i<100;i++)
        {
            Boolean check=false;
            String[] games=strings[i].split(":");
            String[] parts=games[1].split(";");
            for (String partss:parts)
            {
                if(check)
                {
                    break;
                }
                String[] moves=partss.split(",");
                for (String move:moves)
                {

                    String[] finProd=move.trim().split(" ");
                    if(finProd[1].equals("red")&&Integer.parseInt(finProd[0])>12)
                    {
                        check=true;
                        break;
                    }
                    else if(finProd[1].equals("green")&&Integer.parseInt(finProd[0])>13)
                    {
                        check=true;
                        break;
                    }
                    else if(Integer.parseInt(finProd[0])>14)
                    {
                        check=true;
                        break;
                    }
                }
            }
            if(!check)
            {
                sum+=i+1;
            }
        }
        return sum;

    }
}

