package br.com.promeTecnology.api.services.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
public class StandardError {

    private OffsetDateTime timestamp =  OffsetDateTime.now();
    private Integer status;
    private String error;
    private String path;

}
