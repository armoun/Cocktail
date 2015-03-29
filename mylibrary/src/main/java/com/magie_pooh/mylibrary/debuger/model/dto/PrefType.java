package com.magie_pooh.mylibrary.debuger.model.dto;

/**
 * Created by magie-pooh on 2015/03
 */
public enum PrefType {
    INT("\\s*<int name=\"(.*)\"\\svalue=\"(.*)\" />"),
    FLOAT("\\s*<float name=\"(.*)\"\\svalue=\"(.*)\" />"),
    LONG("\\s*<long name=\"(.*)\"\\svalue=\"(.*)\" />"),
    BOOLEAN("\\s*<boolean name=\"(.*)\"\\svalue=\"(.*)\" />"),
    STRING("\\s*<string name=\"(.*)\">(.*)</string>");

    final public String mPattern;

    PrefType(final String pattern) {
        mPattern = pattern;
    }
}
