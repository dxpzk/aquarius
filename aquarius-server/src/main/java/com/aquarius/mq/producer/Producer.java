package com.aquarius.mq.producer;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zk
 * @since 2020-03-16
 */
@Component
public class Producer {
    @Autowired
    private DefaultMQProducer defaultMQProducer;

    public void producer() {

        String msg = "aaa";
        Message sendMsg = new Message("aquarius","DemoTag",msg.getBytes());
        //默认3秒超时
        try {
            SendResult sendResult = defaultMQProducer.send(sendMsg);

            System.out.println(sendResult);
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.err.println("发送成功...");

    }
}
