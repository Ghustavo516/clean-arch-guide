package com.cleanArchitected.cleanArch.core.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.apache.commons.validator.routines.EmailValidator;

@Getter
@EqualsAndHashCode
public class Estudante {

    /**Dentro da entidade eu devo colocar tudo que é regra de negocio da aplicação,
    algo que será imutavel, ou seja, se ouver algum atributo que somente essa entidade tiver
     devemos colocar aqui dentro tambem, conforme esse exemplo demostra**/
    private String identificacaoInterna;

    private String nome;

    private String email;

    private int idade;

    private static void idadeValida(int idade){
        if(idade >= 18){
            throw new IllegalArgumentException("Idade invalida");
        }
    }

    private static void enderecoEmailValido(String email){
        EmailValidator emailValidator = EmailValidator.getInstance();
        if(!emailValidator.isValid(email)){
            throw new IllegalArgumentException("Endereço de email invalido");
        }
    }

    /** Ao desenvolvermos todos os atributos e metodos que pertencem a essa unica regra de negocio,
     * como por exemplo, como foi implementado essa entidade nos garantimos a consistencia dos dados e
     * que a regra de negocio esta sendo seguida e usando boas praticas**/

    public static Estudante create(String nome, int idade, String email) throws IllegalArgumentException{
        if(nome == null || email == null){
            throw new IllegalArgumentException("Nome ou Email invalido");
        }

        enderecoEmailValido(email);
        idadeValida(idade);

        Estudante estudante = new Estudante();
        estudante.setNome(nome);
        estudante.setIdade(idade);
        estudante.setEmail(email);

        return estudante;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        enderecoEmailValido(email);
        this.email = email;
    }

    public void setIdade(int idade) {
        idadeValida(idade);
        this.idade = idade;
    }
}
