/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shiyq.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 *
 * @author flysy
 */
public class LongEventFactory implements EventFactory<LongEvent>{

    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
    
}
