package org.kpi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "project_kpi_value")
public class ProjectKpiValue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @ManyToOne
    @JoinColumn(name = "project_id", foreignKey = @ForeignKey(name = "PROJECTKPIVALUE_PROJECT_ID_FK"))
    @Getter
    @Setter
    private Project project;

    @Id
    @ManyToOne
    @JoinColumn(name = "kpi_id", foreignKey = @ForeignKey(name = "PROJECTKPIVALUE_KPI_ID_FK"))
    @Getter
    @Setter
    private Kpi kpi;

    @Id
    @Getter
    @Setter
    private Integer month;

    @Id
    @Getter
    @Setter
    private Integer year;

    @Column(length = 255)
    @Getter
    @Setter
    private String value;

    @Column(length = 2000)
    @Getter
    @Setter
    private String comment;

    public ProjectKpiValue(Project project, Kpi kpi, Integer month,
            Integer year, String value, String comment) {
        this.project = project;
        this.kpi = kpi;
        this.month = month;
        this.year = year;
        this.value = value;
        this.comment = comment;
    }

    public ProjectKpiValue() {
    }

    public ProjectKpiValue(Integer month, Integer year, String value,
            String comment) {
        this.month = month;
        this.year = year;
        this.value = value;
        this.comment = comment;
    }
    
}
