package telia.cpa.location;

import no.differitas._2006._09.messaging.sms.*;


import javax.xml.ws.BindingProvider;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

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
        originatingAddress.setValue("QuizGame");
        updateLogin();
        System.out.println("client created");

    }

    public void updateLogin(){

        File txt = new File("src/main/java/telia/cpa/location/login");
        Scanner reader = null;
        try {
            reader = new Scanner(txt);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        username = reader.next();
        password = reader.next();

        //System.out.println("Username: " + username + ", password: " + password);

    }

    public void updateCref(){
        File txt = new File("src/main/java/telia/cpa/location/crefCounter");
        Scanner reader = null;
        try {
            reader = new Scanner(txt);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        this.cref = reader.next();


        int newCref = Integer.parseInt(cref) + 1;


        try {
            FileWriter fw = new FileWriter("src/main/java/telia/cpa/location/crefCounter");
            fw.write(String.valueOf(newCref));

            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //public void addMessage(Address cref, ){}

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

        Map<String, Object> reqContext = ((BindingProvider) port).getRequestContext();
        reqContext.put(BindingProvider.USERNAME_PROPERTY, username);
        reqContext.put(BindingProvider.PASSWORD_PROPERTY, password);
        reqContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "https://api.messaging.telia.no/smsbulk/ws/v2");

        request.getSubmitMessage().add(message);
        sendMessage();

    }

    public void sendMessage(){

        try {
          response =  port.submit(request);
        } catch (SmsServiceSubmitServerFaultFaultMessage smsServiceSubmitServerFaultFaultMessage) {
            smsServiceSubmitServerFaultFaultMessage.printStackTrace();
        } catch (SmsServiceSubmitValidationFaultFaultMessage smsServiceSubmitValidationFaultFaultMessage) {
            smsServiceSubmitValidationFaultFaultMessage.printStackTrace();
        }


        //response.getReportMessage().get(0);
        System.out.println("RESPONSE ERROR: " + response.getReportMessage().get(0).getStatus().getValue());
    }

}
