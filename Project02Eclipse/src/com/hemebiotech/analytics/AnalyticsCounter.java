package com.hemebiotech.analytics;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Grouping of all the methods that
 * make it possible to go from an unordered list
 * to a map sorted in alphabetical order.
 */

public class AnalyticsCounter {

	private final ISymptomReader reader;
	private final ISymptomWriter writer;

	/**
	 *
	 * @param reader  method used to read a file
	 * @param writer  method used to write to a file
	 */

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 *
	 * @return an unordered list of symptoms
	 */

	public List<String> getSymptoms (){
        try {
            return reader.getSymptoms();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

	/**
	 * Counts the number of occurrences of each symptom.
	 * @param symptoms the unordered list of symptoms
	 * @return a map of symptoms (unordered) with their respective counts
	 */

	public Map<String , Integer> countSymptoms (List<String> symptoms) {
		Map<String , Integer> symptomsCount = new HashMap<>();

		symptoms.forEach(symptom ->
			symptomsCount.put(symptom, symptomsCount.getOrDefault(symptom, 0) + 1));

		return symptomsCount;
	}

	/**
	 * Sorts a map of symptoms in alphabetical order.
	 * @param countSymptoms a map of symptoms (unordered)
	 * @return a map of symptoms sorted in alphabetical order
	 */


	public Map<String, Integer> sortSymptoms(Map<String, Integer> countSymptoms) {
		Map<String, Integer> sortedSymptoms = new TreeMap<>();

		sortedSymptoms.putAll(countSymptoms);
		return sortedSymptoms;
	}

	/**
	 * Writes the counted and sorted symptoms to a file.
	 * @param symptoms a map of symptoms sorted in alphabetical order
	 */

	public void writeSymptoms (Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);

	}
}