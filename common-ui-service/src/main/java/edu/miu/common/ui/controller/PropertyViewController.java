package edu.miu.common.ui.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.miu.common.ui.service.contract.ExportExcel;
import edu.miu.common.ui.utils.CommonUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class PropertyViewController {

    private final CommonUtils commonUtils;

    public PropertyViewController(CommonUtils commonUtils) {
        this.commonUtils = commonUtils;
    }

    @SneakyThrows
    @PostMapping("/export")
    public ResponseEntity<Resource> exportToExcel(@RequestBody String jsonData) {

        log.debug("Received request to export data");
        ExportExcel exportExcel = new ObjectMapper().readValue(jsonData, ExportExcel.class);
        List<Map<String, String>> tableData = exportExcel.getTableData();
        String filename = exportExcel.getFilename();

        ByteArrayOutputStream excelOutput = commonUtils.createExcel(tableData);
        ByteArrayResource resource = new ByteArrayResource(excelOutput.toByteArray());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", filename));

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(resource.contentLength())
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(resource);
    }

}