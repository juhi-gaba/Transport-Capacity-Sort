
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Count the distinct type of transport.
 *
 * @author Juhi Gaba
 */
public class TransportDistinctCounter {

    /**
     * Set to store distinct plane.
     */
    private static HashSet<String> distinctPlanes = new HashSet<>();

    /**
     * Set to store distinct cars.
     */
    private static HashSet<String> distinctCars= new HashSet<>();

    /**
     * Set to store distinct trains.
     */
    private static HashSet<String> distinctTrains= new HashSet<>();

    /**
     *
     */
    private static Map<String,Long> map = new HashMap<>();


    /**
     * Retrieves the map containing the distinct transport as values.
     *
     * @return Map containing transport as keys and their values.
     */
    public Map<String, Long> getDistinctTransport() {
        map.put("Car", (long)distinctCars.size());
        map.put("Plane", (long)distinctPlanes.size());
        map.put("Train", (long) distinctTrains.size());
        return map;
    }

    /**
     * Adds the transposrt to the set.
     * @param transport Transport
     */
    public void addTransport(Transport transport){

        if(transport instanceof Car){
            distinctCars.add(transport.getModel());

        } else if(transport instanceof Train){
            distinctTrains.add(transport.getModel());

        }else if(transport instanceof Plane){
            distinctPlanes.add(transport.getModel());
        }
    }

}
