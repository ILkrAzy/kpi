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
    private String name;

    @OneToMany(mappedBy = "projectType", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ProjectTypeKpi> kpis = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectType)) return false;

        ProjectType type = (ProjectType) o;

        if (getId() != type.getId()) return false;
        return getName() != null ? getName().equals(type.getName()) : type.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }
}
