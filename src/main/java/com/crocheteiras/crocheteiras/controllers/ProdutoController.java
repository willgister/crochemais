package com.crocheteiras.crocheteiras.controllers;

import com.crocheteiras.crocheteiras.model.Produto;
import com.crocheteiras.crocheteiras.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    // GET: Listar todos os produtos
    @GetMapping
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    // POST: Cadastrar novo produto
    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    // GET: Buscar por ID
    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    // DELETE: Excluir produto
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
    return produtoRepository.findById(id)
            .map(produtoExistente -> {
                produtoExistente.setNome(produtoAtualizado.getNome());
                produtoExistente.setPreco(produtoAtualizado.getPreco());
                produtoExistente.setDescricao(produtoAtualizado.getDescricao());
                produtoExistente.setTipo(produtoAtualizado.getTipo());
                produtoRepository.save(produtoExistente);
                return ResponseEntity.ok(produtoExistente);
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/produtos")
    public List<Produto> listarProdutos() {
    return produtoRepository.findAllByOrderByIdAsc();
    }
}