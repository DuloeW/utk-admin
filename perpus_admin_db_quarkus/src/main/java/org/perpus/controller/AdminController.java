package org.perpus.controller;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import org.perpus.entity.AdminEntity;
import org.perpus.model.body.AdminBody;
import org.perpus.service.AdminService;

@Path("/api/v1/admin")
public class AdminController {

  @Inject
  AdminService adminService;

  @POST
  @Path("/login")
  public Response getAdminByEmailPassAndCode(AdminBody body) {
    return adminService.getAdminByEmailPassAdnCode(body);
  }

  @GET
  @Path("/get-all")
  public List<AdminEntity> getAllAdmin() {
    return adminService.getAllAdmin();
  }
}
