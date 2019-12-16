package br.com.centralerros.application.utils;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class Utils {
    private static MapperUtils mapperUtils;


    public static boolean isNullOrEmpty(String text){
        return text == null || text.isEmpty();
    }

    public static <U,T> U map(T objeto, Class<U> destino){
        return mapperUtils.instance()
                .map(objeto, destino);
    };

    public static <U,T> List<U> listMap(List<T> objeto, Class<U> destino){
        return objeto.stream()
                .map(o -> mapperUtils.instance()
                        .map(o, destino))
                .collect(Collectors.toList());
    }
}