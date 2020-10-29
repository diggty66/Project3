# Project3
List ADT Implementation Group Project

Create a sorted list ADT that implements the Unit 3 ListInterface.java, using a doubly linked list as the underlying data structure.

No changes to ListInterface.java are to be made.

In addition to the operations specified in ListInterface.java, a backwards iterator will also be supported by implementing the following two methods:

void resetBackIterator();

set the current position for getPrevItem() to the last item on the list
E getPrevItem();

return the item at the current (backwards) iterator position on this list
update the current pointer to point to the previous item on the list
if the item returned is the first item on the list, set the value of the current position to the last item on the list
the current position for iterating backwards must be maintained separately from the current position for iterating forwards
preconditions in ListInterface.java for forwards iterator applies to the backwards iterator, with appropriate adjustments
A toString() method must also be developed.

find() and find2() helper methods must be developed. The remove, contains and get operations will make use of these methods to determine whether a given element appears on the list. The element to be searched for will be provided as an argument and two instance variables will be set to indicate the result of the search: found will be set to true or false, accordingly, and if found is true, then location will be set to point to the first instance on the list of a match. Note: if found is false, then the value of location is meaningless and cannot be used.

find() will use a linear search and find2() will use a binary search. In order to do a binary search, the data in the list must be put into an array. Each time find2() is called it will check a status instance variable that will indicate whether any changes to the list have been made since the previous call to find2(). If any changes have occurred, an array of the appropriate size must be instantiated and populated with the current contents of the list. If no changes have been made, the existing array will be used.

In addition to testing the ADT to verify that all of the operations have been properly implemented, each team must execute performance testing to demonstrate the execution efficiency of the find helper methods. This performance testing must use java.lang.System.nanoTime( ), or some other timing method, to measure how long operations take using find() vs. find2(). This performance testing must be consistent with the PP#3 - List ADT Implementation - Linear vs. Binary Search Test Plan submission, provided that a satisfactory plan was developed. Each team must execute enough trials against a sufficiently large list or lists in order to be confident in the results produced.   

A performance testing report must be submitted. This report must include the timing results and appropriate statistics about that data.
