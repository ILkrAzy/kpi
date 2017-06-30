package lkrazy.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "project_kpi_value")
public class ProjectKpiValue implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne
	@JoinColumn(name = "project_id", foreignKey = @ForeignKey(name = "PROJECT_ID_FK"))
	private Project project;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "kpi_id", foreignKey = @ForeignKey(name = "KPI_ID_FK"))
	private Kpi kpi;
	
	@Id
	private Integer month;
	
	@Id
	private Integer year;
	
	private String value;
	
	@Column(length = 2000)
	private String comment;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Kpi getKpi() {
		return kpi;
	}

	public void setKpi(Kpi kpi) {
		this.kpi = kpi;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
