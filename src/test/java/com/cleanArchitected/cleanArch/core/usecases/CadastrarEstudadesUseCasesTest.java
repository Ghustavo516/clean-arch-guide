package com.cleanArchitected.cleanArch.core.usecases;

import com.cleanArchitected.cleanArch.core.dto.NovoEstudanteDTO;
import com.cleanArchitected.cleanArch.core.entities.Estudante;
import com.cleanArchitected.cleanArch.core.interfaces.IEstudanteGateway;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class CadastrarEstudadesUseCasesTest {

    @DisplayName("Cadastra com sucesso")
    @Test
    void testRegistrandoOk(){
        /* arrange */
        String nome = "Juliana";
        int idade = 31;
        String enderecoEmail = "juliana@fiap.com";

        /* A ferramenta mokito serve para simular os comportamentos de dependencias externas para realizar um teste
        de uma regra, como por exemplo, podemos mocar(mock) simular: conexões com banco de dados, api, smtp. */

        IEstudanteGateway  estudanteGateway = Mockito.mock(IEstudanteGateway.class);

        when(estudanteGateway.buscaPorNome(anyString())).thenReturn(
                null
        );
        when(estudanteGateway.incluir(any())).thenReturn(
                Estudante.create("abc", nome, idade, enderecoEmail)
        );

        /* act */
        final Estudante estudante = CadastrarEstudadesUseCases.create(estudanteGateway).run(
                new NovoEstudanteDTO(nome, enderecoEmail, idade)
        );

        /* assert */
        assertNotNull(estudante);
        assertEquals(nome, estudante.getNome());
        assertEquals(estudante.getIdentificacaoInterna(), "abc");
    }
}