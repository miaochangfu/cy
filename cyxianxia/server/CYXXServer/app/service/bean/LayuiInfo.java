package service.bean;

import java.io.Serializable;
import java.util.List;

import org.apache.poi.hssf.record.formula.functions.T;

public class LayuiInfo  extends LayuiDate implements Serializable{

	private List<T> listDate;

	public List<T> getListDate() {
		return listDate;
	}

	public void setListDate(List<T> listDate) {
		this.listDate = listDate;
	}
	
	
}
