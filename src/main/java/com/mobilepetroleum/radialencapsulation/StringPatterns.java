package com.mobilepetroleum.radialencapsulation;

import classycle.util.StringPattern;

import java.util.regex.Pattern;

class StringPatterns {

    static StringPattern exclude(String... excludes) {
        Pattern[] patterns = new Pattern[excludes.length];
        for (int i = 0, excludesLength = excludes.length; i < excludesLength; i++) {
            String exclude = excludes[i];
            patterns[i] = Pattern.compile(exclude);
        }
        return new Exclude(patterns);
    }

    static class Exclude implements StringPattern {
        Pattern[] excludes;

        Exclude(Pattern[] excludes) {
            this.excludes = excludes;
        }

        @Override
        public boolean matches(String string) {
            for (Pattern exclude : excludes) {
                if (exclude.matcher(string).matches()) {
                    return false;
                }
            }
            return true;
        }
    }

}
