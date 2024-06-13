package org.autumn.translateNotebook.constant;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum TranslationTypeEnum {
    ZH_To_EN(0, "中译英"),
    EN_TO_ZH(1, "英译中");

    private final Integer type;
    private final String remark;

    TranslationTypeEnum(Integer type, String remark) {
        this.type = type;
        this.remark = remark;
    }

    public static TranslationTypeEnum getEnumByType(Integer type) {
        return Arrays.stream(values()).filter(item -> item.type.equals(type)).findFirst().orElse(null);
    }
}
