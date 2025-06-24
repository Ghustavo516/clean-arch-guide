package com.cleanArchitected.cleanArch.core.interfaces;

import com.cleanArchitected.cleanArch.core.dto.EstudanteDTO;
import com.cleanArchitected.cleanArch.core.dto.NovoEstudanteDTO;
import com.cleanArchitected.cleanArch.core.entities.Estudante;

public interface IDataSource {
    
    EstudanteDTO obterEstudantePorNome(String nome);

    EstudanteDTO incluirEstudante(NovoEstudanteDTO novoEstudante);
}
