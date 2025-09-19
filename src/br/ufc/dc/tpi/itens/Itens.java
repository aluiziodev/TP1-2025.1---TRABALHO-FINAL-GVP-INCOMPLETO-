package br.ufc.dc.tpi.itens;

import java.io.Serializable;

import br.ufc.dc.tpi.enums.*;

public abstract class Itens implements Serializable{
		protected String nome;
		protected String cor;
		protected Conservaçao conservaçao;
		protected String origem;
		protected Tipos tipo;
		protected int qtd_usos;
		
		public Itens(String nome, String cor, Conservaçao conservaçao, String origem) {
			this.conservaçao = conservaçao;
			this.cor = cor;
			this.nome = nome;
			this.origem = origem;
			this.qtd_usos = 0;
		}
		
		public void modificar_nome(String s) {
			this.nome = s;
		}
		
		public void modificar_origem(String s) {
			this.origem = s;
		}
		
		public void modificar_conservaçao(Conservaçao s) {
			this.conservaçao = s;
		}
		
		public void modificar_cor(String s) {
			this.cor = s;
		}
		
		
		public String get_nome() {
			return nome;
		}
		
		public String get_cor() {
			return cor;
		}
		
		public Conservaçao get_conservaçao() {
			return conservaçao;
		}
		
		public String get_origem() {
			return origem;
		}
		public Tipos get_tipo() {
			return tipo;
		}
		public void registrar_uso() {
			qtd_usos++;
		}
		
		public int get_usos() {
			return qtd_usos;
		}
		
		public boolean isEmprestavel() {
			return this instanceof IEmprestavel;
		}
		public boolean isLavavel() {
			return this instanceof ILavavel;
		}
		
		public String toString() {
			return this.get_nome();
		}
	
		
		
		
		
		
		

		
		

		
}
