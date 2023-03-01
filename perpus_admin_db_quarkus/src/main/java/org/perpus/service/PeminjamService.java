package org.perpus.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

import org.perpus.entity.PeminjamEntity;
import org.perpus.exception.response.MessageResponse;
import org.perpus.model.body.PeminjamBody;

@ApplicationScoped
public class PeminjamService {
    
    public PeminjamEntity getPeminjamById(Long id) {
        return PeminjamEntity.findPeminjamById(id)
        .orElseThrow(() -> MessageResponse.idNotFoundException(id));
    }

    public PeminjamEntity getPeminjamByName(String name) {
        return PeminjamEntity.findPeminjamByName(name)
        .orElseThrow(() -> MessageResponse.idNotFoundException(name));
    }

    private Boolean checkingIsExistPeminjam(String name) {
        return PeminjamEntity.findPeminjamByName(name).isPresent();
    }

    public List<PeminjamEntity> getAllPeminjam() {
        return PeminjamEntity.findAllPeminjam()
        .stream()
        .collect(Collectors.toList());
    }

    public Response getSizePeminjam() {
        Long size = PeminjamEntity.count();
        return Response.ok("{\"size\":\""+ size +"\"}").build();
    }

    public List<PeminjamEntity> getListPeminjamByName(String name) {
        return PeminjamEntity.findAllPeminjam()
        .stream()
        .filter(peminjam -> (peminjam.namaLengkap.toLowerCase().replaceAll("\\s", "").contains(name.toLowerCase())))
        .collect(Collectors.toList());
    }

    public Response createPeminjam(PeminjamBody body) {
        Objects.requireNonNull(body);
        if(Boolean.FALSE.equals(checkingIsExistPeminjam(body.namaLengkap()))) {
            var peminjam = body.mapToPeminjamEntity();
            peminjam.persist();
            return Response.ok().entity(peminjam).build();
        }
        return Response.status(400).entity("{\"message\":\"PEMINJAM IS EXIST\"}").build();
    }

    public Response deletePeminjamById(Long id) {
        if(getPeminjamById(id) != null) {
            PeminjamEntity.deleteById(id);
            return MessageResponse.deleteSucces(id);
        }
        return MessageResponse.idNotFound(id);
    }
}
