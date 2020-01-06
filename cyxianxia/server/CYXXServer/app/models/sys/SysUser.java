package models.sys;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.jpa.Model;

/**
 * 
 * <p>Title: SysUser</p>  
 * <p>try(405327054@qq.com)</p>
 * <p>2019年8月14日-下午4:21:16</p>
 * <p>version 1.0</p>
 * <p>Description: 用户配置表</p>
 */
@Entity
@Table(name = "sys_user")
public class SysUser extends Model implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    /** 用户 */
    private String user_name;

    /** 密码  */
    private String user_pass;

	private int status;
	
	private String remark;
	
	private String nick_name;
	
	
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	
    
}
