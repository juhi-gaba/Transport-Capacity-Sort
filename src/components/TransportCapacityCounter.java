package components;

import dto.Car;
import dto.Plane;
import dto.Train;
import dto.Transport;

import java.util.*;

/**
 * Total capacity counter.
 *
 * @author Juhi Gaba
 */
public class TransportCapacityCounter {

    /**
     * Total plane capacity.
     */
    private static long totalPlaneCapacity = 0;

    /**
     * Total car capacity.
     */
    private static long totalCarCapacity = 0;

    /**
     * Total train capacity.
     */
    private static long totalTrainCapacity = 0;

    /**
     * Map.
     */
    private static Map<String, Long> map = new HashMap<>();

    /**
     * Calculate the capacity according to transport instance.
     *
     * @param transport dto.Transport.
     */
    public void addTransport(Transport transport) {
        if (transport instanceof Plane) {
            totalPlaneCapacity = totalPlaneCapacity + transport.getCapacity();
        } else if (transport instanceof Car) {
            totalCarCapacity = totalCarCapacity + transport.getCapacity();
        } else if (transport instanceof Train) {
            totalTrainCapacity = totalTrainCapacity + transport.getCapacity();
        }
    }

    /**
     * Add total capacity in a map.
     *
     * @return A map containing the transport as key and its total capacity as value.
     */
   public Map<String, Long> getTotalCapacity() {

       map.put("dto.Car", totalCarCapacity);
       map.put("dto.Plane", totalPlaneCapacity);
       map.put("dto.Train", totalTrainCapacity);

       return map;
    }
}

