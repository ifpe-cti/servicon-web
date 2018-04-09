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
import java.util.Objects;

/**
 *
 * @author Lucas Mendes <lucas.mendes147@live.com>
 */
public class Profissional {
    
    private int idProfissional;
    private String nome;
    private BigDecimal avaliacao;
    private String telefone;
    private String email;
    private String dataNascimento;

    public Profissional(int idProfissional, String nome, BigDecimal avaliacao, String telefone, String email, String dataNascimento) {
        this.idProfissional = idProfissional;
        this.nome = nome;
        this.avaliacao = avaliacao;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public int getIdProfissional() {
        return idProfissional;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getAvaliacao() {
        return avaliacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setIdProfissional(int idProfissional) {
        this.idProfissional = idProfissional;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAvaliacao(BigDecimal avaliacao) {
        this.avaliacao = avaliacao;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idProfissional;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.avaliacao);
        hash = 97 * hash + Objects.hashCode(this.telefone);
        hash = 97 * hash + Objects.hashCode(this.email);
        hash = 97 * hash + Objects.hashCode(this.dataNascimento);
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
        final Profissional other = (Profissional) obj;
        if (this.idProfissional != other.idProfissional) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
            return false;
        }
        if (!Objects.equals(this.avaliacao, other.avaliacao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Profissional{" + "idProfissional=" + idProfissional + ", nome=" + nome + ", avaliacao=" + avaliacao + ", telefone=" + telefone + ", email=" + email + ", dataNascimento=" + dataNascimento + '}';
    }

    
    
}
