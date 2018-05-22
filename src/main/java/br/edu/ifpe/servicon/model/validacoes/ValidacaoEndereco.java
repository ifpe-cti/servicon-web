/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.servicon.model.validacoes;

import br.edu.ifpe.servicon.model.entidades.Endereco;
import br.edu.ifpe.servicon.model.implementacoes.hibernate.EnderecoHibernate;
import br.edu.ifpe.servicon.model.interfaces.DAO;
import java.util.List;

/**
 *
 * @author Lucas Mendes <lucas.mendes147@live.com>
 */
public class ValidacaoEndereco {

    private final DAO<Endereco> DAO;

    public ValidacaoEndereco() {
        this.DAO = new EnderecoHibernate();
    }

    public void criar(Endereco endereco) {
        if (((EnderecoHibernate) DAO)
                .recuperar(endereco.getCodigo()) == null) {
            this.DAO.criar(endereco);
        }
    }

    public Endereco recuperar(Integer codigo) {
        if (codigo == null) {
            return null;
        }
        return ((EnderecoHibernate) DAO).recuperar(codigo);
    }

    public void atualizar(Endereco endereco) {
        if (((EnderecoHibernate) DAO)
                .recuperar(endereco.getCodigo()) != null) {
            this.DAO.atualizar(endereco);
        }
    }

    public void deletar(Endereco endereco) {
        if (((EnderecoHibernate) DAO)
                .recuperar(endereco.getCodigo()) != null) {
            this.DAO.deletar(endereco);
        }
    }

    public List<Endereco> recuperarTodos() {
        return ((EnderecoHibernate) DAO).recuperarTodos();
    }
}
