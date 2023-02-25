package org.perpus.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.perpus.entity.BukuEntity;
import org.perpus.model.body.BukuBody;
import org.perpus.service.BukuService;

@Path("/api/v1/buku")
@Produces(MediaType.APPLICATION_JSON)
public class BukuController {
    
    @Inject
    BukuService bukuService;

    @GET
    @Path("/get/{id}")
    public BukuEntity getBukuById(@PathParam("id") Long id) {
        return bukuService.getBukuById(id);
    }

    @GET
    @Path("/get-judul/{judul}")
    public BukuEntity getBukuByTitle(@PathParam("judul") String judul) {
        return bukuService.getBukuByTitle(judul);
    }

    @GET
    @Path("/get-all")
    public List<BukuEntity> getAllBuku() {
        return bukuService.getAllBuku();
    }

    @POST
    @Transactional
    @Path("/create")
    public Response createBuku(BukuBody body) {
        return bukuService.createBuku(body);
    }

    @PUT
    @Transactional
    @Path("/update")
    public Response updateBuku(BukuEntity entity) {
        return bukuService.updateBuku(entity);
    }

    @DELETE
    @Transactional
    @Path("/delete/{id}")
    public Response deleteBuku(@PathParam("id") Long id) {
        return bukuService.deleteBuku(id);
    }

}
