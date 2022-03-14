package tempo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "cidades")
public class Cidade {
	
	@Id @GeneratedValue (strategy= GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer temperatura;
	private String data;
	private String descricao;
	
	public Cidade(String nome, int tempInt, String data, String descricao) {
		this.nome = nome;
		this.temperatura = tempInt;
		this.data = data;
		this.descricao = descricao;
	}
	
	public Cidade() {
	
	}

	public Cidade(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(Integer temperatura) {
		this.temperatura = temperatura;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public String toString() {
		
		return nome + temperatura + data + descricao;
	}
}
