package com.br.renatogomes.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Table(name = "tb_belonging")
public class Belonging implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private BelongingPK id = new BelongingPK();
    private Integer position;
}
