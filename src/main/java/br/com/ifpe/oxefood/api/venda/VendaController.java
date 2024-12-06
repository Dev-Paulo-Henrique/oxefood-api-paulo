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

import java.util.List;

@RestController
@RequestMapping("/api/venda")
@CrossOrigin
public class VendaController {

    @GetMapping
    public List<Venda> listarTodos() {
        return vendaService.listarTodos();
    }

    @GetMapping("/{id}")
    public Venda obterPorID(@PathVariable Long id) {
        return vendaService.obterPorID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venda> update(@PathVariable("id") Long id, @RequestBody VendaRequest request) {

        vendaService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @Autowired
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<Venda> save(@RequestBody VendaRequest request) {

        Venda venda = vendaService.save(request.build());
        return new ResponseEntity<Venda>(venda, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        vendaService.delete(id);
        return ResponseEntity.ok().build();
    }

}
