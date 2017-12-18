/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumerproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static producerconsumerproblem.ProducerConsumerProblem.*;


/**
 *
 * @author Miriam
 */
public class Producer extends Thread{

    @Override
    public void run() {
        int item = 0;
        while (true) {
            item = produce();
            if (counter >= N) {
                System.out.println("Producer sleeps");
                try {
                    synchronized(this){ wait(); }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            insert_item(item);
            if (counter >= 1) {
               synchronized(consumer){ 
                   consumer.notify();
               }
            }
        }
    }  
    int produce(){
        return counter++;
    }
    
}
