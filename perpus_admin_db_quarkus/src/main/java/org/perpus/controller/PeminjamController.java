package org.perpus.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.perpus.entity.PeminjamEntity;
import org.perpus.model.body.PeminjamBody;
import org.perpus.service.PeminjamService;

@Path("/api/v1/peminjam")
@Produces(MediaType.APPLICATION_JSON)
public class PeminjamController {
    
    @Inject
    PeminjamService peminjamService;

    @GET
    @Path("/get/{id}")
    public PeminjamEntity getPeminjamById(@PathParam("id") Long id) {
        return peminjamService.getPeminjamById(id);
    }

    @GET
    @Path("/get-all")
    public List<PeminjamEntity> getAllPeminjam() {
        return peminjamService.getAllPeminjam();
    }

    @GET
    @Path("/get-name/{nama_lengkap}")
    public PeminjamEntity getPeminjamByName(@PathParam("nama_lengkap") String nama) {
        return peminjamService.getPeminjamByName(nama);
    }

    @POST
    @Path("/create")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)    
    public Response createPeminjam(PeminjamBody body) {
        return peminjamService.createPeminjam(body);
    }

    @DELETE
    @Transactional
    @Path("/delete/{id}")
    public Response deletePeminjam(@PathParam("id") Long id) {
        return peminjamService.deletePeminjamById(id);
    }

}
