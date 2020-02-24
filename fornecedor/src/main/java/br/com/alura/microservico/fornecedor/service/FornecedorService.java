package br.com.alura.microservico.fornecedor.service;

import br.com.alura.microservico.fornecedor.model.InfoFornecedor;
import br.com.alura.microservico.fornecedor.repository.InfoFornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornecedorService {

    @Autowired
    private InfoFornecedorRepository fornecedorRepository;

    public InfoFornecedor findByEstado(String estado){
        return fornecedorRepository.findByEstado(estado);
    }
}
