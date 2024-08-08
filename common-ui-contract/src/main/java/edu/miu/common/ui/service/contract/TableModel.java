package edu.miu.common.ui.service.contract;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import lombok.Data;

@Data
public class TableModel {
	
	private List<TableHeader> headers = new ArrayList<>();
	
	private List<TableRow> rows = new ArrayList<>();
	
	private String exportFileName; // This is a required field and should be a meaningful name

	private boolean enableIndex = true;
	
	private boolean enableCheckbox = false;
	
	private boolean enableSearch = true; // By default a search box is provided
	
	private Map<TableColor, String> legend; // If the map is null or empty, then no legend is displayed
	
	public boolean displayLegend() {
		if(Objects.isNull(legend) || legend.isEmpty()) {
			return false;
		}
		else {
			return true;
		}
	}

}
