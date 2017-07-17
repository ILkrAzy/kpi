package org.kpi.repository;

import org.kpi.model.Project;
import org.springframework.data.repository.CrudRepository;

/**
 * @author vquochuy
 * @since 7/17/2017.
 */
public interface ProjectRepository extends CrudRepository<Project, Integer>{
    Project findByName(String name);
}
