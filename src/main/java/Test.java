/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Test {
    public static void main(String[] args) {
        String a = "2016-3-2    12:23:34";
        System.out.println(a.split("\\ {1,}")[0]);
        String[] b = a.split("\\ {1,}");
        System.out.println(b[0]);
        System.out.println(b[1]);
    }
}
