package Test1Package;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test1Class {

	/**
	 * main function for testing
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<String> t = new LinkedList<String>();
		Collection<String> c = new ArrayList<String>();
		c.add("1");
		c.add("2");
		c.add("3");
		c.add("4");
		c.add("5");
		c.add("6");
		c.add("7");
		c.add("8");
		c.add("9");
		c.add("10");
		t.addAll(c);
		
		System.out.println("original list:");
		Iterator<String> ii = t.iterator();
		while(ii.hasNext()){
			System.out.print(ii.next()+"-");
		}
		System.out.println("\n");
        
		int k=4;
		LinkedList<String> r = reverse(t,k);
		//List<String> r = reverseK(t,k);
		
		System.out.println("reverse every " + k + " nodes:");
		Iterator<String> i = r.iterator();
		while(i.hasNext()){
			System.out.print(i.next()+"-");
		}
		
		
		
	}
	
	/**
	 * reverse linked list
	 * @param linkedList - linked list to be reversed
	 * @param k - reverse every k nodes
	 * @return linked list after reverse
	 */
	public static LinkedList<String> reverse(LinkedList<String> linkedList, int k){
		if(k<=1){
			return linkedList;
		}
		
		int l = linkedList.size();
		if (k>l){
			return linkedList;
		}
		
		LinkedList<String> result = new LinkedList<String>();
		int m = l / k;
		for(int i=1; i<=m; i++){
			for(int j=0; j<k; j++){
				result.add(linkedList.get(i*k-1-j));
			}
		}
		
		for(int i=m*k; i<l; i++){
			result.add(linkedList.get(i));
		}
        
		return result;
	}
	
	/**
	 * reverse linked list with Collections
	 * @param nodes - linked list to be reversed
	 * @param k - reverse every k nodes
	 * @return
	 */
	public static List<String> reverseK(List<String> nodes, int k){
		if(k<=1){
			return nodes;
		}
		
	    List<String> result = new LinkedList<String>();
	    
	    int index = 0;	    
	    while(index < nodes.size()){
	        if(index+k > nodes.size()){
	            result.addAll(nodes.subList(index, nodes.size()));
	            break;
	        }
	      
	        Collections.reverse(nodes.subList(index, index+k));
	        result.addAll(nodes.subList(index, index+k));
	        index+=k;
	    }
	    return result;
	}


}
