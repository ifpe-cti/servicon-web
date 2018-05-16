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
package br.edu.ifpe.servicon.model.validacoes;

import br.edu.ifpe.servicon.model.entidades.Profissional;
import br.edu.ifpe.servicon.model.implementacoes.mysql.ProfissionalHibernate;
import br.edu.ifpe.servicon.model.interfaces.DAO;
import java.util.List;

/**
 *
 * @author Lucas Mendes <lucas.mendes147@live.com>
 */
public class ValidacaoProfissional {
    private final DAO<Profissional> DAO;

    public ValidacaoProfissional() {
        this.DAO = ProfissionalHibernate.getInstance();
    }
    
    public void cadastrar(Profissional profissional){
        if(((ProfissionalHibernate)DAO)
                .recuperar(profissional.getCodigo()) == null){
            this.DAO.criar(profissional);
        }
    }
    
    public Profissional recuperar(Integer codigo){
        if(codigo == null){
            return null;
        } 
        return ((ProfissionalHibernate) DAO).recuperar(codigo);
    }
    
    public void alterar (Profissional profissional){
        if(((ProfissionalHibernate)DAO)
                .recuperar(profissional.getCodigo()) != null){
            this.DAO.atualizar(profissional);
        }
    }
    
    public void deletar(Profissional profissional){
        if(((ProfissionalHibernate)DAO)
                .recuperar(profissional.getCodigo()) != null){
            this.DAO.deletar(profissional);
        }
    }
    
    public List<Profissional> recuperarTodos(){
        return ((ProfissionalHibernate)DAO).recuperarTodos();
    }   
}
