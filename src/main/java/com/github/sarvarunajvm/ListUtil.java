package com.github.sarvarunajvm;

import com.github.sarvarunajvm.helper.NaturalSortOrder;

import java.util.*;

public class ListUtil {

    private ListUtil() {
    }

    @SuppressWarnings("rawtypes")
    public static boolean isNullOrEmpty(List list) {
        boolean isNullOrEmpty = false;
        if (list == null || list.isEmpty()) {
            isNullOrEmpty = true;
        }
        return isNullOrEmpty;
    }

    @SuppressWarnings("rawtypes")
    public static boolean isNotNullOrEmpty(List list) {
        return !isNullOrEmpty(list);
    }

    public static List<String> getList(String value) {
        List<String> stringList = new ArrayList<>();
        if (StringUtil.isNotNullOrEmpty(value)) {
            stringList.add(value);
        }
        return stringList;
    }

    public static List<String> getUniqueValues(List<String> stringList) {
        Set<String> set = new LinkedHashSet<>();
        if (isNotNullOrEmpty(stringList)) {
            set.addAll(stringList);
        }
        return new ArrayList<>(set);
    }

    //Yet to test this method
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static List getUniqueList(List stringList) {
        Set set = new LinkedHashSet();
        set.addAll(stringList);
        return new ArrayList(set);
    }

    public static List<String> mergeTwoLists(List<String> list1, List<String> list2) {
        Set<String> set = new LinkedHashSet<>();
        if (ListUtil.isNotNullOrEmpty(list1)) {
            set.addAll(list1);
        }
        if (ListUtil.isNotNullOrEmpty(list2)) {
            set.addAll(list2);
        }
        return new ArrayList<>(set);
    }

    public static List<String> intersectTwoStringList(List<String> list1, List<String> list2) {
        List<String> intersectionList = new ArrayList<>();
        if (isNotNullOrEmpty(list1)
                && isNotNullOrEmpty(list2)) {
            for (String str1 : list1) {
                if (isPresentInList(list2, str1)) {
                    intersectionList.add(str1);
                }
            }
        }
        return intersectionList;
    }

    public static List<String> getDuplicateValue(List<String> list) {
        List<String> duplicateList = new ArrayList<>();
        final Set<String> set1 = new LinkedHashSet<>();
        for (String str : list) {
            if (!set1.add(str)) {
                duplicateList.add(str);
            }
        }
        return duplicateList;
    }

    public static List<String> searchStringListByName(List<String> list, String searchText) {
        List<String> filteredList = new ArrayList<>();
        if (isNotNullOrEmpty(list)
                && StringUtil.isNotNullOrEmpty(searchText)) {
            for (String text : list) {
                if (text.toLowerCase().contains(searchText.toLowerCase())) {
                    filteredList.add(text);
                }
            }
        }
        return filteredList;
    }

    public static boolean searchStringListByNameContains(List<String> list, String searchText) {
        boolean flag = false;
        if (isNotNullOrEmpty(list)
                && StringUtil.isNotNullOrEmpty(searchText)) {
            for (String text : list) {
                if (StringUtil.isEqual(text.toLowerCase(), searchText.toLowerCase())) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    public static boolean searchStringListByNameContainsWithoutIq(List<String> list, String searchText) {
        boolean flag = false;
        if (isNotNullOrEmpty(list)
                && StringUtil.isNotNullOrEmpty(searchText)
                && list.contains(searchText)) {
            flag = true;
        }
        return flag;
    }


    public static List<String> getDifferentBWTwoList(List<String> strList1, List<String> strList2) {
        List<String> differentList = null;

        differentList = new ArrayList<>();
        if (ListUtil.isNotNullOrEmpty(strList1)) {
            for (String strList : strList1) {
                if (!StringUtil.isStrContainsWithEqIgnoreCase(strList2, strList)) {
                    differentList.add(strList);
                }
            }
        }

        if (ListUtil.isNotNullOrEmpty(strList2)) {
            for (String strList : strList2) {
                if ((!StringUtil.isStrContainsWithEqIgnoreCase(strList1, strList) &&
                        !StringUtil.isStrContainsWithEqIgnoreCase(differentList, strList))) {
                    differentList.add(strList);
                }
            }
        }
        return differentList;
    }

    public static List<Double> reverseListDouble(List<Double> list) {
        List<Double> revList = null;
        if (ListUtil.isNotNullOrEmpty(list)) {
            revList = new ArrayList<>();
            int maxIndex = list.size() - 1;
            for (int i = maxIndex; i >= 0; i--) {
                revList.add(list.get(i));
            }
        }
        return revList;
    }

    public static List<Date> reverseListDates(List<Date> list) {
        List<Date> revList = null;
        if (ListUtil.isNotNullOrEmpty(list)) {
            revList = new ArrayList<>();
            int maxIndex = list.size() - 1;
            for (int i = maxIndex; i >= 0; i--) {
                revList.add(list.get(i));
            }
        }
        return revList;
    }

    public static List<String> sort(List<String> stringList) {
        Collections.sort(stringList);
        return stringList;
    }

    public static boolean isPresentInList(List<String> stringList, String value) {
        boolean isPresent = false;
        if (ListUtil.isNotNullOrEmpty(stringList)) {
            for (String type : stringList) {
                if (value != null && type.equalsIgnoreCase(value)) {
                    isPresent = true;
                    break;
                }
            }
        }
        return isPresent;
    }

    public static boolean isIntegerPresentInList(List<Integer> integerList, Integer value) {
        boolean isPresent = false;
        for (Integer type : integerList) {
            if (value != null && type.equals(value)) {
                isPresent = true;
                break;
            }
        }
        return isPresent;
    }

    public static boolean isEquals(List<String> list1, List<String> list2) {
        boolean isEqual = false;
        if (isNotNullOrEmpty(list1) &&
                isNotNullOrEmpty(list2)) {
            HashSet<String> hashSet1 = new HashSet<>();
            HashSet<String> hashSet2 = new HashSet<>();
            hashSet1.addAll(list1);
            hashSet2.addAll(list2);
            if (hashSet1.size() == hashSet2.size()) {
                HashSet<String> tempHashSet2 = new HashSet<>();
                tempHashSet2.addAll(hashSet1);
                tempHashSet2.addAll(hashSet2);
                if (tempHashSet2.size() == hashSet1.size()) {
                    isEqual = true;
                }
            }
        }
        return isEqual;
    }

    public static String getCommaAppendedString(List<String> stringList) {
        String commaSeparator = "";
        for (String commaSeparator1 : stringList) {
            commaSeparator = commaSeparator1 + ",";
        }
        return commaSeparator;
    }

    public static boolean isListContains(Object o, List<?> list) {
        boolean isObjectPresent = false;
        if (ListUtil.isNotNullOrEmpty(list)
                && o != null) {
            isObjectPresent = list.contains(o);
        }
        return isObjectPresent;
    }

    public static boolean containsNullOrEmpty(List<String> stringList) {
        boolean isContainNullOrEmptyValue = false;
        if ((stringList == null || !stringList.contains(null)) && !stringList.contains("")) {
            return isContainNullOrEmptyValue;
        }
        isContainNullOrEmptyValue = true;
        return isContainNullOrEmptyValue;
    }

    public static int getFrequencyValueCount(List<String> list, String containValue) {
        if (isNotNullOrEmpty(list)) {
            return Collections.frequency(list, containValue);
        } else {
            return 0;
        }
    }

    public static List<String> convertIntegerListToStringList(List<Integer> intLst) {
        List<String> strLst = null;
        if (isNotNullOrEmpty(intLst)) {
            strLst = new ArrayList<>();
            for (Integer intValue : intLst) {
                String strValue = NumberUtil.getString(intValue);
                if (StringUtil.isNotNullOrEmpty(strValue)) {
                    strLst.add(strValue);
                }
            }
        }
        return strLst;
    }

    public static boolean listOfStringsAreSameOrNot(List<String> list) {
        boolean isSame = false;
        if (getUniqueValues(list).size() != 1) {
            isSame = true;
        }
        return isSame;
    }

    @SuppressWarnings("unchecked")
    public static boolean isListOfStringSortedAndComparedForConsistency(List<String> list) {
        boolean isConsistent = true;
        if (isNotNullOrEmpty(list)) {
            List<String> sortedList = new ArrayList<>(list);
            Collections.sort(sortedList, new NaturalSortOrder());
            Iterator<String> iterated = list.iterator();
            for (Object obj : sortedList)
                if (!obj.equals(iterated.next())) {
                    isConsistent = false;
                    break;
                }
        }
        return isConsistent;
    }

    public static boolean isBomSorted(List<String> inputList) {
        int startCount = 1;
        int subCount = 1;
        boolean isValid = false;
        String previousInput = null;
        String previousSubInput = null;
        List<String> previousInputsList = new ArrayList<>();

        for (String input : inputList) {
            input = input.trim();
            isValid = true;
            if (previousInput == null) {
                if (input.equals(Integer.toString(startCount))) {
                    startCount++;
                    previousInput = input;
                } else {
                    isValid = false;
                }
                continue;
            }

            int lastIndexOfHyphen = previousInput.lastIndexOf("-");
            boolean previousInputEndsWithSuffix = previousInput.endsWith("C");
            boolean inputEndsWithSuffix = input.endsWith("C");

            if (input.startsWith(previousInput)
                    || (previousInputEndsWithSuffix
                    && input.startsWith(previousInput.substring(0, previousInput.length() - 1)))
            ) {
                boolean validateNextLevel = false;
                if (input.equals(previousInput)) {
                    validateNextLevel = true;
                } else if (input.equals(previousSubInput)) {
                    validateNextLevel = true;
                } else if (input.startsWith(previousSubInput + "-")) {
                    subCount = 1;
                }
                if (!validateNextLevel) {
                    if (previousInputEndsWithSuffix) {
                        String previousInputWithSuffix = previousInput.substring(0, previousInput.length() - 1);
                        if (input.equals(previousInputWithSuffix + "-" + subCount)
                                || input.equals(previousInputWithSuffix + "-" + subCount + "C")) {
                            previousSubInput = previousInputWithSuffix + "-" + subCount + "C";
                        }
                    } else if (input.equals(previousInput + "-" + subCount)
                            || input.equals(previousInput + "-" + subCount + "C")) {
                        previousSubInput = previousInput + "-" + subCount;
                        subCount++;
                    } else {
                        isValid = false;
                    }
                }
            } else {
                int previousInputSublistIndex = 0;
                if (lastIndexOfHyphen >= 0) {
                    if (previousInputEndsWithSuffix) {
                        String lastLevelString = previousInput.substring(lastIndexOfHyphen + 1, previousInput.length() - 1);
                        previousInputSublistIndex = lastLevelString.length() + 2;
                    } else {
                        String lastLevelString = previousInput.substring(lastIndexOfHyphen + 1);
                        previousInputSublistIndex = lastLevelString.length() + 1;
                    }
                }

                if (input.equals(previousInput.substring(0, previousInput.length() - previousInputSublistIndex) + "-" + subCount)
                        || input.equals(previousInput.substring(0, previousInput.length() - previousInputSublistIndex) + "-" + subCount + "C")) {
                    previousSubInput = previousInput.substring(0, previousInput.length() - previousInputSublistIndex) + "-" + subCount;
                    subCount++;
                } else {
                    if (input.equals(Integer.toString(startCount))
                            || input.equals(startCount + "C")) {
                        startCount++;
                    } else if (previousInputsList.contains(input)) {
                        int index = previousInputsList.indexOf(input);
                        previousInputsList = previousInputsList.subList(0, index);
                    } else {
                        int inputLastIndexOfHyphen = input.lastIndexOf("-");
                        String previousInputLastSubLevelString = "";
                        if (inputLastIndexOfHyphen >= 0) {
                            int inputLastSubLevel = 0;
                            String lastLevelString = null;
                            if (inputEndsWithSuffix) {
                                lastLevelString = input.substring(inputLastIndexOfHyphen + 1, input.length() - 1);
                            } else {
                                lastLevelString = input.substring(inputLastIndexOfHyphen + 1);
                            }
                            inputLastSubLevel = Integer.parseInt(lastLevelString) - 1;
                            previousInputLastSubLevelString = input.substring(0, inputLastIndexOfHyphen + 1) + inputLastSubLevel;

                            if (previousInputsList.contains(previousInputLastSubLevelString)) {
                                int index = previousInputsList.indexOf(previousInputLastSubLevelString);
                                previousInputsList = previousInputsList.subList(0, index);
                            } else if (previousInputsList.contains(previousInputLastSubLevelString + "C")) {
                                int index = previousInputsList.indexOf(previousInputLastSubLevelString + "C");
                                previousInputsList = previousInputsList.subList(0, index);
                            } else {
                                isValid = false;
                            }
                        } else {
                            isValid = false;
                        }
                    }
                    subCount = 1;
                }
            }
            if (inputEndsWithSuffix) {
                previousSubInput = previousSubInput + "C";
            }
            previousInput = input;
            previousInputsList.add(input);
            if (!isValid) {
                break;
            }
        }
        return isValid;
    }

}
