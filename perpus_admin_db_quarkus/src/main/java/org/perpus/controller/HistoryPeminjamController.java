package org.perpus.controller;

import org.perpus.entity.HistoryPeminjamEntity;
import org.perpus.model.body.HistoryPeminjanBody;
import org.perpus.service.HistoryPeminjamService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/api/v1/history-peminjam")
public class HistoryPeminjamController {

    @Inject
    HistoryPeminjamService historyPeminjamService;

    @GET
    @Path("/get/{id}")
    public HistoryPeminjamEntity getHistoryPeminjamById(@PathParam("id") Long id) {
        return historyPeminjamService.getHistoryPeminjamById(id);
    }

    @GET
    @Path("/get-all")
    public List<HistoryPeminjamEntity> getAllHistoryPemijam() {
        return historyPeminjamService.getAllHistoryPeminjam();
    }

    @POST
    @Transactional
    @Path("/create")
    public HistoryPeminjamEntity createHistoryPeminjam(HistoryPeminjanBody body) {
        return historyPeminjamService.createHistoryPeminjam(body);
    }
}
