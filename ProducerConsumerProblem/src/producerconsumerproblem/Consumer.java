/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumerproblem;

import java.util.logging.Level;
import java.util.logging.Logger;
import static producerconsumerproblem.ProducerConsumerProblem.*;
/**
 *
 * @author Miriam
 */
public class Consumer extends Thread{

    @Override
    public void run() {
        int item = 0;
       while (true) {
            System.out.println("Consumer awake");
            if (counter <= 0) {
                System.out.println("Consumer sleeps");
                try {
                    synchronized(this){
                        wait();
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            remove();
            if (counter >= N-1) {
                synchronized(producer){
                    producer.notify();
                }
            }
        } 
    }
    
}
