/**
 * EECS 2101 N, Winter 2024
 * Assignment 1, Question 2 starter code.
 * Please read carefully the instructions in the assignment handout
 * and the starter code.
 */
package A1;
// Do NOT modify the package declaration

import java.util.ArrayList;
// Do NOT add any import



// You may implement a new class here, such as a Stack or a Queue.
// Any additional class that you use must be included in THIS file.

class Stack {
	private Node top;    //the head basically
	private int height;
	
	public Stack() {
		height = 0;
	}
	
	class Node{
		int value;
		Node next;
		
		Node(int value){
			this.value = value;
		}
	}
	
	public void printStack() {
		Node temp = top;
		
		while (temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
		
	public int getHeight() {
		return height;
		
	}
	
	public void push(int value) {
		Node newNode = new Node(value);
		
		if (height == 0) {
			top = newNode;
		}else {
			newNode.next = top;
			top = newNode;
		}
		height += 1;
	}
	
	public Node pop() {
		if (height == 0) return null;
		
		Node temp = top;
		top = top.next;
		temp.next = null;
		
		height -= 1;
		return temp;
	}
	
	public Node peek() {
		if (height == 0) return null;
		
		Node temp = top;
		
		return temp;
	}

}

public class A1Q2 {

    /**
     * The function that you need to implement.
     * Read the assignment handout for the specification.
     *
     * DO NOT MODIFY the declaration of the function (its parameter types and return type).
     */
    public static int solve(int[] arr) {

        // TODO: implement this function
    	ArrayList<Integer> nums = new ArrayList<>();
    	Stack temp = new Stack();
    	
    	int j = 0;
    	int i = 0;
    	//j = nums.size() 
    	
    	//we need to make sure the loop runs if i < arr.length OR if there are still numbers in the stack such that are eql to nums.get(nums.size() - 1) + 1; (use test case 2 as example)
    	while(i < arr.length || (temp.getHeight() != 0 && temp.peek().value == nums.get(nums.size() - 1) + 1)) {
    		
    		if(i < arr.length && arr[i] == 1) {  //we need to check if i < arr.length so we do not get an index out of bounds error, when checking arr[i]
    			nums.add(arr[i]);                //this is because it is possible for i to be i >= arr.length
    			i += 1;
    		}
    		else if (i < arr.length && nums.size() >= 1 && arr[i] == nums.get(nums.size() - 1) + 1) { //we need to check if i < arr.length so we do not get an index out of bounds error, when checking arr[i]
    			nums.add(arr[i]);                                                            //this is because it is possible for i to be i >= arr.length
    			i += 1;
    		}
    		else if (temp.peek() != null && nums.size() >= 1 && temp.peek().value == nums.get(nums.size() - 1) + 1) {
    			nums.add(temp.pop().value);
    		}
    		
    		else {
    			temp.push(arr[i]);
    			i += 1;
    		}
    	}
    	
    	
    	
        return nums.size();
    }

    /**
     * This main function contains a few test cases that can be used to check
     * that your code compiles and runs. Note that these test cases are NOT complete,
     * and you need to test your code thoroughly with more cases.
     */
    public static void main(String[] args) {

        // Printing "true" means the return value is correct.

       int[] arr = {4, 5, 2, 1, 3};
        System.out.println(3 == solve(arr));

       arr = new int[] {5, 4, 3, 1, 2};   //used to fail this test case, should have returned 5 but returned 2. Fixed after implementing a few new things
       System.out.println(5 == solve(arr));
        
	   arr = new int[] {1};
	   System.out.println(1 == solve(arr));
	      
	   arr = new int[] {2, 3, 1};
	   System.out.println(1 == solve(arr));
	      
	   arr = new int[] {7, 1, 5, 4, 3, 2, 8, 10, 9, 6};
	   System.out.println(6 == solve(arr));
	   
	   arr = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1};
	   System.out.println(9 == solve(arr));
	   
	   ////make new test cases here////////////////***
    }
}




