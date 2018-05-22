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
package br.edu.ifpe.servicon.model.implementacoes.hibernate;

import br.edu.ifpe.servicon.model.entidades.Pessoa;
import br.edu.ifpe.servicon.model.interfaces.PessoaInterfaceDAO;
import br.edu.ifpe.servicon.model.utill.HibernateUtill;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Lucas Mendes <lucas.mendes147@live.com>
 */
public class PessoaHibernate implements PessoaInterfaceDAO {

    private static PessoaHibernate instance = null;
    private final HibernateUtill UTILL;
    private Session session;

    public static PessoaHibernate getInstance() {
        if (instance == null) {
            instance = new PessoaHibernate();
        }
        return instance;
    }

    public PessoaHibernate() {
        this.UTILL = HibernateUtill.getInstance();
    }

    @Override
    public void criar(Pessoa pessoa) {
        session = UTILL.getSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(pessoa);
            t.commit();
        } catch (Exception addPessoaException) {
            System.out.println(addPessoaException.getMessage());
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Pessoa recuperar(Integer codigo) {
        try {
            session = UTILL.getSession();
            return (Pessoa) session.createQuery
                ("FROM Pessoa where id_pessoa=" + codigo).getResultList();
        } catch (Exception readPessoaException) {
            System.out.println(readPessoaException.getMessage());
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void atualizar(Pessoa pessoa) {
        session = UTILL.getSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(pessoa);
            t.commit();
        } catch (Exception updatePessoaException) {
            System.out.println(updatePessoaException.getMessage());
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Pessoa pessoa) {
        session = UTILL.getSession();
        Transaction t = session.beginTransaction();
        try {
            session.delete(pessoa);
            t.commit();
        } catch (Exception dellPessoaException) {
            System.out.println(dellPessoaException.getMessage());
            t.rollback();
        } finally {
            session.close();
        }
    }
    
    @Override
    public List<Pessoa> recuperarTodos() {
        session = UTILL.getSession();
        List<Pessoa> pessoas = new ArrayList();
        try{
            pessoas = (List) session.createQuery
            ("FROM pessoa").getResultList();
        }catch(Exception readAllPessoasException){
            System.out.println(readAllPessoasException.getMessage());
        }finally{
            session.close();
            return pessoas;
        }
    }
}
