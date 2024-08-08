package edu.miu.common.ui.service.contract;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Breadcrumb {

    private String name;

    private String link;

}