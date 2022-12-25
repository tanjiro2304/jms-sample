package com.vn.jmssample.modules.receivemessage;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vn.jmssample.jms.MessageReceiver;
import com.vn.jmssample.mvputils.BasePresenter;
import com.vn.jmssample.mvputils.BaseView;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.JMSException;

@UIScope
@SpringComponent
public class ReceivedMessagePresenter extends BasePresenter<ReceivedMessageView> {

    @Autowired
    MessageReceiver messageReceiver;

    private String message;

    public String getMessage(){
        try {
            message = messageReceiver.receiveMessage();
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
        return message;
    }
}
