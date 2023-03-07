package org.perpus.controller;

import org.perpus.entity.SiswaEntity;
import org.perpus.model.body.SiswaBody;
import org.perpus.service.SiswaService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/api/v1/siswa")
public class SiswaController {

    @Inject
    SiswaService siswaService;

    @GET
    @Path("/get/{id}")
    public SiswaEntity getSiswaById(@PathParam("id") Long id) {
        return siswaService.getSiswaById(id);
    }

    @GET
    @Path("/get-all")
    public List<SiswaEntity> getAllSiswa() {
        return siswaService.getAllSiswa();
    }

    @POST
    @Transactional
    @Path("/create")
    public SiswaEntity createSiswa(SiswaBody body) {
        return siswaService.createSiswa(body);
    }
}
