package com.dogsong.quartz.job;

import com.dogsong.quartz.service.DemoService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author domisong.
 * @description: TODO
 * @date 2021/4/24.
 */
public class DemoJob01 extends QuartzJobBean {


    private Logger logger = LoggerFactory.getLogger(getClass());

    private AtomicInteger counts = new AtomicInteger();

    @Autowired
    private DemoService demoService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("[executeInternal][定时第 ({}) 次执行, demoService 为 ({})]", counts.incrementAndGet(), demoService);
    }
}
