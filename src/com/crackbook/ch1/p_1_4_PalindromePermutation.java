package com.crackbook.ch1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by msoliman on 5/13/17.
 */
public class p_1_4_PalindromePermutation {
    public static void main(String[] args) {


        System.out.print((run_set("Tact Coa")));

        System.out.print((run_bit("Tact Coa")));
        System.out.print((run_perm("Fa baf")));

    }

    static boolean run_set(String s) {

        s = s.replace(" ", "");

        Set<Character> set = new HashSet<>();

        Character ch;

        for (int i = 0; i < s.length(); i++) {
            ch = Character.toLowerCase(s.charAt(i));

            if (set.contains(ch))
                set.remove(ch);
            else
                set.add(ch);
        }

        return set.size() == 0 || set.size() == 1;

    }

    static boolean run_bit(String s) {
        int lowerCase = 0;
        int upperCase = 0;

        s = s.replace(" ", "");

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < 97)
                if ((upperCase & (1 << s.charAt(i))) > 0) {
                    //set off
                    upperCase &= ~(1 << s.charAt(i));
                } else
                    upperCase |= (1 << s.charAt(i));

            if ((lowerCase & (1 << s.charAt(i))) > 0) {
                lowerCase &= ~(1 << s.charAt(i));
            } else
                lowerCase |= (1 << s.charAt(i));
        }


        boolean bl = false;

        for (short i = 0; i < 32; i++) {
            if ((lowerCase & (1 << i)) > 0)
                bl = !bl;
        }

        boolean br = false;

        for (short i = 0; i < 32; i++) {
            if ((upperCase & (1 << i)) > 0)
                br = !br;
        }

        if (bl && br)
            return false;

        if (!bl && !br)
            return false;


        return true;

    }

    //(brute force) generate all permutation and check each one
    static boolean run_perm(String s) {

        List<String> lst = new ArrayList<>();
        perm("", s.replace(" ", "").toLowerCase(), lst);

        StringBuilder sb;


        for (String p : lst) {
            sb = new StringBuilder(p);
            if (sb.reverse().toString().equals(p))
                return true;
        }

        return false;
    }

    static void perm(String prefix, String s, List<String> lst) {
        if (s.isEmpty())
            lst.add(prefix);

        for (int i = 0; i < s.length(); i++) {
            perm(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1), lst);
        }


    }
}
