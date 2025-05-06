package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	private final ISymptomReader reader;
	private final ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms () {
		return reader.GetSymptoms();
	}

	public Map<String , Integer  > countSymptoms (List<String> symptoms) {
		Map<String , Integer> symptomsCount = new HashMap<String , Integer>();

		symptoms.forEach(symptom -> {
			symptomsCount.put(symptom, symptomsCount.getOrDefault(symptom, 0) + 1);
		});

		return symptomsCount;
	}


	public Map<String, Integer> sortSymptoms(Map<String, Integer> countSymptoms) {
		Map<String, Integer> sortedSymptoms = new TreeMap<String, Integer>();

		sortedSymptoms.putAll(countSymptoms);
		return sortedSymptoms;
	}

	public void writeSymptoms (Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);

	}
}