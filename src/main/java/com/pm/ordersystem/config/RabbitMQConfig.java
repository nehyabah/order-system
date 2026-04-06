package com.pm.ordersystem.config;



import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

@Configuration
public class RabbitMQConfig {

    public static final String  EXCHANGE =  "order.exchange";
    public static final String  EMAIL_QUEUE = "order.email.queue";
    public static final String  ORDER_INVENTORY_QUEUE = "order.inventory.queue";
    public static final String NOTIFICATION_QUEUE = "order.notification.queue";
    public static final String ROUTING_KEY = "order.placed";

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Queue emailQueue() {
        return new Queue(EMAIL_QUEUE);
    }

    @Bean
    public Queue inventoryQueue() {
        return new Queue(ORDER_INVENTORY_QUEUE);
    }
    @Bean
    public Queue notificationQueue() {
        return new Queue(NOTIFICATION_QUEUE);
    }

    @Bean
    public Binding emailBinding(Queue emailQueue, TopicExchange exchange) {
        return BindingBuilder.bind(emailQueue).to(exchange).with(ROUTING_KEY);
    }

    @Bean
    public Binding inventoryBinding(Queue inventoryQueue, TopicExchange exchange) {
        return BindingBuilder.bind(inventoryQueue).to(exchange).with(ROUTING_KEY);
    }

    @Bean
    public Binding notificationBinding(Queue notificationQueue, TopicExchange exchange) {
        return BindingBuilder.bind(notificationQueue).to(exchange).with(ROUTING_KEY);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new JacksonJsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }

}
