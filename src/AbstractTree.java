
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
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
public abstract class AbstractTree<E> implements Tree<E> {

    @Override
    /**Checks whether a position has children*/
    public boolean isInternal(Position<E> p) {
        return numChildren(p) > 0;
    }

    @Override
    /**Checks whether a position does not have children*/
    public boolean isExternal(Position<E> p) {
        return numChildren(p) == 0;
    }

    @Override
    public boolean isRoot(Position<E> p) {
        return p == root();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Adds positions of the subtree rooted at Position
     */
    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        snapshot.add(p);
        for (Position<E> c : children(p)) {
            preorderSubtree(c, snapshot);
        }
    }

    /**
     * Returns an iterable collection of positions
     * @return snapshot
     */
    public Iterable<Position<E>> preorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            preorderSubtree(root(), snapshot); //fill the snapshot recursively
        }
        return snapshot;
    }

    public Iterable<Position<E>> positions() {
        return preorder();
    }

    //-------------------nested ElementIterator class-------------------
    /*This class adapts the iteration produced by positions() to return elements*/
    private class ElementIterator implements Iterator<E> {

        Iterator<Position<E>> postIterator = positions().iterator();

        public boolean hasNext() {
            return postIterator.hasNext();
        }

        public E next() {
            return postIterator.next().getElement();
        }//return element

        public void remove() {
            postIterator.remove();
        }
    }

    /**
     * Returns an iterator of the elements stored in the tree
     */
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    /**
     * Adds positions of the subtree rooted at Position p to the given snapshot
     */
    private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        for (Position<E> c : children(p)) {
            postorderSubtree(c, snapshot);
        }
        snapshot.add(p);             //for postorder, we add position p after exploring subtrees
    }
    /**Returns an iterable collection of positions of the tree, reported in postorder*/
    public Iterable<Position<E>> postorder(){
    List<Position<E>> snapshot=new ArrayList<>();
    if(!isEmpty())
        postorderSubtree(root(),snapshot);    //fill the snapshot recursively
    return snapshot;
    }
    /**Returns the height of the subtree rooted at Position p.*/
    public int height(Position<E> p){
    int h=0;
    for(Position<E> c:children(p))
        h=Math.max(h, 1+height(c));
    return h;
    }
    /**Returns the number of levels separating Position p from the root*/
    public double depth(Position<E> p){
    if(isRoot(p))
    return 0;
    else
        return 1+depth(parent(p));
    }   
}
