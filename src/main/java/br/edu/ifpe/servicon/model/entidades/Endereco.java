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

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Lucas Mendes <lucas.mendes147@live.com>
 */
@Entity
@Table
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Integer codigo;
    @Column(length = 8, updatable = false)
    private String cep;
    @Column(length = 20)
    private String estado;
    @Column(length = 25)
    private String cidade;
    @Column(length = 20)
    private String bairro;
    @Column(length = 30)
    private String logradouro;

    @Deprecated
    public Endereco() {
    }

    public Endereco(String cep, String estado,
            String cidade, String bairro, String logradouro) {
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getCEP() {
        return cep;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    @Override
    public int hashCode() {
        final int HASH = 5;
        int result = 1;
        result = (HASH * result) + codigo.hashCode();
        result = (HASH * result) + estado.hashCode();
        result = (HASH * result) + cidade.hashCode();
        result = (HASH * result) + bairro.hashCode();
        result = (HASH * result) + logradouro.hashCode();
        result = HASH * result + ((cep == null) ? 0 : cep.hashCode());
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
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.logradouro, other.logradouro)) {
            return false;
        }
        return Objects.equals(this.codigo, other.codigo);
    }

    @Override
    public String toString() {
        return "Endereco{" + "codigo=" + codigo + ", cep="
                + cep + ", estado=" + estado + ", cidade="
                + cidade + ", bairro=" + bairro + ", logradouro="
                + logradouro + '}';
    }
}
