package br.com.ifpe.oxefood.modelo.cliente;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.SQLRestriction;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "EnderecoCliente")
@SQLRestriction("habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoCliente extends EntidadeAuditavel {

    @JsonIgnore
    @ManyToOne
    private Cliente cliente;
 
    @Column
    private String rua;
 
    @Column
    private String numero;
 
    @Column
    private String bairro;
    
    @Column
    private String cep;
 
    @Column
    private String cidade;
 
    @Column
    private String estado;
 
    @Column
    private String complemento;
   
 }
 