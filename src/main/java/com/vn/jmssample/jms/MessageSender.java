package com.vn.jmssample.jms;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.jms.*;

@Service
public class MessageSender {

    private final String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    private final String queueName = "MESSAGE_QUEUE";

    private String message;

    private Connection connection;

    private Session session;

    private Destination destination;

    private MessageProducer producer;

    private TextMessage textMessage;

    @PostConstruct
    public void createConnection(){

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);


        } catch (JMSException e) {
            throw new RuntimeException(e);
        }


    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void sendMessage(){
        try {
            destination = session.createQueue(queueName);
            producer = session.createProducer(destination);
            textMessage = session.createTextMessage(this.message);
            producer.send(textMessage);

        } catch (JMSException e) {
            throw new RuntimeException(e);
        }

    }
}
