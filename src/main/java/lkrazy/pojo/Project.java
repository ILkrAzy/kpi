package lkrazy.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "project")
public class Project implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int id;

	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_type_id", foreignKey = @ForeignKey(name = "PROJECT_TYPE_ID_FK"))
	private ProjectType type;

	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<UserProject> managers = new ArrayList<>();
	

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

	public ProjectType getType() {
		return type;
	}

	public void setType(ProjectType type) {
		this.type = type;
	}

	public List<UserProject> getManagers() {
		return managers;
	}

	public void addManager(User manager) {
		getManagers().add(new UserProject(manager, this));
	}
	
	public void removeManager(User manager) {
		UserProject userProject = new UserProject(manager, this);
		manager.getProjects().remove(userProject);
		getManagers().remove(userProject);
		userProject.setUser(null);
		userProject.setProject(null);
	}

}
