package com.soluti.backend.controle;


import com.soluti.backend.entidade.Usuario;
import com.soluti.backend.negocio.UsuarioService;
import com.soluti.backend.util.MeuBackEndException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


/**
 *	Classe	controladora	de	Usuarios
 *	Matheus Moreira
 */

@RestController
@CrossOrigin(origins =	"*",	maxAge =	3600)
//Criando a classe de controle
public class UsuarioController {

    //Variável	de	negócio
    //que	será	utilizada
    //pelo	controller

    private UsuarioService usuarioService;

    @Autowired
    public void setMedicoService(UsuarioService usuarioService)	{
        this.usuarioService =	usuarioService;
    }

    /**
     *	Metodo que	lista	os	usuarios
     *	@return lista	de	usuários
     */
    @GetMapping(value =	"/listar-usuarios")
    public List<Usuario>	listar(){
        List<Usuario>	lista	=	usuarioService.listar();
        return lista;
    }



    @GetMapping(value =	"/consultar-usuario/{id}")
    public Usuario consultar(@PathVariable Integer id){
        return usuarioService.consultar(id);
    }

    /**
     *	metood que	salva	(inclui	ou	altera)	um	usuario
     *	@param	usuario
     *	@return usuario alterado	ou	incluido
     */
    @PostMapping(value =	"/salvar-usuario")
    public Usuario salvar(@RequestBody Usuario usuario)	{
        try{
            if (usuario.getId()==null){
                usuario =	usuarioService.incluir(usuario);
            }
            else{
                usuarioService.alterar(usuario);
            }
            return usuario;
        }
        catch	(MeuBackEndException ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,	ex.getReason());
        }
    }
    /**
     *	Metodo que	exclui	usuario pelo	id
     *	@param	id	id	do	usuario a	ser	excluido
     */

    @DeleteMapping(value =	"/excluir-usuario/{id}")
    public void excluir(@PathVariable Integer id){
        usuarioService.excluir(id);
    }
}