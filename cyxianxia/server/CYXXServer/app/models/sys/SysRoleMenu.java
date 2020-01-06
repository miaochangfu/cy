package models.sys;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.jpa.Model;

/**
 * <p>Title: Role</p>  
 * <p>try(405327054@qq.com)</p>
 * <p>2019年8月14日-下午4:21:06</p>
 * <p>version 1.0</p>
 * <p>Description: 角色配置表 </p>
 */
@Entity
@Table(name = "sys_role_menu")
public class SysRoleMenu extends Model implements Serializable, Cloneable {

	 private static final long serialVersionUID = 1L;

	private String role_name;
	
	private String create_time;

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	
	
}
