package edu.miu.common.ui.utils;

import edu.miu.common.ui.config.CommonUIConfiguration;
import edu.miu.common.ui.service.contract.Breadcrumb;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/* This class needs to be extended by any application that implements the Framework UI */
@Slf4j
public abstract class CommonUtils {

    public static final String TABLE_LAYOUT = "framework/layouts/table-layout";

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm a";

    @Autowired
    private CommonUIConfiguration commonUIConfiguration;

    public Object getValueByHeader(Object content, String headerName) {

        // Logic added to extract values from nested objects
        String[] path = headerName.split("\\.");
        Object currentObject = content;

        for (String fieldName : path) {
            if (Objects.isNull(currentObject)) {
                return null;
            }
            Field field = getFieldByHeaderName(currentObject.getClass(), fieldName);
            if (Objects.nonNull(field)) {
                field.setAccessible(true);
                currentObject = extraCustomOperation(field, currentObject);
            } else {
                // Field not found in the current object
                log.debug("Field not found: {}", fieldName);
                return null;
            }
        }

        return currentObject;
    }


    // Necessary when an Entity has Inheritance.
    private Field getFieldByHeaderName(Class<?> clazz, String headerName) {
        Field field;
        while (clazz != null && clazz != Object.class) {
            try {
                field = clazz.getDeclaredField(headerName);
                return field;
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass(); // Move up in class hierarchy
            }
        }
        return null;
    }

    public boolean mapHasKey(Map<String, String> map, String key) {
        return map.containsKey(key);
    }

    public ByteArrayOutputStream createExcel(List<Map<String, String>> tableData) {
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet sheet = workbook.createSheet("Data");

            // Headers
            List<String> headers = new ArrayList<>(tableData.get(0).keySet());
            Row headerRow = sheet.createRow(0);
            IntStream.range(0, headers.size()).forEach(colIndex -> {
                Cell cell = headerRow.createCell(colIndex);
                cell.setCellValue(headers.get(colIndex));
            });

            // Data
            IntStream.range(0, tableData.size()).forEach(rowIndex -> {
                Map<String, String> rowData = tableData.get(rowIndex);
                Row row = sheet.createRow(rowIndex + 1);
                IntStream.range(0, headers.size()).forEach(colIndex -> {
                    Cell cell = row.createCell(colIndex);
                    cell.setCellValue(rowData.get(headers.get(colIndex)));
                });
            });

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);

            return outputStream;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Map<String, Breadcrumb> setNavigationLinks(List<String> names, Map<String, String> navbarUrls) {
        return names.stream()
                .collect(Collectors.toMap(
                        this::camelCaseToTitleCase,
                        name -> new Breadcrumb(camelCaseToTitleCase(name), navbarUrls.get(name)),
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
    }


    public String camelCaseToTitleCase(String camelCaseStr) {

        List<String> camelCaseList = commonUIConfiguration.getCamelCaseList();

        if (Objects.isNull(camelCaseStr) || camelCaseStr.isEmpty()) {
            return camelCaseStr;
        }

        boolean removeFirstWord = camelCaseList.contains(camelCaseStr);

        StringBuffer titleCaseBuffer = new StringBuffer();
        Matcher m = Pattern.compile("(?<=[a-z])(?=[A-Z])").matcher(camelCaseStr);
        while (m.find()) {
            m.appendReplacement(titleCaseBuffer, m.group() + " ");
        }
        m.appendTail(titleCaseBuffer);


        String titleCase = titleCaseBuffer.toString().trim();
        titleCase = titleCase.substring(0, 1).toUpperCase() + titleCase.substring(1);

        if (removeFirstWord) {
            int spaceIndex = titleCase.indexOf(" ");
            if (spaceIndex == -1) {
                return "";
            }
            titleCase = titleCase.substring(spaceIndex + 1);
        }

        return titleCase;
    }

    public static void setDynamicLink(Map<String, String> navbarUrls, String keyName, String partialPath) {
        String linkGenerated = navbarUrls.get(keyName) + partialPath;
        log.debug("Link Generated: {}", linkGenerated);
        navbarUrls.put(keyName, linkGenerated);
    }

    // Subclasses must return an empty string if the row should not be highlighted in the table fragment
    public abstract String settingRowBackGroundColor(Object content);

    // For applications to implemented and specify the custom configuration of the Common Builder Class
    public abstract void initiateDefaults(Map<String, Object> attributes);

    /* For developers to implemented and specify the custom operation to be performed on the value as needed
        E.g. Formatting a date, converting a list to a string, etc.
     */
    protected Object extraCustomOperation(Field field, Object content) {
        Object value;
        try {
            value = field.get(content);
            if(Objects.nonNull(value) && value instanceof LocalDateTime localDateTime) {
                return localDateTime.format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));
            }
            return value;
        } catch (IllegalAccessException e) {
            log.error("Error occurred while trying to access the field: {}, Error Message: {}", field.getName(), e.getMessage());
        }
        return null;
    }

}