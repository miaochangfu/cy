package utils.juhe;

import java.io.Serializable;

public class TelcheckVo implements Serializable{

	/**
	 */
	private static final long serialVersionUID = 1L;

	private String reason;
	
	private Integer error_code;

	private TelcheckResultVo result;
	
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

	public TelcheckResultVo getResult() {
		return result;
	}

	public void setResult(TelcheckResultVo result) {
		this.result = result;
	}
	
	
}
