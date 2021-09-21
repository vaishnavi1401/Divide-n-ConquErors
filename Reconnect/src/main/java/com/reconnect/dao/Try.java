package com.reconnect.dao;



class hack1
{
    private int hack_method1(int hack)
    {
        return hack++;
    }
    public int hack_method2(int hack)
    {
        System.out.println(hack);
        return hack_method1(hack++);
    }
}

class hack2 extends hack1
{
    int hack_method1(int hack)
    {
        return hack_method2(++hack);
    }
}
public class Try
{
    public static void main(String[] args)
    {
        hack2 h = new hack2();
        System.out.println(h.hack_method1(0));

    }
}