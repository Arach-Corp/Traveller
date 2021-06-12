package br.com.fiap.traveller.rest;

import br.com.fiap.traveller.dao.exceptions.CommitException;
import br.com.fiap.traveller.dao.exceptions.EntityNotFoundException;
import br.com.fiap.traveller.dao.generic.CategoriaDAO;
import br.com.fiap.traveller.dao.impl.CategoriaDAOImpl;
import br.com.fiap.traveller.entities.Categoria;
import br.com.fiap.traveller.entities.dto.CategoriaDTO;
import br.com.fiap.traveller.sigleton.EntityManagerFactorySingleton;

import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("categorias")
public class CategoriaEndpoint {

    private EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
    private CategoriaDAO dao = new CategoriaDAOImpl(em);

    @GET
    public List<CategoriaDTO> index(){
        List<Categoria> categorias = dao.findAll();

        List<CategoriaDTO> dtos = categorias.stream().map(CategoriaDTO::new).collect(Collectors.toList());

        return dtos;
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response store(Categoria categoria){
        if(categoria == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        dao.save(categoria);
        try{

            dao.commit();

        }catch(Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.status(Response.Status.CREATED).build();
    }


    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, Categoria categoria){
        if(categoria == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        Categoria categoriaBusca = null;
        try {
            categoriaBusca = dao.findById(id);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }

        if(categoriaBusca == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        categoria.setId(id);
        dao.save(categoria);
        try{
            dao.commit();
        } catch(CommitException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("{id}")
    public Response destroy(@PathParam("id") Long id) {
        try{
            dao.deleteById(id);
        } catch (EntityNotFoundException e){
            e.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        try{
            dao.commit();
        } catch(CommitException e){
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.status(Response.Status.ACCEPTED).build();
    }

    @GET
    @Path("{id}")
    public CategoriaDTO show(@PathParam("id") Long id){

        Categoria instance = null;
        try {
            instance = dao.findById(id);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }

        CategoriaDTO dto = new CategoriaDTO(instance);


        return dto;

    }

}
