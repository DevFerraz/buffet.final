package br.com.bootcampatos.model;

import javax.persistence.*;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	
	public Cliente() {
		
	}
	
	public Cliente(String nome, String cpf, String email) {		
		this.nome = nome;
		this.cpf = cpf;		
		this.email = email;
	}
	
	public Cliente(String nome, String cpf, String telefone, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
