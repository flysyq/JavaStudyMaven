/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shiyq.disruptor;

import com.lmax.disruptor.RingBuffer;
import java.nio.ByteBuffer;

/**
 *
 * @author flysy
 */
public class LongEventProducer {
    private final RingBuffer<LongEvent> ringBuffer;
    
    public LongEventProducer(RingBuffer<LongEvent> ringBuffer){
        this.ringBuffer = ringBuffer;
    }
    
    public void onData(ByteBuffer bb){
        long sequence = ringBuffer.next();
        try{
            LongEvent event = ringBuffer.get(sequence);
            event.set(bb.getLong(0));
        }
        finally
        {
            ringBuffer.publish(sequence);
        }
    }
}
