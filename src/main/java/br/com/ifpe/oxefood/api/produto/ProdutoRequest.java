package br.com.ifpe.oxefood.api.produto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

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

   private String nome;

   @JsonFormat(pattern = "dd/MM/yyyy")
   private LocalDate dataNascimento;

   private String cpf;

   private String foneCelular;

   private String foneFixo;

   public Produto build() {

       return Produto.builder()
           .nome(nome)
           .dataNascimento(dataNascimento)
           .cpf(cpf)
           .foneCelular(foneCelular)
           .foneFixo(foneFixo)
           .build();
   }

}
