package com.deliverytech.delivery_api.dto.responses;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteResponseDTO {
    private String nome;

    private String email;

    private String telefone;

    private String endereco;

    private boolean ativo;
    
    private LocalDate dataCadastro;
    
}
