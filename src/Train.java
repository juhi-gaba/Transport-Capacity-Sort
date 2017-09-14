
import com.google.gson.annotations.SerializedName;

/**
 * @author Juhi Gaba
 */
public class Train extends Transport{

    /**
     * Number of wagons.
     */
    @SerializedName("number-wagons")
    private int noOfWagons;

    /**
     * W passenger capacity.
     */
    @SerializedName("w-passenger-capacity")
    private int wPassengerCapacity;

    /**
     * Retrieves the total capacity of train.
     *
     * @return An integer showing the value of total capacity.
     */
    @Override
    public int getCapacity() {
        return noOfWagons * wPassengerCapacity;
    }

    /**
     * Set the number of wagons value.
     *
     * @param noOfWagons A number representing the value of number of wagons.
     */
    public void setNoOfWagons(int noOfWagons) {
        this.noOfWagons = noOfWagons;
    }

    /**
     * Set the w Passenger Capacity.
     *
     * @param wPassengerCapacity A number representing the value w Passenger Capacity.
     */
    public void setwPassengerCapacity(int wPassengerCapacity) {
        this.wPassengerCapacity = wPassengerCapacity;
    }
}
