package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExampleTest {
    public static boolean f9(boolean x, boolean y, boolean z)
    {
        if (!x && !y && !z) return true;
        if (!x && !y && z) return false;
        if (!x && y && !z) return false;
        if (!x && y && z) return true;
        if (x && !y && !z) return true;
        if (x && !y && z) return false;
        if (x && y && !z) return true;
        if (x && y && z) return false;
        return false;
    }
    public static void main(String[] args) {
        System.out.println(f9(false, false, false));
    }
}
