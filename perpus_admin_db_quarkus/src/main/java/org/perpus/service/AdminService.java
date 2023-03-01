package org.perpus.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import org.perpus.entity.AdminEntity;
import org.perpus.model.body.AdminBody;

@ApplicationScoped
public class AdminService {

  public Response getAdminByEmailPassAdnCode(AdminBody body) {
    var admin = AdminEntity
      .findAdminByEmailPassAndCode(body.email(), body.password(), body.kode())
      .isPresent();
    if (admin) {
      return Response.ok("{\"login\": \"Succes\"}").build();
    } else {
      return Response.status(400).entity("{\"login\": \"Failed\"}").build();
    }
  }

  public List<AdminEntity> getAllAdmin() {
    return AdminEntity.findAllAdmin().stream().collect(Collectors.toList());
  }
}
