package com.ab.makechange.algo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TabDelimitedFileReader {

	private File inputFile = null;
	private String delimiter = null;

	public TabDelimitedFileReader(File inputFile, String delimiter) {
		this.inputFile = inputFile;
		this.delimiter = delimiter;
	}

	public List<String> readFile() throws FileNotFoundException, IOException {
		List<String> words = new ArrayList<String>();
		try (BufferedReader buf = new BufferedReader(new FileReader(inputFile))) {

			String lineJustFetched = null;
			String[] wordsArray;

			while ((lineJustFetched = buf.readLine()) != null) {
				wordsArray = lineJustFetched.split(delimiter);
				for (String each : wordsArray) {
					if (!"".equals(each)) {
						words.add(each);
					}
				}

			}

			for (String each : words) {
				System.out.println(each);
			}

		}

		return words;
	}

	

}
