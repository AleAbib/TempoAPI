package tempo.controller;

import javax.persistence.EntityManager;

import tempo.dao.CidadeDao;
import tempo.model.Cidade;
import tempo.util.JPAUtil;


public class CidadeController {
	
	private CidadeDao cidadeDao;
	private EntityManager em;
	
	public CidadeController() {
		this.em = JPAUtil.getEntityManager();;
		cidadeDao = new CidadeDao(em);
	}
	
	public void cadastrar(Cidade cidade) {
		em.getTransaction().begin();
		this.cidadeDao.cadastrar(cidade);
		em.getTransaction().commit();
		em.close();
	}
	
	public void atualizar(Cidade cidade) {
		em.getTransaction().begin();
		this.cidadeDao.atualizar(cidade);
		em.getTransaction().commit();
		em.close();
	}
	
	public Cidade cidadeCadastrada(String nome) {
		return this.cidadeDao.cidadeCadastrada(nome);
	}

}
