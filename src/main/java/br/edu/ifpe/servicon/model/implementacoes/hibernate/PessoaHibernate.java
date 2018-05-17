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
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Lucas Mendes <lucas.mendes147@live.com>
 */
public class PessoaHibernate implements PessoaInterfaceDAO{
    private static PessoaHibernate instance = null;
    private final HibernateUtill utill;
    private Session session;
    
    public static PessoaHibernate getInstance(){
        if(instance == null){
            instance = new PessoaHibernate();
        }
        return instance;
    }

    public PessoaHibernate() {
        this.utill = HibernateUtill.getInstance();
    }  

    @Override
    public void criar(Pessoa pessoa) {
        session = utill.getSession();
        Transaction t = session.beginTransaction();
        try{
            session.saveOrUpdate(pessoa);
            t.commit();
        }catch(Exception addPessoaException){
            t.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public Pessoa recuperar(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Pessoa pessoa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Pessoa pessoa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pessoa> recuperarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
