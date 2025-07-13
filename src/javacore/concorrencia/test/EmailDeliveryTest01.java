package javacore.concorrencia.test;

import javacore.concorrencia.dominio.Members;
import javacore.concorrencia.service.EmailDeliveryService;

import javax.swing.*;

public class EmailDeliveryTest01 {
    public static void main(String[] args) {
        // os métodos await, signal e signalAll são utilizados com a classe Condition que necessita de ter um lock
        Members members = new Members();
        Thread jiraya = new Thread(new EmailDeliveryService(members), "Jiraya");
        Thread iruka = new Thread(new EmailDeliveryService(members), "Iruka");
        Thread kakashi = new Thread(new EmailDeliveryService(members), "Kakashi");
        jiraya.start();
        iruka.start();
        kakashi.start();
        while(true){
            var email = JOptionPane.showInputDialog("Enter with email");
            if(email == null || email.isEmpty()){
                members.close();
                break;
            }
            members.addMemberEmail(email);
        }
    }
}
