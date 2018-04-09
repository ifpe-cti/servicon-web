/*MIT License

Copyright (c) 2018 Fabricio Barros Cabral, Lucas Mendes Cavalcanti, Marcela Cardoso Melo, Sebastiao Izidorio de Oliveira Neto

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

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 * @author Lucas Mendes <lucas.mendes147@live.com>
 */
public class Servico {
    
    private int idServico;
    private Timestamp dataHorario;
    private BigDecimal valor;
    private Cliente cliente;
    private Profissional profissional;

    public Servico(int idServico, Timestamp dataHorario, BigDecimal valor, Cliente cliente, Profissional profissional) {
        this.idServico = idServico;
        this.dataHorario = dataHorario;
        this.valor = valor;
        this.cliente = cliente;
        this.profissional = profissional;
    }

    public int getIdServico() {
        return idServico;
    }

    public Timestamp getDataHorario() {
        return dataHorario;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public void setDataHorario(Timestamp dataHorario) {
        this.dataHorario = dataHorario;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + this.idServico;
        hash = 43 * hash + Objects.hashCode(this.dataHorario);
        hash = 43 * hash + Objects.hashCode(this.valor);
        hash = 43 * hash + Objects.hashCode(this.cliente);
        hash = 43 * hash + Objects.hashCode(this.profissional);
        return hash;
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
        if (this.idServico != other.idServico) {
            return false;
        }
        if (!Objects.equals(this.dataHorario, other.dataHorario)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.profissional, other.profissional)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servico{" + "idServico=" + idServico + ", dataHorario=" + dataHorario + ", valor=" + valor + ", cliente=" + cliente + ", profissional=" + profissional + '}';
    }

    
    
}
