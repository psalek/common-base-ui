package edu.miu.common.ui.service.contract;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ExportExcel {

    private List<Map<String, String>> tableData;

    private String filename;

}