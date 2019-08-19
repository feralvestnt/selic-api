package com.anbima.selic.config;

import com.anbima.selic.dto.SelicDtoConverter;
import com.anbima.selic.model.Selic;
import com.anbima.selic.repository.SelicRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class SelicDatabase implements CommandLineRunner {

    @Autowired
    private SelicRepository selicRepository;

    @Override
    public void run(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        File file = ResourceUtils.getFile("classpath:database/ESTIMATIVA_SELIC.JSON");
        List<SelicDtoConverter> selicDtoConverters =
                Arrays.asList(objectMapper.readValue(file, SelicDtoConverter[].class));

        selicDtoConverters.forEach(selicConv -> {
            selicRepository.save(Selic.createFromString(selicConv.getDataReferencia(),
                    selicConv.getEstimativaTaxaSelic()));
        });
    }
}
