/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Damilola
 * @param <K>
 * @param <V>
 */
public interface Entry<K,V> {
    K getKey();            //returns the key stored in this entry
    V getValue();          //returns the value stored in this entry
}
