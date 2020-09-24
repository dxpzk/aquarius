package com.aquarius.job;

import com.github.ltsopensource.core.domain.Action;
import com.github.ltsopensource.core.domain.Job;
import com.github.ltsopensource.core.logger.Logger;
import com.github.ltsopensource.core.logger.LoggerFactory;
import com.github.ltsopensource.spring.tasktracker.JobRunnerItem;
import com.github.ltsopensource.spring.tasktracker.LTS;
import com.github.ltsopensource.tasktracker.Result;

@LTS
public class JobScheduler {
	private static final Logger LOGGER = LoggerFactory.getLogger(JobScheduler.class);

	/**
     * 示例任务
     * <功能详细描述>
     *
     * @param job
     * @return
     * @throws Throwable
     * @see [类、类#方法、类#成员]
     */
    @JobRunnerItem(shardValue = "test")
    public Result runJob2(Job job) throws Throwable {
        try {
        	LOGGER.info("-------------开始执行任务-------------：" + job.getTaskId());
            for(int i=0;i<45;i++){
            	Thread.sleep(1000);
            	System.out.println("@"+i +"@----------------我在执行中！------------------@"+i+"@");
            }

        } catch (Exception e) {
            LOGGER.info("Run job failed!", e);
            return new Result(Action.EXECUTE_LATER, e.getMessage());
        }
        return new Result(Action.EXECUTE_SUCCESS, "执行成功了，哈哈");
    }
}
