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
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Lucas Mendes <lucas.mendes147@live.com>
 */
public class Pagamento {
    
    private int idPagamento;
    private boolean status;
    private Servico servico;
    private BigDecimal valor;

    public Pagamento(int idPagamento, boolean status, Servico servico, BigDecimal valor) {
        this.idPagamento = idPagamento;
        this.status = status;
        this.servico = servico;
        this.valor = valor;
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public boolean isStatus() {
        return status;
    }

    public Servico getServico() {
        return servico;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.idPagamento;
        hash = 41 * hash + Objects.hashCode(this.cliente);
        hash = 41 * hash + Objects.hashCode(this.profissional);
        hash = 41 * hash + (this.status ? 1 : 0);
        hash = 41 * hash + Objects.hashCode(this.servico);
        hash = 41 * hash + Objects.hashCode(this.valor);
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
        final Pagamento other = (Pagamento) obj;
        if (this.idPagamento != other.idPagamento) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.profissional, other.profissional)) {
            return false;
        }
        if (!Objects.equals(this.servico, other.servico)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pagamento{" + "idPagamento=" + idPagamento + ", "status=" + status + ", servico=" + servico + ", valor=" + valor + '}';
    }

    
    
    
    
}
