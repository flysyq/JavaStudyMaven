/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shiyq.jackson;

/**
 *
 * @author admin
 */
public class All {
    private Head head;
    private Body body;

    All() {
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public All(Head head, Body body) {
        this.head = head;
        this.body = body;
    } 
    
    
}
