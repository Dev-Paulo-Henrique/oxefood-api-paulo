package br.com.ifpe.oxefood.api.produto;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

   private Long idCategoria;

   private String codigo;

   private String descricao;

   private String tempoEntregaMaximo;

   private String tempoEntregaMinimo;

   private String titulo;

   private Double valorUnitario;

   public Produto build() {

       return Produto.builder()
           .codigo(codigo)
           .descricao(descricao)
           .tempoEntregaMaximo(tempoEntregaMaximo)
           .tempoEntregaMinimo(tempoEntregaMinimo)
           .titulo(titulo)
           .valorUnitario(valorUnitario)
           .build();
   }

}
