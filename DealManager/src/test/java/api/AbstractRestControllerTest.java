package api;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @Created by am on 1 lip 2018
 *
 */
public class AbstractRestControllerTest {
	 public static String asJsonString(final Object obj) {
	        try {
	            return new ObjectMapper().writeValueAsString(obj);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	}
}
