package com.ada.emprestimo.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.UriSpec;

import com.ada.emprestimo.dto.LivroDto;
import com.ada.emprestimo.service.LivroService;

import ch.qos.logback.core.net.server.Client;
import io.netty.handler.codec.http.HttpMethod;
import reactor.core.publisher.Flux;

@Service
public class LivroServiceImpl implements LivroService {

    private final String URL = "http://localhost:8090";
    private final String URI = "livros";
    @Override
    public LivroDto retornaDadosLivro(int idLivro) {
        return WebClient
                .create(URL)
                .get()
                .uri(URI + "/{id}", idLivro)
                .retrieve()
                .bodyToMono(LivroDto.class).block();
    }
    @Override
    public Flux<LivroDto> livrosDisponiveis() {
        return WebClient
                .create(URL)
                .get()
                .uri(URI)
                .retrieve()
                .bodyToFlux(LivroDto.class);
    }
    
    @Override
    public void gerenciamentoEstoque(int idLivro, String tipoTransacao) {
		WebClient
        .create(URL)
        .patch()
        .uri(URI + "/" + idLivro + "/estoque")
        .header("tipoTransacao", tipoTransacao)
        .retrieve()
        .bodyToMono(String.class)
        .subscribe(System.out::println);

    }
    
}
