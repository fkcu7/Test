/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cc15.moodtracker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Francis King C. Uyguangco
 * BSIT - 2
 */
class MoodList
{
    private int Mood;
    private int Day;
    MoodList(int Mood, int Day)
    {
        this.Mood = Mood;
        this.Day = Day;
    }
    public int getMood()
    {
        return Mood;
    }
    public int getDay()
    {
        return Day;
    }
}
public class MoodTracker 
{
    public static Scanner cl = new Scanner(System.in);
    
    public static List<MoodList> moods = new ArrayList<MoodList>();
    public static String[] Moods = {"Happy","Sad","Angry"};
    public static int[] counter = {0,0,0};
    public static String[] Days = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
    public static void main(String[] args) 
    {
        String choices = "1. Add\n2. Calculate\n3. Find\n4.exit";
        boolean loop = true;
        do
        {
            System.out.println("Weekly Mood Tracker");
            System.out.println(choices);
            int choice = cl.nextInt();
            switch(choice)
            {
                case 1:
                {
                    Add();
                    break;
                }
                case 2:
                {
                    Calculate();
                    break;
                }
                case 3:
                {
                    Find();
                    break;
                }
                case 4:
                {
                    System.exit(0);
                }
            }
        }
        while (loop = true);
    }  

    private static void Add() 
    {
        System.out.println("What is your current mood:\n1. Happy\n2. Sad\n3. Angry");
        int currentMood = cl.nextInt();
        System.out.println("Today is:\n1. Monday\n2. Tuesday\n3. Wednesday\n4. Thursday\n5. Friday\n6. Saturday\n7. Sunday");
        int currentDay = cl.nextInt();
        moods.add(new MoodList(currentMood,currentDay));
    }

    private static void Calculate() 
    {
        Iterator<MoodList> i = moods.iterator();
        while(i.hasNext())
        {
            MoodList m = i.next();
            if(m.getDay()==1)
            {
                counter[0]++;
            }
            else if (m.getDay()==2)
            {
                counter[1]++;
            }
            else
            {
                counter[2]++;
            }
        }
        if((counter[0]>counter[1])&&(counter[0]>counter[2]))
        {
            System.out.println("Average Mood is HAPPY!");
        }
        else if ((counter[0]<counter[1])&&(counter[1]>counter[2]))
        {
            System.out.println("Average Mood is Sad.");
        }
        else if ((counter[1]<counter[2])&&(counter[2]>counter[0]))
        {
            System.out.println("Average Mood is Angry.");
        }
        else if ((counter[1]==counter[2])&&(counter[1]==counter[3]))
        {
            System.out.println("All mood are equal.");
        }
        else if(counter[1]==counter[2])
        {
            System.out.println("Average Mood is Happy and Sad.");
        }
        else if (counter[1]==counter[3])
        {
            System.out.println("Average Mood is Happy and Angry.");
        }
        else if (counter[2]==counter[3])
        {
            System.out.println("Average Mood is Sad and Angry.");
        }
    }

    private static void Find() 
    {
        int[] HappyCounter = {0,0,0,0,0,0,0};
        int[] SadCounter = {0,0,0,0,0,0,0};
        
        Iterator<MoodList> i = moods.iterator();
        while(i.hasNext())
        {
            MoodList m = i.next();
            if(m.getMood()==1)
            {
                HappyCounter[m.getDay()]++;
            }
            else
            {
                SadCounter[m.getDay()]++;
            }
        }
        int HappyMax = 0;
        int HappyDay = 0;
        int SadMax = 0;
        int SadDay = 0;
        for(int x = 0; x < HappyCounter.length;x++)
        {
            if(HappyCounter[x]>HappyMax)
            {
                HappyMax = HappyCounter[x];
                HappyDay = x;
            }
        }
        for(int x = 0; x < SadCounter.length;x++)
        {
            if(SadCounter[x]>SadMax)
            {
                SadMax = SadCounter[x];
                SadDay = x;
            }
        }
        System.out.println("Happiest Day: " + HappyDay + "\nSaddest Day: " + SadDay);
    }
}
