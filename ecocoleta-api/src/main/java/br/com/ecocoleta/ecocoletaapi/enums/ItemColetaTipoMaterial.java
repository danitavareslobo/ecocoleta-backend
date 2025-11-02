package br.com.ecocoleta.ecocoletaapi.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum ItemColetaTipoMaterial {
    PLASTICO,
    VIDRO,
    PAPEL,
    METAL
}
