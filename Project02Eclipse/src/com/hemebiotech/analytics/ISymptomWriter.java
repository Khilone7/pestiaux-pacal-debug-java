package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface for writing symptom data to a file.
 * It takes a map of symptoms and their occurrences as input.
 */

public interface ISymptomWriter {

    /**
     * Writes the given map of symptoms to a file.
     * @param symptoms A map containing symptom names as keys and their occurrence counts as values.
     */

    public void  writeSymptoms(Map<String, Integer> symptoms);
}
