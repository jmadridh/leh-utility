package com.zc.leh;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.interceptor.AbstractEnvelopeInterceptor;
import org.mule.management.stats.ProcessingTime;

public class CustomTimerInterceptor extends AbstractEnvelopeInterceptor{

    private static Log logger = LogFactory.getLog(CustomTimerInterceptor.class);

    @Override
    public MuleEvent last(MuleEvent event, ProcessingTime time, long startTime,
      boolean exceptionWasThrown) throws MuleException {
        long endTime = System.currentTimeMillis();
        logger.info("Flow:"+event.getFlowConstruct().getName()+"-Processing Time:"+(endTime-startTime));
        event.setFlowVariable("latency", (endTime-startTime));;
        return event;
     }

    @Override
    public MuleEvent before(MuleEvent event) throws MuleException {
        return event;
    }

    @Override
    public MuleEvent after(MuleEvent event) throws MuleException {
        return event;
    }
}