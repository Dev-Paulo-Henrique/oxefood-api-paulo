package br.com.ifpe.oxefood.modelo.venda;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaService {

    @Autowired
    private VendaRepository repository;

    @Transactional
    public Venda save(Venda venda) {

        venda.setHabilitado(Boolean.TRUE);
        return repository.save(venda);
    }

    public List<Venda> listarTodos() {

        return repository.findAll();
    }

    public Venda obterPorID(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Venda vendaAlterado) {

        Venda venda = repository.findById(id).get();
        venda.setCliente(vendaAlterado.getCliente());
        venda.setProduto(vendaAlterado.getProduto());
        venda.setStatusVenda(vendaAlterado.getStatusVenda());
        venda.setDataVenda(vendaAlterado.getDataVenda());
        venda.setValorTotal(vendaAlterado.getValorTotal());
        venda.setObservacao(vendaAlterado.getObservacao());
        venda.setRetiradaEmLoja(vendaAlterado.getRetiradaEmLoja());

        repository.save(venda);
    }

    @Transactional
    public void delete(Long id) {

        Venda venda = repository.findById(id).get();
        venda.setHabilitado(Boolean.FALSE);

        repository.save(venda);
    }

}