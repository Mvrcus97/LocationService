package no.telia.cpa.location.server;

import no.differitas._2006._09.messaging.sms.SmsCallbackService;
import no.differitas._2006._09.messaging.sms.SmsCallbackService_Service;

import javax.xml.ws.Endpoint;

public class CallbackServer{



    public static void main(String[] args) {

        SmsCallbackService_Service service = new SmsCallbackService_Service();
        SmsCallbackService port = service.getSmsCallbackPort();


    }

}