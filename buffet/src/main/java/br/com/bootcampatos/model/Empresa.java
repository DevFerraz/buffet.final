package br.com.bootcampatos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Empresa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private String cnpj;
	private String nome;
	private String telefone;

	public Empresa(String cnpj, String nome, String telefone) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.telefone = telefone;
	}
	public Empresa(){
		this.cnpj = "43.789.256/0001-99";
		this.nome = "Elegance Buffet";
		this.telefone = "(21) 3000-2000";
	}

	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getString() {
		return "A empresa de nome: " + this.nome + "<br> inscrita sob o CNPJ: " +
				this.cnpj + "<br> de telefone " + this.telefone
				+ "<br> apresenta, sob todos os termos legais, a seguinte proposta " +
				"comercial: <br>";
	}
}
