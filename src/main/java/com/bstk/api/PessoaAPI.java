package com.bstk.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bstk.dao.PessoaDAO;
import com.bstk.models.Pessoa;

@Path("/")
public class PessoaAPI {
	
	private PessoaDAO dao;
	
	public PessoaAPI() {
		dao = new PessoaDAO();
	}
	
	@GET
	@Path("pessoas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<?> getAll(){
		return this.dao.getPessoas();
	}
	
	@GET
	@Path("pessoa/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pessoa getById(@PathParam("id") int id) {
		return dao.getPessoa(id);
	}
	
	@DELETE
	@Path("pessoa/{id}")
	public void remove(@PathParam("id") int id) {
		dao.remover(id);
	}
	
	@POST
	@Path("pessoa/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void add(Pessoa pessoa) {
		dao.salvar(pessoa);
	}
}
