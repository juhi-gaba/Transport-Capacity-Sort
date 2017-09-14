package transport;

import com.google.gson.annotations.SerializedName;

/**
 * DTO for Car.
 *
 * @author Juhi Gaba
 */
public class Car extends Transport{

    /**
     * Capacity of the passenger in a car.
     */
    @SerializedName("passenger-capacity")
    private int passengerCapacity;

    /**
     * Retrieves the capacity.
     *
     * @return An integer representing the capacity.
     */
    @Override
    public int getCapacity() {
        return passengerCapacity;
    }

    /**
     * Sets the passenger capacity.
     *
     * @param passengerCapacity An integer representing the capacity.
     */
    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}
