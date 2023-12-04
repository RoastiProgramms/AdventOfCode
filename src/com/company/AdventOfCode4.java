package com.company;

import java.util.HashSet;
import java.util.Scanner;

public class AdventOfCode4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] strings=new String[188];
        for(int i=0;i<188;i++)
        {
            strings[i] = scanner.nextLine();
        }
        System.out.println(func(strings));
    }
    public static int func(String[] strings)
    {
        int sum=0;
        for(int i=0;i<188;i++)
        {
            int curCount=0;
            String[] two=strings[i].split(":");
            String[] fin=two[1].split("\\|");
            String[] left=fin[0].trim().split("\\s+");
            String[] right=fin[1].trim().split("\\s+");
            HashSet<Integer> leftset=new HashSet<>();
            for (String num:left)
            {

                leftset.add(Integer.parseInt(num));
            }
            for(String num:right)
            {
                if(leftset.contains(Integer.parseInt(num)))
                {
                    curCount++;
                }
            }
            if(curCount==1)
            {
                sum+=1;
            }
            else if(curCount>1)
            {
                sum+=Math.pow(2,curCount-1);
            }
        }
        return sum;
    }
}
