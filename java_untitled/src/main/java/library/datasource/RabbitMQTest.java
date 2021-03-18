package library.datasource;

import com.rabbitmq.client.*;
import org.junit.jupiter.api.Test;

public class RabbitMQTest {

    @Test
    public void test() {
        try {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setUsername("guest");
            connectionFactory.setPassword("guest");
            connectionFactory.setHost("127.0.0.1");
            connectionFactory.setPort(5672);
            connectionFactory.setVirtualHost("/");
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();

            String exchange = "exchange";
            String queue = "queue";
            String routingKey = "routingKey";
            String message = "message";
            channel.queueDeclare(queue, false, false, false, null); /* 创建队列 */
            /* fixme 绑定exchange/queue */
            channel.basicPublish(exchange, routingKey, null, message.getBytes()); /* 发布消息 */
            /* 消费消息 */
            channel.basicConsume(queue, true, new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) {
                    System.out.println(new String(body));
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
