package transport;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Deserializer
 *
 * @author Juhi Gaba
 */
public class TransportDeserializer implements JsonDeserializer<Transport> {

    /**
     * Deserialize the object.
     *
     * @param jsonElement                Json element
     * @param type                       Type
     * @param jsonDeserializationContext Context.
     *
     * @return                           Deserialize object.
     * @throws JsonParseException        Json parse exception.
     */
    @Override
    public Transport deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext)
            throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        Transport transport = null;
        JsonElement carCapacity = jsonObject.get("passenger-capacity");
        JsonElement trainWCapacity = jsonObject.get("w-passenger-capacity");
        JsonElement planeBCapacity = jsonObject.get("b-passenger-capacity");

        if (carCapacity != null) {
            Car car = new Car();
            car.setPassengerCapacity(carCapacity.getAsInt());
            transport = car;

        } else if (trainWCapacity != null) {
            Train train = new Train();
            train.setwPassengerCapacity(trainWCapacity.getAsInt());
            train.setNoOfWagons(jsonObject.get("number-wagons").getAsInt());
            transport = train;

        } else if (planeBCapacity != null) {
            Plane plane = new Plane();
            plane.setBPassengerCapacity(planeBCapacity.getAsInt());
            plane.setEPassengerCapacity(jsonObject.get("e-passenger-capacity").getAsInt());
            transport = plane;
        }

        if (transport != null) {
            transport.setModel(jsonObject.get("model").getAsString());
        }

        return transport;
    }
}
