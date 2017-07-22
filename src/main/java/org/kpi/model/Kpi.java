package org.kpi.model;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "kpi", indexes = { @Index(name = "KPI_NAME_IDX", columnList = "name", unique = true)})
public class Kpi implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Getter
    @Setter 
    String uuid = UUID.randomUUID().toString();
    
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 50)
    private String measure;

    @OneToMany(mappedBy = "kpi", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ProjectTypeKpi> projectTypes = new ArrayList<>();

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

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public List<ProjectTypeKpi> getProjectTypes() {
        return projectTypes;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((measure == null) ? 0 : measure.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Kpi other = (Kpi) obj;
        if (measure == null) {
            if (other.measure != null)
                return false;
        } else if (!measure.equals(other.measure))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    

}
