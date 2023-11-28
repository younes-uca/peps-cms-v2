package ma.peps.sqli.util.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ma.peps.sqli.util.security.bean.Permission;

public interface PermissionDao extends JpaRepository<Permission, Long> {
    public Permission findByName(String name);
}
