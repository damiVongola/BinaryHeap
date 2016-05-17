/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Damilola
 * @param <E>
 */
public interface Position<E> {
 /**
  *Returns the element stored at this position
  *
  *@return the sorted element
  *@throws IllegalStateException if position no longer valid
  */
    
    E getElement() throws IllegalStateException;
}
