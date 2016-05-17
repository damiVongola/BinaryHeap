/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Note: This class does not work, i couldnt get the heap to work. I tried my best but the insert and remove logic is beyond me
 */

/**
 * An implementation of a binary structure linked heap
 */
import java.util.Comparator;

/**
 *
 * @author Damilola
 * @param <K>
 * @param <V>
 */
public class BinaryHeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {

    /**
     * Linked Binary tree that holds elements
     */
    protected LinkedBinaryTree<Entry<K, V>> tree = new LinkedBinaryTree<>();

    /**
     * Creates an empty priority queue based on natural ordering of keys
     */
    public BinaryHeapPriorityQueue() {
        super();
    }

    /**
     * Creates an empty priority queue using given comparator to order keys
     * @param comp
     */
    public BinaryHeapPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    protected Entry<K, V> left(Position<Entry<K, V>> p) {
        return tree.left(p).getElement();
    }

    /**
     * Exchanges the entrieSs at indices i and j of the array list
     *
     * @param i
     * @param j
     */
    protected void swap(Position<Entry<K, V>> i, Position<Entry<K, V>> j) {
        Entry<K, V> temp = j.getElement();
        Entry<K, V> temp2 = i.getElement();
        tree.set(i, temp);
        tree.set(j, temp2);
    }

    /**
     * Moves the entry at index j higher, if necessary, to restore the heap
     * property
     *
     * @param v
     */
    protected void upheap(Position<Entry<K, V>> v) {
        Position<Entry<K, V>> u;
        while (!tree.isRoot(v)) {
            u = tree.parent(v);
            if (compare(u.getElement(), v.getElement()) <= 0) {
                break;
            }
            swap(u, v);
            v = u;
        }
    }

    /**
     * Moves the entry at index j lower, if necessary, to restore the heap
     * property
     *
     * @param e
     */
    protected void downheap(Position<Entry<K, V>> e) {

        while (tree.left(e) != getLastParent(tree.root, tree.height(tree.root))) {
            Position<Entry<K, V>> leftPosition = tree.left(e);
            Position<Entry<K, V>> smallChildPosition = leftPosition;
            //System.out.println(leftPosition.getElement().getValue());
            if (tree.right(e) != null) {
                Position<Entry<K, V>> rightPosition = tree.right(e);
                if (compare(leftPosition.getElement(), rightPosition.getElement()) > 0) {
                    smallChildPosition = rightPosition;
                }
            }
            if (compare(smallChildPosition.getElement(), e.getElement()) >= 0) {
                break;
            }
            swap(e, smallChildPosition);
            e = smallChildPosition;
        }

    }

    /**
     * Returns the number of items in the priority queue
     *
     * @return tree.size()
     */
    @Override
    public int size() {
        return tree.size();
    }

    /**
     * Gets the last parent of the tree
     *
     * @param p
     * @param height
     * @return right
     * @return left
     */
    protected Position<Entry<K, V>> getLastParent(Position<Entry<K, V>> p, int height) {
        height++;
        if (tree.left(p) == null || tree.right(p) == null) {
            return p;
        } else {
            int leftHeight = 0;
            int rightHeight = 0;
            Position<Entry<K, V>> left = getLastParent(tree.left(p), leftHeight);
            Position<Entry<K, V>> right = getLastParent(tree.right(p), rightHeight);
            if (leftHeight == rightHeight) {
                height += rightHeight;
                return right;
            } else {
                if (leftHeight > rightHeight) {
                    height += leftHeight;
                    return left;
                }
            }

        }
        return null;
    }

/**This was my best attempt at creating the insertion but it did not work*/
//    protected Position<Entry<K,V>>location(Position<Entry<K,V>> p,Entry<K,V> e){
//    
//    Position<Entry<K,V>> child;    
//   
//    double currentLevel=Math.floor(Math.log(tree.size())/Math.log(2));
//    double maxNodesLevel=Math.pow(2.0, currentLevel);
//    double maxNodesTree=Math.pow(2.0, currentLevel+1)-1;
//    double spotInLevel=maxNodesLevel-(maxNodesTree-tree.size());
//      
//      if(tree.left(p)!=null){
//        location(tree.left(p),e);
//      } 
//      
//      if(tree.right(p)!=null){
//        location(tree.right(p),e);
//      }
//      
//      
//      if(tree.left(p)==null||tree.right(p)==null){
//      if(spotInLevel%2==0){
//        child=tree.addRight(p, e);
//        return child;
//      } else{
//      
//         child=tree.addLeft(p, e);
//        return child;
//      }
//      }
//   return null;
//  }
    /**Returns(But does not remove) an entry with minimal key(if any)
     *@return tree.root().getElement()
     * 
     */
    @Override
    public Entry<K,V> min() {

        if (tree.isEmpty()) {
            return null;
        }
     
        return tree.root().getElement();
    }

    /**
     * Inserts new entry into our tree, and uses upheap to restore heap order
     * property
     *
     * @param key
     * @param value
     * @return newest
     */
    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K, V> newest = new PQEntry<>(key, value);
        if (tree.root == null) {
            tree.addRoot(newest);
        } else {

            Position<Entry<K, V>> t = getLastParent(tree.root(), tree.height(tree.root()));
            tree.set(t, newest);
            if(tree.left(t)==null){
             upheap(tree.addLeft(t, newest));
             
            } else{
              upheap(tree.addRight(t, newest));
               
            }
            //System.out.println(tree.parent(t).getElement().getValue());
        }
        return newest;
    }

    /**
     * Remove the entry with the minimal key from the tree
     *
     * @return temp
     */
    @Override
    public Entry<K, V> removeMin() {
        if (tree.isEmpty()) {
            return null;
        }
        Position<Entry<K, V>> answer = tree.root();
        Entry<K, V> temp = answer.getElement();
        Position<Entry<K, V>> last = getLastParent(tree.root, tree.height(tree.root));
        //System.out.println(tree.parent(last).getElement().getValue());
        if (tree.size() > 1) {
            swap(tree.root(), last);
            tree.remove(last);

            downheap(tree.root());
        }
        tree.remove(answer);
        return temp;
    }
}
