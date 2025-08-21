package utils;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

import testData.billingAdressDetails;

public class JectionUtils {
	public static billingAdressDetails deserializeJsonFromResource(String resourceFile) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();

        // Load from classpath
        InputStream is = JectionUtils.class.getClassLoader().getResourceAsStream(resourceFile);
        if (is == null) {
            throw new IllegalArgumentException("Resource not found: " + resourceFile);
        }

        return objectMapper.readValue(is, billingAdressDetails.class);
    }
	}

