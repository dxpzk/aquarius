//package com.aquarius.config;
//
//import com.github.ltsopensource.core.listener.MasterChangeListener;
//import com.github.ltsopensource.jobclient.JobClient;
//import com.github.ltsopensource.spring.JobClientFactoryBean;
//import com.github.ltsopensource.spring.TaskTrackerAnnotationFactoryBean;
//import com.github.ltsopensource.spring.tasktracker.JobDispatcher;
//import com.github.ltsopensource.tasktracker.TaskTracker;
//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Properties;
//
///**
// * @author zk
// * @since 2020-03-16
// */
//@Configuration
//public class LTSSpringConfig  implements ApplicationContextAware {
//    private ApplicationContext applicationContext;
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.applicationContext = applicationContext;
//    }
//    @Bean(name = "taskTracker")
//    public TaskTracker getTaskTracker() throws Exception {
//        TaskTrackerAnnotationFactoryBean factoryBean = new TaskTrackerAnnotationFactoryBean();
//        factoryBean.setApplicationContext(applicationContext);
//        factoryBean.setClusterName("test_cluster");
//        factoryBean.setJobRunnerClass(JobDispatcher.class);
//        factoryBean.setNodeGroup("test_trade_TaskTracker");
//        factoryBean.setBizLoggerLevel("INFO");
//        factoryBean.setRegistryAddress("zookeeper://127.0.0.1:2181");
////        factoryBean.setMasterChangeListeners(new MasterChangeListener[]{
////                new MasterChangeListenerImpl()
////        });
//        factoryBean.setWorkThreads(20);
//        Properties configs = new Properties();
//        configs.setProperty("job.fail.store", "leveldb");
//        factoryBean.setConfigs(configs);
//
//        factoryBean.afterPropertiesSet();
////        factoryBean.start();
//        return factoryBean.getObject();
//    }
//}