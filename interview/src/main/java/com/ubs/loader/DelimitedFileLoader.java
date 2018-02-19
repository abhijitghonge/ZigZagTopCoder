package com.ubs.loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ubs.data.IDataListener;

/**
 * Read the File and load 
 * @author abhij
 *
 */
public class DelimitedFileLoader {

	
	private File inputFile = null;
	private List<IDataListener> listeners = new ArrayList<IDataListener>();
	private String  delimiter = null;
	
	public DelimitedFileLoader(File inputFile,String  delimiter) {
		this.inputFile = inputFile;
		this.delimiter = delimiter;
	}
	
	public void registerBuilder(IDataListener listener) {
		this.listeners.add(listener);
	}

	public List<String> loadData() throws FileNotFoundException, IOException {
		List<String> words = new ArrayList<String>();
		try (BufferedReader buf = new BufferedReader(new FileReader(inputFile))) {

			String dataRow = null;
			
			if(buf.readLine() == null){
				System.out.println("Empty File");
				return words;
			}

			while ((dataRow = buf.readLine()) != null) {
				String[] dataFields =  dataRow.split(delimiter);
				for (IDataListener dataListener : listeners) {
					dataListener.notifyDataReady(dataFields);
				}
			}

			for (String each : words) {
				System.out.println(each);
			}
		}

		return words;
	}

}
