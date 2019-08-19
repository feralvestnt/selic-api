package com.anbima.selic.service;

import com.anbima.selic.dto.HistoricoFilterDto;
import com.anbima.selic.dto.MediaDto;
import com.anbima.selic.dto.MesDto;
import com.anbima.selic.model.Selic;
import com.anbima.selic.predicate.SelicPredicate;
import com.anbima.selic.repository.SelicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SelicService {

    @Autowired
    private SelicRepository selicRepository;

    public List<Selic> getByFilter(HistoricoFilterDto historicoFilterDto) {
        SelicPredicate selicPredicate = new SelicPredicate();
        selicPredicate.comAno(historicoFilterDto.getAno()).comMes(historicoFilterDto.getMes());

        return selicRepository.findByFilter(selicPredicate.build());
    }

    public List<Integer> getAnosDisponiveis() {
        List<Selic> selicList = (List<Selic>) selicRepository.findAll();
        return selicList
                .stream()
                .map(s -> s.getAno())
                .distinct()
                .collect(Collectors.toList());
    }

    public List<MesDto> getMesesDisponiveis(Integer ano) {
        SelicPredicate selicPredicate =
            new SelicPredicate().comAno(ano);

        List<Selic> selicList = selicRepository.findByFilter(selicPredicate.build());

        return selicList
            .stream()
            .map(s -> new MesDto(s.getMes(), s.getAno()))
            .collect(Collectors.toList());
    }

    public List<MediaDto> getMedia(Integer ano) {
        SelicPredicate selicPredicate =
                new SelicPredicate().comAno(ano);

        List<Selic> selicList = selicRepository.findByFilter(selicPredicate.build());
        Map<Integer, Double> medias =
             selicList
            .stream()
            .collect(Collectors.groupingBy(Selic::getAno,
                    Collectors.averagingDouble(Selic::getEstimativaTaxaSelic)));

        List<MediaDto> mediaDtos = new ArrayList<>();
        for (Map.Entry<Integer, Double> entry : medias.entrySet()) {
            mediaDtos.add(new MediaDto(entry.getKey(), entry.getValue()));
        }

        return mediaDtos;
    }

}
