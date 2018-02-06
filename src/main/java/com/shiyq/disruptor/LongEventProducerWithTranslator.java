/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shiyq.disruptor;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;
import java.nio.ByteBuffer;

/**
 *
 * @author flysy
 */
public class LongEventProducerWithTranslator {

    private final RingBuffer<LongEvent> ringBuffer;
    
    public LongEventProducerWithTranslator(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }
    
    private static final EventTranslatorOneArg<LongEvent, ByteBuffer> TRANSLATOR
            = new EventTranslatorOneArg<LongEvent, ByteBuffer>() {
        @Override
        public void translateTo(LongEvent event, long sequence, ByteBuffer bb) {
            event.set(bb.getLong(0));
        }        
    };
    
    public void onData(ByteBuffer bb){
        ringBuffer.publishEvent(TRANSLATOR,bb);
    }
}
