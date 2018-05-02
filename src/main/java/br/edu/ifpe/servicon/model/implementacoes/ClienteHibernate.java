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

import br.edu.ifpe.servicon.model.entidades.Cliente;
import br.edu.ifpe.servicon.model.interfaces.ClienteInterfaceDAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Your Sebastião Izidorio <sebastian.izydorio@gmail.com>
 */
public class ClienteHibernate implements ClienteInterfaceDAO{
    
    private final SessionFactory sessions;
    private static ClienteHibernate instance = null;
    
    public static ClienteHibernate getInstance() {
        if (instance == null) {
            instance = new ClienteHibernate();
        }
        return instance;
    }
    
    private ClienteHibernate() {
        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }

    @Override
    public void adicionar(Cliente cliente) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.persist(cliente);
            t.commit();
        } catch (Exception cadClienteError) {
            System.out.println(cadClienteError.getCause()
                    + "\nOcorreu um erro ao adicionar um cliente!");
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Cliente recuperar(int codigo) {
        Session session = this.sessions.openSession();
        try {
            return (Cliente) session.createQuery("FROM Cliente WHERE idCliente=" + codigo).getResultList().get(0);
        } catch (Exception recClienteError) {
            return null;
        }finally{
            session.close();
        }
    }

    @Override
    public void atualizar(Cliente cliente) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(cliente);
            t.commit();
        } catch (Exception atualizaClienteError) {
            System.out.println(atualizaClienteError.getCause()
                    + "\nOcorreu um erro ao atualizar um cliente!");
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Cliente cliente) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.delete(cliente);
            t.commit();
        } catch (Exception delClienteError) {
            System.out.println(delClienteError.getCause()
                    + "\nOcorreu um erro ao deletar um cliente!");
        } finally {
            session.close();
        }
    }

    @Override
    public List<Cliente> recuperarTodos() {
        Session session = this.sessions.openSession();
        List<Cliente> clientes = null;

        try {
            clientes = (List) session.createQuery("FROM Cliente").getResultList();
        } catch (Exception recTodosClientesError) {
            System.out.println(recTodosClientesError.getCause()
                    + "\nOcorreu um erro ao recuperar todos os clientes!");
        } finally {
            session.close();
            return clientes;
        }
    }
    
}
