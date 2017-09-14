package transport;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.*;

/**
 * @author Juhi Gaba
 */
public class TransportCapacitySort {

    /**
     * Entry point of the code.
     *
     * @param args Input
     */
    public static void main(String[] args) {

        String filePath = args[0];

        try {
            processLargeJsonWithGson(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Process the json file.
     *
     * @param filePath      Path of the file that has to be processed.
     * @throws IOException  Thrown when the file can not be read.
     */
    private static void processLargeJsonWithGson(String filePath)
            throws IOException {

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Transport.class,
                new TransportDeserializer());
        Gson gson = builder.create();

        processFile(filePath, gson);

    }

    /**
     * Read the file.
     *
     * @param filePath          Path of the file that has to be processed
     * @param gson              Gson
     * @throws IOException      Thrown when the file can not be read.
     */
    private static void processFile(String filePath,
                                    Gson gson)
            throws IOException {

        InputStream in = new FileInputStream(filePath);

        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        reader.beginObject();

        String transports = reader.nextName();

        if ("transports".equals(transports)) {

            parseReaderAsArray(gson, reader);

            reader.endArray();
        }

        reader.endObject();
        reader.close();
    }

    /**
     * Parse the reader as array.
     *

     * @param gson            Gson
     * @param reader          Reader
     * @throws IOException    Thrown when the file can not be read.
     */
    private static void parseReaderAsArray(
             Gson gson,
            JsonReader reader)
            throws IOException {

        TransportCapacityCounter capacityCounter = new TransportCapacityCounter();
        TransportDistinctCounter distinctCounter = new TransportDistinctCounter();

        reader.beginArray();

        while (reader.hasNext()) {
            Transport transportMedium = gson.fromJson(reader,
                    Transport.class);
            capacityCounter.addTransport(transportMedium);
            distinctCounter.addTransport(transportMedium);
        }

        processOutput(capacityCounter, distinctCounter);
    }

    /**
     * Process the output.
     *
     * @param capacityCounter Counts the total capacity.
     * @param distinctCounter Counts the distinct transports.
     */
    private static void processOutput(TransportCapacityCounter capacityCounter,
                                      TransportDistinctCounter distinctCounter)
    {

        Map sortCapacity = sortMap(capacityCounter.getTotalCapacity());
        Map sortDistinct = sortMap(distinctCounter.getDistinctTransport());

        printMap(sortCapacity);
        System.out.println();
        System.out.println();
        printMap(sortDistinct);
    }

    /**
     * Sorting of the map.
     *
     * @return The sorted map according to values.
     */
    private static Map<String, Long> sortMap(Map<String, Long> unsortedMap) {

        List<Map.Entry<String, Long>> list = new LinkedList<>(
                unsortedMap.entrySet());

        list.sort(new Comparator<Map.Entry<String, Long>>() {

            public int compare(Map.Entry<String, Long> o1,
                               Map.Entry<String, Long> o2) {
                return o2.getValue()
                         .compareTo(o1.getValue());
            }
        });

        Map<String, Long> sortedMap = new LinkedHashMap<>();

        for (Map.Entry<String, Long> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    /**
     * Print the output.
     *
     * @param sortedMap Sorted map that has to be printed.
     */
    private static void printMap(Map<String, Integer> sortedMap) {

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println("\"" + entry.getKey() + "\"  :  "
                    + entry.getValue());
        }
    }
}