package com.ibrahim.sr.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    @Value("${sr.rabbit.queue.name}") //application.properties dosyasinda yazdigimiz degiskenler otomatik bunlara atanacak
    private String queueName;

    @Value("${sr.rabbit.routing.name}")
    private String bindingName;

    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;

    @Autowired
    private RabbitTemplate rabbitTemplate; //rabbit kuyruguna gitmek icin kullaniriz

    @Bean //yani bu instance i baska yerlerde kullanacagiz
    public Queue queue(){
        return new Queue(queueName);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(exchangeName);
    }

    @Bean
    public Binding binding(final Queue queue, final DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with(bindingName); //kuyrugu exchane e bagli onuda routing name ile yonet
    }



}
