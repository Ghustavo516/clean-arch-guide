package com.cleanArchitected.cleanArch.core.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class EstudanteTest {

    /** Ao usarmos o @DisplayName conseguimos idenficar melhor qual teste que foi executado**/
    @DisplayName("Cria estudantes com sucesso")
    @Test
    void testEstudanteOk(){
        /* Existe uma boa pratica para desenvolver bom teste é o AAA,
        definindo toda a estrutura dessa maneira: */

        /* Arrange (Arranjo) : Onde definimos toda a estrutura do test*/
        String mail = "joao@fiap.com.br";
        String nome = "João";
        int idade = 31;

        /* act (Ação)*/
        var estudante = Estudante.create(nome, idade, mail);

        /* assert : onde validamos os dados usando as ferramentas do framework*/
        assertEquals(estudante.getNome(), nome);
        assertEquals(estudante.getIdade(), idade);
        assertEquals(estudante.getEmail(), mail);
        assertNull(estudante.getIdentificacaoInterna());
    }

    @DisplayName("Cria estudantes com identificacao com sucesso")
    @Test
    void testEstudanteIdentificacaoOk(){
        String mail = "joao@fiap.com.br";
        String nome = "João";
        int idade = 31;

        String identificao = "abc";
        var estudante = Estudante.create(identificao, nome, idade, mail);
        assertEquals(estudante.getNome(), nome);
        assertEquals(estudante.getIdade(), idade);
        assertEquals(estudante.getEmail(), mail);
        assertEquals(estudante.getIdentificacaoInterna(), identificao);
    }
}