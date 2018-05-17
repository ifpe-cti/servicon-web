/*MIT License

Copyright (c) 2018 Fabricio Barros Cabral, Lucas Mendes Cavalcanti, 
Marcela Cardoso Melo, Sebastiao Izidorio de Oliveira Neto

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.*/
package br.edu.ifpe.servicon.model.entidades;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Lucas Mendes <lucas.mendes147@live.com>
 */
@Entity
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servico")
    private Integer codigo;
    private Cliente cliente;
    private List<Profissional> profissionais;
    private Timestamp dataHora;

    @Deprecated
    public Servico() {
    }

    public Servico(Cliente cliente, List<Profissional> profissionais,
            Timestamp dataHora) {
        this.cliente = cliente;
        this.profissionais = profissionais;
        this.dataHora = dataHora;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Profissional> getProfissionais() {
        return profissionais;
    }

    public void setProfissionais(List<Profissional> Profissionais) {
        this.profissionais = Profissionais;
    }

    public Timestamp getDataHora() {
        return dataHora;
    }

    public void setDataHora(Timestamp dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public int hashCode() {
        final int HASH = 23;
        int result = 1;
        result = (HASH * result) + codigo.hashCode();
        result = (HASH * result) + cliente.hashCode();
        result = (HASH * result) + profissionais.hashCode();
        result = (HASH * result) + dataHora.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Servico other = (Servico) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.profissionais, other.profissionais)) {
            return false;
        }
        return Objects.equals(this.dataHora, other.dataHora);
    }

    @Override
    public String toString() {
        return "Servico{" + "codigo=" + codigo
                + ", cliente=" + cliente + ", profissionais=" + profissionais
                + ", dataHora=" + dataHora + '}';
    }
}
