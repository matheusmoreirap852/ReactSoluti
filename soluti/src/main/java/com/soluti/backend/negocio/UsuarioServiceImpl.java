package com.soluti.backend.negocio;
import com.soluti.backend.entidade.Usuario;
import com.soluti.backend.persistencia.UsuarioRepository;
import com.soluti.backend.util.MeuBackEndException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Componente gerenciado	pelo Spring
@Component
//Faz	o	controle	de transação	em	cada método
@Transactional
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository repository;

    //Faz	a	injeção	de	dependência	do objeto de persistência na	class de negócio
    @Autowired
    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario incluir(Usuario usuario) {
        try {
            //Método	da	persistência	que	salva ao usuário no	banco de dados
            repository.save(usuario);
            return usuario;

        } catch (Exception e) {
            throw new MeuBackEndException("Não	foi	possível	incluir	o	usuário!");
        }
    }

    @Override
    public List<Usuario>	listar()	{
        try {
            //Método	da	persistência
            //que	lista	todos	usuários
            return (List<Usuario>)	this.repository.findAll();
        }
        catch	(Exception e){
            throw new	MeuBackEndException("Não	foi	possível	listar	os	usuários!");
        }
    }

    @Override
    //Método	da	persistência	que
    //busca	um	usuário	por	id
    public Usuario consultar(Integer id)	{
        try {
            return this.repository.findById(id).get();
        }
        catch	(Exception e){
            throw new	MeuBackEndException("Não	foi	possível	consultar	o	usuário:	"+id+"!");
        }
    }

    //Método	da	persistência
    //que	deleta	um	usuário
    //por	id
    @Override
    public void alterar(Usuario usuario)	{
        try {
            repository.save(usuario);
        }
        catch	(Exception e){
            throw new	MeuBackEndException("Não	foi	possível	alterar	o	usuario:	"+usuario.getId()+"!");
        }
    }

    @Override
    public void excluir(Integer id)	{
        try {
            repository.deleteById(id);
        }
        catch	(Exception e){
            throw new	MeuBackEndException("Não	foi	possível	excluir	o	usuario:	"+id+"!");
        }
    }

}