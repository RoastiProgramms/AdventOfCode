package com.company;
import java.util.Scanner;

public class AdventOfCode1 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] strings=new String[1000];
        for(int i=0;i<1000;i++)
        {
            strings[i]=scanner.nextLine();
        }
        System.out.println(func(strings));
    }
    public static int func(String[] test){
        int sum=0;
        for(int i=0;i< test.length;i++)
        {
            for(int j=0;j<test[i].length();j++)
            {
                if(test[i].charAt(j)>='0'&&test[i].charAt(j)<='9')
                {
                    sum+=(test[i].charAt(j)-'0')*10;
                    break;
                }
            }
            for(int j=test[i].length()-1;j>=0;j--)
            {
                if(test[i].charAt(j)>='0'&&test[i].charAt(j)<='9')
                {
                    sum+=(test[i].charAt(j)-'0');
                    break;
                }
            }

        }
        return sum;
    }
}

