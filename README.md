# BinaryHeap
This program is supposed to use a provided Linked Binary Tree to create a Binary Heap that we can use as an Adaptable Priority Queue (Incomplete)
----------------------------
Complete Program Description
----------------------------
This program uses a Linked Binary tree to create a Binary heap that can be used in developing an airline priority queue. The LinkedBinaryTree uses
nodes to store references and elements. The objects that are used for storage are entries that exist as a pair of keys and values. And we use position
objects as an abstraction of location. This program is incomplete at the moment, i have not managed to finish the deletion of entries in the priority queue
--------
Classes
--------
AbstarctBinaryTree,
AbstractPriorityQueue,
AbstractTree,
Airline(incomplete),
BinaryHeapPriorityQueue(Close logically but incomplete),
BinaryTree,
DefaultComparator,
Entry,
LinkedBinaryTree,
Position,
PriorityQueue,
Tree,
TreeDriver
------------------
Class Descriptions
------------------
AbstractBinaryTree: This is an abstract class that creates a base for the linkedBinaryTree to be made off. left and right children are described with position objects. 
This class also has an inordertraversal class that traverses through the through the tree using an in order traversal. Source: Data Strctures and algorithms in Java by wiley
AbstractPriorityQueue: This is an abstract class that creates a base for the Priority Queue to be made off. It implements the Entry interface and gets and set the element and key pairs.
There is also a checkKey() method that verifes that a key is valid. Source: Data Strctures and algorithms in Java by wiley
AbstractTree:This is an abstract class that creates a base for a general tree to be made off. Source: Data Strctures and algorithms in Java by wiley
Airline: This class was suppossed to model an airline application that added entries to the priority queue with their respective keys. And removed the element/passenger with the highest 
priority. However i could not complete it due to the fact i cannot finish the binary heap
BinaryHeapPriorityQueue: This is suppossed to be the priority queue that will be created, using the LinedBinaryTree to create the heap. I could not complete this because i failed at implementing
an efficient removal method for the element with the highest priority. 
BinaryTree: An interface for a binary tree, in which each node has at most two children.Source: Data Strctures and algorithms in Java by wiley
DefaultComparator: This is a comparator that is used by the binary heap to determine the priority of the keys. It is default in case a person does not pass in their ow way of comparison.Source: Data Strctures and algorithms in Java by wiley
Entry: These are the objects that are stored in the Priority Queue.Source: Data Strctures and algorithms in Java by wiley
LinkedBinaryTree: This is a binary tree implementation that used a doubly linked list that uses nodes to store references and elements. This class is to be used to create the BinaryHeap. Source: Data Strctures and algorithms in Java by wiley
Position: This object will abstract location of elements in the any of the data structures.Source: Data Strctures and algorithms in Java by wiley
PriorityQueue: Interface for the priority queue ADT.Source: Data Strctures and algorithms in Java by wiley
Tree:An interface for a tree where nodes can have an arbitrary number of children.Source: Data Strctures and algorithms in Java by wiley
TreeDriver: This class uses the LinkedBinaryTree class to make sure everything works properly.

