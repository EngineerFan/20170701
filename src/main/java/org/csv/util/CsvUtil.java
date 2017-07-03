package org.csv.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class CsvUtil {

	public static final ExecutorService fixThreadPool = Executors.newFixedThreadPool(3);
	public static volatile boolean TIME_STATUS= true;
	//CSV文件字符编码格式；
	public static final String CHARSET_NAME ="GBK";
	//marriot
	public static final String[] MARRIOT = {"企业/推广活动代码","酒店名称","最低房价"};
	public static final Map<Integer,String> MAP_MARRIOT = new HashMap<Integer,String>();
	//ihg
	public static final String[] IHG = {"酒店名称","每晚最低房价","公司ID"};
	public static final Map<Integer,String>MAP_IHG = new HashMap<Integer,String>();
	//hyatt
	public static final String[] HYATT={"Corporate code","Room type","Price per night(CNY)"};
	public static final Map<Integer,String>MAP_HYATT = new HashMap<Integer,String>();
	
	public static List<Map<Integer,String>> l = new ArrayList<Map<Integer,String>>();
	static{
		MAP_MARRIOT.put(1, MARRIOT[0]);
		MAP_MARRIOT.put(3, MARRIOT[1]);
		MAP_MARRIOT.put(8, MARRIOT[2]);
		
		MAP_IHG.put(1, IHG[0]);
		MAP_IHG.put(4, IHG[1]);
		MAP_IHG.put(8, IHG[2]);
		
		MAP_HYATT.put(6,HYATT[0]);
		MAP_HYATT.put(7, HYATT[1]);
		MAP_HYATT.put(8, HYATT[2]);
		
		l.add(MAP_HYATT);
		l.add(MAP_IHG);
		l.add(MAP_MARRIOT);
	}
	//筛选符合条件的CSV格式
	public static int[] getCsvEffectiveHeaders(String[] headers){
		int[] newHeaders;
		int validIndex = -1;
		for (int i = 0; i < l.size(); i++) {
			Iterator<Entry<Integer,String>> it =l.get(i).entrySet().iterator();
//			int vaidNum = l.get(i).size();
//			int count = 0;
			boolean valid = true;
			while(it.hasNext()){
				Entry<Integer, String> mEntry =it.next();
				int key = mEntry.getKey();
				String value = mEntry.getValue();
				if(key<=headers.length-1&&value.equals(headers[key])){
//					count = count + 1;
				}else{
					valid = false;
					break;
				}
			}
			if(valid==true){
				validIndex = i;
				break;
			}
		}
		if(validIndex==-1){//没找到符合CSV文件，上传的CSV文件均不符合要求
			return null;
		}
		Object[] ks = l.get(validIndex).keySet().toArray();
		newHeaders = new int[ks.length];
		for (int i = 0; i < ks.length; i++) {
			newHeaders[i] = (int) ks[i];
		}
		return newHeaders;
	}
	
}
