package com.vn.jmssample.modules.receivemessage;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vn.jmssample.jms.MessageReceiver;
import com.vn.jmssample.mvputils.BaseView;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.JMSException;

@UIScope
@SpringComponent
@Route("/message")
public class ReceivedMessageView extends BaseView<ReceivedMessagePresenter> {

    Label message;



    @Override
    protected void init() {
        message = new Label(getPresenter().getMessage());
        message.setTitle("Received Message");
        message.setEnabled(false);
        add(message);
    }
}
