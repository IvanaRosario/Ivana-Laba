package com.solvd.laba;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonParser {
    private static ObjectMapper mapper = new ObjectMapper();

    public static <T> T parseJason(String filePath, Class<T> type) {
        try {
            return mapper.readValue(new File(filePath), type);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static <T> T parseJason(String filePath, TypeReference<T> typeRef) {
        try {
            return mapper.readValue(new File(filePath), typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeJson( String filePath, Object object) {
        try {
            mapper.writeValue(new File(filePath), object);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
