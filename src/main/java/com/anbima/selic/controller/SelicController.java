package com.anbima.selic.controller;

import com.anbima.selic.dto.HistoricoFilterDto;
import com.anbima.selic.dto.MediaDto;
import com.anbima.selic.dto.MesDto;
import com.anbima.selic.model.Selic;
import com.anbima.selic.service.SelicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/selic")
public class SelicController {

    @Autowired
    private SelicService selicService;

    @RequestMapping(method = RequestMethod.GET, path = "historico")
    public Iterable<Selic> getHistorico(HistoricoFilterDto historicoFilterDto) {
        return selicService.getByFilter(historicoFilterDto);
    }

    @RequestMapping(method = RequestMethod.GET, path = "anos-disponiveis")
    public List<Integer> getAnos() {
        return selicService.getAnosDisponiveis();
    }

    @RequestMapping(method = RequestMethod.GET, path = "meses-disponiveis")
    public List<MesDto> getMeses(Integer ano) {
        return selicService.getMesesDisponiveis(ano);
    }

    @RequestMapping(method = RequestMethod.GET, path = "medias")
    public List<MediaDto> getMedia(Integer ano) {
        return selicService.getMedia(ano);
    }
}



