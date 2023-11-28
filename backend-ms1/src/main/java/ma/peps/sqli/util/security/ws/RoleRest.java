package ma.peps.sqli.util.security.ws;

import ma.peps.sqli.util.security.bean.Role;
import ma.peps.sqli.util.security.service.facade.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/roles")
@RestController
// @PreAuthorize("hasRole(AuthoritiesConstants.super_admin)")
public class RoleRest {
    @Autowired
    private RoleService roleService;

    // @PreAuthorize("hasRole(AuthoritiesConstants.super_admin)")
    @GetMapping("/")
    public List<Role> findAll() {
        return this.roleService.findAll();
    }
}
