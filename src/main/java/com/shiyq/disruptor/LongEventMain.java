/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shiyq.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 *
 * @author flysy
 */
public class LongEventMain {
    public static void main(String[] args) throws InterruptedException {
        Executor executor = Executors.newCachedThreadPool();
        
        LongEventFactory factory = new LongEventFactory();
        
        int bufferSize = 1024;
        
        Disruptor<LongEvent> disruptor = new Disruptor<>(factory,bufferSize,executor);
        
        disruptor.handleEventsWith(new LongEventHandler());
        disruptor.start();
        
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        
        LongEventProducer producer = new LongEventProducer(ringBuffer);
        
        ByteBuffer bb = ByteBuffer.allocate(8);
        
        for(long l=0;true;l++){
            bb.putLong(0,l);
            producer.onData(bb);
            Thread.sleep(1000);
        }
        
    }
}
