package org.perpus.service;

import org.perpus.entity.SiswaEntity;
import org.perpus.exception.response.MessageResponse;
import org.perpus.model.body.SiswaBody;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ApplicationScoped
public class SiswaService {

    public SiswaEntity getSiswaById(Long id) {
        return SiswaEntity.findSiswaById(id)
                .orElseThrow(() -> MessageResponse.idNotFoundException(id));
    }

    public List<SiswaEntity> getAllSiswa() {
        return new ArrayList<>(SiswaEntity.findAllSiswa());
    }

    public Boolean checkingSiswaIsExist(Long id) {
        return SiswaEntity.findById(id).isPersistent();
    }

    public SiswaEntity createSiswa(SiswaBody body) {
        Objects.requireNonNull(body);
        var siswa = body.mapToSiswaEntity();
        siswa.persist();
        return siswa;
    }

    public Response deleteSiswa(Long id) {
        if(checkingSiswaIsExist(id)) {
            return MessageResponse.deleteSucces(id);
        } else {
            return MessageResponse.idNotFound(id);
        }
    }


}
