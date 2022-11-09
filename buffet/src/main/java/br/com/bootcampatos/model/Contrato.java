package br.com.bootcampatos.model;

import javax.persistence.*;

@Entity
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantidadeConvidados;
    private boolean sobremesa;
    @ManyToOne
    private Cliente cliente;
    @Transient
    private Empresa empresa;


    public Empresa getEmpresa() {
        return empresa;
    }


    public Contrato(int quantidadeConvidados, boolean sobremesa, Cliente cliente) {
        this.empresa = new Empresa();
        this.cliente = cliente;
        this.quantidadeConvidados = quantidadeConvidados;
        this.sobremesa = sobremesa;
    }

    public Contrato() {

    }

    public int getQuantidadeConvidados() {
        return quantidadeConvidados;
    }

    public void setQuantidadeConvidados(int quantidadeConvidados) {
        this.quantidadeConvidados = quantidadeConvidados;
    }


    public int getQuantidadeGarcons() {
        return (int) Math.ceil((double) this.quantidadeConvidados / 15);
    }

    public double getTaxaGarcom() {
        return this.getQuantidadeGarcons() * 250;
    }


    public double getValorTotal() {
        double total = getTaxaGarcom() + quantidadeConvidados * 22.9;
        if (sobremesa == true) {
            return Math.round((total *= 1.1 * 100) / 100);
        } else {
            return Math.round((total * 100) / 100);
        }
    }

    public double getValorSobremesa() {
        double total1 = getTaxaGarcom() + quantidadeConvidados * 22.9;
        if (sobremesa == true) {
            return Math.round((total1 *= 0.1 * 100) / 100);
        } else {
            return Math.round((total1 * 0));
        }
    }

    public boolean isSobremesa() {
        return sobremesa;
    }

    public void setSobremesa(boolean sobremesa) {
        this.sobremesa = sobremesa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente nome) {
        this.cliente = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
