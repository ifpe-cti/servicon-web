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

import br.edu.ifpe.servicon.model.entidades.Endereco;
import br.edu.ifpe.servicon.model.interfaces.EnderecoInterfaceDAO;
import br.edu.ifpe.servicon.model.utill.HibernateUtill;
import java.util.ArrayList;
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
            System.out.println(createEnderecoException.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Endereco recuperar(Integer codigo) {
        try {
            session = utill.getSession();
            return (Endereco) session.createQuery
            ("FROM Endereco where id_endereco=" + codigo).getResultList();
        } catch (Exception readEnderecoException) {
            System.out.println(readEnderecoException.getMessage());
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void atualizar(Endereco endereco) {
        session = utill.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(endereco);
            transaction.commit();
        } catch (Exception updateEnderecoException) {
            System.out.println(updateEnderecoException.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Endereco endereco) {
        session = utill.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(endereco);
            transaction.commit();
        } catch (Exception delEnderecoException) {
            System.out.println(delEnderecoException.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Endereco> recuperarTodos() {
        session = utill.getSession();
        List<Endereco> enderecos = new ArrayList();
        try{
            enderecos = (List) session.createQuery
            ("FROM endereco").getResultList();
        }catch(Exception readAllEnderecosException){
            System.out.println(readAllEnderecosException.getMessage());
        }finally{
            session.close();
            return enderecos;
        }
    }
}
