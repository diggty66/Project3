package apps;

import adts.*;

public class PlayWithLists {

	public static void main(String[] args) {
		
		/**/
		ArrayBasedList<String> list1 = new ArrayBasedList<String>();
	      
	    list1.add("Dykstra");
		list1.add("Wirth");
	    list1.add("Dahl");
	    list1.add("Nygaard");
	    list1.add("Liskov");
	    list1.add("DePasquale");

	    System.out.println("\nComputer Scientists: "+list1);
	      
		ArrayBasedList<Integer> list2 = new ArrayBasedList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			list2.add(i);
		}
		      
	    System.out.println("\nDecimal Digits: "+list2);
	    
	    System.out.println(list2.remove(0) ? "0 removed" : "0 not found on the list");
	    System.out.println(list2.remove(2) ? "2 removed" : "2 not found on the list");
	    System.out.println(list2.remove(4) ? "4 removed" : "4 not found on the list");
	    System.out.println(list2.remove(6) ? "6 removed" : "6 not found on the list");
	    System.out.println(list2.remove(8) ? "8 removed" : "8 not found on the list");
	    System.out.println(list2.remove(0) ? "0 removed" : "0 not found on the list");
	    System.out.println(list2.remove(4) ? "4 removed" : "4 not found on the list");
	    

	    System.out.println("\nDecimal Digits after removing evens: "+list2);
	    
	    System.out.println("\nDecimal Digits traversal, started with resetIterator():");
		list2.resetIterator();
		System.out.println("getNextItem(): " + list2.getNextItem());
		System.out.println("getNextItem(): " + list2.getNextItem());
		System.out.println("getNextItem(): " + list2.getNextItem());
		System.out.println("getNextItem(): " + list2.getNextItem());
		System.out.println("getNextItem(): " + list2.getNextItem());
	    
	    System.out.println("\nDecimal Digits second traversal:");
		list2.resetIterator();
		int counter = 1;
		while (counter <= list2.size()) {
			System.out.println("getNextItem(): " + list2.getNextItem());
			counter++;
		}
		
		// remove all of the items from the list
		while (!list2.isEmpty()) {
			list2.resetIterator();
			list2.remove(list2.getNextItem());
		}
	    System.out.println("\nWhere have all the digits gone?"+list2);
		
		
	}
      
}
