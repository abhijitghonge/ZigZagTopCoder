package com.ab.makechange.algo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class TabDelimitedFileReaderTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void positiveExistingFileScenario() throws FileNotFoundException, IOException {

		File inputFile = new File("E:\\abhi\\test.txt");

		TabDelimitedFileReader reader = new TabDelimitedFileReader(inputFile, "\\t");
		List<String> actual = reader.readFile();
		List<String> expected = Arrays.asList("Abhijit", "Ghonge", "Madhuri", "Ghonge");

		assertThat(actual, is(expected));

	}

	@Test
	public void negativeExistingFileScenario() throws IOException{
		
		File inputFile = new File("E:\\abhi\\test.io");

		thrown.expect(FileNotFoundException.class);
		TabDelimitedFileReader reader = new TabDelimitedFileReader(inputFile, "\\t");
		List<String> actual = reader.readFile();
		

	}
}
