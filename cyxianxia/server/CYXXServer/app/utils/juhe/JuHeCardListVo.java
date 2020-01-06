package utils.juhe;

import java.io.Serializable;
import java.util.List;

public class JuHeCardListVo implements Serializable{

	/**
	 */
	private static final long serialVersionUID = 1L;

	private String reason;
	
	private Integer error_code;

	private List<JuHeCardListResultVo> result;
	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getError_code() {
		return error_code;
	}

	public void setError_code(Integer error_code) {
		this.error_code = error_code;
	}

	public List<JuHeCardListResultVo> getResult() {
		return result;
	}

	public void setResult(List<JuHeCardListResultVo> result) {
		this.result = result;
	}
	
	
}
