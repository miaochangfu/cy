package entity;

import java.io.Serializable;

/**
 * @author:try
 * @version:1.0
 * @Description:
 * @Date:2017年1月4日下午11:43:08
 */
public class VersionRes  implements Serializable {
	
	/*当前版本*/
	private String current_version;
	
	/*用户最低版本*/
	private String min_version;
	
	/*资源版本*/
    private String resource_version;
    
	public String getCurrent_version() {
		return current_version;
	}
	public void setCurrent_version(String current_version) {
		this.current_version = current_version;
	}
	public String getMin_version() {
		return min_version;
	}
	public void setMin_version(String min_version) {
		this.min_version = min_version;
	}
	public String getResource_version() {
		return resource_version;
	}
	public void setResource_version(String resource_version) {
		this.resource_version = resource_version;
	}
    
    
}
