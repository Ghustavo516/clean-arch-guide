package com.cleanArchitected.cleanArch.core.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.security.InvalidParameterException;
import java.util.ArrayList;

@Getter
@EqualsAndHashCode
public class Curso {

    private String nome;

    private boolean ativo;

    private ArrayList<Estudante> estudantes;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void setEstudantes(ArrayList<Estudante> estudantes) {
        this.estudantes = estudantes;
    }

    private boolean validaNome(String nome){
        if(nome.trim().isBlank()){
            throw new InvalidParameterException("Nome Invalido");
        }
        return true;
    }

    public Curso(String nome, boolean ativo) {
        /** Uma pratica que não sabia que era ideal era realizar uma chamada dos metodos dentro do
          contrutor **/

        boolean nomeV = validaNome(nome);

        this.nome = nome;
        this.ativo = ativo;
    }
}
