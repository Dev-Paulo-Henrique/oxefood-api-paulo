package br.com.ifpe.oxefood.api.entregador;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorRequest {

    @NotBlank(message = "O Email é de preenchimento obrigatório")
    @Email
    private String email;
   
   private String nome;
   private String cpf;
   private String rg;
   @JsonFormat(pattern = "dd/MM/yyyy")
   private LocalDate dataNascimento;
   private String foneCelular;
   private String foneFixo;
   private String qtdEntregasRealizadas;
   private String valorFrete;
   private String enderecoRua;
   private Number enderecoNumero;
   private String enderecoBairro;
   private String enderecoCep;
   private String enderecoCidade;
   private String enderecoEstado;
   private String enderecoComplemento;
   private Boolean ativo;

   public Entregador build() {

       return Entregador.builder()
           .nome(nome)
           .rg(rg)
           .qtdEntregasRealizadas(qtdEntregasRealizadas)
           .valorFrete(valorFrete)
           .enderecoRua(enderecoRua)
           .enderecoNumero(enderecoNumero)
           .enderecoBairro(enderecoBairro)
           .enderecoCep(enderecoCep)
           .enderecoCidade(enderecoCidade)
           .enderecoEstado(enderecoEstado)
           .enderecoComplemento(enderecoComplemento)
           .ativo(ativo)
           .dataNascimento(dataNascimento)
           .cpf(cpf)
           .email(email)
           .foneCelular(foneCelular)
           .foneFixo(foneFixo)
           .build();
   }

}
