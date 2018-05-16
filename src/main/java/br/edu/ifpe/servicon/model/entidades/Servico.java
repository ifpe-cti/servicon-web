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

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Lucas Mendes <lucas.mendes147@live.com>
 */
public class Servico {
    private Integer codigo;
    private Cliente cliente;
    private List<Profissional> Profissionais;
    private Timestamp dataHora;
    private Pagamento pagamento;

    public Servico(Integer codigo, Cliente cliente, List<Profissional> 
            Profissionais, Timestamp dataHora, Pagamento pagamento) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.Profissionais = Profissionais;
        this.dataHora = dataHora;
        this.pagamento = pagamento;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Profissional> getProfissionais() {
        return Profissionais;
    }

    public void setProfissionais(List<Profissional> Profissionais) {
        this.Profissionais = Profissionais;
    }

    public Timestamp getDataHora() {
        return dataHora;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    @Override
    public int hashCode() {
        final int HASH = 7;
        int result = 1;
        result = HASH * result + ((codigo == null) ? 0 : codigo.hashCode());
        result = HASH * result + ((cliente == null) ? 0 : cliente.hashCode());
        result = HASH * result + ((Profissionais == null) ? 0 : Profissionais.hashCode());
        result = HASH * result + ((dataHora == null) ? 0 : dataHora.hashCode());
        result = HASH * result + ((pagamento == null) ? 0 : pagamento.hashCode());
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
        if (!Objects.equals(this.Profissionais, other.Profissionais)) {
            return false;
        }
        if (!Objects.equals(this.dataHora, other.dataHora)) {
            return false;
        }
        if (!Objects.equals(this.pagamento, other.pagamento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servico{" + "codigo=" + codigo + ", cliente=" + cliente + 
                ", Profissionais=" + Profissionais + ", dataHora=" + dataHora +
                ", pagamento=" + pagamento + '}';
    }
}
