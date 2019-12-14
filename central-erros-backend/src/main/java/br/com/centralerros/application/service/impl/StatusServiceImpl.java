package br.com.centralerros.application.service.impl;

import br.com.centralerros.application.domain.entity.Status;
import br.com.centralerros.application.domain.enumerables.StatusEnum;
import br.com.centralerros.application.service.StatusService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatusServiceImpl implements StatusService {

    @Override
    public List<Status> findAll() {
        return Arrays.asList(StatusEnum.values())
                .stream()
                .map(s -> new Status(s.getValue(), s.toString()))
                .collect(Collectors.toList());
    }

    @Override
    public Status findById(int id) {

        return Arrays.asList(
                StatusEnum.values())
                .stream()
                .filter( s -> s.getValue() == id)
                .map(s -> new Status(id, s.toString()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Status findByName(String name) {
        return Arrays.asList(
                StatusEnum.values())
                .stream()
                .filter( s -> s.toString() == name)
                .map(s -> new Status(s.getValue(), name))
                .findFirst()
                .orElse(null);
    }
}
