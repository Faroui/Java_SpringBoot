package ma.n7.demospringandkafka.serializers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ma.n7.demospringandkafka.entities.PageEvent;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

public class CustomDeSerializer implements Deserializer<PageEvent> {
    @Override
    public PageEvent deserialize(String s, byte[] data) {
        try {
            return new ObjectMapper().readValue(new String(data),PageEvent.class);
        } catch (Exception e) {
            throw new SerializationException(e);
        }
    }
}
