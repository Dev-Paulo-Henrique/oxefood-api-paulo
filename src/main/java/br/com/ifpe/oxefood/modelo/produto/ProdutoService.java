package br.com.ifpe.oxefood.modelo.produto;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Transactional
    public Produto save(Produto produto) {

        produto.setHabilitado(Boolean.TRUE);
        return repository.save(produto);
    }

    public List<Produto> listarTodos() {

        return repository.findAll();
    }

    public Produto obterPorID(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Produto produtoAlterado) {

        Produto produto = repository.findById(id).get();
        produto.setTitulo(produtoAlterado.getTitulo());
        produto.setDescricao(produtoAlterado.getDescricao());
        produto.setTempoEntregaMaximo(produtoAlterado.getTempoEntregaMaximo());
        produto.setTempoEntregaMinimo(produtoAlterado.getTempoEntregaMinimo());
        produto.setCodigo(produtoAlterado.getCodigo());
        produto.setValorUnitario(produtoAlterado.getValorUnitario());

        repository.save(produto);
    }

}
