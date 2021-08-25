package ru.otus.spring.oca.service.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
 * Сервисный класс для получения экзэмпляра класса из HAL данных
 */
@Service
public class HalMapper<T> {
    private ObjectMapper objectMapper;

    public HalMapper(@Autowired ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<T> process(LinkedHashMap map, Class<T> type) {
        List<T> listOfT = new ArrayList<T>();
        ArrayList<Map<String, String>> list = (ArrayList<Map<String, String>>) map.get("items");
        for(Object obj: list) {
            T objT = (T) objectMapper.convertValue(obj, type);
            listOfT.add(objT);
        }
        return listOfT;
    }

    public T processEntity(LinkedHashMap map, Class<T> type) {
        return (T) objectMapper.convertValue(map, type);
    }
}
