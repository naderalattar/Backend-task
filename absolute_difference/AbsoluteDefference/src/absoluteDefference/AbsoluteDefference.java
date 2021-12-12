package absoluteDefference;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AbsoluteDefference {
	
	
	String nums;
	int size;
	int [] integerArray;
	List<Integer> absoluteDefference;
	
      // method to accept the data
	public void input() {
		
        Scanner input=new Scanner(System.in);
	    size=Integer.parseInt(input.nextLine());
		this.nums=input.nextLine();
		 
	}
	
	
	// method to convert string array to integer array
	public void toIntegerArray() {
		String [] stringArray=nums.split("\\s");
		
		this.integerArray=new int[size];
		
		for(int x=0;x<stringArray.length;x++) {
			this.integerArray[x]=Integer.parseInt(stringArray[x]);
		}
	}
	
	
	//method to get the absolute defference
	public void getAbsoluteDefference() {
		
		List<Integer> ad=new ArrayList<Integer>();
		for(int x:integerArray) {
			for(int y :integerArray) {
				
				ad.add(Math.abs((x-y)));
			}
		}
		
		absoluteDefference=new ArrayList<Integer>();
		for(int i : ad) {
			if(i != 0)
				this.absoluteDefference.add(i);
		}
	}
	
	
	//method to get the minimum absolute defference
	public int getMinAbsoluteDefference() {
		int temp=absoluteDefference.get(1);
		for(int i:absoluteDefference) {
			
			if(i<temp)
				temp=i;
		}
		return temp;
	}
	
	
	
	
	
}
