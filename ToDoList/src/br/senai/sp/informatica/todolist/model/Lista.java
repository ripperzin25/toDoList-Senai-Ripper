package br.senai.sp.informatica.todolist.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Lista {
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
	private Long id;
	@Column(length = 100) // Configurar as colunas
	private String title;
	@OneToMany(mappedBy="lista", cascade=CascadeType.ALL, orphanRemoval=true)	//dono do relacionamento, vai virar chave estrangeira na outra tabela Cascade 
																				//deleta em todas as tabelas sincronizando
	private List<ItemList> itens;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<ItemList> getItens() {
		return itens;
	}

	public void setItens(List<ItemList> itens) {
		this.itens = itens;
	}

	public boolean isDid() {
		for (ItemList item : itens) {
			if (!item.isDid()) {
				return false;
			}
		}
		return true;
	}

}
