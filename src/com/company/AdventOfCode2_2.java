package com.company;

import java.util.Scanner;

public class AdventOfCode2_2 {

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
            int curMaxBlue=0;
            int curMaxGreen=0;
            int curMaxRed=0;
            Boolean check=false;
            String[] games=strings[i].split(":");
            String[] parts=games[1].split(";");
            for (String partss:parts)
            {
                String[] moves=partss.split(",");
                for (String move:moves)
                {

                    String[] finProd=move.trim().split(" ");
                    if(finProd[1].equals("red")&&Integer.parseInt(finProd[0])>curMaxRed)
                    {
                        curMaxRed=Integer.parseInt(finProd[0]);
                    }
                    else if(finProd[1].equals("green")&&Integer.parseInt(finProd[0])>curMaxGreen)
                    {
                        curMaxGreen=Integer.parseInt(finProd[0]);
                    }
                    else if(finProd[1].equals("blue")&&Integer.parseInt(finProd[0])>curMaxBlue)
                    {
                        curMaxBlue=Integer.parseInt(finProd[0]);
                    }
                }
            }
            sum+=curMaxBlue*curMaxGreen*curMaxRed;
        }
        return sum;

    }
}
