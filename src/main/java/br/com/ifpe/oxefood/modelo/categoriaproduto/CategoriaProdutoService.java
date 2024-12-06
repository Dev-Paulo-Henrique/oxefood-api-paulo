package br.com.ifpe.oxefood.modelo.categoriaproduto;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class CategoriaProdutoService {

    @Autowired
    private CategoriaProdutoRepository repository;

    @Transactional
    public CategoriaProduto save(CategoriaProduto categoriaProduto) {

        categoriaProduto.setHabilitado(Boolean.TRUE);
        return repository.save(categoriaProduto);
    }

    public List<CategoriaProduto> listarTodos() {

        return repository.findAll();
    }

    public CategoriaProduto obterPorID(Long id) {

        Optional<CategoriaProduto> consulta = repository.findById(id);

        if (consulta.isPresent()) {
            return consulta.get();
        } else {
            throw new EntidadeNaoEncontradaException("CategoriaProduto", id);
        }

    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public class EntidadeNaoEncontradaException extends RuntimeException {

        public EntidadeNaoEncontradaException(String entidade, Long id) {
            super(String.format("Não foi encontrado(a) um(a) %s com o id %s", entidade, id.toString()));
        }
    }

    @Transactional
    public void update(Long id, CategoriaProduto categoriaProdutoAlterado) {

        CategoriaProduto categoriaProduto = repository.findById(id).get();
        categoriaProduto.setDescricao(categoriaProdutoAlterado.getDescricao());

        repository.save(categoriaProduto);
    }

    @Transactional
    public void delete(Long id) {

        CategoriaProduto categoriaProduto = repository.findById(id).get();
        categoriaProduto.setHabilitado(Boolean.FALSE);

        repository.save(categoriaProduto);
    }

}
