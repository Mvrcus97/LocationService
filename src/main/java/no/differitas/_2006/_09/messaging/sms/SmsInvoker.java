package no.differitas._2006._09.messaging.sms;

import com.sun.tools.internal.xjc.reader.xmlschema.BindGreen;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import java.io.ObjectStreamException;
import java.util.*;

public class SmsInvoker {

    SmsService_Service service;
    SmsService port;
    SubmitReq request;
    SubmitRsp response;

    public SmsInvoker(){

        this.service = new SmsService_Service();
        this.port = service.getSmsPort();
        this.request = new SubmitReq();
        this.response = new SubmitRsp();

    }

    public void sendMessage(String cref, String msIsdn, String username, String password){

       Address account = new Address();
       account.setValue("8419");

       Address originatingAddress = new Address();
       originatingAddress.setValue("QuizGame");

       Address destinationAddress = new Address();
       destinationAddress.setValue(msIsdn);

       Text text = new Text();
       text.setValue("Holaaa");

       Content content = new Content();
       content.getText().add(text);

       SubmitMessage message = new SubmitMessage();
        message.setCref(cref);
        message.setAccount(account);
        message.setDA(destinationAddress);
        message.setOA(originatingAddress);
        message.setContent(content);

        Map<String, Object> reqContext = ((BindingProvider) port).getRequestContext();
        reqContext.put(BindingProvider.USERNAME_PROPERTY, username);
        reqContext.put(BindingProvider.PASSWORD_PROPERTY, password);
        reqContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "https://api.messaging.telia.no/smsbulk/ws/v2");

        request.getSubmitMessage().add(message);
        try {
            port.submit(request);
        } catch (SmsServiceSubmitServerFaultFaultMessage smsServiceSubmitServerFaultFaultMessage) {
            smsServiceSubmitServerFaultFaultMessage.printStackTrace();
        } catch (SmsServiceSubmitValidationFaultFaultMessage smsServiceSubmitValidationFaultFaultMessage) {
            smsServiceSubmitValidationFaultFaultMessage.printStackTrace();
        }



    }

}
