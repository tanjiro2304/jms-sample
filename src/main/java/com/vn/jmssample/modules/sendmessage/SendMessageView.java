package com.vn.jmssample.modules.sendmessage;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vn.jmssample.mvputils.BaseView;


@UIScope
@SpringComponent
@Route("")
public class SendMessageView extends BaseView<SendMessagePresenter> {

    private TextArea message;

    private Button sendButton;


    @Override
    protected void init() {
        message = new TextArea("Enter your Message");
        sendButton = new Button("Send");
        sendButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS,ButtonVariant.LUMO_PRIMARY);
        sendButton.addClickListener(event -> getPresenter().sendMessage(message.getValue()));
        add(message, sendButton);
    }
}
