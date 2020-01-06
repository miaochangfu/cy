package models.sys;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.jpa.Model;

/**
 * <p>Title: SysMenu</p>  
 * <p>try(405327054@qq.com)</p>
 * <p>2019年8月14日-下午4:31:25</p>
 * <p>version 1.0</p>
 * <p>Description: 权限路径表</p>
 */
@Entity
@Table(name = "sys_menu")
public class SysMenu extends Model implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	/** 菜单名 **/
	private String menu_name;
	
	/** 父级菜单号 **/
	private Long parent_code;
	
	/** 菜单号 **/
	private int code;
	
	/** 级别   **/
	private int level;
	
	/** 排序   **/
	private int sort;
	
	/** 菜单路径   **/
	private String path_url;
	
	/** 图标   **/
	private String icon;

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public Long getParent_code() {
		return parent_code;
	}

	public void setParent_code(Long parent_code) {
		this.parent_code = parent_code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getPath_url() {
		return path_url;
	}

	public void setPath_url(String path_url) {
		this.path_url = path_url;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
}
