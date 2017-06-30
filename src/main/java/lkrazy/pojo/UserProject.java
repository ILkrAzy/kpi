package lkrazy.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_project")
public class UserProject implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne
	@JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "USER_ID_FK"))
	private User user;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "project_id", foreignKey = @ForeignKey(name = "PROJECT_ID_FK"))
	private Project project;
	
	public UserProject() {
	}
	
	public UserProject(User user, Project project) {
		this.user = user;
		this.project = project;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	

}
