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
package br.edu.ifpe.servicon.model.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

/**
 *
 * @author Lucas Mendes <lucas.mendes147@live.com>
 */
@Entity
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa")
    private Integer codigo;
    @Column(length = 35, nullable = false)
    private String nome;
    @Column(unique = true, length = 11, nullable = false)
    private String telefone;
    @Column(unique = true, length = 40, nullable = false)
    private String email;
    @Column(unique = true, length = 11, nullable = false)
    private String cpf;
    @Column(nullable = false)
    private LocalDate nascimento;
    @Column
    private Endereco endereco;
    
    @Deprecated
    public Pessoa() {
    }

    public Pessoa(String nome, String telefone, String email,
            String cpf, LocalDate nascimento, Endereco endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.endereco = endereco;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        final int HASH = 11;
        int result = 1;
        result = (HASH * result) + codigo.hashCode();
        result = (HASH * result) + nome.hashCode();
        result = (HASH * result) + cpf.hashCode();
        result = (HASH * result) + email.hashCode();
        result = (HASH * result) + nascimento.hashCode();
        result = (HASH * result) + endereco.hashCode();
        result = HASH * result + ((nome == null) ? 0 : nome.hashCode());
        result = HASH * result + 
                ((telefone == null) ? 0 : telefone.hashCode());
        result = HASH * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "codigo=" + codigo + ", nome=" +
                nome + ", telefone=" + telefone + ", email=" +
                email + ", cpf=" + cpf + ", nascimento=" + nascimento +
                ", endereco=" + endereco + '}';
    }   
}
