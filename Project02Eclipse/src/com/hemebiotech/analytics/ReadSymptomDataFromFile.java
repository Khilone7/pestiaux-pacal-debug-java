package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private final String filepath;

	BufferedReader reader;

	private static final Logger logger = Logger.getLogger(ReadSymptomDataFromFile.class.getName());

    /**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath)  {
		this.filepath = filepath;

			try {
				reader = new BufferedReader (new FileReader(filepath));
			} catch (FileNotFoundException e) {
				throw new IllegalStateException(e);
			}
	}
	
	@Override
	public List<String> getSymptoms() throws IOException {
		ArrayList<String> result = new ArrayList<>();

		if (filepath != null) {
			try {

				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
			} catch (IOException e) {
				logger.severe(e.getMessage());
			}
			finally {
				reader.close();
			}
		}
		return result;
	}

}
