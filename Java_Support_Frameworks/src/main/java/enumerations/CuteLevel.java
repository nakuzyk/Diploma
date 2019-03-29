package enumerations;

import org.apache.commons.lang3.StringUtils;

public enum CuteLevel {
    BAD_CAT,
    FAT_CAT,
    GARBAGE_CAN_CAT,
    HOME_CAT,
    GOOD_CAT;

    @Override
    public String toString() {
        return StringUtils.capitalize(StringUtils.lowerCase(StringUtils.replace(this.name(), "_", " ")));
    }
}