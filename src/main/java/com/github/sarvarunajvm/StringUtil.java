package com.github.sarvarunajvm;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    static final int MAX_CHAR = 256;

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.length() <= 0;
    }

    public static boolean isNotNullOrEmpty(String str) {
        return !isNullOrEmpty(str);
    }

    public static boolean isNotNullOrEmptyAfterTrim(String str) {
        return StringUtil.isNotNullOrEmpty(str) && str.trim().length() > 0;
    }

    public static boolean isEqual(String str1, String str2) {
        boolean isEqual = false;
        if (str1 != null && str2 != null
                && str1.equalsIgnoreCase(str2)) {
            isEqual = true;
        }
        return isEqual;
    }

    public static boolean isEqual(String str1, String str2, String str3) {
        boolean isEqual = false;
        if (str1 != null && str2 != null && str3 != null
                && str1.equalsIgnoreCase(str2)
                && str2.equalsIgnoreCase(str3)) {
            isEqual = true;
        }
        return isEqual;
    }

    public static boolean isNotEqual(String str1, String str2) {
        return !isEqual(str1, str2);
    }

    public static boolean isNullOrEqual(String str1, String str2) {
        boolean isNullOrEqual = false;
        if (str1 == null && str2 == null) {
            isNullOrEqual = true;
        } else {
            isNullOrEqual = isEqual(str1, str2);
        }
        return isNullOrEqual;
    }

    public static boolean isEqualAfterTrim(String str1, String str2) {
        boolean isEqual = false;
        if (str1 != null && str2 != null
                && str1.trim().equalsIgnoreCase(str2.trim())) {
            isEqual = true;
        }
        return isEqual;
    }

    public static List<String> getUniqueValues(List<String> stringList) {
        Set<String> set = new LinkedHashSet<>();
        set.addAll(stringList);
        return new ArrayList<>(set);
    }

    public static String convertStringListToString(List<String> stringList) {
        String value = "";
        if (ListUtil.isNotNullOrEmpty(stringList)) {
            int count = 0;
            for (String val : stringList) {
                if (count != 0) {
                    value = value + ",";
                }
                value = value + val;
                count++;
            }
        }
        return value;
    }

    public static String convertStringListToStringWithDelimiter(List<String> stringList, String delimiter) {
        String value = "";
        if (ListUtil.isNotNullOrEmpty(stringList)) {
            int count = 0;
            for (String val : stringList) {
                if (count != 0) {
                    value = value + delimiter;
                }
                value = value + val;
                count++;
            }
        }
        return value;
    }

    public static String getString(String str) {
        return StringUtil.isNullOrEmpty(str) ? "" : str;
    }

    public static String getString(String str, String altText) {
        return StringUtil.isNullOrEmpty(str) ? getString(altText) : str;
    }

    public static String getBooleanString(boolean isTrue) {
        if (isTrue) {
            return "TRUE";
        } else {
            return "FALSE";
        }
    }

    public static boolean getBoolean(String str) {
        return isEqual(str, "TRUE");
    }

    public static String[] split(String str, String seperator) {
        String[] strArray = null;
        if (isNotNullOrEmpty(str)) {
            strArray = str.split(seperator);
        }
        return strArray;
    }

    public static List<String> splitOnlyNonEmpty(String str, String separator) {
        List<String> values = new ArrayList<String>();
        String[] strArray = split(str, separator);
        if (strArray != null) {
            for (String val : strArray) {
                if (StringUtil.isNotNullOrEmpty(val)) {
                    values.add(val);
                }
            }
        }
        return values;
    }

    public static List<String> splitMultipleIdsBySpace(String idList) {
        List<String> itemIdsList = StringUtil.splitOnlyNonEmpty(idList, " ");
        return itemIdsList;
    }

    public static String subStringByMaxSize(String str, int size) {
        if (StringUtil.isNotNullOrEmpty(str)) {
            str = str.trim();
            if (str.length() >= size) {
                str = str.substring(0, size);
            }
        }
        return str;
    }

    public static List<String> splitStringByMaxSize(String str, int maxSize) {
        List<String> stringList = null;
        if (StringUtil.isNotNullOrEmpty(str)) {
            stringList = new ArrayList<String>();
            str = str.trim();
            while (str.length() > maxSize) {
                String splittedString = getStringTill(str, maxSize);
                str = getStringAfter(str, maxSize);
                stringList.add(splittedString);
            }
            if (str.length() < maxSize) {
                stringList.add(str);
            }
        }
        return stringList;
    }

    public static int countLines(String str) {
        String[] lines = str.split("\r\n|\r|\n");
        return lines.length;
    }


    public static String replace(String str, String toBeReplaced, String toReplaceWith) {
        if (isNotNullOrEmpty(str) && isNotNullOrEmpty(toBeReplaced)) {
            str = str.replace(toBeReplaced, getString(toReplaceWith));
        }
        return str;
    }

    public static String reverseString(String str) {
        return new StringBuffer(str).reverse().toString();
    }

    public static int getCountOfOccurrenceOfChar(String str1, String strSubset) {
        int count = 0;
        char c = strSubset.charAt(0);
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    public static String repeatStringForCount(String str1, int count) {
        String newStr = "";
        for (int i = 0; i < count; i++) {
            newStr = str1 + newStr;
        }
        return newStr;
    }

    public static String getFirstLetter(String str) {
        String fl = "";
        if (isNotNullOrEmptyAfterTrim(str)) {
            fl = str.substring(0, 1);
        }
        return fl;
    }

    public static String getStringAfter(String str, int count) {
        String fl = "";
        if (isNotNullOrEmptyAfterTrim(str)) {
            fl = str.substring(count);
        }
        return fl;
    }

    public static String getStringTill(String str, int count) {
        String fl = "";
        if (isNotNullOrEmptyAfterTrim(str)) {
            fl = str.substring(0, count);
        }
        return fl;
    }

    public static String concatStrings(String str1, String str2) {
        String concatedString = "";
        if (isNotNullOrEmpty(str1) && isNotNullOrEmpty(str2)) {
            concatedString = str1.concat(str2);
        }
        return concatedString;
    }

    public static List<String> convertStringToStringList(String str, String printerNameSpliter) {
        String[] strArray = null;
        List<String> strList = null;

        if (isNotNullOrEmpty(printerNameSpliter)) {
            if (isNullOrEmpty(str)) {
                str = "";
            }

            strArray = str.split(printerNameSpliter);

            if (strArray != null && strArray.length > 0) {
                strList = new ArrayList<String>();
                int size = strArray.length;
                for (int i = 0; i < size; i++) {
                    strList.add(strArray[i]);
                }
            }
        }

        strArray = strArray;
        return strList;
    }

    public static String convertStringListToStringWithJSONFormat(List<String> stringList) {
        String value = "";
        if (ListUtil.isNotNullOrEmpty(stringList)) {
            int count = 0;
            for (String val : stringList) {
                if (count != 0) {
                    value = value + ",";
                }
                value = value + "'" + val + "'";
                count++;
            }
        }
        return value;
    }

    public static String getStringAfterSpecialCharacter(String string, String specialCharacter) {

        String value = "";
        int positionOfSpecialChar = 0;
        if (isNotNullOrEmpty(string)) {
            positionOfSpecialChar = string.indexOf(specialCharacter) + 1;
            value = getStringAfter(string, positionOfSpecialChar);
        }
        return value;
    }

    public static String getStringInBetween(String string, int a, int b) {
        return string.substring(a, b);
    }

    public static String getStringListToStringWithAddnFrontComma(List<String> strList) {
        String strValue = StringUtil.convertStringListToString(strList);
        if (StringUtil.isNotNullOrEmpty(strValue)) {
            strValue = "," + strValue;
        }
        return strValue;
    }

    public static boolean isStrContainsWithEqIgnoreCase(List<String> strList, String value) {
        boolean isContains = false;
        if (ListUtil.isNotNullOrEmpty(strList)) {
            for (String str : strList) {
                if (value != null &&
                        str != null) {
                    if (value.equalsIgnoreCase(str)) {
                        isContains = true;
                        break;
                    }
                }
            }
        }
        return isContains;
    }

    public static boolean isStrListContainsWithEqIgnoreCase(List<String> strList, String value) {
        boolean isContains = false;
        if (ListUtil.isNotNullOrEmpty(strList)) {
            for (String str : strList) {
                if (value != null &&
                        str != null) {
                    if (isStrContainsWithEqIgnoreCase(str, value)) {
                        isContains = true;
                        break;
                    }
                }
            }
        }
        return isContains;
    }


    public static boolean isStrContainsWithEqIgnoreCase(String strValue, String value) {
        boolean isContains = false;
        String value1 = "";
        String value2 = "";
        if (StringUtil.isNotNullOrEmpty(strValue) &&
                StringUtil.isNotNullOrEmpty(value)) {
            value1 = strValue.toLowerCase();
            value2 = value.toLowerCase();
            if (value1.contains(value2)) {
                isContains = true;
            }
        }
        return isContains;
    }

    public static String getStringForJSArgsString(String str) {
        String value = "";
        if (isNotNullOrEmpty(str)) {
            value = replace(str, "\"", "&quot;");
        }

        return value;
    }

    public static List<String> getStringListByDates(List<LocalDate> dates, DateTimeFormatter dateFormat) {
        List<String> stringList = new ArrayList<String>();
        if (ListUtil.isNotNullOrEmpty(dates)) {
            for (LocalDate date : dates) {
                stringList.add(dateFormat.format(date));
            }
        }
        return stringList;
    }

    public static boolean isStartsWith(String value, String startValue) {
        boolean isStartWith = false;
        if (value.startsWith(startValue)) {
            isStartWith = true;
        }
        return isStartWith;
    }

    public static String removeLastChar(String value) {
        if (StringUtil.isNotNullOrEmpty(value)) {
            value = value.trim();
            if (value.length() > 0) {
                value = value.substring(0, value.length() - 1);
            }
        }
        return value;
    }

    public static String removeFirstChar(String value) {
        if (StringUtil.isNotNullOrEmpty(value)) {
            value = value.trim();
            if (value.length() > 0) {
                value = value.substring(1);
            }
        }
        return value;
    }

    public static String removeFirstAndLastChar(String value) {
        value = removeFirstChar(value);
        value = removeLastChar(value);
        return value;
    }

    public static String convertAnsiToUtf8(String value) throws Exception {
        String resultString = "";
        if (isNotNullOrEmpty(value)) {
            byte[] b1 = value.getBytes(StandardCharsets.ISO_8859_1);
            resultString = new String(b1, StandardCharsets.UTF_8);
        }
        return resultString;
    }

    public static String convertIntToUnicode(int value) {
        String s = Character.toString((char) value);
        return s;
    }

    public static boolean isStringContainsSpecialChars(String name) {
        boolean isContains = false;
        char[] splChars = {'\'', '\"', '&', '%', ':'};

        for (int index = 0; index < splChars.length; index++) {
            if (!(name.indexOf(splChars[index]) == -1)) {
                isContains = true;
                break;
            }
        }
        return isContains;
    }

    public static String getStringWithoutSpecialCharacters(String name) {
        String pdtName = "";
        char[] splChars = {'\'', '\"', '&', '%', ':'};

        if (StringUtil.isNotNullOrEmpty(name)) {

            try {

                pdtName = name;

                for (int index = 0; index < splChars.length; index++) {
                    if (!(pdtName.indexOf(splChars[index]) == -1)) {
                        Character char1 = splChars[index];
                        if (StringUtil.isEqual(char1.toString(), "'")) {
                            pdtName = pdtName.replaceAll("'", "`");
                        } else if (StringUtil.isEqual(char1.toString(), "%")) {
                            pdtName = pdtName.replaceAll("\\%", " " + " PERCENT ") + " ";
                        } else if (StringUtil.isEqual(char1.toString(), "\"")) {
                            pdtName = pdtName.replaceAll("\"", "``");
                        } else if (StringUtil.isEqual(char1.toString(), "&")) {
                            pdtName = pdtName.replaceAll("&", " " + " AND ") + " ";
                        } else if (StringUtil.isEqual(char1.toString(), ":")) {
                            pdtName = pdtName.replaceAll(":", " " + " - ") + " ";
                        }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return pdtName;
    }

    public static String fastReplace(String str, String target, String replacement) {
        int targetLength = target.length();
        if (targetLength == 0) {
            return str;
        }
        int idx2 = str.indexOf(target);
        if (idx2 < 0) {
            return str;
        }
        StringBuilder buffer = new StringBuilder(targetLength > replacement.length() ? str.length() : str.length() * 2);
        int idx1 = 0;
        do {
            buffer.append(str, idx1, idx2);
            buffer.append(replacement);
            idx1 = idx2 + targetLength;
            idx2 = str.indexOf(target, idx1);
        } while (idx2 > 0);
        buffer.append(str, idx1, str.length());
        return buffer.toString();
    }

    public static String getMailIdFromGivenString(String str) {
        String emailId = "";
        Pattern p = Pattern.compile("(.*?)<([^>]+)>\\s*,?", Pattern.DOTALL);
        Matcher m = p.matcher(str);
        while (m.find()) {
            emailId = m.group(2).replaceAll("[\\n\\r]+", "");
        }
        return emailId;
    }

    public static List<String> lineByLineReadFromParagraph(String content) {
        Scanner scanner = new Scanner(content);
        List<String> stringList = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (StringUtil.isNotNullOrEmpty(line)) {
                stringList.add(line);
            }
        }
        scanner.close();
        return stringList;
    }

    public static String getOnlyNomberFromGivenString(final CharSequence input) {
        final StringBuilder sb = new StringBuilder(input.length());
        for (int i = 0; i < input.length(); i++) {
            final char c = input.charAt(i);
            if (c > 47 && c < 58) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String getAlphabetFromPosition(int pos) {
        String alphabetList = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] alphaArray = alphabetList.split("");
        String alphabet = "";
        alphabet = alphaArray[pos];
        return alphabet;
    }

    public static String getLastLetter(String str) {
        if (StringUtil.isNotNullOrEmpty(str)) {
            str = str.trim();
            if (StringUtil.isNotNullOrEmpty(str)) {
                int length = str.length();
                str = str.substring(length - 1, length);
            }
        }
        return str;
    }

    public static String[] getSplitBySlashN(String str) {
        String[] splittedList = null;
        if (StringUtil.isNotNullOrEmpty(StringUtil.getString(str))) {
            splittedList = str.split("\\r?\\n");
        }
        return splittedList;
    }

    public static String getStringInBetweenUsingStrings(String string, String from, String to) {
        String betweenvalue = null;
        if (StringUtil.isNotNullOrEmpty(string) &&
                StringUtil.isNotNullOrEmpty(from) &&
                StringUtil.isNotNullOrEmpty(to)) {
            betweenvalue = StringUtil.getStringInBetween(string, Integer.getInteger(from), Integer.getInteger(to));
        }

        return betweenvalue;
    }

    public static String wrap(String str, int wrapLength, String newLineStr, final boolean wrapLongWords, String wrapOn) {
        if (isNullOrEmpty(str)) {
            str = "";
        }
        if (newLineStr == null) {
            newLineStr = System.lineSeparator();
        }
        if (wrapLength < 1) {
            wrapLength = 1;
        }
        if (isNullOrEmpty(wrapOn)) {
            wrapOn = " ";
        }
        final Pattern patternToWrapOn = Pattern.compile(wrapOn);
        final int inputLineLength = str.length();
        int offset = 0;
        final StringBuilder wrappedLine = new StringBuilder(inputLineLength + 32);

        while (offset < inputLineLength) {
            int spaceToWrapAt = -1;
            Matcher matcher = patternToWrapOn.matcher(str.substring(offset, Math.min((int) Math.min(Integer.MAX_VALUE, offset + wrapLength + 1L), inputLineLength)));
            if (matcher.find()) {
                if (matcher.start() == 0) {
                    offset += matcher.end();
                    continue;
                }
                spaceToWrapAt = matcher.start() + offset;
            }

            // only last line without leading spaces is left
            if (inputLineLength - offset <= wrapLength) {
                break;
            }

            while (matcher.find()) {
                spaceToWrapAt = matcher.start() + offset;
            }

            if (spaceToWrapAt >= offset) {
                // normal case
                wrappedLine.append(str, offset, spaceToWrapAt);
                wrappedLine.append(newLineStr);
                offset = spaceToWrapAt + 1;

            } else {
                // really long word or URL
                if (wrapLongWords) {
                    // wrap really long word one line at a time
                    wrappedLine.append(str, offset, wrapLength + offset);
                    wrappedLine.append(newLineStr);
                    offset += wrapLength;
                } else {
                    // do not wrap really long word, just extend beyond limit
                    matcher = patternToWrapOn.matcher(str.substring(offset + wrapLength));
                    if (matcher.find()) {
                        spaceToWrapAt = matcher.start() + offset + wrapLength;
                    }

                    if (spaceToWrapAt >= 0) {
                        wrappedLine.append(str, offset, spaceToWrapAt);
                        wrappedLine.append(newLineStr);
                        offset = spaceToWrapAt + 1;
                    } else {
                        wrappedLine.append(str, offset, str.length());
                        offset = inputLineLength;
                    }
                }
            }
        }

        // Whatever is left in line is short enough to just pass through
        wrappedLine.append(str, offset, str.length());

        return wrappedLine.toString();
    }

    public static List<String> wrapAsList(String str, int wrapLength, final boolean wrapLongWords, String wrapOn) {
        List<String> wrappedList = new ArrayList<>();
        if (isNullOrEmpty(str)) {
            str = "";
        }
        if (wrapLength < 1) {
            wrapLength = 1;
        }
        if (isNullOrEmpty(wrapOn)) {
            wrapOn = " ";
        }
        final Pattern patternToWrapOn = Pattern.compile(wrapOn);
        final int inputLineLength = str.length();
        int offset = 0;
        //final StringBuilder wrappedLine = new StringBuilder(inputLineLength + 32);

        while (offset < inputLineLength) {
            int spaceToWrapAt = -1;
            Matcher matcher = patternToWrapOn.matcher(str.substring(offset, Math.min((int) Math.min(Integer.MAX_VALUE, offset + wrapLength + 1L), inputLineLength)));
            if (matcher.find()) {
                if (matcher.start() == 0) {
                    offset += matcher.end();
                    continue;
                }
                spaceToWrapAt = matcher.start() + offset;
            }

            // only last line without leading spaces is left
            if (inputLineLength - offset <= wrapLength) {
                break;
            }

            while (matcher.find()) {
                spaceToWrapAt = matcher.start() + offset;
            }

            if (spaceToWrapAt >= offset) {
                // normal case
                wrappedList.add(str.substring(offset, spaceToWrapAt));
                offset = spaceToWrapAt + 1;

            } else {
                // really long word or URL
                if (wrapLongWords) {
                    // wrap really long word one line at a time
                    wrappedList.add(str.substring(offset, wrapLength + offset));
                    offset += wrapLength;
                } else {
                    // do not wrap really long word, just extend beyond limit
                    matcher = patternToWrapOn.matcher(str.substring(offset + wrapLength));
                    if (matcher.find()) {
                        spaceToWrapAt = matcher.start() + offset + wrapLength;
                    }

                    if (spaceToWrapAt >= 0) {
                        wrappedList.add(str.substring(offset, spaceToWrapAt));
                        offset = spaceToWrapAt + 1;
                    } else {
                        wrappedList.add(str.substring(offset));
                        offset = inputLineLength;
                    }
                }
            }
        }

        // Whatever is left in line is short enough to just pass through
        wrappedList.add(str.substring(offset));

        return wrappedList;
    }

    public static boolean isAlphaNumericOrNumeric(String invoiceNumber) {
        String n = ".*[0-9].*";
        String a = ".*[A-Za-z].*";
        return invoiceNumber.matches(n);

    }

    public static String replaceFileSystemReservedCharacters(String str) {
        String regex = "[$&+,:;=?@#|'<>.^*()%!/\\\\]";
        if (isNotNullOrEmpty(str)) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                str = str.replaceAll(regex, "-");
            }
        }
        return str;
    }

    public static List<String> splitAsList(String str, String seperator) {
        List<String> stringList = null;
        if (isNotNullOrEmpty(str)) {
            stringList = new ArrayList<>();
            String[] strArray = str.split(seperator);
            for (String spltStr : strArray) {
                stringList.add(spltStr.trim());
            }
        }
        return stringList;
    }

    public static boolean isStringEndsWith(String str, String endsWith) {
        boolean flag = false;
        if (isNotNullOrEmpty(str)
                && isNotNullOrEmpty(endsWith)) {
            flag = str.endsWith(endsWith);
        }
        return flag;
    }

    public static String getYesOrNoByBoolean(boolean isTrue) {
        if (isTrue) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static Integer getNumberOfOccurrenceInString(String value, char c) {
        int no = 0;
        if (isNotNullOrEmpty(value)) {
            for (int i = 0; i < value.length(); i++) {
                if (value.charAt(i) == c) {
                    no++;
                }
            }
        }
        return no;
    }
}