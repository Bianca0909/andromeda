package br.com.triersistemas.andromeda.controller;

import br.com.triersistemas.andromeda.domain.Fornecedor;
import br.com.triersistemas.andromeda.model.FornecedorModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class FornecedorController {

    @RestController
    @RequestMapping("/farmaceutico")
    public class FarmaceuticoController {

        private static final List<Fornecedor> LIST = new ArrayList<>();

        @GetMapping("/consultar")
        public List<Fornecedor> consultar() {
            return LIST;
        }

        @PostMapping("/cadastrar")
        public List<Fornecedor> cadastrar(@RequestBody FornecedorModel model) {
            LIST.add(new Fornecedor(model.getNome(), model.getNiver(), model.getCnpj()));
            return LIST;
        }

        @PutMapping("/alterar/{index}")
        public List<Fornecedor> alterar(@PathVariable int index, @RequestBody FornecedorModel model) {
            LIST.remove(index);
            LIST.add(new Fornecedor(model.getNome(), model.getNiver(), model.getCnpj()));
            return LIST;
        }

        @DeleteMapping("/remover/{index}")
        public List<Fornecedor> remover(@PathVariable int index) {
            LIST.remove(index);
            return LIST;
        }
    }
}
