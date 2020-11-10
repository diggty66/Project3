package src.apps;

import src.adts.DoublyLinkedList;


public class PlayWithLists {

	public static void main(String[] args) {
		
		/**/
		DoublyLinkedList<String> list1 = new DoublyLinkedList<String>();
	      
	    list1.add("Dykstra");
		list1.add("Wirth");
	    list1.add("Dahl");
		list1.add("Nygaard");
		list1.add("orange");
	    list1.add("Liskov");
	    list1.add("DePasquale");

	    System.out.println("\nComputer Scientists: "+list1);
	      
		DoublyLinkedList<Integer> list2 = new DoublyLinkedList<Integer>();
		
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
			list2.remove(list2.getNextItem());
		}
	    System.out.println("\nWhere have all the digits gone?"+list2);
		
		//Reset()
		//test 1 Iterator position set at the first item on the list
		list1.resetIterator();
		//Called for the resetIterator() method
		System.out.println(list1.getNextItem());
		//Iterator position was correctly set at first item on list

		//test 2 Iterator position set at the first item on the list
		list1.resetBackIterator();
		//Called for the resetBackIterator() method
		System.out.println(list1.getPrevItem());
		//Iterator position was correctly set at last item on list

		//getNext()
		//test 1 Get next element in a list
		//Forward iterator until “orange” found
		while(list1.getNextItem() != "orange"){
			list1.getNextItem();
		}
		list1.getPrevItem();
		System.out.println("\nnext item is orange: " + list1.getPrevItem());

		//getPrev()
		//test 1 Get previous element in a list
		//Reverse iterator until “orange” found
		list1.resetIterator();
		// reset so organe is infront of current location to test wrapping
		while(list1.getPrevItem() != "orange"){
			list1.getPrevItem();
		}
		list1.getNextItem();
		System.out.println("\nnext item is orange: " + list1.getNextItem());

		//Add()

		// test 1 Adding an item to a list that is empty.
		DoublyLinkedList<String> addTest = new DoublyLinkedList<String>();
		addTest.add("Mercedes GLK.");
		//Item is added to the list.
		System.out.println(addTest);

		// test 2 Adding an item that is already on the list
		addTest.add("BMW");
		addTest.add("BMW");
		System.out.println(addTest);
		//BMW is on the list twice 
		
		//Test 3 Add to the end of the list.

		addTest.add("Audi TT");
		System.out.println(addTest);
		// added item is at the back of the list

		//contains

		//test 1 Looks to see if the List contains an element

		System.out.println("should return true: "+addTest.contains("Mercedes GLK."));
		//Ask if the list contains “Mercedes GLK.” should return true

		// test 2 Ask if the list contains "aplha" should return false 
		System.out.println("should return false: " + addTest.contains("aplha"));	
	 
		
		//test 3 Ask if the list contains “alpha”, with an empty list
		while(!list1.isEmpty()){
			list1.resetIterator();
			list1.remove(list1.getNextItem());
		}
		System.out.println("should return false: " + list1.contains("aplha"));
		//should return false 

		//test 4 Ask if an int list with 1 in it contains 1
		for(int i = 0; i < 10; ++i){
			list2.add(i);
		}
		System.out.println("should return true: " + list2.contains(1));
		//should return true

		// test 5 ask int list without 11 if it contains 11
		System.out.println("should return false: " + list2.contains(11));
		//should return false 

		//test 6 Ask if the list contains “alpha”, with list of int that has numbers in the list
		String string = "aplha";
		try{
		System.out.println(list2.contains(Integer.parseInt(string)));
		}
		catch(NumberFormatException e){
			System.out.println(e);
		}
		// Return error 

		//test 7 ask list of strings if it contains 1
		// cannot cast int to string 
		
		// Get 
		// Test 1 Get orange from on the list with orange on it 
		addTest.add("orange");
		String returned = addTest.get("orange");
		System.out.println(returned + " is returned and the list is unchanged: " + addTest);

		//Test 2 Get a nonexistent item from the list
		returned = addTest.get("onion");
		System.out.println("a nonexistent get looks like: " + returned);

		// Test 3 Get an item from an empty list
		DoublyLinkedList<String> emptyList = new DoublyLinkedList<String>();
		returned = emptyList.get("apple");
		System.out.println("a nonexistent get looks like: " + returned);

		// Test 4 Get a multiple item from a list 
		returned = addTest.get("BMW");
		System.out.println("a multiple get looks like: " + returned);

		// Test 5 Call get() without any element
		// complier doesnt allow 

		//isEmpty
		// Test 1 Check if an empty list is empty
		System.out.println("empty list isempty return: " + emptyList.isEmpty()); 
		
		//Test 2 Check a list with Items 
		System.out.println("list with items isempty return: " + addTest.isEmpty());

		//Test 3 Check a previously filled list 
		System.out.println( "empty previously filled: " + list1.isEmpty());

		// Test 4 Add more to an empty list and use isempty to empty it
		list1.add("element");
		list1.add("coke");
		list1.add("sprite");
		list1.add("water");
		
		list1.resetIterator();
		//Have to run resetIterator or you get a null pointer execption idk how to fix that 
		while(!list1.isEmpty()){
			list1.remove(list1.getNextItem());
			System.out.println( "not empty yet: " + list1.isEmpty());
		}
		System.out.println( "empty previously filled: " + list1.isEmpty());
		
		//Test 5 running isempty after a single remove
		list1.add("element");
		list1.add("water");
		list1.add("earth");
		list1.add("fire");
		list1.add("air");
		list1.remove("air");
		System.out.println( "not empty previously empty: " + list1.isEmpty());

		//Remove

		// Test 1 Remove item from a list 
		System.out.println("Orange removed: " + addTest.remove("orange") + "\nThe list no longer has orange"+ addTest);

		// Test 2 Try to remove an item not on the list 
		System.out.println("Orange removed: " + addTest.remove("orange") + "\nThe list is unchanged:"+addTest);

		// Test 3 Try to remove from an empty list
		System.out.println("Orange removed: " + emptyList.remove("orange") + "\nThe list is still empty:" + emptyList);
	
		// Test 4 Remove a duplicate item
		System.out.println("BMW removed: "+ addTest.remove("BMW")+ " List has only one BMW: " + addTest);
		
		// ToString 

		//Test 1 call toString on a list 
		System.out.println(list1.toString());

		//Test 2 use toString to compare two lists
		if(list1.toString().equals(emptyList.toString())){
			System.out.println("They lists equal");
		}
		else{
			System.out.println("Lists not equal");
		}
		// Test 3
		if(list1.toString().equals(list1.toString())){
			System.out.println("The are lists equal");
		}
		else{
			System.out.println("Lists not equal");
		}

		// Size 

		// test 1 get size from empty list 
		System.out.println("The size of an empty list: " + emptyList.size());
	
		// Test 2 get size from a list with items
		System.out.println("The size of a list with items: "+ addTest.size()+ addTest);
	}
      
}
