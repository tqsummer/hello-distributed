package com.study.hello.distributed.rocketmq.api.quickstart;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @author : fangxiangqian
 * @created : 2023/11/1
 **/
public class Producer {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("test_quick_producer_name");
        producer.setNamesrvAddr("192.168.31.61:9876");
        producer.start();
        for (int i = 0; i < 2; i++) {
            Message message = new Message("TopicTest", "TagA", ("hello rocketmq " + i).getBytes());
            message.setKeys("test_producer" + i);
            /**
             * 方式一：单向发送消息，没有任何返回结果，性能最高，可靠性最低
             */
            //producer.sendOneway(message);
            /**
             * 方式二：同步发送消息，返回结果，性能较高，可靠性较高
             */
            SendResult sendResult = producer.send(message);
            /**
             * 方式三：异步发送消息，性能较高，可靠性较低
             */
            /*producer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.println(sendResult);
                }

                @Override
                public void onException(Throwable throwable) {
                    throwable.printStackTrace();
                }
            });*/

            System.out.println(sendResult);
            Thread.sleep(1000);
        }
        producer.shutdown();
    }
}
