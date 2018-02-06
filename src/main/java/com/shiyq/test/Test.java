/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shiyq.test;

/**
 *
 * @author flysy
 */
public class Test {

    public static void main(String[] args) {
        Person person = (Person)new Student();
        person.printAge();
    }
}
