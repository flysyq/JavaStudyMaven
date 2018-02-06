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
class Person {

    public void Person() {
        System.out.println("Person A");
    }

    public Person() {
        System.out.println("Person B");
    }

    int getAge() {
        return 20;
    }

    public void printAge() {
        System.out.println(getAge());
    }    
}

