package org.kpi.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "project_type_kpi")
public class ProjectTypeKpi implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter 
    String uuid = UUID.randomUUID().toString();

    @ManyToOne
    @JoinColumn(name = "project_type_id", foreignKey = @ForeignKey(name = "PROJECTTYPEKPI_PROJECT_TYPE_ID_FK"))
    private ProjectType projectType;

    @ManyToOne
    @JoinColumn(name = "kpi_id", foreignKey = @ForeignKey(name = "PROJECTTYPEKPI_KPI_ID_FK"))
    private Kpi kpi;

    public ProjectTypeKpi() {
    }

    public ProjectTypeKpi(ProjectType projectType, Kpi kpi) {
        this.projectType = projectType;
        this.kpi = kpi;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

    public Kpi getKpi() {
        return kpi;
    }

    public void setKpi(Kpi kpi) {
        this.kpi = kpi;
    }

    public void clear() {
        this.kpi = null;
        this.projectType = null;
    }


}
