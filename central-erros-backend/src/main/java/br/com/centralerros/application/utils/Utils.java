package br.com.centralerros.application.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class Utils {
    private static MapperUtils mapperUtils;

    public static <U,T> U map(T objeto, Class<U> destino){
        return mapperUtils.getModelMapper()
                .map(objeto, destino);
    };

    public static <U,T> List<U> listMap(List<T> objeto, Class<U> destino){
        return objeto.stream()
                .map(o -> mapperUtils.getModelMapper()
                .map(o, destino))
                .collect(Collectors.toList());
    }

}
