package com.cleanArchitected.cleanArch.core.controllers;

import com.cleanArchitected.cleanArch.core.dto.EstudanteDTO;
import com.cleanArchitected.cleanArch.core.dto.NovoEstudanteDTO;
import com.cleanArchitected.cleanArch.core.gateway.EstudanteGateway;
import com.cleanArchitected.cleanArch.core.interfaces.IDataSource;
import com.cleanArchitected.cleanArch.core.presenters.EstudantePresenter;
import com.cleanArchitected.cleanArch.core.usecases.CadastrarEstudadesUseCases;
import com.cleanArchitected.cleanArch.exceptions.EstudanteJaExisteException;

public class EstudanteController {

    /* A real função do controller e organizar as coisas para passar para o use cases de forma mastigada,
    * ou seja, tem o trabalho de orquestrar */

    private final IDataSource dataStorageSource;

    private EstudanteController(IDataSource dataSource) {
        this.dataStorageSource = dataSource;

    }

    private static EstudanteController create(IDataSource dataSource){
        return new EstudanteController(dataSource);
    }

    // 1. Controller recebe uma chamada
    public EstudanteDTO cadastrar(NovoEstudanteDTO novoEstudanteDTO){

        // 2. Cria um gateway
        var estudanteGateway = EstudanteGateway.create(this.dataStorageSource);

        // 3. Use Case faz o papel dele, retornando uma resposta
        var useCases = CadastrarEstudadesUseCases.create(estudanteGateway);

        try{
            // 4. A resposta do Use Case foi tratada
            var estudante = useCases.run(novoEstudanteDTO);

            // 5. Foi retornado uma resposta, sendo passada para o presenter para formatação.
            // Chama o presenter pra realizar a formação toDto para ser retornada
            var estudanteDTO = EstudantePresenter.toDTO(estudante);
            return estudanteDTO;

        }catch (EstudanteJaExisteException e){
            return null;
        }
    }

    public EstudanteDTO buscaPorNome(String nome){
        /* */
        return null;
    }

}
