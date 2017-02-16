package com.Test3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Storage {
	
	/**
	 * use one array to simulate storage
	 * every array element can allocated to LUN
	 */
	static String[] storageArray = new String[100];
	
	/**
	 * singleton Storage class
	 */
	private static Storage storage = null;	
	private Storage(){};
	public static synchronized Storage getInstance(){	
		if(null == storage){
			storage = new Storage();
		}
			
		return storage;		
	}
	
	/**
	 * allocate storage unit to LUN
	 * @return
	 */
	public String allocate(){
		for(int i=0; i<storageArray.length; i++){
			if(storageArray[i]!="allocated"){			
				//mark storage unit as allocated
				storageArray[i]="allocated";
				return String.valueOf(i);
			}
		}
		
		return "create LUN failed, no enough storage";
	}
	
	/**
	 * make storage unit available
	 * @param LUNNumber
	 * @return
	 */
	public String remove(String LUNNumber){
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(LUNNumber);
		if(!isNum.matches()){
			return "invalid LUNNumber, please check";
		}
		
		
		int t = Integer.parseInt(LUNNumber);
		if(t<storageArray.length){
			//mark storage unit as available
			storageArray[t]=" ";
			return "removed LUNNumber " + LUNNumber;
		} else {
			return "LUNNumber out of range";
		}
	}
	
	/**
	 * get count of allocated storage unit
	 * @return
	 */
	public String getStorageInfo(){
		int allocatedNumber = 0;
		for(int i=0; i<storageArray.length; i++){
			if ("allocated" == storageArray[i]){
				allocatedNumber++;
			}
		}
		
		return "have allocated " + String.valueOf(allocatedNumber) + " storage unit for LUN";
	}
	
}
