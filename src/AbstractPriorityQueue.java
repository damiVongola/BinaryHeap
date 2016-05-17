/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Comparator;


/**
 *
 * @author Damilola
 *
 */
/**An abstract base class to assist implementations of the PriorityQueue interface
 * @param <K>e
 * @param <V>*/
public abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V>{

 protected static class PQEntry<K,V> implements Entry <K,V>{
  private K k;  //key   
 private V v;   //value
 public PQEntry(K key, V value){
 k=key;
 v=value;
 }
 //methods of Entry interface
  @Override
  /**@return k*/
 public K getKey(){
     return k;
 }
 /**@return v*/
  @Override
 public V getValue(){
     return v;
 }
 //utilities not exposed as part of the Entry interface
 protected void setKey(K key){k=key;}
 protected void setValue(V value){v=value;}
 } //-----------end of nested PQEntry class--------
 
 //instance variable for an AbstractProrityQueue
 /**The comparator defining the ordering of keys in the priority queue. */
 private Comparator<K> comp;
 /**Creates an empty prority queue using the given comparator to order key
     * @param c*/
 protected AbstractPriorityQueue(Comparator<K> c){comp=c;}
 /**Creates an empty priority queue based on the natural ordering of its keys*/
 protected AbstractPriorityQueue(){this(new DefaultComparator<K>());}
 /**Method for comparing two entries according to key*/

    /**
     * Method for comparing two entries according to key
     * @param a
     * @param b
     * @return comp.compare(a.getKey(), b.getKey())
     */
    protected int compare(Entry<K,V> a, Entry<K,V> b){
 return comp.compare(a.getKey(), b.getKey());
 }
 /**Determines whether a key is valid
     * @param key.
     * @return */
 protected boolean checkKey(K key) throws IllegalArgumentException{
 try
 {
   return(comp.compare(key, key)==0); //see if key can be compared to itself
 
 } catch(ClassCastException e){
   throw new IllegalArgumentException("Incompatble key");
 }
 }
 /**Tests whether the priority queue is empty
     * @return size()==0*/
 @Override
 public boolean isEmpty(){return size()==0;}
 }
