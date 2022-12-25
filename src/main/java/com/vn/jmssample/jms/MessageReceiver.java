package com.vn.jmssample.jms;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.jms.*;

@Service
public class MessageReceiver {

    private String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    private String queueName = "MESSAGE_QUEUE";

    private Message message;

    private Connection connection;

    private Session session;

    private Destination destination;

    private MessageConsumer consumer;

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

    public String receiveMessage() throws JMSException {
        try {
            destination = session.createQueue(queueName);
            consumer = session.createConsumer(destination);
            message = consumer.receive();
            if(message instanceof  TextMessage){
                textMessage = (TextMessage) message;
            }
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
        return textMessage.getText();
    }
}
