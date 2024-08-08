package edu.miu.common.ui.builders;

import edu.miu.common.ui.config.CommonUIConfiguration;
import edu.miu.common.ui.utils.CommonUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * <h1>TableLayoutBuilder</h1>
 * <p>This class is a builder for constructing table-based layouts for views in a Spring MVC application. It encapsulates attributes commonly used in table layouts and provides a fluent interface for building a model.</p>
 *
 * <h2>Public Methods</h2>
 * <dl>
 *   <dt>{@link #withTableList(T)}</dt>
 *   <dd>Sets the list of items to be displayed in the table fragment. The type of the list is generic to accommodate different data structures.</dd>
 *
 *   <dt>{@link #withHeaderNames(List)}</dt>
 *   <dd>Defines the column headers for the table fragment, provided as a list of strings.</dd>
 *
 *   <dt>{@link #withFileName(String)}</dt>
 *   <dd>Sets the name of a file in the table fragment, typically used in export or download features related to the table.</dd>
 *
 *   <dt>{@link #withAttributeNames(List)}</dt>
 *   <dd>Specifies the attribute names corresponding to the table columns, used to map data to the table layout.</dd>
 *
 *   <dt>{@link #withPaths(List)}</dt>
 *   <dd>Sets a list of URL paths associated with the table fragment, usually linking to further details or actions for each table item.</dd>
 *
 *   <dt>{@link #withTableListAttribute(String)}</dt>
 *   <dd>Assigns an attribute for the table list, typically used for custom data handling or processing.</dd>
 *
 *   <dt>{@link #withNonSortable(List)}</dt>
 *   <dd>Specifies which columns in the table should not be sortable, provided as a list of column names.</dd>
 *
 *   <dt>{@link #withColumnTextCenterList(List)}</dt>
 *   <dd>Defines the columns whose text should be centered, given as a list of column names.</dd>
 *
 *   <dt>{@link #withColumnLinkEnable(boolean)}</dt>
 *   <dd>Enables or disables linking functionality within table columns.</dd>
 *
 *   <dt>{@link #withHeaderColumnName(String)}</dt>
 *   <dd>Sets the name of the header column, typically used in dynamically generated tables.</dd>
 *
 *   <dt>{@link #withPathColumnName(String)}</dt>
 *   <dd>Specifies the column name that contains path information, often used for navigation within the table.</dd>
 *
 *   <dt>{@link #withColumnParamVariable(String)}</dt>
 *   <dd>Sets a parameter variable for the column, used for customizing column behavior or data processing.</dd>
 *
 *   <dt>{@link #withHeaderColumnTextCenterList(List)}</dt>
 *   <dd>Centers the text of specified header columns, provided as a list of column names.</dd>
 *
 *   <dt>{@link #withAbsolutePathLinks(Map)}</dt>
 *   <dd>Sets absolute path links for the layout, typically used for external resources or fixed URLs.</dd>
 *
 *   <dt>{@link #withAbsolutePathName(String)}</dt>
 *   <dd>Assigns a name for the absolute path, often used in conjunction with absolute path links.</dd>
 *
 *   <dt>{@link #withRowHyperlinkMap(Map)}</dt>
 *   <dd>Subtitles the value of a specific field in case the value is not needed and a Static text is preferred.</dd>
 *
 *   <dd>Applies the configured attributes to a Spring MVC Model, finalizing the layout for rendering.</dd>
 * </dl>
 *
 * <h2>Usage</h2>
 * <p>
 *   Create an instance of the builder, configure the table attributes, and call `build` to apply the setup to a Model:
 * </p>
 * <pre><code>
 *   // Instantiate the builder
 *   TableLayoutBuilder builder = new TableLayoutBuilder(controllerUtils);
 *
 *   // Configure table attributes
 *   builder.initiateDefaults()
 *     .withHeadTitle("Table View")
 *     .withMainTitle("Main Table Title")
 *     // ... other configurations ...
 *     .withBreadCrumbList(List.of("Home", "Table View"));
 *
 *   // Apply to a Model
 *   builder.build(model);
 * </code></pre>
 */
@Component
public class TableLayoutBuilder extends CommonLayoutBuilder<TableLayoutBuilder> {

    public TableLayoutBuilder(CommonUtils commonUtils, CommonUIConfiguration navbarConfiguration) {
        super(commonUtils, navbarConfiguration);
    }

    @Override
    public TableLayoutBuilder initiateDefaults() {

        super.initiateDefaults();

        commonUtils.initiateDefaults(attributes);

        attributes.put("headerNames", Collections.emptyList());
        attributes.put("fileName", "excelFile");
        attributes.put("tableList", Collections.emptyList());
        attributes.put("attributeNames", Collections.emptyList());
        attributes.put("paths", Collections.emptyList());
        attributes.put("pathVariableName", "");
        attributes.put("tableListAttribute", "");
        attributes.put("nonSortable", Collections.emptyList());
        attributes.put("columnTextCenterList", Collections.emptyList());
        attributes.put("columnLinkEnable", false);
        attributes.put("headerColumnName", "");
        attributes.put("pathColumnName", "");
        attributes.put("columnParamVariable", "");
        attributes.put("headerColumnTextCenterList", Collections.emptyList());
        attributes.put("absolutePathLinks", Collections.emptyList());
        attributes.put("absolutePathName", "");
        attributes.put("rowHyperlinkMap", Collections.emptyMap());

        return this;
    }

    public <T> TableLayoutBuilder withTableList(T tableList) {
        attributes.put("tableList", tableList);
        return this;
    }

    public TableLayoutBuilder withHeaderNames(List<String> headerNames) {
        attributes.put("headerNames", headerNames);
        return this;
    }

    public TableLayoutBuilder withFileName(String fileName) {
        attributes.put("fileName", fileName);
        return this;
    }

    public TableLayoutBuilder withAttributeNames(List<String> attributeNames) {
        attributes.put("attributeNames", attributeNames);
        return this;
    }

    public TableLayoutBuilder withPaths(List<String> paths) {
        attributes.put("paths", paths);
        return this;
    }

    public TableLayoutBuilder withTableListAttribute(String tableListAttribute) {
        attributes.put("tableListAttribute", tableListAttribute);
        return this;
    }

    public TableLayoutBuilder withNonSortable(List<String> nonSortable) {
        attributes.put("nonSortable", nonSortable);
        return this;
    }

    public TableLayoutBuilder withColumnTextCenterList(List<String> columnTextCenterList) {
        attributes.put("columnTextCenterList", columnTextCenterList);
        return this;
    }

    public TableLayoutBuilder withColumnLinkEnable(boolean columnLinkEnable) {
        attributes.put("columnLinkEnable", columnLinkEnable);
        return this;
    }

    public TableLayoutBuilder withHeaderColumnName(String headerColumnName) {
        attributes.put("headerColumnName", headerColumnName);
        return this;
    }

    public TableLayoutBuilder withPathColumnName(String pathColumnName) {
        attributes.put("pathColumnName", pathColumnName);
        return this;
    }

    public TableLayoutBuilder withColumnParamVariable(String columnParamVariable) {
        attributes.put("columnParamVariable", columnParamVariable);
        return this;
    }

    public TableLayoutBuilder withHeaderColumnTextCenterList(List<String> headerColumnTextCenterList) {
        attributes.put("headerColumnTextCenterList", headerColumnTextCenterList);
        return this;
    }

    public TableLayoutBuilder withAbsolutePathLinks(Map<String, String> absolutePathLinks) {
        attributes.put("absolutePathLinks", absolutePathLinks);
        return this;
    }

    public TableLayoutBuilder withAbsolutePathName(String absolutePathName) {
        attributes.put("absolutePathName", absolutePathName);
        return this;
    }

    public TableLayoutBuilder withPathVariableName(String pathVariableName) {
        attributes.put("pathVariableName", pathVariableName);
        return this;
    }
    public TableLayoutBuilder withRowHyperlinkMap(Map<String,Object> rowHyperlinkMap) {
        attributes.put("rowHyperlinkMap", rowHyperlinkMap);
        return this;
    }

}