package com.vn.jmssample.modules.sendmessage;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vn.jmssample.jms.MessageSender;
import com.vn.jmssample.mvputils.BasePresenter;
import org.springframework.beans.factory.annotation.Autowired;


@UIScope
@SpringComponent
public class SendMessagePresenter extends BasePresenter<SendMessageView> {
    @Autowired
    MessageSender messageSender;
    public void sendMessage(String message){
        messageSender.setMessage(message);
        messageSender.sendMessage();
    }

}
