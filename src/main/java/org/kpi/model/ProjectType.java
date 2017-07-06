package org.kpi.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "project_type", indexes = { @Index(name = "PROJECT_TYPE_NAME_IDX", columnList = "name", unique = true)})
public class ProjectType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    @Column(length = 50, nullable = false)
    private int name;

    @OneToMany(mappedBy = "projectType", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ProjectTypeKpi> kpis = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public List<ProjectTypeKpi> getKpis() {
        return kpis;
    }

    public void removeKpi(Kpi kpi) {
        ProjectTypeKpi projectTypeKpi = new ProjectTypeKpi(this, kpi);
        kpi.getProjectTypes().remove(projectTypeKpi);
        getKpis().remove(projectTypeKpi);
        projectTypeKpi.clear();
    }


}
