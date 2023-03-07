package org.perpus.model.body;

import org.perpus.entity.AdminEntity;

public record AdminBody(
    String email,
    String password,
    String kode,
    String namaAdmin
) {

    public AdminEntity mapToAdminEntity() {
        var admin = new AdminEntity();
        admin.email = email;
        admin.password = password;
        admin.kodeAdmin = kode;
        admin.namaAdmin = namaAdmin;
        return admin;
    }
    
}
