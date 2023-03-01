package org.perpus.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

import org.perpus.entity.BukuEntity;
import org.perpus.exception.response.MessageResponse;
import org.perpus.model.body.BukuBody;

@ApplicationScoped
public class BukuService {
    
    public BukuEntity getBukuById(Long id) {
        return BukuEntity.findBukuById(id)
        .orElseThrow(() -> MessageResponse.idNotFoundException(id));
    }

    public BukuEntity getBukuByTitle(String judul) {
        return BukuEntity.findBukuByTitle(judul)
        .orElseThrow(() -> MessageResponse.idNotFoundException(judul));
    }

    private Boolean checkingBukuExistByKode(String kode) {
        return BukuEntity.findBukuByCode(kode).isPresent();
    }

    private Boolean checkingBukuIsExistById(Long id) {
        return BukuEntity.findBukuById(id).isPresent();
    }

    public Response getSizeBuku() {
        Long size = BukuEntity.count();
        return Response.ok("{\"size\":\""+ size +"\"}").build();
    }

    public List<BukuEntity> getAllBuku() {
        return BukuEntity.findAllBuku()
        .stream()
        .collect(Collectors.toList());
    }

    public List<BukuEntity> getListBukuByTitle(String name) {
        return BukuEntity.findAllBuku()
        .stream()
        .filter(buku -> (buku.judulBuku.toLowerCase().replaceAll("\\s", "").contains(name.toLowerCase())))
        .collect(Collectors.toList());
    }

    public Response createBuku(BukuBody body) {
        Objects.requireNonNull(body);
        if(Boolean.FALSE.equals(checkingBukuExistByKode(body.kodeBuku()))) {
            var buku = body.mapToBukuEntity();
            buku.persist();
            return Response.ok().entity(body).build();
        }
        return Response.status(400).entity("{\"message\":\"BUKU IS EXIST\"}").build();
    }

    public Response updateBuku(BukuEntity entity ,Long id) {
        if(Boolean.TRUE.equals(checkingBukuIsExistById(id))) {
            var buku = getBukuById(id);
            entity.updateBuku(buku);
            return Response.ok(buku).build();
        }
        return MessageResponse.idNotFound(entity.id);
    }

    public Response deleteBuku(Long id) {
        if(Boolean.TRUE.equals(checkingBukuIsExistById(id))) {
            BukuEntity.deleteById(id);
            return MessageResponse.deleteSucces(id);
        }
        return MessageResponse.idNotFound(id);
    }
}
