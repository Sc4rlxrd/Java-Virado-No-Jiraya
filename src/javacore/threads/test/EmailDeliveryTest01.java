package javacore.threads.test;

import javacore.threads.dominio.Members;
import javacore.threads.service.EmailDeliveryService;

import javax.swing.*;

public class EmailDeliveryTest01 {
    public static void main(String[] args) {
        // os métodos wait, notify e notifyAll necessita estar num bloco synchronized para funcionar
        Members members = new Members();
        Thread jiraya = new Thread(new EmailDeliveryService(members), "Jiraya");
        Thread iruka = new Thread(new EmailDeliveryService(members), "Iruka");
        Thread kakashi = new Thread(new EmailDeliveryService(members), "Kakashi");
        jiraya.start();
        iruka.start();
        kakashi.start();
        while(true){
            var email = JOptionPane.showInputDialog("Entre com o email");
            if(email == null || email.isEmpty()){
                members.close();
                break;
            }
            members.addMemberEmail(email);
        }
    }
}
