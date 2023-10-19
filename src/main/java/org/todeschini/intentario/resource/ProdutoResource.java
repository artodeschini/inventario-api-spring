package org.todeschini.intentario.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.todeschini.intentario.exception.ResourceNotFindException;
import org.todeschini.intentario.model.Produto;
import org.todeschini.intentario.service.ProdutoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("inventario-app")
@CrossOrigin(value = "http://localhost:4200")
public class ProdutoResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProdutoResource.class);

    @Autowired
    private ProdutoService service;

    @GetMapping("/produtos")
    public List<Produto> listAll() {
        List<Produto> produtos = service.listAll();
        produtos.forEach(p -> LOGGER.info(p.toString()));
        return produtos;
    }

    @PostMapping("/produtos")
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto p) {
        return new ResponseEntity<Produto>(service.salvarProduto(p), HttpStatus.CREATED);
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Integer id) {
        Optional<Produto> p = service.findById(id);

        if (p.isPresent()) {
            return ResponseEntity.ok(p.get());
        } else {
            throw new ResourceNotFindException("Nao se encontrou o produto com id " + id);
        }
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<Produto> editarProduto(@PathVariable Integer id, @RequestBody Produto p) {
        Optional<Produto> database = service.findById(id);

        if (database.isPresent()) {
            Produto original = database.get();
            original.setDescricao(p.getDescricao());
            original.setPreco(p.getPreco());
            original.setQuantidade(p.getQuantidade());


            return ResponseEntity.ok(service.salvarProduto(original));

        } else {
            throw new ResourceNotFindException("Nao se encontrou o produto com id " + id);
        }
    }

    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<Map<String,Boolean>> delete(@PathVariable Integer id) {
        Optional<Produto> p = service.findById(id);

        if (p.isPresent()) {
            service.deleteById(id);

            Map<String,Boolean> resposta = new HashMap<>();
            resposta.put("delete", Boolean.TRUE);
            return ResponseEntity.ok(resposta);
        } else {
            throw new ResourceNotFindException("Nao se encontrou o produto com id " + id);
        }
    }
}
