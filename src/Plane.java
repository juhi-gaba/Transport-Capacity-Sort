package transport;

import com.google.gson.annotations.SerializedName;

/**
 * @author Juhi Gaba
 */
public class Plane extends Transport{

    /**
     * Capacity of passengers in business class.
     */
    @SerializedName("b-passenger-capacity")
    private int bPassengerCapacity;

    /**
     * Capacity of passengers in economy class.
     */
    @SerializedName("e-passenger-capacity")
    private int ePassengerCapacity;

    /**
     * Set the business class passenger capacity.
     *
     * @param bPassengerCapacity An integer representing the business class passenger capacity.
     */
    public void setBPassengerCapacity(int bPassengerCapacity) {
        this.bPassengerCapacity = bPassengerCapacity;
    }

    /**
     * Set the economy class passenger capacity.
     *
     * @param ePassengerCapacity An integer representing the economy class passenger capacity.
     */
    public void setEPassengerCapacity(int ePassengerCapacity) {
        this.ePassengerCapacity = ePassengerCapacity;
    }

    /**
     * Retrieves the total passenger capacity of a plane.
     *
     * @return An integer representing the total capacity.
     */
    @Override
    public int getCapacity() {
        return bPassengerCapacity + ePassengerCapacity;
    }
}
