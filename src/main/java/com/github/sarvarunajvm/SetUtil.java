package com.github.sarvarunajvm;

import java.util.Set;

public class SetUtil {

    private SetUtil() {
    }

    public static boolean isNullOrEmpty(Set<?> set) {
        boolean isNullOrEmpty = false;
        if (set == null || set.isEmpty()) {
            isNullOrEmpty = true;
        }
        return isNullOrEmpty;
    }

    public static boolean isNotNullOrEmpty(Set<?> set) {
        return !isNullOrEmpty(set);
    }

    public static boolean contains(Set<?> set, Object o) {
        boolean flag = false;
        if (isNotNullOrEmpty(set) && set.contains(o)) {
            flag = true;
        }
        return flag;
    }
}
