/* The MIT License (MIT)

Copyright (C) 2018 Servi�On Lucas Mendes Cavalcanti, Marcela Cardoso Melo,
Sebastiao Izidorio de Oliveira Neto, Fabricio Cabral (Orientador)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to
deal in the Software without restriction, including without limitation the
rights to use, copy, modify, merge, publish, distribute, sublicense, and/or
sell copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
IN THE SOFTWARE.*/
package br.edu.ifpe.servicon.model.implementacoes;

import br.edu.ifpe.servicon.model.entidades.Pagamento;
import br.edu.ifpe.servicon.model.interfaces.PagamentoInterfaceDAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Your Sebastião Izidorio <sebastian.izydorio@gmail.com>
 */
public class PagamentoHibernate implements PagamentoInterfaceDAO{
    
    private final SessionFactory sessions;
    private static PagamentoHibernate instance = null;
    
    public static PagamentoHibernate getInstance() {
        if (instance == null) {
            instance = new PagamentoHibernate();
        }
        return instance;
    }
    
    private PagamentoHibernate() {
        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }

    @Override
    public void adicionar(Pagamento pagamento) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.persist(pagamento);
            t.commit();
        } catch (Exception cadPagamentoError) {
            System.out.println(cadPagamentoError.getCause()
                    + "\nOcorreu um erro ao adicionar um pagamento!");
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Pagamento recuperar(int codigo) {
        Session session = this.sessions.openSession();
        try {
            return (Pagamento) session.createQuery("FROM Pagamento WHERE idPagamento=" + codigo).getResultList().get(0);
        } catch (Exception recPagamentoError) {
            return null;
        }finally{
            session.close();
        }
    }

    @Override
    public void atualizar(Pagamento pagamento) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(pagamento);
            t.commit();
        } catch (Exception atualizaPagamentoError) {
            System.out.println(atualizaPagamentoError.getCause()
                    + "\nOcorreu um erro ao atualizar um pagamento!");
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Pagamento pagamento) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.delete(pagamento);
            t.commit();
        } catch (Exception delPagamentoError) {
            System.out.println(delPagamentoError.getCause()
                    + "\nOcorreu um erro ao deletar um pagamento!");
        } finally {
            session.close();
        }
    }

    @Override
    public List<Pagamento> recuperarTodos() {
        Session session = this.sessions.openSession();
        List<Pagamento> pagamentos = null;

        try {
            pagamentos = (List) session.createQuery("FROM Pagamento").getResultList();
        } catch (Exception recTodosPagamentosError) {
            System.out.println(recTodosPagamentosError.getCause()
                    + "\nOcorreu um erro ao recuperar todos os pagamentos!");
        } finally {
            session.close();
            return pagamentos;
        }
    }
    
    
    
}
