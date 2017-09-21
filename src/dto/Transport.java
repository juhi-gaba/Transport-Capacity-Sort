package dto;

import com.google.gson.annotations.SerializedName;

/**
 * DTO for transport.
 *
 * @author Juhi Gaba
 */
public abstract class Transport {

    /**
     * Model.
     */
    @SerializedName("model")
    private String model;

    /**
     * Retrieves the model of the transport.
     *
     * @return A string representing the model.
     */
    public String getModel() {
        return model;
    }

    /**
     * Set the model.
     *
     * @param model A string representing the model.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Abstract method to calculate total capacity.
     *
     * @return An integer representing the total capacity.
     */
    public abstract int getCapacity();
}
