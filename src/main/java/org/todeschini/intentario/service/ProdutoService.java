package org.todeschini.intentario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.todeschini.intentario.model.Produto;
import org.todeschini.intentario.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService implements IProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Override
    public List<Produto> listAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Produto> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Produto salvarProduto(Produto p) {
        return repository.save(p);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
