package ma.peps.sqli.util.dao;

import ma.peps.sqli.util.domain.AuditDomainObject;

import java.util.List;

public interface IDao<D extends AuditDomainObject> {

    D save(D model);

    List<D> findAll();

    D findById(Long id);

    int deleteById(Long id);

    List<D> findAlloptimized();

    D update(D model);
}
