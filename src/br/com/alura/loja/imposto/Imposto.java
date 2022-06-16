package br.com.alura.loja.imposto;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.Orcamento;

// transformada em classe para ter outros métodos com implementação
public abstract class Imposto {

	// classe que representa outro imposto - autorelacionamento
	// uma classe está decorando outra classe com ela mesma
	private Imposto outro;
	
	public Imposto(Imposto outro) {
		this.outro = outro;
	}

	// abstrato, pois não sabe quem vai calcular
	protected abstract BigDecimal realizarCalculo(Orcamento orcamento);
	
	public BigDecimal calcular(Orcamento orcamento) {
		BigDecimal valorImposto = realizarCalculo(orcamento);
		BigDecimal valorDoOutroImposto = BigDecimal.ZERO;
		// se não tiver outro imposto então o valor é zero
		if (outro != null)
			valorDoOutroImposto = outro.realizarCalculo(orcamento);
		return valorImposto.add(valorDoOutroImposto);
	}

}
