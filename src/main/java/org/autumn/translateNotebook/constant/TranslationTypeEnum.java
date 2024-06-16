package org.autumn.translateNotebook.constant;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum TranslationTypeEnum {
    ZH_To_EN(0, "zh", "en", "中译英"),
    EN_TO_ZH(1, "en", "zh", "英译中");

    private final Integer type;
    private final String from;
    private final String to;
    private final String remark;

    TranslationTypeEnum(Integer type, String from, String to, String remark) {
        this.type = type;
        this.from = from;
        this.to = to;
        this.remark = remark;
    }

    public static TranslationTypeEnum getEnumByType(Integer type) {
        return Arrays.stream(values()).filter(item -> item.type.equals(type)).findFirst().orElse(null);
    }
}
