
package xingkong.tool.core;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author 星空
 *
 */
@Slf4j
public class JsonTool {

	public static String toJSONString(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonText = null;
		try {
			jsonText = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			log.error("JsonProcessingException", e);
		}
		return jsonText;
	}

	public static Object parseObject(String jsonText, Class classType) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(jsonText, classType);
		} catch (JsonParseException e) {
			log.error("JsonParseException", e);
		} catch (JsonMappingException e) {
			log.error("JsonMappingException", e);
		} catch (IOException e) {
			log.error("IOException", e);
		}
		return null;

	}
}
