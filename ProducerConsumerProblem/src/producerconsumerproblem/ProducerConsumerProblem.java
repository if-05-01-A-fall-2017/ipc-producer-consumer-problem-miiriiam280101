/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumerproblem;

/**
 *
 * @author Miriam
 */
public class ProducerConsumerProblem {
    
    public static final int N = 50;
    public static int counter = 5;
    public static Producer producer = new Producer();
    public static Consumer consumer = new Consumer();
    public static void main(String[] args) {
       producer.start();
       consumer.start();  
   }
    public static void insert_item(int item){
        counter++;
    }
    public static void remove(){
        counter--;
    }
    
}
