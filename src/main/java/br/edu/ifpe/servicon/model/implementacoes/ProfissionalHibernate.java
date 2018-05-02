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

import br.edu.ifpe.servicon.model.entidades.Profissional;
import br.edu.ifpe.servicon.model.interfaces.ProfissionalInterfaceDAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Your Sebastião Izidorio <sebastian.izydorio@gmail.com>
 */
public class ProfissionalHibernate implements ProfissionalInterfaceDAO{
    
    private final SessionFactory sessions;
    private static ProfissionalHibernate instance = null;
    
    public static ProfissionalHibernate getInstance() {
        if (instance == null) {
            instance = new ProfissionalHibernate();
        }
        return instance;
    }
    
    private ProfissionalHibernate() {
        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }

    @Override
    public void adicionar(Profissional profissional) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.persist(profissional);
            t.commit();
        } catch (Exception cadProfissionalError) {
            System.out.println(cadProfissionalError.getCause()
                    + "\nOcorreu um erro ao adicionar um profissional!");
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Profissional recuperar(int codigo) {
        Session session = this.sessions.openSession();
        try {
            return (Profissional) session.createQuery("FROM Profissional WHERE idProfissional=" + codigo).getResultList().get(0);
        } catch (Exception recProfissionalError) {
            return null;
        }finally{
            session.close();
        }
    }

    @Override
    public void atualizar(Profissional profissional) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(profissional);
            t.commit();
        } catch (Exception atualizaProfissionalError) {
            System.out.println(atualizaProfissionalError.getCause()
                    + "\nOcorreu um erro ao atualizar um profissional!");
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Profissional profissional) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.delete(profissional);
            t.commit();
        } catch (Exception delProfissionalError) {
            System.out.println(delProfissionalError.getCause()
                    + "\nOcorreu um erro ao deletar um profissional!");
        } finally {
            session.close();
        }
    }

    @Override
    public List<Profissional> recuperarTodos() {
        Session session = this.sessions.openSession();
        List<Profissional> profissionais = null;

        try {
            profissionais = (List) session.createQuery("FROM Profissional").getResultList();
        } catch (Exception recTodosProfissionaisError) {
            System.out.println(recTodosProfissionaisError.getCause()
                    + "\nOcorreu um erro ao recuperar todos os profissionais!");
        } finally {
            session.close();
            return profissionais;
        }
    }
    
}
