package br.com.ifpe.oxefood.api.venda;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.venda.Venda;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VendaRequest {

    private String cliente;

    private String produto;

    private String statusVenda;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataVenda;

    private Double valorTotal;

    private String observacao;

    private Boolean retiradaEmLoja;

    public Venda build() {

        return Venda.builder()
                .cliente(cliente)
                .produto(produto)
                .statusVenda(statusVenda)
                .dataVenda(dataVenda)
                .valorTotal(valorTotal)
                .observacao(observacao)
                .retiradaEmLoja(retiradaEmLoja)
                .build();
    }

}