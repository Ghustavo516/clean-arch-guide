package com.cleanArchitected.cleanArch.core.usecases;

import com.cleanArchitected.cleanArch.core.entities.Estudante;
import com.cleanArchitected.cleanArch.core.interfaces.IEstudanteGateway;
import com.cleanArchitected.cleanArch.exceptions.EstudanteNaoEncontradoException;

public class BuscaEstudantePorNomeUseCase {

    /** Um detalhe importante da clean arch é quem define como o gateway vai funcionar é o
      use case **/

    private IEstudanteGateway estudanteGateway;

    private BuscaEstudantePorNomeUseCase(IEstudanteGateway estudanteGateway) {
        this.estudanteGateway = estudanteGateway;
    }

    /** Sempre crie um metodo pra create e um para run **/

    public BuscaEstudantePorNomeUseCase create(IEstudanteGateway estudanteGateway) {
        return new BuscaEstudantePorNomeUseCase(estudanteGateway);
    }

    public Estudante run(String nome) {
        Estudante estudante = this.estudanteGateway.buscaPorNome(nome);

        if(estudante == null){
            throw new EstudanteNaoEncontradoException("Estudante nao encontrado");
        }

        return estudante;
    }
}
