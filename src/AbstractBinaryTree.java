/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Damilola
 * @param <E>
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {

    @Override
    /**Returns the Position of p's sibling(or null if no sibling exists)*/
    public Position<E> sibling(Position<E> p) {
        Position<E> parent = parent(p);
        if (parent == null) {
            return null;                           //p must be root
        }
        if (p == left(parent)) {                   //p is left child
            return right(parent);                  //(right child might be null)
        } else {                                   //p is right child
            return left(parent);                   //(left child might be null)
        }

    }
    /**Returns the number of children of Position p
     * @param p.
     * @return count */
    @Override
    public int numChildren(Position<E> p) {
        int count = 0;
        if (left(p) != null) {
            count++;
        }
        if (right(p) != null) {
            count++;
        }
        return count;
    }
    /**Returns an iterable collection of the Positions representing p's childre
     * @param p
     * 
     * @return snapshot */
    @Override
    public Iterable<Position<E>> children(Position<E> p) {
        List<Position<E>> snapshot = new ArrayList<>(2);
        if (left(p) != null) {
            snapshot.add(left(p));
        }
        if (right(p) != null) {
            snapshot.add(right(p));
        }
        return snapshot;
    }

    /**
     * Adds positions of the subtree rooted at Position p to the given snapshot
     */
    private void inorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        if (left(p) != null) {
            inorderSubtree(left(p), snapshot);
        }
        snapshot.add(p);
        if (right(p) != null) {
            inorderSubtree(right(p), snapshot);
        }
    }

    /**
     * Returns an iterable collection of positions of the tree, reported inorder
     * @return snapshot
     */
    public Iterable<Position<E>> inorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            inorderSubtree(root(), snapshot);          //fill the snapshot recursively
        }
        return snapshot;
    }

    /**
     * Overrides positions to make inorder the default order for binary trees
     * @return inorder()
     */
    @Override
    public Iterable<Position<E>> positions() {
        return inorder();
    }

}
