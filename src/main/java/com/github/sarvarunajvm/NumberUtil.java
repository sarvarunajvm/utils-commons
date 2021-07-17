package com.github.sarvarunajvm;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

public class NumberUtil {

    public static final String NUMBER_FORMAT_NO_DECIMAL = "0";
    public static final String NUMBER_FORMAT_ROUND_1000_NEGATIVE_RED = "#,##0,_);[Red]\\(#,##0,\\)";
    public static final String NUMBER_FORMAT_DATE_M_SLASH_D = "m/d";
    public static final String NUMBER_FORMAT_NEGATIVE_RED = "#,##0_);[Red]\\(#,##0\\)";
    public static final NumberFormat INT_10DIGIT = new DecimalFormat("0000000000");
    public static final NumberFormat INT_9DIGIT = new DecimalFormat("000000000");
    public static final NumberFormat INT_8DIGIT = new DecimalFormat("000000000");
    public static final NumberFormat INT_6DIGIT = new DecimalFormat("000000");
    public static final NumberFormat INT_5DIGIT = new DecimalFormat("00000");
    public static final NumberFormat INT_4DIGIT = new DecimalFormat("0000");
    //----Integer-----------------
    public static final NumberFormat INT_3DIGIT = new DecimalFormat("000");
    public static final NumberFormat INT_2DIGIT = new DecimalFormat("00");
    public static final DecimalFormat DECIMAL_2_ROUNDOFF = new DecimalFormat("#.##");
    public static final NumberFormat DECIMAL_2 = new DecimalFormat("#0.00");
    public static final NumberFormat DECIMAL_4 = new DecimalFormat("#0.0000");
    public static final NumberFormat DECIMAL_3 = new DecimalFormat("###.000");
    public static final DecimalFormat DECIMAL_5_ROUNDOFF = new DecimalFormat("#.#####");
    public static final NumberFormat DECIMAL_5 = new DecimalFormat("#0.00000");

    public static BigDecimal getBigDecimal(String value) {
        BigDecimal decimal = null;
        if (null != value && value.length() > 0) {
            decimal = new BigDecimal(value);
        }
        return decimal;
    }

    public static BigDecimal getBigDecimal(Integer value) {
        BigDecimal decimal = null;
        if (null != value) {
            decimal = new BigDecimal(value);
        }
        return decimal;
    }

    public static BigDecimal getBigDecimal(Double value) {
        BigDecimal decimal = null;
        if (value != null) {
            decimal = new BigDecimal(value);
        }
        return decimal;
    }

    public static BigDecimal getBigDecimal(double value) {
        BigDecimal decimal = new BigDecimal(value);
        return decimal;
    }

    public static BigDecimal getBigDecimalFormated4(Double dblVal) {
        String val = NumberUtil.getString(dblVal);
        return NumberUtil.getBigDecimal(val);
    }

    public static String getBigDecString(BigDecimal decimal) {
        return decimal.toString();
    }

    public static boolean checkInteger(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean checkIsDecimal(Double decimalVal) {
        boolean value = false;
        Double decimal = Math.ceil(decimalVal) - Math.floor(decimalVal);
        if (decimal != 0) {
            value = true;
        }
        return value;
    }

    public static String getString(Integer value) {
        String str = "";
        if (value != null) {
            str = Integer.toString(value);
        }
        return str;
    }

    //----------------------
    public static Double getDouble(String value) {
        Double d = null;
        if (StringUtil.isNotNullOrEmpty(value)) {
            value = StringUtil.replace(value, ",", "");
            d = new Double(value);
        }
        return d;
    }

    public static Double getDouble(Integer value) {
        Double d = null;
        if (value != null) {
            d = new Double(value);
        }
        return d;
    }

    public static Double getDouble(float value) {
        Double doubleValue = new Double(value);
        return doubleValue;
    }

    public static String getString(int value) {
        return String.valueOf(value);
    }

    public static double getdDouble(String value) {
        double d = 0;
        if (StringUtil.isNotNullOrEmpty(value)) {
            value = StringUtil.replace(value, ",", "");
            try {
                Double dbl = new Double(value);
                d = dbl.doubleValue();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return d;
    }

    public static double getdDoubleThrowEx(String value) throws NumberFormatException {
        double d = 0;
        if (StringUtil.isNotNullOrEmpty(value)) {
            value = StringUtil.replace(value, ",", "");
            Double dbl = new Double(value);
            d = dbl.doubleValue();
        }
        return d;
    }

    public static double getAbsoluteVal(double val) {
        return Math.abs((int) val);
    }

    public static Double getDouble(Double value) {
        double d = 0;
        if (value != null
                && !value.isNaN()) {
            d = value.doubleValue();
        }
        return d;
    }

    public static Double getDouble(BigDecimal value) {
        Double d = null;
        if (value != null) {
            d = value.doubleValue();
        }
        return d;
    }

    public static Double getDouble(long value) {
        Double d = (double) value;
        return d;
    }

    public static long getLong(String value) {
        long l = Long.parseLong(value);
        return l;
    }

    public static double getdDouble(BigDecimal value) {
        double d = 0;
        if (value != null) {
            d = value.doubleValue();
        }
        return d;
    }

    public static String getString(Double value) {
        String str = "";
        if (value != null) {
            str = value.toString();
        }
        return str;
    }

    public static String getString(BigDecimal value) {
        String str = "";
        if (value != null) {
            str = value.toString();
        }
        return str;
    }

    public static String getString(double value) {
        return Double.toString(value);
    }

    public static Integer getInteger(String str) {
        Integer value = null;
        if (StringUtil.isNotNullOrEmpty(str)) {
            value = Integer.valueOf(str);
        }
        return value;
    }

    public static Integer getInteger(Double doubleValue) {
        Integer intValue = null;
        if (doubleValue != null) {
            intValue = doubleValue.intValue();
        }
        return intValue;
    }

    public static Integer getInteger(BigDecimal doubleValue) {
        Integer intValue = null;
        if (doubleValue != null) {
            intValue = doubleValue.intValue();
        }
        return intValue;
    }

    public static int getInt(Long longValue) {
        int intValue = 0;
        if (longValue != null) {
            intValue = longValue.intValue();
        }
        return intValue;
    }

    public static int getInt(Integer integerVal) {
        int value = 0;
        if (integerVal != null) {
            value = integerVal.intValue();
        }
        return value;
    }

    public static int getInt(String str) {
        int value = 0;
        if (StringUtil.isNotNullOrEmpty(str) && !isNotNumber(str)) {
            value = Integer.valueOf(str);
        }
        return value;
    }

    public static int getInt(Double d) {
        if (d == null) {
            return 0;
        } else {
            return getInteger(d);
        }
    }

    public static int getInt(double d) {
        return (int) d;
    }

    public static boolean isNotNumber(String string) {
        char[] c = string.toCharArray();
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isDigit(c[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPostiveNumber(Integer int1, Integer int2) {
        boolean isPostiveNumber = false;
        Integer value = 0;
        if (int1 != null &&
                int2 != null) {
            value = int1 - int2;
        }
        if (value >= 0) {
            isPostiveNumber = true;
        }
        return isPostiveNumber;
    }

    public static boolean isValidDecimal(String string) {
        try {
            Double.parseDouble(string);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isEqualInteger(Integer int1, Integer int2) {
        boolean isEqual = false;
        if (int1 != null && int2 != null
                && int1.equals(int2)) {
            isEqual = true;
        }
        return isEqual;
    }

    public static boolean isEqualDouble(Double d1, Double d2) {
        boolean isEqual = false;
        if (d1 != null && d2 != null
                && d1.equals(d2)) {
            isEqual = true;
        }
        return isEqual;
    }

    public static boolean isZero(double d1) {
        boolean isZero = false;
        if (d1 == 0 || d1 == 0.0 || d1 == 0.00) {
            //if(Double.valueOf(d1).equals(Double.valueOf(0))){
            isZero = true;
        }
        return isZero;
    }

    public static int ceilToInt(double d) {
        return (int) Math.ceil(d);
    }

    public static int floorToInt(double d) {
        return (int) Math.floor(d);
    }

    public static int max(int num1, int num2) {
        return Math.max(num1, num2);
    }

    public static Double round(Double val) {
        if (val != null) {
            return getDouble(Math.round(val));
        } else {
            return null;
        }
    }

    public static int roundToInt(Double val) {
        if (val != null) {
            return getInt(Math.round(val));
        } else {
            return 0;
        }
    }

    public static int roundToNearestInt(Double val) {
        int val1 = val.intValue();
        int newValue;
        if (val == val1) {
            newValue = val1;
            return newValue;

        } else {
            val1++;
            newValue = val1;
            return newValue;
        }
    }

    public static String roundToIntString(Double val) {
        int intVal = roundToInt(val);
        return getString(intVal);
    }

    public static String formatDecimal(double val) {
        return DECIMAL_2_ROUNDOFF.format(val);
    }

    public static String formatDecimal(Double val, DecimalFormat decFormat) {
        if (val != null) {
            return decFormat.format(val);
        } else {
            return null;
        }
    }

    public static String getNextAlphabetCharacter(String alphabet) {
        int charValue = alphabet.charAt(0);
        String nextStr = String.valueOf((char) (charValue + 1));
        return nextStr;
    }

    public static String roundOffDecimalByFormat(double val, DecimalFormat format) {
        return format.format(val);
    }

    public static String formatNumByformat(double num, NumberFormat numFormat) {
        String dateStr = null;
        try {
            if (numFormat != null) {
                dateStr = numFormat.format(num);
            }
        } catch (Exception e) {
            return null;
        }
        return dateStr;
    }

    public static String formatNum(double num) {
        String dateStr = formatNumByformat(num, INT_5DIGIT);
        return dateStr;
    }

    public static double parseFormattedValue(String value, NumberFormat format) {
        try {
            return format.parse(value != null ? value : "0").doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static double parseFormattedValue(String value, DecimalFormat format) {
        try {
            return format.parse(value != null ? value : "0").doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static double doubleRoundTo2Decimal(double val) {
        return Math.round(val * 100.0) / 100.0;
    }

    public static String roundTo2DecimalIfHaveDecimal(double val) {
        DecimalFormat format = new DecimalFormat();
        format.setDecimalSeparatorAlwaysShown(false);
        return format.format(Math.round(val * 100.0) / 100.0);
    }

    public static String getDoubleValueGiveDecimalOnlyIfHaveDecimal(double val) {
        String valStr = "";
        NumberFormat formatter = new DecimalFormat("##.########");
        valStr = formatter.format(val);
        return valStr;
    }

    public static String getDoubleValueGiveDecimalOnlyIfHaveDecimalNoComma(double val) {
        String valStr = "";
        NumberFormat formatter = new DecimalFormat("##.########");
        formatter.setRoundingMode(RoundingMode.DOWN);
        valStr = formatter.format(val);
        return valStr;
    }

    public static String getDoubleValueGiveDecimalOnlyIfHaveDecimalNoComma2Decimal(double val) {
        String valStr = "";
        NumberFormat formatter = new DecimalFormat("##.##");
        formatter.setRoundingMode(RoundingMode.DOWN);
        valStr = formatter.format(val);
        return valStr;
    }

    public static double convertNegDoubleToPositive(Double value) {
        double d = Math.abs(value);
        return d;
    }

    public static double parseIndianCurrency(String value) {
        double currencyIndian = 0;
        if (StringUtil.isNotNullOrEmpty(value)) {
            try {
                currencyIndian = new DecimalFormat("##,##,##,##,###.00").parse(value != null ? value : "0").doubleValue();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return currencyIndian;
    }

    public static String getIndianCurrencyFormat(double value) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        String moneyString = formatter.format(value);
        moneyString = moneyString.replace("Rs.", "");
        moneyString = moneyString.replace("鈧� ", "");
        return moneyString;
    }

    public static String roundMax8Digits(Double value) {
        NumberFormat df = DecimalFormat.getInstance();
        df.setMinimumFractionDigits(0);
        df.setMaximumFractionDigits(8);
        df.setRoundingMode(RoundingMode.DOWN);
        String valueStr = "";
        if (value != null) {
            valueStr = df.format(value);
        }
        return valueStr;
    }

    public static String roundMax10Digits(Double value) {
        NumberFormat df = DecimalFormat.getInstance();
        df.setMinimumFractionDigits(0);
        df.setMaximumFractionDigits(10);
        df.setRoundingMode(RoundingMode.DOWN);
        String valueStr = "";
        if (value != null) {
            valueStr = df.format(value);
        }
        return valueStr;
    }

    public static List<Integer> getUniqueValues(List<Integer> integerList) {
        Set<Integer> set = new LinkedHashSet<>();
        set.addAll(integerList);
        return new ArrayList<>(set);
    }

    public static Integer getMaxInteger(List<Integer> integerList) {
        Integer selInt = null;
        if (ListUtil.isNotNullOrEmpty(integerList)) {
            for (Integer integer : integerList) {
                if (selInt == null) {
                    selInt = integer;
                } else if (selInt != null && selInt < integer) {
                    selInt = integer;
                }
            }
        }
        return selInt;
    }

    public static float[] convertStringArrayTofloatArray(String[] strArray) {
        float[] floatArray = new float[0];
        if (strArray.length > 0) {
            floatArray = new float[strArray.length];
            int index = 0;
            for (String val : strArray) {
                if (StringUtil.isNotNullOrEmpty(val)) {
                    floatArray[index] = NumberUtil.getInt(val);
                }
                index++;
            }
        }
        return floatArray;
    }

    public static Double addDouble(Double a, Double b) {
        Double c = null;
        if (a != null || b != null) {
            c = getDouble(a) + getDouble(b);
        }
        return c;
    }

    public static String getQtyTypeFormat(Double val) {
        DecimalFormat df = new DecimalFormat("###");
        return (df.format(val));
    }

    public static String getDoubleQtyTypeFormat(Double val) {
        DecimalFormat df = new DecimalFormat("###.##");
        return (df.format(val));
    }

    public static boolean isNumberEven(int number) {
        boolean isEven = false;
        if (number % 2 == 0) {
            isEven = true;
        }
        return isEven;
    }

    public static boolean getBoolean(int integer) {
        return integer == 1;
    }

    public static int getBooleanInt(boolean booleanValue) {
        if (booleanValue) {
            return 1;
        } else {
            return 0;
        }
    }

    public static NumberFormat getIntegerFormat(Integer numberFormat, int length) {
        NumberFormat intDigit = null;
        if (length == 10) {
            intDigit = new DecimalFormat("0000000000");
        } else if (length == 9) {
            intDigit = new DecimalFormat("000000000");
        } else if (length == 8) {
            intDigit = new DecimalFormat("00000000");
        } else if (length == 7) {
            intDigit = new DecimalFormat("0000000");
        } else if (length == 6) {
            intDigit = new DecimalFormat("000000");
        } else if (length == 5) {
            intDigit = new DecimalFormat("00000");
        } else if (length == 4) {
            intDigit = new DecimalFormat("0000");
        } else if (length == 3) {
            intDigit = new DecimalFormat("000");
        } else if (length == 2) {
            intDigit = new DecimalFormat("00");
        } else if (length == 1) {
            intDigit = new DecimalFormat("0");
        }
        return intDigit;
    }

    public static String convertExponentialDoubleToString(double number) {
        return BigDecimal.valueOf(number).toPlainString();
    }


    public static String convertExponentialDoubleToOneString(double number) {
        String numberAsString = String.format("%.2f", number);
        return numberAsString;
    }

    public static String integerToRomanNumeral(int input) {
        if (input < 1 || input > 3999)
            return "Invalid Roman Number Value";
        String s = "";
        while (input >= 1000) {
            s += "M";
            input -= 1000;
        }
        while (input >= 900) {
            s += "CM";
            input -= 900;
        }
        while (input >= 500) {
            s += "D";
            input -= 500;
        }
        while (input >= 400) {
            s += "CD";
            input -= 400;
        }
        while (input >= 100) {
            s += "C";
            input -= 100;
        }
        while (input >= 90) {
            s += "XC";
            input -= 90;
        }
        while (input >= 50) {
            s += "L";
            input -= 50;
        }
        while (input >= 40) {
            s += "XL";
            input -= 40;
        }
        while (input >= 10) {
            s += "X";
            input -= 10;
        }
        while (input >= 9) {
            s += "IX";
            input -= 9;
        }
        while (input >= 5) {
            s += "V";
            input -= 5;
        }
        while (input >= 4) {
            s += "IV";
            input -= 4;
        }
        while (input >= 1) {
            s += "I";
            input -= 1;
        }
        return s;
    }


    public static List<String> getMonthsInYearInMMMformat() {
        List<String> monthsInYear = new ArrayList<String>();
        monthsInYear.add("Jan");
        monthsInYear.add("Feb");
        monthsInYear.add("Mar");
        monthsInYear.add("Apr");
        monthsInYear.add("May");
        monthsInYear.add("Jun");
        monthsInYear.add("Jul");
        monthsInYear.add("Aug");
        monthsInYear.add("Sep");
        monthsInYear.add("Oct");
        monthsInYear.add("Nov");
        monthsInYear.add("Dec");
        return monthsInYear;
    }

    public static Double roundToNextDouble(Double val) {
        if (val != null) {
            float f = getFloat(val);
            return Math.ceil(f);
        } else {
            return null;
        }
    }

    public static Float getFloat(Double value) {
        float f = 0;
        if (value != null) {
            f = value.floatValue();
        }
        return f;
    }

    public static boolean isNumberWith2Decimals(String string) {
        return string.matches("^\\d+\\.\\d{2}$");
    }

    public static String getRateWithPrecisionAsString(int n, double val) {
        String numberPresicion = "";
        DecimalFormat decimalFormat;
        if (StringUtil.isNotNullOrEmpty(getString(n))) {
            for (int j = 0; j < n; j++) {
                numberPresicion = "0" + numberPresicion;
            }
            decimalFormat = new DecimalFormat("#0." + numberPresicion);
        } else {
            numberPresicion = "00";
            decimalFormat = new DecimalFormat("#0." + numberPresicion);
        }
        return decimalFormat.format(val);
    }

    public static Double convertToDecimal(String str) {
        Double decimal = null;
        if (StringUtil.isNotNullOrEmpty(str)) {
            int slashIndex = str.indexOf("/");
            double dividend = getdDouble(str.substring(0, slashIndex));
            double divisor = getdDouble(str.substring(slashIndex + 1));
            decimal = dividend / divisor;
        }
        return decimal;
    }

    public static boolean isNumberPositive(Double value) {
        boolean isPostiveNumber = false;
        if (value >= 0) {
            isPostiveNumber = true;
        }
        return isPostiveNumber;
    }

    public static boolean isNumberNegative(Double value) {
        boolean isNegativeNumber = false;
        if (value < 0) {
            isNegativeNumber = true;
        }
        return isNegativeNumber;
    }

    public static boolean isValueBetweenRange(Double value, Double from, Double to) {
        boolean isValueBetweenRange = false;
        if (value >= from && value <= to) {
            isValueBetweenRange = true;
        }
        return isValueBetweenRange;
    }

    public static Double changeToNegativeValue(Double val) {
        if (val != null
                && val != 0.0) {
            int x = -1;
            return val * x;
        } else {
            return val;
        }
    }

    public static List<Double> convertStringListToDoubleList(List<String> strList) {
        List<Double> dobleList = null;
        if (ListUtil.isNotNullOrEmpty(strList)) {
            dobleList = new ArrayList<Double>();
            for (String s : strList) {
                if (s.matches("[0-9]+")) {
                    dobleList.add(Double.valueOf(s));
                }
            }
        }
        return dobleList;
    }

    public static Integer[] getPreviousAndNextMultiple(double number, double lowestValue, double multiple) {

        Integer[] previousAndNextMultiple = new Integer[2];
        double divideValue = number / multiple;
        if (number < lowestValue) {
            previousAndNextMultiple[0] = 0;
            previousAndNextMultiple[1] = (int) lowestValue;
        } else if (divideValue < 1) {
            previousAndNextMultiple[0] = (int) lowestValue;
            previousAndNextMultiple[1] = (int) multiple;
        } else {
            double calcLowestValue = multiple * Math.floor(divideValue);
            double calcMultiple = multiple * Math.floor(divideValue + 1);

            previousAndNextMultiple[0] = (int) calcLowestValue;
            previousAndNextMultiple[1] = (int) calcMultiple;
        }
        return previousAndNextMultiple;
    }

    public static boolean isValidDecimalAfterRemovedIndianCurrencyFormat(String value) {
        boolean isValidDecimal = false;
        if (StringUtil.isNotNullOrEmpty(value)) {
            value = value.trim();
            value = StringUtil.replace(value, " ", "");
            value = StringUtil.replace(value, ",", "");
            try {
                Double.parseDouble(value);
                isValidDecimal = true;
            } catch (NumberFormatException e) {
                isValidDecimal = false;
            }
        }
        return isValidDecimal;
    }

    public static boolean isValidNumber(String value) {
        boolean isValid = false;
        if (StringUtil.isNotNullOrEmpty(value)) {
            try {
                Double.parseDouble(value);
                isValid = true;
            } catch (NumberFormatException e) {
                isValid = false;
            }
        }
        return isValid;

    }

    public static <T> double sumOfListValues(Iterable<? extends T> list) {
        double result = 0;
        if (list != null) {
            for (T number : list) {
                if (number != null) {
                    result += (getBigDecimal(number.toString())).doubleValue();
                }
            }
        }
        return result;
    }

    public static Double getQuotientValueByString(String dividendAndDivisor, String separator) {
        Double quotient = null;
        try {
            if (StringUtil.isNotNullOrEmpty(dividendAndDivisor)) {
                String[] strArray = dividendAndDivisor.split(StringUtil.isNotNullOrEmpty(separator) ? separator : "/");
                if (strArray.length != 2) {
                    strArray = dividendAndDivisor.split("/");
                }
                if (strArray.length == 2) {
                    Double dividend = getDouble(strArray[0]);
                    Double divisor = getDouble(strArray[1]);
                    if (dividend != null && divisor != null) {
                        quotient = dividend / divisor;
                    }
                }
            }
        } catch (ArithmeticException e) {
            System.out.println("Math error " + e.getMessage());
        }
        return quotient;
    }

    public static Double getRemainderValueByString(String dividendAndDivisor, String separator) {
        Double quotient = null;
        try {
            if (StringUtil.isNotNullOrEmpty(dividendAndDivisor)) {
                String[] strArray = dividendAndDivisor.split(StringUtil.isNotNullOrEmpty(separator) ? separator : "%");
                if (strArray.length != 2) {
                    strArray = dividendAndDivisor.split("%");
                }
                if (strArray.length == 2) {
                    Double dividend = getDouble(strArray[0]);
                    Double divisor = getDouble(strArray[1]);
                    if (dividend != null && divisor != null) {
                        quotient = dividend / divisor;
                    }
                }
            }
        } catch (ArithmeticException e) {
            System.out.println("Math error " + e.getMessage());
        }
        return quotient;
    }

    public static double getPercentageValue(double earnd, double total) {
        double percentage = 0;
        if (earnd > 0 && total > 0) {
            percentage = ((earnd / total) * 100);
        }
        return percentage;
    }
}