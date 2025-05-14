package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Map;
import java.util.logging.Logger;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private final String filepath;

    private static final Logger logger = Logger.getLogger(WriteSymptomDataToFile.class.getName());

    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Writes the symptoms and their counts to "result.out".
     * @param symptoms A map containing symptom names as keys and their occurrence counts as values.
     */

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {

        try(BufferedWriter writer = new BufferedWriter (new FileWriter(filepath))){
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey()+": " + entry.getValue());
                writer.newLine();
            }
        }catch(Exception e){
            logger.severe(e.getMessage());
        }


    }
}
