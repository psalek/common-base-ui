package edu.miu.common.ui.service.contract;

import java.util.Objects;

import lombok.Data;

@Data
public class TableElement {
	
	private String text = "";
	
	private String hyperlink = "";
	
	private TableIcon icon;

	public boolean isIcon() {
		return Objects.nonNull(icon);
	}

	public boolean isHyperlink() {
		return Objects.nonNull(hyperlink) && !hyperlink.isBlank();
	}
}
