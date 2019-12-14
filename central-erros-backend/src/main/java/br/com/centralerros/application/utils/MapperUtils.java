package br.com.centralerros.application.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MapperUtils {
    public static ModelMapper instance(){
        return new ModelMapper();
    }
}