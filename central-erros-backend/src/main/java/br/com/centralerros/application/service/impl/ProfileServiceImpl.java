package br.com.centralerros.application.service.impl;

import br.com.centralerros.application.domain.entity.Profile;
import br.com.centralerros.application.domain.enumerables.ProfileEnum;
import br.com.centralerros.application.service.ProfileService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService {


    @Override
    public List<Profile> findAll() {
        return Arrays.asList(ProfileEnum.values())
                .stream()
                .map(l -> new Profile(l.getValue(), l.toString()))
                .collect(Collectors.toList());
    }

    @Override
    public Profile findById(int id) {

        return Arrays.asList(
                ProfileEnum.values())
                .stream()
                .filter( l -> l.getValue() == id)
                .map(l -> new Profile(id, l.toString()))
                .findFirst().orElse(null);
    }

    @Override
    public Profile findByName(String name) {

        return Arrays.asList(
                ProfileEnum.values())
                .stream()
                .filter( l -> l.toString() == name)
                .map(l -> new Profile(l.getValue(), name))
                .findFirst().orElse(null);
    }

}
