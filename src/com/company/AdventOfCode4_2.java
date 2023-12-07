package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
class CustomData {
    private int value;
    private int copyCount;

    public CustomData(int value, int copyCount) {
        this.value = value;
        this.copyCount = copyCount;

    }
    public int getValue() {
        return value;
    }

    public int getCopyCount() {
        return copyCount;
    }
}
public class AdventOfCode4_2 {
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
        HashMap<Integer, Integer> cardsValues = new HashMap<>();
        for(int i=0;i<188;i++) {
            int curCount = 0;
            String[] two = strings[i].split(":");
            String[] fin = two[1].split("\\|");
            String[] left = fin[0].trim().split("\\s+");
            String[] right = fin[1].trim().split("\\s+");
            HashSet<Integer> leftset = new HashSet<>();
            for (String num : left) {
                leftset.add(Integer.parseInt(num));
            }
            for (String num : right) {
                if (leftset.contains(Integer.parseInt(num))) {
                    curCount++;
                }
            }
            cardsValues.put(i + 1, curCount);
        }
        HashMap<Integer,CustomData>keyValueCopies=new HashMap<>();
        for(Map.Entry<Integer,Integer> entry:cardsValues.entrySet())
        {
            keyValueCopies.put(entry.getKey(),new CustomData(entry.getValue(),1));
        }
        for(int i=1;i<189;i++)
        {
            CustomData data=keyValueCopies.get(i);
            for(int j=1;j<= data.getValue();j++)
            {
                CustomData data1=keyValueCopies.get(i+j);
                if(i+j<189)
                {
                    keyValueCopies.put(i+j,new CustomData(data1.getValue(), data1.getCopyCount()+data.getCopyCount()));
                }
            }
            sum+=data.getCopyCount();
        }

        return sum;
    }

}