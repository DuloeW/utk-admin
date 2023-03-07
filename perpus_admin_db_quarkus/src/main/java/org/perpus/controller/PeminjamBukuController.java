package org.perpus.controller;

import org.perpus.entity.PeminjamBukuEntity;
import org.perpus.model.body.PeminjamBukuBody;
import org.perpus.service.PeminjamBukuService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/api/v1/peminjam-buku")
public class PeminjamBukuController {

    @Inject
    PeminjamBukuService peminjamBukuService;

    @GET
    @Path("/get-peminjam/{id}")
    public PeminjamBukuEntity getPeminjamBukuById(@PathParam("id") Long id) {
        return peminjamBukuService.getPeminjamBukuById(id);
    }

    @GET
    @Path("/get-all")
    public List<PeminjamBukuEntity> getAllPeminjamBuku() {
        return peminjamBukuService.getAllPeminjamBuku();
    }

    @POST
    @Transactional
    @Path("/create")
    public PeminjamBukuEntity createPeminjamBuku(PeminjamBukuBody body) {
        return peminjamBukuService.createPeminjamBuku(body);
    }
}
