package tempo.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tempo.controller.CidadeController;
import tempo.model.Cidade;
import tempo.util.PrevisaoUtil;

public class buscaAPI implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nome = request.getParameter("city");
				
		CidadeController cidadeController = new CidadeController();
		
		Cidade cidade = new Cidade(nome);
		cidadeController.cadastrar(cidade);
		//new PrevisaoUtil(cidade);
		
		HttpSession sessao = request.getSession();
		sessao.setAttribute("cidadeLogada", cidade);
		return "redirect:frete";
		
	}

}
