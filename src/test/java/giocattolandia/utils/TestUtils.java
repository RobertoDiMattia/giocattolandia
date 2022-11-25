package giocattolandia.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.Objects;


public class TestUtils {
    public static String getJsonResource(String path) throws IOException {
        return IOUtils.toString(Objects.requireNonNull(TestUtils.class.getResourceAsStream(path)),"UTF-8");
    }

    public static String json(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }
}
