/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * This class was supposed to shw the use of the priority queue but as i could not implement the priority queue, i cannot properly demonstrate all its methods
 */

/**
 * Name: Aleshinloye Damilola
 * StudNo: 3050957
 * @author Damilola
 */
public class Airline {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    //initializing and adding passengers of a flight
    BinaryHeapPriorityQueue<Integer,String>  heap= new BinaryHeapPriorityQueue<> ();
    heap.insert(1, "Dami");
    heap.insert(2, "Dare");
    heap.insert(3, "Damola");
    heap.insert(4, "Dayo");

    System.out.println(heap.size());
   
    System.out.println(heap.min().getValue());
 //   System.out.println(heap.removeMin().getValue());
//    System.out.println(heap.removeMin().getValue());
//    System.out.println(heap.removeMin().getValue());
     System.out.println(heap.size());
     
    }
    
}
