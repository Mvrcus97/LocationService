package no.telia.cpa.location.clients;

//import com.sun.tools.internal.xjc.reader.xmlschema.BindGreen;
import no.differitas._2006._09.messaging.sms.*;


import javax.xml.ws.BindingProvider;
import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

/* This class represents a SOAP Client. Used to communicate with the SMS BULK API.
 *
 * REMEMBER* To change the path of loginSms.txt and crefCounter.txt to your correct path.
 *
 * - loginSms.txt includes the loginSms credentials for the basic authentication in 2 lines of text:
 *      -username
 *      -password
 *
 * - crefCounter.txt includes a single number used to represent the next cref-value.
 *   For each run, the crefCounter.txt is read and updated. This is to simulate a unique
 *   cref for each call to the API. The crefCounter.txt could be changed manually to
 *   any number, preferably larger than 1000.
 *
 *
 */


public class SmsInvoker {

    SmsService_Service service;
    SmsService port;
    SubmitReq request;
    SubmitRsp response;
    Address account;
    Address originatingAddress;
    String cref;
    String username;
    String password;

    public SmsInvoker(){
        this.service = new SmsService_Service();
        this.port = service.getSmsPort();
        this.request = new SubmitReq();
        this.response = new SubmitRsp();
        this.account = new Address();
        account.setValue("8419");
        this.originatingAddress = new Address();
        originatingAddress.setValue("HintSprint");
        updateLogin();
        //System.out.println("client created");

    }

    public void updateLogin(){
        InputStream in = getClass().getResourceAsStream("/loginSms");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        try {
            username = reader.readLine();
            password = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Object> reqContext = ((BindingProvider) port).getRequestContext();
        reqContext.put(BindingProvider.USERNAME_PROPERTY, username);
        reqContext.put(BindingProvider.PASSWORD_PROPERTY, password);
        reqContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "https://api.messaging.telia.no/smsbulk/ws/v2");

    }

    public void updateCref(){
        //New UUID:
        UUID uuid = UUID.randomUUID();
        this.cref = uuid.toString();
    }//end updateCref


    //Update the request to contain information of the next text-message, including recipient(s) and message.
    public void addMessage(String msIsdn, String textToSend){
        request = new SubmitReq();
        Address destinationAddress = new Address();
        destinationAddress.setValue(msIsdn);

        Text text = new Text();
        text.setValue(textToSend);

        Content content = new Content();
        content.getText().add(text);

        updateCref();

        SubmitMessage message = new SubmitMessage();
        message.setCref(cref);
        message.setAccount(account);
        message.setDA(destinationAddress);
        message.setOA(originatingAddress);
        message.setContent(content);

        request.getSubmitMessage().add(message);
        sendMessage();
    }//end addMessage

    public void sendMessage(){
        try {
          response = port.submit(request);
        } catch (SmsServiceSubmitServerFaultFaultMessage smsServiceSubmitServerFaultFaultMessage) {
            smsServiceSubmitServerFaultFaultMessage.printStackTrace();
        } catch (SmsServiceSubmitValidationFaultFaultMessage smsServiceSubmitValidationFaultFaultMessage) {
            smsServiceSubmitValidationFaultFaultMessage.printStackTrace();
        }


        String response_s = response.getReportMessage().get(0).getStatus().getValue();
    }//end sendMessage
}//end SmsInvoker
