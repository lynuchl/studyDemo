package lynu.chaohl.SpringbootMybatis.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;


/**
 * @author 26925
 */
public abstract class JacksonJsonUtils {

    private static final ObjectMapper OM = new ObjectMapper();

    /**
     * bean 转 json
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> String toJson(T t) {
        try (StringWriter sw = new StringWriter()) {
            OM.writeValue(sw, t);
            return sw.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * json 转 bean
     *
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String json, Class<T> type) {
        try (StringReader sr = new StringReader(json)) {
            return OM.readValue(sr, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
