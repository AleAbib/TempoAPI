package tempo.dao;

import javax.persistence.EntityManager;

import tempo.model.Cidade;

public class CidadeDao {
	
	private EntityManager em;

	public CidadeDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Cidade cidade) {
		this.em.persist(cidade);
	}
	
	public void atualizar(Cidade cidade) {
		this.em.merge(cidade);
	}
	
	public Cidade cidadeCadastrada(String nome) {
		try{
			String jpql = "FROM Cliente WHERE nome = :nome";
			return em.createQuery(jpql, Cidade.class).setParameter("nome", nome).getSingleResult();
		} catch (Exception e) {
			System.err.println("Cidade não encontrado!");
			return null;
		}
	}

}
