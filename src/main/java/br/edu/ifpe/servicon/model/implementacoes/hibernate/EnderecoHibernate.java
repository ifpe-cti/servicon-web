/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.servicon.model.implementacoes.hibernate;

import br.edu.ifpe.servicon.model.entidades.Endereco;
import br.edu.ifpe.servicon.model.interfaces.EnderecoInterfaceDAO;
import br.edu.ifpe.servicon.model.utill.HibernateUtill;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Lucas Mendes <lucas.mendes147@live.com>
 */
public class EnderecoHibernate implements EnderecoInterfaceDAO {

    private final HibernateUtill utill;
    private static EnderecoHibernate instance;
    private Session session;

    public EnderecoHibernate() {
        utill = HibernateUtill.getInstance();
    }

    @Override
    public void criar(Endereco endereco) {
        session = utill.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(endereco);
            transaction.commit();
        } catch (Exception createEnderecoException) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Endereco recuperar(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Endereco endereco) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Endereco endereco) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Endereco> recuperarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
