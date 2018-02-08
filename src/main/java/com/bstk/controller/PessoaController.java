package com.bstk.controller;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.bstk.dao.PessoaDAO;
import com.bstk.models.Pessoa;

public class PessoaController {
	
	private PessoaDAO dao;
	
	public PessoaController() {
		this.dao = new PessoaDAO();
	}
	
	public Pessoa getPessoa(int id) {
		if(id == 0) {
			throw new WebApplicationException(Response.Status.NO_CONTENT);
		} else {
			return dao.getPessoa(id);
		}
	}
}
