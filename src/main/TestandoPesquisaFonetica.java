package main;

import pessoa.PessoaDAO;

public class TestandoPesquisaFonetica {
	public static void main(String[] args) {
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.listarPessoas();
	}
}
