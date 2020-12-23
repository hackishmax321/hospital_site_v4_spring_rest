package com.hello.FirstApp.functionalities;

import com.sun.xml.internal.org.jvnet.mimepull.MIMEMessage;
import sun.plugin2.message.Message;

import javax.websocket.Session;
import java.util.ArrayList;

public class EmailGen {
    private boolean sendEmail(String from, ArrayList<String> toList, ArrayList<String> ccList,
                              ArrayList<String> bccList, String subject, String messageBody, Session ses) {

        try {
//            sendMail(toList.get(0), subject, messageBody);
            Session mailnoreplygrasshopperslk = ses;//getMailnoreplygrasshopperslk();
//            Message message = new MIMEMessage(mailnoreplygrasshopperslk);
//
////////////////////////////////////////////////
//            /////////////////// Set Sent Date /////////////////
//            message.setSentDate(new Date());
//            //////////////////////////////////////////////
//            /////////////// Add Recipients ///////////////
//            InternetAddress[] addressTo = new InternetAddress[toList.size()];
//            InternetAddress[] addressCC = new InternetAddress[ccList.size()];
//            InternetAddress[] addressBCC = new InternetAddress[bccList.size()];
//            for (int idx = 0; idx < addressTo.length; idx++) {
//                addressTo[idx] = new InternetAddress(toList.get(idx));
//            }
//            for (int idx = 0; idx < addressCC.length; idx++) {
//                addressCC[idx] = new InternetAddress(ccList.get(idx));
//            }
//            for (int idx = 0; idx < addressBCC.length; idx++) {
//                addressBCC[idx] = new InternetAddress(bccList.get(idx));
//            }
//
//            InternetAddress addressFrom = new InternetAddress(from);
//            message.setFrom(addressFrom);
//            message.setRecipients(Message.RecipientType.TO, addressTo);
//            message.setRecipients(Message.RecipientType.CC, addressCC);
//            message.setRecipients(Message.RecipientType.BCC, addressBCC);
//            //////////////////////////////////////////////
//            message.addHeader("site", "https://www.gmail.com");
//            ///////////////   Set Subject  ///////////////
//            message.setSubject(subject);
//            ///////////////////////////////////////////////////////////////////////////////
//            //////////////////////////////   Set Body Start  //////////////////////////////
//            MimeMultipart mimeMultipart = new MimeMultipart();
//            ///////////////   Set Message ///////////////
//            BodyPart messageBodyPart = new MimeBodyPart();
//            messageBodyPart.setContent(messageBody, "text/html; charset=utf-8");
//            mimeMultipart.addBodyPart(messageBodyPart);
//            //////////////////////////////   Set Body End  //////////////////////////////
//            /////////////////////////////////////////////////////////////////////////////
//            message.setContent(mimeMultipart);
//            Transport transport = ses.getTransport();
//            transport.connect();
//            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
//            transport.close();
//            Transport.send(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("MessagingException : " + e);
            return false;
        }
    }
}
