package com.br.renatogomes.dslist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class ReplacementDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private int sourceIndex;
    private int destinationIndex;
}
