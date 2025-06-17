package com.cleanArchitected.cleanArch.core.usecases;

import com.cleanArchitected.cleanArch.core.dto.NovoEstudanteDTO;
import com.cleanArchitected.cleanArch.core.entities.Estudante;
import com.cleanArchitected.cleanArch.core.interfaces.IEstudanteGateway;
import com.cleanArchitected.cleanArch.exceptions.EstudanteJaExisteException;

public class CadastrarEstudadesUseCases {

    /** Os UsesCases servem como uma camada de orquestração e aplica as regras de negocio da entidade,
     nesse exemplo podemos notar que foi criado um use case para cadastrar um aluno e note que no clean arch
     para cada novo use case usamos uma classe diferente (somos forçados a usar o solid - (S) single responsability principle)
     * */

    IEstudanteGateway estudanteGateway;

    public CadastrarEstudadesUseCases(IEstudanteGateway estudanteGateway) {
        this.estudanteGateway = estudanteGateway;
    }

    public static CadastrarEstudadesUseCases create(IEstudanteGateway estudanteGateway) {
        return new CadastrarEstudadesUseCases(estudanteGateway);
    }

    public Estudante run(NovoEstudanteDTO novoEstudanteDTO) {
        /** Uma boa pratica é sempre usar DTO, eles fornecem um canal seguro para os dados alem que facilitar com o
         processo e ficar bem organizado **/

        /** Outra boa pratica é criar exception personalizadas de acordo com a regra de negocio, dessa forma ao ocorrer
         um erro fica melhor de identificar e para lançar exceptions tambem **/

        final Estudante estudanteExiste = this.estudanteGateway.buscaPorNome(novoEstudanteDTO.nome().trim());

        if(estudanteExiste != null){
            throw new EstudanteJaExisteException("Esse estudante já esta cadastrado: " + novoEstudanteDTO.nome());
        }

        //Cria um novo estudante
        final Estudante novoEstudante = Estudante.create(
                novoEstudanteDTO.nome(),
                novoEstudanteDTO.idade(),
                novoEstudanteDTO.email()
        );

        //Retorna o estudante criado com o campo de identificação interna
        Estudante estudante = this.estudanteGateway.incluir(novoEstudante);
        return estudante;

    }
}
