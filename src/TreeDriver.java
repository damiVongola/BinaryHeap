/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * This class is meant to test the LinkedBinaryTree class we have created
 */

/**
 *
 * @author Damilola
 */
public class TreeDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    // TODO code application logic here
        
    LinkedBinaryTree<String> tree=new LinkedBinaryTree<> ();
    //We are making "Providence" the root
    Position root=tree.addRoot("Providence");
    //We are adding Chicago to the left of the root
    Position rootLeft=tree.addLeft(root,"Chicago");
    //We are adding Seattle to the right of the root
    Position rootRight=tree.addRight(root,"Seattle");
    
    Position rootLeft2=tree.addLeft(rootLeft, "Baltimore");
    
    Position rootRight2=tree.addRight(rootLeft, "New York");
    
   
    //Here we are going through the tree and printing te elements
    for(Position<String> p:tree.postorder()){
    System.out.println(p.getElement());
    }
    }
    
}
