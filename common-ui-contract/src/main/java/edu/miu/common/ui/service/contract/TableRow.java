package edu.miu.common.ui.service.contract;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class TableRow {
	
	private TableColor rowColor = TableColor.DEFAULT;
	
	private Map<String, TableElement> values = new HashMap<>();

}
