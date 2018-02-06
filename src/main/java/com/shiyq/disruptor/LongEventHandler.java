/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shiyq.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 *
 * @author flysy
 */
public class LongEventHandler implements EventHandler<LongEvent>{

    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("Event: " + event);
    }
    
}
