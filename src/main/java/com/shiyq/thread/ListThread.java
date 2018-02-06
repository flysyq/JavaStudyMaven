/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shiyq.thread;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author flysy
 */
public class ListThread extends Thread{

    private List list;
    private int from;
    private int to;
    
    public ListThread(ArrayList list, int from, int to) {
        this.list = list;
        this.from = from;
        this.to = to;
    }
    
    @Override
    public void run() {
        for (int i =from;i<to;i++ ){
            System.out.println("Thread : "+Thread.currentThread()+","+list.get(i));
        }
    }  
    
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        int step = 100;
        int step_num = 100;
        int all = step * step_num;
        for(int i=0;i<all;i++){
            list.add(i);
        }
        
        for(int i=0;i<step_num;i++){
            new ListThread(list,i*step,(i+1)*step).start();
        }
    }
}
