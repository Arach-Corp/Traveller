package br.com.fiap.traveller.rest;

import br.com.fiap.traveller.dao.exceptions.CommitException;
import br.com.fiap.traveller.dao.exceptions.EntityNotFoundException;
import br.com.fiap.traveller.dao.generic.PontoTuristicoDAO;
import br.com.fiap.traveller.dao.impl.PontoTuristicoDAOImpl;
import br.com.fiap.traveller.entities.Categoria;
import br.com.fiap.traveller.entities.PontoTuristico;
import br.com.fiap.traveller.entities.dto.CategoriaDTO;
import br.com.fiap.traveller.sigleton.EntityManagerFactorySingleton;
import org.postgresql.core.ConnectionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Path("pontos")
@Produces(MediaType.APPLICATION_JSON)
public class PontoEndpoint {

    private EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
    private PontoTuristicoDAO dao = new PontoTuristicoDAOImpl(em);

    @GET
    public List<PontoTuristico> index(){
        List<PontoTuristico> pontos = dao.findAll();

        pontos.stream().forEach(ponto -> {
            ponto.setEndereco(null);
            ponto.setCategoria(null);
        });

        return pontos;
    }


    @POST
    @Consumes (MediaType.APPLICATION_JSON)
    public Response store(PontoTuristico ponto){
        if(ponto == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        dao.save(ponto);
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
    public Response update(@PathParam("id") Long id, PontoTuristico ponto){
        if(ponto == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        PontoTuristico pontoBusca = null;
        try {
            pontoBusca = dao.findById(id);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }

        if(pontoBusca == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        ponto.setId(id);
        dao.save(ponto);
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
    public PontoTuristico show(@PathParam("id") Long id){

        PontoTuristico instance = null;
        try {
            instance = dao.findById(id);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }

        instance.setCategoria(null);
        instance.setEndereco(null);

        return instance;

    }

}
