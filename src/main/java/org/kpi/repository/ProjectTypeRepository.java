package org.kpi.repository;

import org.kpi.model.ProjectType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lnphi
 * @since 7/15/2017.
 */
public interface ProjectTypeRepository extends CrudRepository<ProjectType, Integer> {
    ProjectType findByName(String name);
}
