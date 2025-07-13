package javacore.concorrencia.service;

import javacore.concorrencia.dominio.Members;

public class EmailDeliveryService implements Runnable{
    private final Members members;

    public EmailDeliveryService(Members members) {
        this.members = members;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(STR."\{threadName} starting to deliver emails...");
        while (members.isOpen() || members.pendingEmails()>0){
            try {
                String email = members.retrieveEmail();
                if(email == null) continue;
                System.out.println(STR."\{threadName}  sending email to \{email}");
                Thread.sleep(2000);
                System.out.println(STR."\{threadName}  send email successfully \{email}");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("all emails were sent successfully!");
    }
}
