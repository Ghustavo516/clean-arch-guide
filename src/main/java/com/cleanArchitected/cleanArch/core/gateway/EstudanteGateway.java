package com.cleanArchitected.cleanArch.core.gateway;

import com.cleanArchitected.cleanArch.core.dto.EstudanteDTO;
import com.cleanArchitected.cleanArch.core.dto.NovoEstudanteDTO;
import com.cleanArchitected.cleanArch.core.entities.Estudante;
import com.cleanArchitected.cleanArch.core.interfaces.IDataSource;
import com.cleanArchitected.cleanArch.core.interfaces.IEstudanteGateway;
import com.cleanArchitected.cleanArch.exceptions.EstudanteNaoEncontradoException;

public class EstudanteGateway implements IEstudanteGateway {

    private final IDataSource dataStorageSource;

    private EstudanteGateway(IDataSource dataSource){
        this.dataStorageSource = dataSource;
    }

    public static EstudanteGateway create(IDataSource dataSourceSource){
        return new EstudanteGateway(dataSourceSource);
    }

    @Override
    public Estudante buscaPorNome(String nome) {
        EstudanteDTO estudanteDTO = this.dataStorageSource.obterEstudantePorNome(nome);
        if(estudanteDTO == null){
            throw new EstudanteNaoEncontradoException("Estudante não encontrado");
        }
        return Estudante.create(
                estudanteDTO.identificacao(),
                estudanteDTO.nome(),
                estudanteDTO.idade(),
                estudanteDTO.enderecoEmail()
        );
    }

    @Override
    public Estudante incluir(Estudante novoEstudante) {
        final NovoEstudanteDTO novoEstudanteDTO = new NovoEstudanteDTO(
                novoEstudante.getNome(),
                novoEstudante.getEmail(),
                novoEstudante.getIdade()
        );
        final EstudanteDTO estudanteDTO = this.dataStorageSource.incluirEstudante(novoEstudanteDTO);
        return Estudante.create(estudanteDTO.nome(), estudanteDTO.idade(), estudanteDTO.enderecoEmail());
    }
}
