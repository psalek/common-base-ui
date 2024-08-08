package edu.miu.common.ui.builders;

import edu.miu.common.ui.config.CommonUIConfiguration;
import edu.miu.common.ui.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>CommonLayoutBuilder</h1>
 * <p>This class is a builder for constructing a standard layout model for views in a Spring MVC application. It encapsulates the common attributes that are frequently used across different views.</p>
 *
 * <h2>Public Methods</h2>
 * <dl>
 *   <dt>{@link #showDefaultHead(boolean)}</dt>
 *   <dd>Enables or disables the default head section. Takes a boolean value to show or hide the default head.</dd>
 *
 *   <dt>{@link #showDefaultHeader(boolean)}</dt>
 *   <dd>Enables or disables the default header. Takes a boolean value to show or hide the default header.</dd>
 *
 *   <dt>{@link #showDefaultMainTitle(boolean)}</dt>
 *   <dd>Enables or disables the display of the default main title. A boolean value determines whether the default main title is shown.</dd>
 *
 *   <dt>{@link #showDefaultFooter(boolean)}</dt>
 *   <dd>Controls the visibility of the default footer. A boolean value specifies if the default footer should be displayed.</dd>
 *
 *   <dt>{@link #showDefaultNavigationMenu(boolean)}</dt>
 *   <dd>Decides whether the default navigation menu should be shown or hidden, based on the boolean value provided.</dd>
 *
 *   <dt>{@link #showDefaultSearchBox(boolean)}</dt>
 *   <dd>Determines the display of the default search box using a boolean value to show or hide it.</dd>
 *
 *   <dt>{@link #showDefaultTable(boolean)}</dt>
 *   <dd>Enables or disables the default table view. A boolean value indicates the visibility of the default table.</dd>
 *
 *   <dt>{@link #withCustomHead(String)}</dt>
 *   <dd>Sets custom HTML content for the head section. Accepts a String representing custom HTML.</dd>
 *
 *   <dt>{@link #withCustomHeader(String)}</dt>
 *   <dd>Specifies custom HTML content for the header. Takes a String of custom HTML content.</dd>
 *
 *   <dt>{@link #withCustomMainTitle(String)}</dt>
 *   <dd>Assigns custom HTML content for the main title section. Accepts a String containing HTML content.</dd>
 *
 *   <dt>{@link #withCustomNavigationMenu(String)}</dt>
 *   <dd>Sets custom HTML content for the navigation menu. Accepts a String with the custom HTML.</dd>
 *
 *   <dt>{@link #withCustomSearchBox(String)}</dt>
 *   <dd>Defines custom HTML for the search box. A String parameter specifies the HTML content.</dd>
 *
 *   <dt>{@link #withCustomTable(String)}</dt>
 *   <dd>Provides a way to define custom HTML content for the table. A String parameter is used for the HTML content.</dd>
 *
 *   <dt>{@link #withCustomFooter(String)}</dt>
 *   <dd>Allows setting custom HTML content for the footer. Takes a String of HTML content.</dd>
 *
 *   <dt>{@link #withExtraStandardFragmentOne(String)} to {@link #withExtraStandardFragmentFour(String)}</dt>
 *   <dd>Configures additional custom fragments for use in the layout. Each method accepts a String identifying the fragment's content.</dd>
 *
 *   <dt>{@link #withExtraTableFragmentOne(String)} to {@link #withExtraTableFragmentSix(String)}</dt>
 *   <dd>Allows adding up to six extra custom fragments specifically for tables. Each accepts a String for the fragment's HTML content.</dd>
 *
 *   <dt>{@link #withFooterExtensionFragment(String)} to {@link #withJsExtensionFragment(String)}</dt>
 *   <dd>Enables customization of specific layout sections (footer, head, CSS, and JS) by providing additional content through Strings.</dd>
 *
 *   <dt>{@link #withHeaderExtensionFragmentOne(String)} to {@link #withHeaderExtensionFragmentThree(String)}</dt>
 *   <dd>Permits the addition of up to three custom header extension fragments, each accepting a String of HTML content.</dd>
 *
 *   <dt>{@link #withMainTitleExtensionFragmentOne(String)} and {@link #withMainTitleExtensionFragmentTwo(String)}</dt>
 *   <dd>Allows for one or two custom main title extensions, providing additional customization with Strings of HTML content.</dd>
 *
 *   <dt>{@link #withExtraNavigationButtonBefore(String)} and {@link #withExtraNavigationButtonAfter(String)}</dt>
 *   <dd>Configures additional navigation buttons to be placed before or after the main navigation, with each taking a String for HTML content.</dd>
 *
 *   <dt>{@link #withCommonCss(boolean)}</dt>
 *   <dd>Allows the custom css style file given in the framework, change to false if it is not needed.</dd>
 *
 *    <dt>{@link #withCommonJs(boolean)}</dt>
 *    <dd>Allows the custom JS file given in the framework, change to false if it is not needed.</dd>
 *
 *   <dt>{@link #withPageUrls(Map)}</dt>
 *   <dd>Updates navbar URLs for the header and footer. Accepts a map of String keys (link names) and values (URLs).</dd>
 *
 *   <dt>{@link #withNavbarMenu(List)}</dt>
 *   <dd>Sets the navigation menu items. Takes a list of NavbarItem objects defining each menu item.</dd>
 *
 *   <dt>{@link #withStyleModifierHeader(String)} and {@link #withStyleModifierFooter(String)}</dt>
 *   <dd>Applies custom style modifiers to the header and footer, respectively. Each takes a String that modifies the existing style.</dd>
 *
 *   <dt>{@link #withTextColorHeader(String)} and {@link #withTextColorFooter(String)}</dt>
 *   <dd>Sets the text color for the header and footer. Each method accepts a String representing a CSS color value.</dd>
 *
 *   <dt>{@link #withHeaderDepartment(String)}</dt>
 *   <dd>Specifies the department name to be displayed in the header. Accepts a String for the department name.</dd>
 *
 *   <dt>{@link #withFooterName(String)}</dt>
 *   <dd>Sets the name to be displayed in the footer. Accepts a String for the name.</dd>
 *
 *   <dt>{@link #withHeadTitle(String)}</dt>
 *   <dd>Sets the page's title for display in the browser's title bar. Accepts a String for the title.</dd>
 *
 *   <dt>{@link #withMainTitle(String)}</dt>
 *   <dd>Sets the main title for the page. This title is typically displayed prominently. Accepts a String for the title.</dd>
 *
 *   <dt>{@link #withBreadCrumbList(List)}</dt>
 *   <dd>Sets a breadcrumb list for navigation. Accepts a list of Strings representing the breadcrumb items.</dd>
 *
 *   <dt>{@link #withBreadCrumbList(List, Map)}</dt>
 *   <dd>Overloaded version of `withBreadCrumbList` that also allows setting dynamic navigation links through a map.</dd>
 *
 *   <dt>{@link #withSearchBoxPath(String)}, {@link #withSearchBoxName(String)}, and {@link #withSearchBoxPlaceHolder(String)}</dt>
 *   <dd>Configures the search box's form action path, name, and placeholder text, each accepting a String.</dd>
 * </dl>
 *
 * <h2>Usage</h2>
 * <p>
 *   To use this class, create an instance, chain the necessary attribute methods, and call `build` to apply the configuration to a Model:
 * </p>
 * <pre><code>
 *   // Autowired an instance
 *   StandardLayoutBuilder standardLayoutBuilder;
 *
 *   // Configure the attributes
 *   commonBuilder.initiateDefaults()
 *     .withHeadTitle("Head Title")
 *     .withMainTitle("Main Title")
 *     .withSubTitle("Sub Title")
 *     .withLinkPath("link/path")
 *     .withLinkName("Link Name")
 *     .withBreadCrumbList(List.of("Home", "Link Name"));
 *
 *   // Apply the configuration to a Model
 *   builder.build(model);
 * </code></pre>
 */

@Slf4j
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public abstract class CommonLayoutBuilder<T extends CommonLayoutBuilder<T>> {

    protected final Map<String, Object> attributes = new HashMap<>();
    protected final CommonUIConfiguration commonUIConfiguration;
    protected final CommonUtils commonUtils;

    protected CommonLayoutBuilder(CommonUtils commonUtils, CommonUIConfiguration commonUIConfiguration) {
        this.commonUtils = commonUtils;
        this.commonUIConfiguration = commonUIConfiguration;
        initiateDefaults();
    }

    @SuppressWarnings("unchecked")
    private T returnThis() {
        return (T) this;
    }

    public T initiateDefaults() {

        attributes.clear();

        // Setting default values for the layouts
        attributes.put("showDefaultHead", true);
        attributes.put("showDefaultHeader", true);
        attributes.put("showDefaultMainTitle", true);
        attributes.put("showDefaultFooter", true);
        attributes.put("showDefaultNavigationMenu", true);
        attributes.put("showDefaultSearchBox", true);
        attributes.put("showDefaultTable", true);
        attributes.put("customHead", "");
        attributes.put("customHeader", "");
        attributes.put("customMainTitle", "");
        attributes.put("customNavigationMenu", "");
        attributes.put("customSearchBox", "");
        attributes.put("customTable", "");
        attributes.put("customFooter", "");
        attributes.put("extraStandardFragmentOne", "");
        attributes.put("extraStandardFragmentTwo", "");
        attributes.put("extraStandardFragmentThree", "");
        attributes.put("extraStandardFragmentFour", "");
        attributes.put("extraStandardFragmentFive", "");
        attributes.put("extraTableFragmentOne", "");
        attributes.put("extraTableFragmentTwo", "");
        attributes.put("extraTableFragmentThree", "");
        attributes.put("extraTableFragmentFour", "");
        attributes.put("extraTableFragmentFive", "");
        attributes.put("extraTableFragmentSix", "");
        attributes.put("extraTableFragmentSeven", "");
        attributes.put("standardBodyClassConfiguration", "d-flex flex-column min-vh-100");
        attributes.put("standardContainerClassConfiguration", "container flex-grow-1 pt-5 pb-0");
        attributes.put("tabletBodyClassConfiguration", "d-flex flex-column min-vh-100");
        attributes.put("tabletContainerClassConfiguration", "custom-container flex-grow-1 pt-5 pb-0");

        // Setting default values for fragments
        attributes.put("showNavbarMenuFragment", true);
        attributes.put("showHeaderSearchBox", true);
        attributes.put("footerExtensionFragment", "");
        attributes.put("headExtensionFragment", "");
        attributes.put("cssExtensionFragment", "");
        attributes.put("jsExtensionFragment", "");
        attributes.put("headerExtensionFragmentOne", "");
        attributes.put("headerExtensionFragmentTwo", "");
        attributes.put("headerExtensionFragmentThree", "");
        attributes.put("mainTitleExtensionFragmentOne", "");
        attributes.put("mainTitleExtensionFragmentTwo", "");
        attributes.put("extraNavigationButtonBefore", "");
        attributes.put("extraNavigationButtonAfter", "");

        // Setting default values for the fragments
        attributes.put("headTitle", "");
        attributes.put("withHeaderHomeLink", commonUIConfiguration.getUrls().get("home"));
        attributes.put("headerDepartment", "");
        attributes.put("footerName", "");
        attributes.put("styleModifierHeader", "");
        attributes.put("styleModifierFooter", "");
        attributes.put("textColorHeader", "");
        attributes.put("textColorFooter", "");
        attributes.put("mainTitle", "");
        attributes.put("pageUrls",commonUIConfiguration.getUrls());
        attributes.put("navbarMenu", commonUIConfiguration.getNavbarItems());
        attributes.put("breadCrumbList", Collections.emptyMap());
        attributes.put("commonUtils", commonUtils);
        attributes.put("searchBoxPath", "");
        attributes.put("searchBoxName", "");
        attributes.put("searchBoxPlaceholder", "");
        attributes.put("exportButtonPath", "");
        attributes.put("withCommonCss", true);
        attributes.put("withCommonJs", true);

        log.debug("Common Layout Builder initiated with default values");
        log.debug("with pageUrls: {}", commonUIConfiguration.getUrls());
        log.debug("with navbarMenu: {}", commonUIConfiguration.getNavbarItems());

        return returnThis();

    }

    public T showDefaultHead(boolean showDefaultHead) {
        attributes.put("showDefaultHead", showDefaultHead);
        return returnThis();
    }

    public T showDefaultHeader(boolean showDefaultHeader) {
        attributes.put("showDefaultHeader", showDefaultHeader);
        return returnThis();
    }

    public T showDefaultMainTitle(boolean showDefaultMainTitle) {
        attributes.put("showDefaultMainTitle", showDefaultMainTitle);
        return returnThis();
    }

    public T showDefaultFooter(boolean showDefaultFooter) {
        attributes.put("showDefaultFooter", showDefaultFooter);
        return returnThis();
    }

    public T showDefaultNavigationMenu(boolean showDefaultNavigationMenu) {
        attributes.put("showDefaultNavigationMenu", showDefaultNavigationMenu);
        return returnThis();
    }

    public T showDefaultSearchBox(boolean showDefaultSearchBox) {
        attributes.put("showDefaultSearchBox", showDefaultSearchBox);
        return returnThis();
    }

    public T showDefaultTable(boolean showDefaultTable) {
        attributes.put("showDefaultTable", showDefaultTable);
        return returnThis();
    }

    public T withCustomHead(String customHead) {
        attributes.put("customHead", customHead);
        return returnThis();
    }

    public T withCustomHeader(String customHeader) {
        attributes.put("customHeader", customHeader);
        return returnThis();
    }

    public T withCustomMainTitle(String customMainTitle) {
        attributes.put("customMainTitle", customMainTitle);
        return returnThis();
    }

    public T withCustomNavigationMenu(String customNavigationMenu) {
        attributes.put("customNavigationMenu", customNavigationMenu);
        return returnThis();
    }

    public T withCustomSearchBox(String customSearchBox) {
        attributes.put("customSearchBox", customSearchBox);
        return returnThis();
    }

    public T withCustomTable(String customTable) {
        attributes.put("customTable", customTable);
        return returnThis();
    }

    public T withCustomFooter(String customFooter) {
        attributes.put("customFooter", customFooter);
        return returnThis();
    }

    public T withExtraStandardFragmentOne(String extraStandardFragmentOne) {
        attributes.put("extraStandardFragmentOne", extraStandardFragmentOne);
        return returnThis();
    }

    public T withExtraStandardFragmentTwo(String extraStandardFragmentTwo) {
        attributes.put("extraStandardFragmentTwo", extraStandardFragmentTwo);
        return returnThis();
    }

    public T withExtraStandardFragmentThree(String extraStandardFragmentThree) {
        attributes.put("extraStandardFragmentThree", extraStandardFragmentThree);
        return returnThis();
    }

    public T withExtraStandardFragmentFour(String extraStandardFragmentFour) {
        attributes.put("extraStandardFragmentFour", extraStandardFragmentFour);
        return returnThis();
    }

    public T withExtraStandardFragmentFive(String extraStandardFragmentFive) {
        attributes.put("extraStandardFragmentFive", extraStandardFragmentFive);
        return returnThis();
    }

    public T withExtraTableFragmentOne(String extraTableFragmentOne) {
        attributes.put("extraTableFragmentOne", extraTableFragmentOne);
        return returnThis();
    }

    public T withExtraTableFragmentTwo(String extraTableFragmentTwo) {
        attributes.put("extraTableFragmentTwo", extraTableFragmentTwo);
        return returnThis();
    }

    public T withExtraTableFragmentThree(String extraTableFragmentThree) {
        attributes.put("extraTableFragmentThree", extraTableFragmentThree);
        return returnThis();
    }

    public T withExtraTableFragmentFour(String extraTableFragmentFour) {
        attributes.put("extraTableFragmentFour", extraTableFragmentFour);
        return returnThis();
    }

    public T withExtraTableFragmentFive(String extraTableFragmentFive) {
        attributes.put("extraTableFragmentFive", extraTableFragmentFive);
        return returnThis();
    }

    public T withExtraTableFragmentSix(String extraTableFragmentSix) {
        attributes.put("extraTableFragmentSix", extraTableFragmentSix);
        return returnThis();
    }

    public T withExtraTableFragmentSeven(String extraTableFragmentSeven) {
        attributes.put("extraTableFragmentSeven", extraTableFragmentSeven);
        return returnThis();
    }

    public T withFooterExtensionFragment(String footerExtensionFragment) {
        attributes.put("footerExtensionFragment", footerExtensionFragment);
        return returnThis();
    }

    public T withHeadExtensionFragment(String headExtensionFragment) {
        attributes.put("headExtensionFragment", headExtensionFragment);
        return returnThis();
    }

    public T withCssExtensionFragment(String cssExtensionFragment) {
        attributes.put("cssExtensionFragment", cssExtensionFragment);
        return returnThis();
    }

    public T withJsExtensionFragment(String jsExtensionFragment) {
        attributes.put("jsExtensionFragment", jsExtensionFragment);
        return returnThis();
    }

    public T withHeaderExtensionFragmentOne(String headerExtensionFragmentOne) {
        attributes.put("headerExtensionFragmentOne", headerExtensionFragmentOne);
        return returnThis();
    }

    public T withHeaderExtensionFragmentTwo(String headerExtensionFragmentTwo) {
        attributes.put("headerExtensionFragmentTwo", headerExtensionFragmentTwo);
        return returnThis();
    }

    public T withHeaderExtensionFragmentThree(String headerExtensionFragmentThree) {
        attributes.put("headerExtensionFragmentThree", headerExtensionFragmentThree);
        return returnThis();
    }

    public T withMainTitleExtensionFragmentOne(String mainTitleExtensionFragmentOne) {
        attributes.put("mainTitleExtensionFragmentOne", mainTitleExtensionFragmentOne);
        return returnThis();
    }

    public T withMainTitleExtensionFragmentTwo(String mainTitleExtensionFragmentTwo) {
        attributes.put("mainTitleExtensionFragmentTwo", mainTitleExtensionFragmentTwo);
        return returnThis();
    }

    public T withExtraNavigationButtonBefore(String extraNavigationButtonBefore) {
        attributes.put("extraNavigationButtonBefore", extraNavigationButtonBefore);
        return returnThis();
    }

    public T withExtraNavigationButtonAfter(String extraNavigationButtonAfter) {
        attributes.put("extraNavigationButtonAfter", extraNavigationButtonAfter);
        return returnThis();
    }

    public T withCommonCss(boolean commonCss) {
        attributes.put("withCommonCss", commonCss);
        return returnThis();
    }

    public T withCommonJs(boolean commonJs) {
        attributes.put("withCommonJs", commonJs);
        return returnThis();
    }

    public T withStandardBodyClassConfiguration(String standardBodyClassConfiguration) {
        attributes.put("standardBodyClassConfiguration", standardBodyClassConfiguration);
        return returnThis();
    }

    public T withStandardContainerClassConfiguration(String standardContainerClassConfiguration) {
        attributes.put("standardContainerClassConfiguration", standardContainerClassConfiguration);
        return returnThis();
    }

    public T withTabletBodyClassConfiguration(String tabletBodyClassConfiguration) {
        attributes.put("tabletBodyClassConfiguration", tabletBodyClassConfiguration);
        return returnThis();
    }

    public T withTabletContainerClassConfiguration(String tabletContainerClassConfiguration) {
        attributes.put("tabletContainerClassConfiguration", tabletContainerClassConfiguration);
        return returnThis();
    }

    public T withPageUrls(Map<String, String> pageUrls) {
        attributes.put("pageUrls", pageUrls);
        return returnThis();
    }

    public T withNavbarMenu(List<CommonUIConfiguration.NavbarItem> navbarItems) {
        attributes.put("navbarMenu", navbarItems);
        return returnThis();
    }

    public T showNavbarMenuFragment(boolean showNavbarMenuFragment) {
        attributes.put("showNavbarMenuFragment", showNavbarMenuFragment);
        return returnThis();
    }

    public T showHeaderSearchBox(boolean showHeaderSearchBox) {
        attributes.put("showHeaderSearchBox", showHeaderSearchBox);
        return returnThis();
    }

    public T withStyleModifierHeader(String styleModifierHeader) {
        attributes.put("styleModifierHeader", styleModifierHeader);
        return returnThis();
    }

    public T withStyleModifierFooter(String styleModifierFooter) {
        attributes.put("styleModifierFooter", styleModifierFooter);
        return returnThis();
    }

    public T withTextColorHeader(String textColorHeader) {
        attributes.put("textColorHeader", textColorHeader);
        return returnThis();
    }

    public T withTextColorFooter(String textColorFooter) {
        attributes.put("textColorFooter", textColorFooter);
        return returnThis();
    }

    public T withHeaderHomeLink(String withHeaderHomeLink) {
        attributes.put("withHeaderHomeLink", withHeaderHomeLink);
        return returnThis();
    }

    public T withHeaderDepartment(String headerDepartment) {
        attributes.put("headerDepartment", headerDepartment);
        return returnThis();
    }

    public T withFooterName(String footerName) {
        attributes.put("footerName", footerName);
        return returnThis();
    }

    public T withHeadTitle(String headTitle) {
        attributes.put("headTitle", headTitle);
        return returnThis();
    }

    public T withMainTitle(String mainTitle) {
        attributes.put("mainTitle", mainTitle);
        return returnThis();
    }

    public T withBreadCrumbList(List<String> breadCrumbList) {
        attributes.put("breadCrumbList", commonUtils.setNavigationLinks(breadCrumbList, commonUIConfiguration.getUrls()));
        return returnThis();
    }

    public T withBreadCrumbList(List<String> breadCrumbList, Map<String, String> pageUrls) {
        attributes.put("breadCrumbList", commonUtils.setNavigationLinks(breadCrumbList, pageUrls));
        return returnThis();
    }

    public T withSearchBoxPath(String searchBoxPath) {
        attributes.put("searchBoxPath", searchBoxPath);
        return returnThis();
    }

    public T withSearchBoxName(String searchBoxName) {
        attributes.put("searchBoxName", searchBoxName);
        return returnThis();
    }

    public T withSearchBoxPlaceHolder(String searchBoxPlaceholder) {
        attributes.put("searchBoxPlaceholder", searchBoxPlaceholder);
        return returnThis();
    }

    public T withExportButtonPath(String exportButtonPath) {
        attributes.put("exportButtonPath", exportButtonPath);
        return returnThis();
    }

    public void build(Model model) {
        attributes.forEach(model::addAttribute);
    }

}