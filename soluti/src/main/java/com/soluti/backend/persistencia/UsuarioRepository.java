package com.soluti.backend.persistencia;
import com.soluti.backend.entidade.Usuario;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario,	Integer>	{

}
