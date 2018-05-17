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

import br.edu.ifpe.servicon.model.entidades.Profissional;
import br.edu.ifpe.servicon.model.interfaces.ProfissionalInterfaceDAO;
import br.edu.ifpe.servicon.model.utill.HibernateUtill;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Lucas Mendes <lucas.mendes147@live.com>
 */
public class ProfissionalHibernate implements ProfissionalInterfaceDAO {
    private static ProfissionalHibernate instance = null;
    private final HibernateUtill utill;
    private Session session;
    
    public static ProfissionalHibernate getInstance(){
        if(instance == null){
            instance = new ProfissionalHibernate();
        }
        return instance;
    }

    public ProfissionalHibernate() {
        this.utill = HibernateUtill.getInstance();
    }

    @Override
    public void criar(Profissional profissional) {
        session = utill.getSession();
        Transaction t = session.beginTransaction();
        try{
            session.save(profissional);
            t.commit();
        }catch(Exception addProfissionalException){
            t.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public Profissional recuperar(int codigo) {
        session = utill.getSession();
        try {
            return (Profissional) session.createQuery
            ("FROM Profissional WHERE id_profissional = " + codigo).getResultList().get(0);
        } catch (Exception recProfissionalException) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void atualizar(Profissional profissional) {
        session = utill.getSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(profissional);
            t.commit();
        } catch (Exception updateProfissionalException) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Profissional profissional) {
        session = utill.getSession();
        Transaction t = session.beginTransaction();
        try {
            session.delete(profissional);
            t.commit();
        } catch (Exception delProfissionalException) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Profissional> recuperarTodos() {
        session = utill.getSession();
        List<Profissional> profissionais = null;
        try {
            profissionais = (List) session.createQuery
                ("FROM Profissional").getResultList();
        } catch (Exception recTodosProfissionalException) {
            return null;
        } finally {
            session.close();
            return profissionais;
        }
    }

}
