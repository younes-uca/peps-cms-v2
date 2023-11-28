package ma.peps.sqli.util.service;

import ma.peps.sqli.util.bean.BusinessObject;
import ma.peps.sqli.util.criteria.BaseCriteria;

import java.util.List;

public interface IService<D extends BusinessObject, Criteria extends BaseCriteria> {
    D save(D model);

    List<D> findAll();

    List<D> findAllOptimized();

    D update(D model);

    D findById(Long id);

    int deleteById(Long id);
}
