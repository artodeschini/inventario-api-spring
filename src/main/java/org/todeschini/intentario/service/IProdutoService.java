package org.todeschini.intentario.service;

import org.todeschini.intentario.model.Produto;

import java.util.List;
import java.util.Optional;

public interface IProdutoService {

    public List<Produto> listAll();

    public Optional<Produto> findById(Integer id);

    public Produto salvarProduto(Produto p);

    public void deleteById(Integer id);
}
