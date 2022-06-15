package br.com.alura.loja.orcamento;

import java.util.Map;

import br.com.alura.loja.DomainException;
import br.com.alura.loja.http.HttpAdapter;

// classe que vai usar um adapter sem precisar saber quem é
// tem um atributo do tipo da interface do adapter HttpAdapter
public class RegistroDeOrcamento {

	private HttpAdapter http;
	
	public RegistroDeOrcamento(HttpAdapter http) {
		this.http = http;
	}

	// método que usa o adapter
	public void registrar(Orcamento orcamento) {
		
		if (!orcamento.isFinalizado()) {
			throw new DomainException("Orçamento não finalizado!");
		}
		// chamada HTTP para API externa
		// URL Connection
		// Http Client
		// lib Rest
		String url = "http://api.externa/orcamento";
		Map<String, Object> dados = Map.of(
				"valor", orcamento.getValor(),
				"quantidadeItens", orcamento.getQuantidadeItens()
				);
		http.post(url, dados);
	}
	
}
