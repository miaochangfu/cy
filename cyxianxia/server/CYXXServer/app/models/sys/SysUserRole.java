package models.sys;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.jpa.Model;

@Entity
@Table(name = "sys_user_role")
public class SysUserRole  extends Model implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	private Integer role_id;
	
	private Integer user_id;

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	
}
