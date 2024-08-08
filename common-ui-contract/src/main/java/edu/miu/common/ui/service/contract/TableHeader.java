package edu.miu.common.ui.service.contract;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class TableHeader extends TableElement {
	
	private boolean sortable = true;
	
	// "All" will always be added automatically and is the default selection
	private List<String> dropdown; // Can be null
	
	private TableJustification headerJustification = TableJustification.LEFT;

	private TableJustification valuesJustification = TableJustification.LEFT;

}
