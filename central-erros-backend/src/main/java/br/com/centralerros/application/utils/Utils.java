package br.com.centralerros.application.utils;

import br.com.centralerros.application.domain.entity.User;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class Utils {
    private static MapperUtils mapperUtils;
    private static UserUtils userUtils;
    private static StringUtils stringUtils;

    public static User getLoggedUser() {
        return userUtils.getLoggedUser();
    }

    public static boolean isNullOrWhiteSpace(String string){
        return stringUtils.isNullOrWhiteSpace(string);
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