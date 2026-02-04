package com.deliverytech.delivery_api.dto.requests;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {

    @NotBlank(message = "O nome do produto é obrigatório.")
    private String nome;
    
    @NotBlank(message = "A descrição é obrigatória.")
    @Size(min = 5, message = "A descrição deve ter ao menos 5 caracteres.")
    private String descricao;

    @NotBlank(message = "A categoria do produto é obrigatória.")
    private String categoria;

    @Positive
    @NotNull(message = "O preço é obrigatório.")
    private BigDecimal preco;

}
