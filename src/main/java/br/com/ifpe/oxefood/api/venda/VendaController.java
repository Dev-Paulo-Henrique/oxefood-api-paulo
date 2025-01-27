package br.com.ifpe.oxefood.api.venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.venda.Venda;
import br.com.ifpe.oxefood.modelo.venda.VendaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/venda")
@CrossOrigin

@Tag(
    name = "API Venda",
    description = "API responsável pelos serviços de venda no sistema"
)
public class VendaController {

    @Operation(
        summary = "Serviço responsável por listar todas as vendas no sistema."
    ) 
    @GetMapping
    public List<Venda> listarTodos() {
        return vendaService.listarTodos();
    }

    @Operation(
        summary = "Serviço responsável por listar uma venda de ID específico no sistema."
    ) 
    @GetMapping("/{id}")
    public Venda obterPorID(@PathVariable Long id) {
        return vendaService.obterPorID(id);
    }

    @Operation(
        summary = "Serviço responsável por editar uma venda de ID específico no sistema."
    ) 
    @PutMapping("/{id}")
    public ResponseEntity<Venda> update(@PathVariable("id") Long id, @RequestBody VendaRequest request) {

        vendaService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @Autowired
    private VendaService vendaService;

    @Operation(
        summary = "Serviço responsável por salvar uma venda no sistema."
    ) 
    @PostMapping
    public ResponseEntity<Venda> save(@RequestBody VendaRequest request) {

        Venda venda = vendaService.save(request.build());
        return new ResponseEntity<Venda>(venda, HttpStatus.CREATED);
    }

    @Operation(
        summary = "Serviço responsável por deletar uma venda de ID específico no sistema."
    ) 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        vendaService.delete(id);
        return ResponseEntity.ok().build();
    }

}
