package org.csv.task;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

import javax.swing.JTextArea;

import org.csv.util.CsvUtil;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class MyTaskThread implements Runnable {

    private String sourcePath;
    private String targetPath;
    private JTextArea jTextArea;
    
	public MyTaskThread(String sourcePath,String targetPath,JTextArea jTextArea) {
       this.sourcePath = sourcePath;
       this.targetPath = targetPath;
       this.jTextArea = jTextArea;
	}
	
	@Override
	public void run() { 
		CsvReader csvReader = null;
		try {
			csvReader = new CsvReader(sourcePath,',',Charset.forName("GBK"));
		} catch (FileNotFoundException e) {
			jTextArea.append("FileNotFoundException!\n");
			e.printStackTrace();
		}
		CsvWriter csvWriter = new CsvWriter(targetPath, ',',Charset.forName("GBK"));
		csvWriter.setForceQualifier(true);
		String[] newHeaders ={};
		int[] validHeadIndexs = null;
		long t1 = System.currentTimeMillis();
		try {
			while(csvReader.readRecord()){
			    if(csvReader.getCurrentRecord()==0){
			    	newHeaders = csvReader.getValues();
			    	//获取所需要的CSV文件头
			    	validHeadIndexs = CsvUtil.getCsvEffectiveHeaders(newHeaders);
			    }		
				String[] tmp = new String[validHeadIndexs.length];
				for (int i = 0; i < tmp.length; i++) {
					tmp[i] = csvReader.getValues()[validHeadIndexs[i]];
				}
				csvWriter.writeRecord(tmp);
			}
		} catch (IOException e) {
			jTextArea.append("IO Exception!\n");
			e.printStackTrace();
		}
		csvReader.close();
		csvWriter.close();
		long t2 = System.currentTimeMillis();
		jTextArea.append("耗时："+(t2-t1)/1000+"秒"+"  线程名："+Thread.currentThread().getName()+"\n");
	}
}
