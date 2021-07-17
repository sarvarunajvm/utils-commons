package com.github.sarvarunajvm;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DateUtil {

    public static final String PERIOD_TYPE_DAILY = "Daily";
    public static final String PERIOD_TYPE_WEEKLY = "Weekly";
    public static final String PERIOD_TYPE_MONTHLY = "Monthly";
    public static final String PERIOD_TYPE_YEARLY = "Yearly";
    public static final String PERIOD_TYPE_DAILY_DB_ID = "PERIOD_TYPE_DAILY";
    public static final String PERIOD_TYPE_MONTHLY_DB_ID = "PERIOD_TYPE_MONTHLY";
    public static final String PERIOD_TYPE_YEARLY_DB_ID = "PERIOD_TYPE_YEARLY";
    public static final String PERIOD_TYPE_WEEKLY_DB_ID = "PERIOD_TYPE_WEEKLY";
    private static ThreadLocal<DateUtil> instance = new ThreadLocal<DateUtil>() {
        @Override
        protected DateUtil initialValue() {
            return new DateUtil();
        }
    };
    private static ThreadLocal<Calendar> calendarInstance = new ThreadLocal<Calendar>() {
        @Override
        protected Calendar initialValue() {
            return Calendar.getInstance();
        }
    };
    public final String YYYY_MM_DD = "yyyy/MM/dd";
    public final String DD_MMM_YYYY_HH_MM_SS = "dd-MMM-yyyyHHmmss";
    public final String DDMMYYYY = "dd/MM/yyyy";
    public final String MMDDYYYY = "MM/dd/yyyy";
    public final String MMDD = "MMdd";
    public final String MMDD_SLACE = "MM/dd";
    public final String DD_MMM_YYYY_SPACE_HHMMSS = "dd-MMM-yyyy HHmmss";
    public final String DD_MMM_YYYY_SPACE_HHMM_COLON = "dd-MMM-yyyy HH:mm";
    public final String DD_MMM_YY_SPACE_HHMM_COLON = "dd-MMM-yy HH:mm";
    public final String YYMMDDHHMMSS = "yyMMddHHmmss";
    public final String YY_MM_DD_HH_MM_SS = "dd-MM-yyyy-HHmmss";
    public final String YYYYMMDD = "yyyyMMdd";
    public final String YYYY = "yyyy";
    public final String YY = "yy";
    public final String MMM = "MMM";
    public final String SQL = "yyyy-MM-dd";
    public final String DD_MMM_YY = "dd-MMM-yy";
    public final String DD_MMM = "dd-MMM";
    public final String DD__MMM_HH_MM = "dd-MMM HH:mm";
    public final String DDMMM_HH_MM = "ddMMM HH:mm";
    public final String DDMMMYY_HH_MM = "ddMMMyy HH:mm";
    public final String DDMMMYY = "dd-MMM-yy";
    public final String DDMMMYY_WITHOUT_HYPON = "ddMMMyy";
    public final String DD__MMM = "dd MMM";
    public final String MMM__DD = "MMM dd";
    public final String MMM_YY = "MMM yy";
    public final String MMM__YY = "MMM yy";
    public final String MMMYYYY = "MMMyyyy";
    public final String MMMYY = "MMMyy";
    public final String MMMM = "MMMM";
    public final String MMMM__YY = "MMMM-yy";
    public final String MMMM__YYYY = "MMMM-yyyy";
    public final String MM_YYYY = "MM-yyyy";
    public final String MM_YY = "MM-yy";
    public final String MM_DD_YYYY = "MM/dd/yyyy";
    public final String DD_MMM_YYYY = "dd-MMM-yyyy";
    public final String DDMMMYYYY = "ddMMMyyyy";
    public final String DD_MM_YYYY = "dd-MM-yyyy";
    public final String SQL_WITH_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public final String HH_MM_SS = "HH:mm:ss";
    public final String HH_MM = "HH:mm";
    public final String MMM_DD_YYYY_HH_MM_SS = "MMM-dd-yyyy-HHmmss";
    public final String DD_MMM_YYYY_HH_MM_SS_WITHCOLON = "dd-MMM-yyyy HH:mm:ss";
    public final String DD_MMM_YYYY_HH_MM_AMPM_WITHCOLON = "dd-MMM-yyyy:hh:mm:a";
    public final String DD_MMM_YYYY_SPACE_HH_MM_A_WITHCOLON = "dd-MMM-yyyy hh:mm:a";
    public final String YY_MM_DD = "yy-MM-dd";
    public final String DDMMM_WITHOUTHIPHEN = "ddMMM";
    public final String YYMMDD = "yyMMdd";
    public final String MM = "MM";
    public final String DD = "dd";
    public final String DD_MM_YY = "dd-MM-yy";
    public final String DD_MMM_HH_MM_SS = "dd-MMM HH:mm:ss";
    public final String DDMMM_YY = "ddMMM-yy";
    public final String DDMMM_YY_HH_MM_SS_AMPM = "ddMMM-yy hh:mm:ss a";
    public final String DD_MMM_YY_HH_MM_AMPM = "dd-MMM-yy hh:mm  a";
    public final String DDMMMYY_HH_MM_AMPM = "ddMMMyy hh:mm  a";
    public final String HH_MM_SS_AMPM = "hh:mm:ss a";
    public final String HH_MM_AMPM = "hh:mm a";
    public final String HH = "HH";
    public final String hh = "hh";
    public final String mm = "mm";
    public final String ss = "ss";
    public final String AM_PM_A = "a";
    public final String DDMMM_YY_HH_MM_AMPM = "ddMMM-yy hh:mm: a";
    public final String HH_MM_AMPM_BYCOLON = "hh:mm:a";
    public final String HHMMSS = "HHmmss";
    public final String EEE = "EEE";
    public final String EEEE = "EEEE";
    public final String EE_DATE_3LETTER = "EE";
    public final String MM_SLASH_YY = "MM/yy";
    public final String DATEFORMAT_DD_MMM_YYYY_HH_MM_AP_WITHCOLON = "dd-MMM-yyyy:hh:mm:a";
    public final String DD_MMM_HH_MM_SS_WITHCOLON = "dd:MMM:HH:mm:ss";
    public final String DD_MMM_YYYY_HH_MM_AM_PM = "dd-MMM-yyyy hh:mm a";
    public final String DATEFORMAT_DD_MMM_YYYY_HH_MM_AP = "dd-MMM-yyyy HH:mm a";
    public final String DD_MMM_Y_HH_MM_SS = "dd MMM yyyy HH:mm:ss";
    public final String DD_MM_YYYY_HH_MM_WITH_COLON = "dd-MM-yyyy HH:mm";
    public final String YYYY_MM_DD_HH_MM_WITH_COLON = "yyyy-MM-dd HH:mm";
    public final String YYYY_MM_DD_HH_MM_SS_WITH_COLON = "yyyy-MM-dd hh:mm:ss";
    public final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public final DateFormat DATEFORMAT_YYYYMMDDHHMMSS = new SimpleDateFormat(YYYYMMDDHHMMSS);
    public final String DD_MM_YY_SPACE_HH_COLON_MM_SPACE_SS_SPACE_SS = "yyyy-MM-dd hh:mm:ss a";
    public final String DD_MM_YY_SPACE_HH_COLON_MM_SPACE_SS_SPACE = "MM/dd/yy hh:mm:ss a";
    public final DateFormat DATEFORMAT_DD_MMM_YYYY_HH_MM_AM_PM = new SimpleDateFormat(DD_MMM_YYYY_HH_MM_AM_PM);
    public final DateFormat DATEFORMAT_DD_MMM_YYYY_HH_MM_SS = new SimpleDateFormat(DD_MMM_YYYY_HH_MM_SS);
    public final DateFormat DATEFORMAT_DDMMYYYY = new SimpleDateFormat(DDMMYYYY);
    public final DateFormat DATEFORMAT_DDMMYYYY_WITH_DOT = new SimpleDateFormat("dd.MM.yyyy");
    public final DateFormat DATEFORMAT_DDMMMYY_WITHOUT_HYPON = new SimpleDateFormat(DDMMMYY_WITHOUT_HYPON);
    public final DateFormat DATEFORMAT_DD_MMM_YYYY_SPACE_HHMMSS = new SimpleDateFormat(DD_MMM_YYYY_SPACE_HHMMSS);
    public final DateFormat DATEFORMAT_DD_MMM_YYYY_SPACE_HHMM_COLON = new SimpleDateFormat(DD_MMM_YYYY_SPACE_HHMM_COLON);
    public final DateFormat DATEFORMAT_YYMMDDHHMMSS = new SimpleDateFormat(YYMMDDHHMMSS);
    public final DateFormat DATEFORMAT_YY_MM_DD_HH_MM_SS = new SimpleDateFormat(YY_MM_DD_HH_MM_SS);
    public final DateFormat DATEFORMAT_YYYYMMDD = new SimpleDateFormat(YYYYMMDD);
    public final DateFormat DATEFORMAT_YYYY = new SimpleDateFormat(YYYY);
    public final DateFormat DATEFORMAT_YY = new SimpleDateFormat(YY);
    public final DateFormat DATEFORMAT_MM = new SimpleDateFormat(MM);
    public final DateFormat DATEFORMAT_DD = new SimpleDateFormat(DD);
    public final DateFormat DATEFORMAT_DD_MMM_HH_MM_SS_COLON = new SimpleDateFormat(DD_MMM_HH_MM_SS_WITHCOLON);
    public final DateFormat DATEFORMAT_MMM = new SimpleDateFormat(MMM);
    public final DateFormat DATEFORMAT_SQL = new SimpleDateFormat(SQL);
    public final DateFormat DATEFORMAT_DD_MMM = new SimpleDateFormat(DD_MMM);
    public final DateFormat DATEFORMAT_DDMMM = new SimpleDateFormat(DDMMM_WITHOUTHIPHEN);
    public final DateFormat DATEFORMAT_DDMMMYY = new SimpleDateFormat(DDMMMYY);
    public final DateFormat DATEFORMAT_MMM_YY = new SimpleDateFormat(MMM_YY);
    public final DateFormat DATEFORMAT_MMM__YY = new SimpleDateFormat(MMM__YY);
    public final DateFormat DATEFORMAT_MMM__DD = new SimpleDateFormat(MMM__DD);
    public final DateFormat DATEFORMAT_DD__MMM = new SimpleDateFormat(DD__MMM);
    public final DateFormat DATEFORMAT_MMMYY = new SimpleDateFormat(MMMYY);
    public final DateFormat DATEFORMAT_MMMYYYY = new SimpleDateFormat(MMMYYYY);
    public final DateFormat DATEFORMAT_DD_MMM_YYYY = new SimpleDateFormat(DD_MMM_YYYY);
    public final DateFormat DATEFORMAT_DDMMMYYYY = new SimpleDateFormat(DDMMMYYYY);
    public final DateFormat DATEFORMAT_MM_DD_YYYY = new SimpleDateFormat(MM_DD_YYYY);
    public final DateFormat DATEFORMAT_MMDD_SLACE = new SimpleDateFormat(MMDD_SLACE);
    public final DateFormat DATEFORMAT_EE_DATE_3LETTER = new SimpleDateFormat(EE_DATE_3LETTER);
    public final DateFormat DATEFORMAT_DD_MM_YYYY = new SimpleDateFormat(DD_MM_YYYY);
    public final DateFormat DATEFORMAT_SQL_WITH_HH_MM_SS = new SimpleDateFormat(SQL_WITH_HH_MM_SS);
    public final DateFormat DATEFORMAT_HH_MM_SS = new SimpleDateFormat(HH_MM_SS);
    public final DateFormat DATEFORMAT_MMM_DD_YYYY_HH_MM_SS = new SimpleDateFormat(MMM_DD_YYYY_HH_MM_SS);
    public final DateFormat DATEFORMAT_DD_MMM_YYYY_HH_MM_SS_WITHCOLON = new SimpleDateFormat(DD_MMM_YYYY_HH_MM_SS_WITHCOLON);
    public final DateFormat DD_MMM_HH_MM = new SimpleDateFormat(DD__MMM_HH_MM);
    public final DateFormat DATEFORMAT_DDMMM_HH_MM = new SimpleDateFormat(DDMMM_HH_MM);
    public final DateFormat DATEFORMAT_DDMMMYY_HH_MM = new SimpleDateFormat(DDMMMYY_HH_MM);
    public final DateFormat DATEFORMAT_DD_MMM_YYYY_HH_MM_A_WITHCOLON = new SimpleDateFormat(DATEFORMAT_DD_MMM_YYYY_HH_MM_AP_WITHCOLON);
    public final DateFormat DATEFORMAT_DD_MMM_YYYY_HH_MM_AMPM_WITHCOLON = new SimpleDateFormat(DD_MMM_YYYY_HH_MM_AMPM_WITHCOLON);
    public final DateFormat DATEFORMAT_DD_MMM_YYYY_SPACE_HH_MM_A_WITHCOLON = new SimpleDateFormat(DD_MMM_YYYY_SPACE_HH_MM_A_WITHCOLON);
    public final DateFormat DD_MMM_YYYY_HH_MM_AMPM = new SimpleDateFormat(DATEFORMAT_DD_MMM_YYYY_HH_MM_AP);
    public final DateFormat DATEFORMAT_YY_MM_DD = new SimpleDateFormat(YY_MM_DD);
    public final DateFormat DATEFORMAT_YYMMDD = new SimpleDateFormat(YYMMDD);
    public final DateFormat DATEFORMAT_MMM_YYYY = new SimpleDateFormat("MMM-yyyy");
    public final DateFormat DATEFORMAT_MM_YYYY = new SimpleDateFormat(MM_YYYY);
    public final DateFormat DATEFORMAT_DDMMM_WITHOUTHIPHEN = new SimpleDateFormat(DDMMM_WITHOUTHIPHEN);
    public final DateFormat DATEFORMAT_MMMM = new SimpleDateFormat(MMMM);
    public final DateFormat DATEFORMAT_MMMM__YY = new SimpleDateFormat(MMMM__YY);
    public final DateFormat DATEFORMAT_MMMM__YYYY = new SimpleDateFormat(MMMM__YYYY);
    public final DateFormat DATEFORMAT_DD_MM_YY = new SimpleDateFormat(DD_MM_YY);
    public final DateFormat DATEFORMAT_DD_MMM_HH_MM_SS = new SimpleDateFormat(DD_MMM_HH_MM_SS);
    public final DateFormat DATEFORMAT_DDMMM_YY_HH_MM_AMPM = new SimpleDateFormat(DDMMM_YY_HH_MM_AMPM);
    public final DateFormat DATEFORMAT_HH_MM_AMPM_BYCOLON = new SimpleDateFormat(HH_MM_AMPM_BYCOLON);
    public final DateFormat DATEFORMAT_DDMMM_YY = new SimpleDateFormat(DDMMM_YY);
    public final DateFormat DATEFORMAT_DDMMM_YY_HH_MM_SS_AMPM = new SimpleDateFormat(DDMMM_YY_HH_MM_SS_AMPM);
    public final DateFormat DATEFORMAT_DD_MMM_YY_HH_MM_AMPM = new SimpleDateFormat(DD_MMM_YY_HH_MM_AMPM);
    public final DateFormat DATEFORMAT_DDMMMYY_HH_MM_AMPM = new SimpleDateFormat(DDMMMYY_HH_MM_AMPM);
    public final DateFormat DATEFORMAT_HH_MM_SS_AMPM = new SimpleDateFormat(HH_MM_SS_AMPM);
    public final DateFormat DATEFORMAT_HH_MM_AMPM = new SimpleDateFormat(HH_MM_AMPM);
    public final DateFormat DATEFORMAT_DD_MMM_YY = new SimpleDateFormat(DD_MMM_YY);
    public final DateFormat DATEFORMAT_HH_MM = new SimpleDateFormat(HH_MM);
    public final DateFormat DATEFORMAT_YYYY_MM_DD = new SimpleDateFormat(YYYY_MM_DD);
    public final DateFormat DATEFORMAT_HH = new SimpleDateFormat(HH);
    public final DateFormat DATEFORMAT_hh = new SimpleDateFormat(hh);
    public final DateFormat DATEFORMAT_mm = new SimpleDateFormat(mm);
    public final DateFormat DATEFORMAT_ss = new SimpleDateFormat(ss);
    public final DateFormat DATEFORMAT_AM_PM_A = new SimpleDateFormat(AM_PM_A);
    public final DateFormat DATEFORMAT_HHMMSS = new SimpleDateFormat(HHMMSS);
    public final DateFormat DATEFORMAT_EEE = new SimpleDateFormat(EEE);
    public final DateFormat DATEFORMAT_DAYSHORT = DATEFORMAT_EEE;
    public final DateFormat DATEFORMAT_EEEE = new SimpleDateFormat(EEEE);
    public final DateFormat DATEFORMAT_DAYFULL = DATEFORMAT_EEEE;
    public final DateFormat DD_MMM_YYYY_HH_MM_AP = new SimpleDateFormat(DD_MMM_YYYY_HH_MM_AM_PM);
    public final DateFormat DD_MM_YY_SPACE_HH_COLON_MM_SPACE_SS = new SimpleDateFormat(DD_MM_YY_SPACE_HH_COLON_MM_SPACE_SS_SPACE_SS);
    public final DateFormat DATEFORMAT_DD_MMM_YYYY_HH_MM_SS_WITHCOLON1 = new SimpleDateFormat(DD_MMM_YYYY_HH_MM_SS_WITHCOLON);
    public final DateFormat DATEFORMAT_MMDDYYYY = new SimpleDateFormat(MMDDYYYY);
    public final DateFormat DATEFORMAT_MMDD = new SimpleDateFormat(MMDD);
    public final DateFormat DATEFORMAT_DD_MM_YYYY_HH_MM_WITH_COLON = new SimpleDateFormat(DD_MM_YYYY_HH_MM_WITH_COLON);
    public final DateFormat DATEFORMAT_YYYY_MM_DD_HH_MM_WITH_COLON = new SimpleDateFormat(YYYY_MM_DD_HH_MM_WITH_COLON);
    public final DateFormat DATEFORMAT_YYYY_MM_DD_HH_MM_SS_WITH_COLON = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS_WITH_COLON);
    public int DAY_OF_WEEK_SUNDAY = Calendar.SUNDAY;
    public int DAY_OF_WEEK_MONDAY = Calendar.MONDAY;
    public int DAY_OF_WEEK_TUESDAY = Calendar.TUESDAY;
    public int DAY_OF_WEEK_WEDNESDAY = Calendar.WEDNESDAY;
    public int DAY_OF_WEEK_THURSDAY = Calendar.THURSDAY;
    public int DAY_OF_WEEK_FRIDAY = Calendar.FRIDAY;
    public int DAY_OF_WEEK_SATURDAY = Calendar.SATURDAY;
    public int SQL_DAY_OF_WEEK_SUNDAY = 0;
    public int SQL_DAY_OF_WEEK_MONDAY = 1;
    public int SQL_DAY_OF_WEEK_TUESDAY = 2;
    public int SQL_DAY_OF_WEEK_WEDNESDAY = 3;
    public int SQL_DAY_OF_WEEK_THURSDAY = 4;
    public int SQL_DAY_OF_WEEK_FRIDAY = 5;
    public int SQL_DAY_OF_WEEK_SATURDAY = 6;

    public static DateUtil getInstance() {
        return instance.get();
    }

    private Calendar getCalendarInstance() {
        return Calendar.getInstance();
    }

    public Calendar getCalendar(Date date) {
        Calendar cal = getCalendarInstance();
        cal.setTime(date);
        return cal;
    }

    public Date parseString(String dateString) {
        Date date = null;
        DateFormat formatter = null;
        if (StringUtil.isNotNullOrEmpty(dateString)) {
            try {
                formatter = new SimpleDateFormat(DD_MMM_YYYY);
                date = (Date) formatter.parse(dateString);
            } catch (ParseException e) {
                System.out.println("Exception :" + e);
            }
            clearVariables(formatter);
        }
        return date;
    }

    public Object clearVariables(Object object) {
        if (object != null) {
            object = null;
        }
        return object;
    }

    public LocalDate parseString(String dateString, String format) {
        LocalDate date = null;
        DateTimeFormatter formatter = null;
        if (StringUtil.isNotNullOrEmpty(dateString)
                && StringUtil.isNotNullOrEmpty(format)) {
            formatter = DateTimeFormatter.ofPattern(format);
            date = LocalDate.parse(dateString, formatter);
            clearVariables(formatter);
        }
        return date;
    }

    public Date parseString(String dateString, DateFormat format) {
        Date date = null;
        if (StringUtil.isNotNullOrEmpty(dateString) && format != null) {
            try {
                date = (Date) format.parse(dateString);
            } catch (ParseException e) {
                System.out.println("ParseException :" + e);
            } catch (Exception e) {
                System.out.println("Exception :" + e);
            }
        }
        return date;
    }

    public boolean isValidDateString(String dateString, DateFormat format) {
        boolean isvalid = false;
        if (StringUtil.isNotNullOrEmpty(dateString) && format != null) {
            try {
                //Date date = (Date) format.parse(dateString);
                format.parse(dateString);
                isvalid = true;
            } catch (Exception e) {
                isvalid = false;
            }
        }
        return isvalid;
    }

    public String parseDate(Date date) {
        String date2 = "";
        if (date != null) {
            DateFormat formatter;
            formatter = new SimpleDateFormat("dd-MMM-yy");
            date2 = (String) formatter.format(date);
        }
        return date2;
    }

    public String NewparseDate(Date date) {

        String date2 = null;
        DateFormat formatter;
        formatter = new SimpleDateFormat("DATEFORMAT_DD_MM_YY");
        date2 = (String) formatter.format(date);

        return date2;
    }

    public String parseDateWithTime(Date date) {

        String date2 = null;
        DateFormat formatter;
        formatter = new SimpleDateFormat("dd-MMM-yy hh:mm a");
        date2 = (String) formatter.format(date);

        return date2;
    }

    public String getMonthWithWeekCountStartDaySaturday(Date date) {
        String weekCount = getWeekMonthCount(date);
        String month = DateUtil.getInstance().DATEFORMAT_MMM.format(date);
        month = month.substring(0, 1).toUpperCase() + month.substring(1);
        month = month + " " + "wk" + weekCount;
        return month;
    }

    public String getWeekMonthCount(Date date1) {
        Calendar cal = getCalendarInstance();
        cal.setTime(date1);
        cal.setFirstDayOfWeek(Calendar.SATURDAY);
        cal.setMinimalDaysInFirstWeek(7);
        String weekCount = NumberUtil.getString(cal.get(Calendar.WEEK_OF_MONTH));
        return weekCount;
    }

    public String formatDate(Date date) {
        return formatDate(date, DD_MMM_YYYY);
    }

    public String formatDate(Date date, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        return formatDateByformat(date, dateFormat);
    }

    public String formatDateByformat(Date date, DateFormat dateFormat) {
        String dateStr = "";
        try {
            if (date != null) {
                dateStr = dateFormat.format(date);
            }
        } catch (Exception e) {
            return "";
        }
        return dateStr;
    }

    public String formatDate(Date date, DateFormat dateFormat) {
        return dateFormat.format(date);
    }

    public List<String> formatDatesByformat(List<Date> dates, DateFormat dateFormat) {
        List<String> dateStrList = null;
        if (ListUtil.isNotNullOrEmpty(dates)) {
            dateStrList = new ArrayList<String>();
            for (Date date : dates) {
                String dateStr = formatDate(date, dateFormat);
                dateStrList.add(dateStr);
            }
        }
        return dateStrList;
    }

    public List<Date> parseStringListByDateFormat(List<String> dateStrList, DateFormat dateFormat) {
        List<Date> dates = null;
        if (ListUtil.isNotNullOrEmpty(dateStrList)) {
            dates = new ArrayList<Date>();
            for (String dateStr : dateStrList) {
                Date date = parseString(dateStr, dateFormat);
                dates.add(date);
            }
        }
        return dates;
    }

    public Date getMonthDate(Date date) {
        Calendar cal = getCalendarInstance();
        cal.setTime(date);
        cal.setLenient(true);
        cal.set(Calendar.DATE, 1);
        return cal.getTime();
    }

    public Date getNextMonthDate(Date date) {
        Calendar cal = getCalendarInstance();
        cal.setTime(date);
        cal.setLenient(true);
        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
        cal.add(Calendar.DATE, 1);
        return cal.getTime();
    }

    public Date getPrevMonthStartDate(Date date) {
        Calendar cal = getCalendarInstance();
        cal.setTime(date);
        cal.setLenient(true);
        cal.set(Calendar.DATE, cal.getActualMinimum(Calendar.DATE));
        cal.add(Calendar.DATE, -1);
        cal.set(Calendar.DATE, cal.getActualMinimum(Calendar.DATE));
        cal = getCalendarWithStartTime(cal);
        return cal.getTime();
    }

    public Date getNextMonthEndDate(Date date) {
        Calendar cal = getCalendarInstance();
        cal.setTime(date);
        cal.setLenient(true);
        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
        cal.add(Calendar.DATE, 1);
        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
        return cal.getTime();
    }

    public Date getCurrentMonthEndDate(Date date) {
        Calendar cal = getCalendarInstance();
        cal.setTime(date);
        cal.setLenient(true);
        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
        cal.add(Calendar.DATE, 0);
        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
        return cal.getTime();
    }

    public Date getPreviousMonthEndDate(Date date) {
        Calendar cal = getCalendarInstance();
        cal.setTime(date);
        cal.setLenient(true);
//		cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
        cal.add(Calendar.DATE, -1);
        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
        return cal.getTime();
    }

    public Date getMonthEndDate(Date date) {
        Calendar cal = getCalendarInstance();
        cal.setTime(date);
        cal.setLenient(true);
        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
        cal = getCalendarWithEndTime(cal);
        return cal.getTime();
    }

    public Date getYearStartDate(Date date, int x) {
        Calendar cal = getCalendarInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.MONTH, 0);
        cal.add(Calendar.YEAR, x);
        cal = getCalendarWithStartTime(cal);
        return cal.getTime();
    }

    public Date getLastOrNextYearSameDay(Date date, int i) {
        Calendar cal = getCalendarInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, i); // to get previous year add -1
        Date nextOrPrevYear = cal.getTime();
        return nextOrPrevYear;
    }

    public String getFinancialYearFrom(Date date) {
        Calendar calendar = DateUtil.getInstance().getCalendar(date);
        int CurrentYear = calendar.get(Calendar.YEAR);
        int CurrentMonth = (calendar.get(Calendar.MONTH) + 1);
        String financiyalYearFrom = "";
        if (CurrentMonth < 4) {
            financiyalYearFrom = "01-04-" + (CurrentYear - 1);
        } else {
            financiyalYearFrom = "01-04-" + (CurrentYear);
        }
        return financiyalYearFrom;
    }

    public Date getFinancialYearFromDate(Date date) {
        String fromDateStr = getFinancialYearFrom(date);
        Date fromDate = getDateWithStartTime(DateUtil.getInstance().parseString(fromDateStr, "dd-MM-yyyy"));
        return fromDate;
    }

    public Date getFinancialYearToDate(Date date) {
        String toDateStr = getFinancialYearTo(date);
        Date toDate = getDateWithEndTime(DateUtil.getInstance().parseString(toDateStr, "dd-MM-yyyy"));
        return toDate;
    }

    public String getFinancialYearTo(Date date) {
        Calendar calendar = DateUtil.getInstance().getCalendar(date);

        int CurrentYear = calendar.get(Calendar.YEAR);
        int CurrentMonth = (calendar.get(Calendar.MONTH) + 1);
        String financiyalYearTo = "";
        if (CurrentMonth < 4) {
            financiyalYearTo = "31-03-" + (CurrentYear);
        } else {
            financiyalYearTo = "31-03-" + (CurrentYear + 1);
        }
        return financiyalYearTo;
    }

    public Date getYearGivenByBusinessStartDate(Date date, int x, String businessMonthStart) {
        int businessStart = Calendar.APRIL;
        if (StringUtil.isEqual(businessMonthStart, "April")) {
            businessStart = Calendar.APRIL;
        } else {
            businessStart = Calendar.JANUARY;
        }
        Calendar c = getCalendarInstance(); //Will given you current date
        c.setTime(date);
        c.add(Calendar.YEAR, x);            //Decrement 1 year
        c.set(Calendar.MONTH, businessStart); //Set Month to April
        c.set(Calendar.DAY_OF_MONTH, 1);       //Set First date of that month
        return c.getTime();
    }

    public Date getYearGivenByBusinessEndDate(Date date, int x, String businessMonthStart) {
        int businessEnd = Calendar.MARCH;
        if (StringUtil.isEqual(businessMonthStart, "April")) {
            businessEnd = Calendar.MARCH;
        } else {
            businessEnd = Calendar.DECEMBER;
        }
        Calendar c = getCalendarInstance(); //Will given you current date
        c.setTime(date);
        c.add(Calendar.YEAR, x);            //Decrement 1 year
        c.set(Calendar.MONTH, businessEnd); //Set Month to April
        c.set(Calendar.DAY_OF_MONTH, 1);       //Set First date of that month
        return DateUtil.getInstance().getMonthEndDate(c.getTime());
    }

    public Date getYearEndDate(Date date, int x) {
        Calendar cal = getCalendarInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 31);
        cal.set(Calendar.MONTH, 11);
        cal.add(Calendar.YEAR, x);
        cal = getCalendarWithEndTime(cal);
        return cal.getTime();
    }

    public Date getYearEndDate(Date date) {
        Calendar cal = getCalendarInstance();
        cal.setTime(date);
        cal.setLenient(true);
        cal.add(Calendar.YEAR, 1);
        cal.add(Calendar.DATE, -1);
        cal = getCalendarWithEndTime(cal);
        return cal.getTime();
    }

    public Calendar getCalNextDay(Calendar cal) {
        cal.add(Calendar.DAY_OF_YEAR, 1);
        return cal;
    }

    public Calendar getCalPreviousDay(Calendar cal) {
        cal.add(Calendar.DAY_OF_YEAR, -1);
        return cal;
    }

    public Date getPreviousDay(Date date) {
        Calendar cal = getCalPreviousDay(getCalendar(date));
        return cal.getTime();
    }

    public Calendar addDaysToCal(Calendar cal, int noOfDays) {
        cal.add(Calendar.DAY_OF_YEAR, noOfDays);
        return cal;
    }

    public Calendar addToCalByType(Calendar cal, int no, int field) {
        cal.add(field, no);
        return cal;
    }

    public Date addDaysToDate(Date date, int noOfDays) {
        Calendar cal = addDaysToCal(getCalendar(date), noOfDays);
        return cal.getTime();
    }

    public Date addWeeksToDate(Date date, int num) {
        Calendar cal = addToCalByType(getCalendar(date), num, Calendar.WEEK_OF_MONTH);
        return cal.getTime();
    }

    public Date addMonthsToDate(Date date, int num) {
        Calendar cal = addToCalByType(getCalendar(date), num, Calendar.MONTH);
        return cal.getTime();
    }

    public Date addYearsToDate(Date date, int num) {
        Calendar cal = addToCalByType(getCalendar(date), num, Calendar.YEAR);
        return cal.getTime();
    }

    public Date addHoursToDate(Date date, int num) {
        Calendar cal = addToCalByType(getCalendar(date), num, Calendar.HOUR);
        return cal.getTime();
    }

    public Date addMinutesToDate(Date date, int num) {
        Calendar cal = addToCalByType(getCalendar(date), num, Calendar.MINUTE);
        return cal.getTime();
    }

    public Date addMinutesToDateInLong(Date date, long num) {
        Calendar cal = getCalendar(date);
        cal.setTimeInMillis(cal.getTimeInMillis() + (num * 1000));
        return cal.getTime();
    }

    public Date addSecondsToDate(Date date, int noOfSeconds) {
        Calendar cal = addToCalByType(getCalendar(date), noOfSeconds, Calendar.SECOND);
        return cal.getTime();
    }

    public Date setMonthNumberToDate(Date date, int num) {
        Calendar cal = setToCalByType(getCalendar(date), num, Calendar.MONTH);
        return cal.getTime();
    }

    public Calendar setToCalByType(Calendar cal, int no, int field) {
        cal.set(field, no);
        return cal;
    }

    public Date setToDateByType(Date date, int no, int field) {
        Calendar cal = getCalendar(date);
        cal.set(field, no);
        return cal.getTime();
    }

    public int getDateFieldType(Date date, int field) {
        Calendar cal = getCalendar(date);
        return cal.get(field);
    }

    public Date addTimeOrDayOrWeekOrMonthOrYearToDate(Date date, String periodType, int count) {
        Date newDate = null;
        if (StringUtil.isEqual(periodType, "Month")) {
            newDate = addMonthsToDate(date, count);
        } else if (StringUtil.isEqual(periodType, "Day")) {
            newDate = addDaysToDate(date, count);
        } else if (StringUtil.isEqual(periodType, "Year")) {
            newDate = addYearsToDate(date, count);
        } else if (StringUtil.isEqual(periodType, "Minute")) {
            newDate = addMinutesToDate(date, count);
        } else if (StringUtil.isEqual(periodType, "Hour")) {
            newDate = addHoursToDate(date, count);
        }
        return newDate;
    }

    public Calendar getNextCalDateByDay(Calendar cal1, int calDayInt) {
        int count = 0;
        while (count < 7) {
            if (cal1.get(Calendar.DAY_OF_WEEK) == calDayInt) {
                break;
            } else {
                cal1.add(Calendar.DAY_OF_YEAR, 1);
            }
            count++;
        }
        return cal1;
    }

    public Date getNextDay(Date currentDate) {
        Calendar cal = getCalendarInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.DAY_OF_YEAR, 1);
        return cal.getTime();
    }

    public Date getNextSecond(Date currentDate) {
        return addSecondsToDate(currentDate, 1);
    }

    public Date getNextDayDateOnly(Date currentDate) {
        Calendar cal = getCalendarInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.DAY_OF_YEAR, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    public Date getWeekStartDay(Date currentDate) {
        Calendar cal = getCalendarInstance();
        cal.setTime(currentDate);
        int week = cal.get(Calendar.WEEK_OF_YEAR);
        int year = cal.get(Calendar.YEAR);
        cal.clear();
        cal.set(Calendar.WEEK_OF_YEAR, week);
        cal.set(Calendar.YEAR, year);
        return cal.getTime();
    }

    public Date getWeekStartDayAsMonday(Date currentDate) {
        Calendar cal = getCalendarInstance();
        cal.setTime(currentDate);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }

    public Date getNextWeekStartDayAsMonday(Date currentDate) {
        Calendar cal = getCalendarInstance();
        cal.setTime(currentDate);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.add(Calendar.DATE, 7);
        return cal.getTime();
    }

    public Date getPreviousWeekFriday(Date currentDate) {
        Calendar cal = getCalendarInstance();
        cal.setTime(currentDate);
        int week = cal.get(Calendar.WEEK_OF_YEAR);
        int year = cal.get(Calendar.YEAR);
        cal.clear();
        cal.set(Calendar.WEEK_OF_YEAR, week - 1);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        return cal.getTime();
    }

    public int getNoOfDatesForTheMonth(Date monthDate) {
        Calendar cal = getCalendarInstance();
        cal.setTime(monthDate);
        int monthMaxDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        return monthMaxDays;
    }

    public int getNoofWeeksBetweenTwoDates(Date startDate, Date endDate) {
        int noOfdays = getDaysBetweenTwoDates(startDate, endDate);
        int noOfWeeks = Math.round(noOfdays / 7);
        return noOfWeeks;
    }

    public Date getWeekEndDay(Date currentDate) {
        Calendar cal = getCalendarInstance();
        cal.setTime(currentDate);
        int week = cal.get(Calendar.WEEK_OF_YEAR);
        int year = cal.get(Calendar.YEAR);
        cal.clear();
        cal.set(Calendar.WEEK_OF_YEAR, week);
        cal.set(Calendar.YEAR, year);
        cal.add(Calendar.DATE, 6);
        return cal.getTime();
    }

    public Date getNextWeekStartDay(Date currentDate) {
        Calendar cal = getCalendarInstance();
        cal.setTime(currentDate);
        int week = cal.get(Calendar.WEEK_OF_YEAR);
        int year = cal.get(Calendar.YEAR);
        cal.clear();
        cal.set(Calendar.WEEK_OF_YEAR, week);
        cal.set(Calendar.YEAR, year);
        cal.add(Calendar.DATE, 7);
        return cal.getTime();
    }

    public boolean isSameMonth(Date date1, Date date2) {
        Calendar cal1 = getCalendarInstance();
        cal1.setTime(date1);
        Calendar cal2 = getCalendarInstance();
        cal2.setTime(date2);
        boolean isSameMonth = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
        return isSameMonth;
    }

    public boolean isSameWeek(Date date1, Date date2) {
        Calendar cal1 = getCalendarInstance();
        cal1.setTime(date1);
        Calendar cal2 = getCalendarInstance();
        cal2.setTime(date2);
        boolean isSameWeek = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR);
        return isSameWeek;
    }

    public boolean isSameTimeStamp(Date date1, Date date2) {
        Calendar cal1 = getCalendarInstance();
        cal1.setTime(date1);
        Calendar cal2 = getCalendarInstance();
        cal2.setTime(date2);
        boolean isSameTime = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
                && cal1.get(Calendar.DATE) == cal2.get(Calendar.DATE)
                && cal1.get(Calendar.HOUR_OF_DAY) == cal2.get(Calendar.HOUR_OF_DAY)
                && cal1.get(Calendar.MINUTE) == cal2.get(Calendar.MINUTE)
                && cal1.get(Calendar.SECOND) == cal2.get(Calendar.SECOND);
        return isSameTime;
    }

    public boolean isSameTime(Date date1, Date date2) {
        Calendar cal1 = getCalendarInstance();
        cal1.setTime(date1);
        Calendar cal2 = getCalendarInstance();
        cal2.setTime(date2);
        boolean isSameTime = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
                && cal1.get(Calendar.DATE) == cal2.get(Calendar.DATE)
                && cal1.get(Calendar.HOUR_OF_DAY) == cal2.get(Calendar.HOUR_OF_DAY)
                && cal1.get(Calendar.MINUTE) == cal2.get(Calendar.MINUTE)
                && cal1.get(Calendar.SECOND) == cal2.get(Calendar.SECOND);
        return isSameTime;
    }

    public boolean isSameDay(Date date1, Date date2) {
        Calendar cal1 = getCalendarInstance();
        cal1.setTime(date1);
        Calendar cal2 = getCalendarInstance();
        cal2.setTime(date2);
        boolean isSameDay = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
                cal1.get(Calendar.DATE) == cal2.get(Calendar.DATE);
        return isSameDay;
    }

    public boolean isSameYear(Date date1, Date date2) {
        Calendar cal1 = getCalendarInstance();
        cal1.setTime(date1);
        Calendar cal2 = getCalendarInstance();
        cal2.setTime(date2);
        boolean isSameYear = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
        return isSameYear;
    }

    public boolean isMonthLastDay(Date date) {
        boolean isMonthEndDay = false;
        Calendar cal1 = getCalendarInstance();
        cal1.setTime(date);
        if (cal1.get(Calendar.DATE) == cal1.getActualMaximum(Calendar.DAY_OF_MONTH)) {
            isMonthEndDay = true;
        }
        return isMonthEndDay;
    }

    public boolean isNullOrSameDay(Date date1, Date date2) {
        boolean isNullOrSame = false;
        if (date1 == null
                && date2 == null) {
            isNullOrSame = true;
        } else if (date1 != null
                && date2 != null) {
            isNullOrSame = isSameDay(date1, date2);
        }
        return isNullOrSame;
    }

    public boolean isPastDay(Date date) {
        boolean isPastDay = false;
        Date today = getTodayDate();
        if (date.getTime() < today.getTime()) {
            isPastDay = true;
        }
        return isPastDay;
    }

    public boolean isPastTime(Date date) {
        boolean isPastDay = false;
        Date today = new Date();
        if (date.getTime() < today.getTime()) {
            isPastDay = true;
        }
        return isPastDay;
    }

    public boolean isFutureDay(Date date) {
        boolean isFutureDay = false;
        date = getDateWithStartTime(date);
        Date today = getTodayDate();
        if (date.getTime() > today.getTime()) {
            isFutureDay = true;
        }
        return isFutureDay;
    }

    public boolean isFutureTime(Date date) {
        boolean isFutureTime = false;
        Date today = getTodayDate();
        if (date.getTime() > today.getTime()) {
            isFutureTime = true;
        }
        return isFutureTime;
    }

    public boolean isTodayOrPastDay(Date date) {
        boolean isTodayOrPastDay = false;
        date = getDateWithStartTime(date);
        Date today = getTodayDate();
        if (date.getTime() <= today.getTime()) {
            isTodayOrPastDay = true;
        }
        return isTodayOrPastDay;
    }

    public boolean isTodayOrFutureDay(Date date) {
        boolean isTodayOrFutureDay = false;
        date = getDateWithStartTime(date);
        Date today = getTodayDate();
        if (date.getTime() >= today.getTime()) {
            isTodayOrFutureDay = true;
        }
        return isTodayOrFutureDay;
    }

    public boolean isSameOrPastDay(Date date1, Date date2) {
        boolean isTodayOrPastDay = false;
        date1 = getDateWithStartTime(date1);
        if (date1.getTime() <= date2.getTime()) {
            isTodayOrPastDay = true;
        }
        return isTodayOrPastDay;
    }

    public boolean isSameOrFutureDay(Date date1, Date date2) {
        boolean isTodayOrFutureDay = false;
        date1 = getDateWithStartTime(date1);
        if (date1.getTime() >= date2.getTime()) {
            isTodayOrFutureDay = true;
        }
        return isTodayOrFutureDay;
    }

    public boolean isTodayOrFutureTime(Date date) {
        boolean isTodayOrFutureDay = false;
        Date today = getTodayDate();
        if (date.getTime() >= today.getTime()) {
            isTodayOrFutureDay = true;
        }
        return isTodayOrFutureDay;
    }

    public boolean isTodayOrFutureDateWithTime(Date date) {
        boolean isTodayOrFutureDay = false;
        Date today = getTodayDateWithTime();
        if (date.getTime() >= today.getTime()) {
            isTodayOrFutureDay = true;
        }
        return isTodayOrFutureDay;
    }

    public boolean isSameOrPastTime(Date date1, Date date2) {
        boolean isTodayOrPastDay = false;
        if (date1.getTime() <= date2.getTime()) {
            isTodayOrPastDay = true;
        }
        return isTodayOrPastDay;
    }

    public boolean isSameOrFutureTime(Date date1, Date date2) {
        boolean isTodayOrFutureDay = false;
        if (date1.getTime() >= date2.getTime()) {
            isTodayOrFutureDay = true;
        }
        return isTodayOrFutureDay;
    }

    public boolean isBetween(Date fromDate, Date toDate, Date currentDate) {
        boolean isBetween = false;
        if ((currentDate.after(fromDate) && currentDate.before(toDate)) ||
                isSameDay(currentDate, fromDate) ||
                isSameDay(currentDate, toDate)) {
            isBetween = true;
        }
        return isBetween;
    }

    public boolean isPresentInList(List<Date> dateList, Date value) {
        boolean isPresent = false;
        if (ListUtil.isNotNullOrEmpty(dateList)
                && value != null) {
            for (Date date : dateList) {
                if (isSameDay(date, value)) {
                    isPresent = true;
                    break;
                }
            }
        }
        return isPresent;
    }

    public boolean isTimePresentInList(List<Date> dateList, Date value) {
        boolean isPresent = false;
        if (ListUtil.isNotNullOrEmpty(dateList)
                && value != null) {
            for (Date date : dateList) {
                if (isSameTime(date, value)) {
                    isPresent = true;
                    break;
                }
            }
        }
        return isPresent;
    }

    public int getMaxNumberOfDaysForMonth(Date date) {
        Calendar cal = getCalendar(date);
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public int getDaysBetweenTwoDates(Date date1, Date date2) {
        long noOfDays = 0;
        long diff = date1.getTime() - date2.getTime();
        noOfDays = diff / (60 * 60 * 1000 * 24);
        return Math.abs((int) noOfDays);
    }

    public List<Date> getDatesBetweenFields(Date startDate, Date endDate, int duration) {
        List<Date> dates = new ArrayList<Date>();
        long endTime = endDate.getTime();
        long curTime = startDate.getTime();

        dates.add(startDate);
        while (curTime <= endTime) {
            Date date = DateUtil.getInstance().addMinutesToDate(startDate, duration);
            int diffTime = getMinutesBetweenTwoDates(endDate, date);
            //if(diffTime !=-1){
            if (diffTime > 1) {
                dates.add(date);
            }
            curTime = date.getTime();
            startDate = date;
        }
        return dates;
    }

    public int getDaysBetweenTwoDatesSigned(Date date1, Date date2) {
        long noOfDays = 0;
        long diff = date1.getTime() - date2.getTime();
        noOfDays = diff / (60 * 60 * 1000 * 24);
        return (int) noOfDays;
    }

    //does not include date1 and date2; date1 is smaller
    public int getNumberOfGivenDayBetweenDates(Date date1, Date date2, int calDayInt) {
        int num = 0;
        if (date1 != null
                && date2 != null) {
            Calendar cal1 = getCalendarInstance();
            cal1.setTime(date1);
            Calendar cal2 = getCalendarInstance();
            cal2.setTime(date2);
            cal1 = getNextCalDateByDay(cal1, calDayInt);
            while (cal1.before(cal2)) {
                cal1.add(Calendar.DATE, 7);
                num++;
            }
        }
        return num;
    }

    public int getNoOfYearsBWTwoDates(Date date1, Date date2) {
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("yyyy");
        Integer.parseInt(simpleDateformat.format(date1));
        return Integer.parseInt(simpleDateformat.format(date2)) - Integer.parseInt(simpleDateformat.format(date1));
    }

    public int getMinutesBetweenTwoDates(Date date1, Date date2) {
        long noOfMinutes = 0;
        long diff = date1.getTime() - date2.getTime();
        noOfMinutes = diff / (60 * 1000);
        return Math.abs((int) noOfMinutes);
    }

    public int getMinutesBetweenTwoDate(Date date1, Date date2) {
        long noOfHours = 0;
        long diff = date1.getTime() - date2.getTime();
        noOfHours = diff / (60 * 60 * 1000) % 24;
        return Math.abs((int) noOfHours);
    }

    public double convertMinuteToDateFormat(int minutes) {
        String hours = NumberUtil.getString(minutes / 60);
        int minute = minutes % 60;
        double hoursAndMintus = NumberUtil.getdDouble(hours + "." + minute);
        System.out.println(hoursAndMintus);
        return hoursAndMintus;
    }

    public Date getTodayDateWithTime() {
        String date = DATEFORMAT_YY_MM_DD_HH_MM_SS.format(getNewDateWithCurrentTime());
        return parseString(date, DATEFORMAT_YY_MM_DD_HH_MM_SS);
    }

    public Date getTodayDate() {
        String date = DATEFORMAT_YYYYMMDD.format(getNewDateWithCurrentTime());
        return parseString(date, DATEFORMAT_YYYYMMDD);
    }

    public Date getNewDate() {
        return new Date();
    }

    public Date getNewDateWithCurrentTime() {
        Calendar calendar = getCalendarInstance();
        return calendar.getTime();
    }

    public Date getDate(int day, int month, int year) {
        Calendar cal = getCalendarInstance();
        cal.set(year, month, 1);
        return cal.getTime();
    }

    public Date getDate(int year) {
        return getDate(1, 0, year);
    }

    public Date getLeastDateFromList(List<Date> dates) {
        Date leastDate = null;
        for (Date date : dates) {
            if (leastDate == null) {
                leastDate = date;
            } else if (leastDate.after(date)) {
                leastDate = date;
            }
        }
        return leastDate;
    }

    public Date getLatestDateFromList(List<Date> dates) {
        Date latestDate = null;
        for (Date date : dates) {
            if (latestDate == null) {
                latestDate = date;
            } else if (latestDate.before(date)) {
                latestDate = date;
            }
        }
        return latestDate;
    }

    /*public List<Date> getMonthsBetweenDates(Date date1, Date date2){
        date2 = new Date();
        List<Date> dates = new ArrayList<Date>();
        date1 =  DateUtil.getInstance().parseString("01-Jan-2011", DateUtil.getInstance().DATEFORMAT_DD_MMM_YYYY);
        dates.add(date1);
        while(date1.before(date2)){
            Date newDate = DateUtil.getInstance().getNextMonthDate(date1);
            dates.add(newDate);
        }
        return dates;
    }*/
	/*public int getNoOfMonthsBetweenDates(Date date1, Date date2){
		int months = 0;
		Calendar cal1 = getCalendarInstance();
		cal1.setTime(date1);
		Calendar cal2 = getCalendarInstance();
		cal2.setTime(date2);
		if(cal1.get(Calendar.DATE) == cal2.get(Calendar.DATE)
				&& cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)){
			months = Math.abs(cal2.get(Calendar.MONTH) - cal1.get(Calendar.MONTH));
		}else{
			int days = DateUtil.getInstance().getDaysBetweenTwoDates(date1, date2);
			months = Math.round(days/30);
		}
		return months;
	}*/
    public int getNumberOfMonthsBetweenTwoDatesOfSameDay(Date date1, Date date2) {
        int months = 0;
        Calendar cal1 = getCalendarInstance();
        cal1.setTime(date1);
        Calendar cal2 = getCalendarInstance();
        cal2.setTime(date2);
        while (cal1.get(Calendar.MONTH) < cal2.get(Calendar.MONTH)
                && (cal1.get(Calendar.YEAR) <= cal2.get(Calendar.YEAR))) {
            months++;
            cal1.add(Calendar.MONTH, 1);
        }
        return months;
    }

    public List<Date> getMonthsBetweenDates(Date date1, Date date2) {
        List<Date> dates = new ArrayList<Date>();
        date1 = getMonthDate(date1);
        dates.add(date1);
        while (date1.before(date2)) {
            Date newDate = DateUtil.getInstance().getNextMonthDate(date1);
            if (newDate.before(date2)) {
                dates.add(newDate);
                date1 = newDate;
            } else {
                break;
            }
        }
        return dates;
    }

    public List<Date> getMonthsForGivenCount(Date date, int count) {
        List<Date> dates = new ArrayList<Date>();
        Calendar cal1 = getCalendarInstance();
        cal1.setTime(date);
        int i = 0;
        while (i < count) {
            dates.add(cal1.getTime());
            cal1.add(Calendar.MONTH, 1);
            i++;
        }
        return dates;
    }

    public List<Date> getPreviousMonthsListForGivenCount(Date date, int count) {
        List<Date> dates = new ArrayList<Date>();
        Calendar cal1 = getCalendarInstance();
        cal1.setTime(date);
        int i = 0;
        while (i < count) {
            cal1.add(Calendar.MONTH, -1);
            dates.add(cal1.getTime());
            i++;
        }
        return dates;
    }

    public Date getPreviousMonthsForGivenCount(Date date, int count) {
        List<Date> dates = new ArrayList<Date>();
        Calendar cal1 = getCalendarInstance();
        cal1.setTime(date);
        int i = 0;
        while (i < count) {
            dates.add(cal1.getTime());
            cal1.add(Calendar.MONTH, -1);
            i++;
        }
        Date date1 = dates.get(dates.size() - 1);
        return date1;
    }

    public Date getNextMonthsForGivenCount(Date date, int count) {
        List<Date> dates = new ArrayList<Date>();
        Calendar cal1 = getCalendarInstance();
        cal1.setTime(date);
        int i = 0;
        while (i < count) {
            dates.add(cal1.getTime());
            cal1.add(Calendar.MONTH, 1);
            i++;
        }
        return dates.get(dates.size() - 1);
    }

    public List<Date> getMonthEndDatesBetweenDates(Date date1, Date date2) {
        List<Date> dates = new ArrayList<Date>();
        date1 = getMonthEndDate(date1);
        dates.add(date1);
        while (date1.before(date2)) {
            Date newDate = DateUtil.getInstance().getNextMonthEndDate(date1);
            if (newDate.before(date2)) {
                dates.add(newDate);
                date1 = newDate;
            } else {
                break;
            }
        }
        return dates;
    }

    public List<String> convertDatesToStringList(List<Date> dates, DateFormat dateFormat) {
        List<String> dateStrList = null;
        if (ListUtil.isNotNullOrEmpty(dates)) {
            dateStrList = new ArrayList<String>();
            for (Date date : dates) {
                dateStrList.add(formatDate(date, dateFormat));
            }
        }
        return dateStrList;
    }

    public List<Date> getAllDatesBetween(Date date1, Date date2) {
        List<Date> dates = new ArrayList<Date>();
        while (date1.before(date2)
                || isSameDay(date1, date2)) {
            dates.add(date1);
            Date newDate = DateUtil.getInstance().getNextDay(date1);
            date1 = newDate;
        }
        return dates;
    }

    public List<Date> getWeekDatesBetween(Date date1, Date date2) {
        List<Date> dates = new ArrayList<Date>();
        //date1 = getNextWeekStartDay(date1);
        dates.add(date1);
        while (date1.before(date2)) {
            Date newDate = DateUtil.getInstance().addDaysToDate(date1, 7);
            if (newDate.before(date2)) {
                dates.add(newDate);
            }
            date1 = newDate;
			/*Date newDate = DateUtil.getInstance().addDaysToDate(date1, 15);
			dates.add(newDate);
			date1 = newDate;*/
        }
        return dates;
    }

    public Date getLastWeekDate() {
        Calendar today = getCalendarInstance();
        today.add(Calendar.DATE, -7);
        Date date = today.getTime();
        return date;
    }

    public Date getDateBeforeXDays(int x) {
        Calendar today = getCalendarInstance();
        today.add(Calendar.DATE, -x);
        Date date = today.getTime();
        return date;
    }

    public Date getDateAfterXDays(int x) {
        Calendar today = getCalendarInstance();
        today.add(Calendar.DATE, +x);
        Date date = today.getTime();
        return date;
    }

    public Date getDateAfterXDays(Date date, int x) {
        Calendar calendar = getCalendarInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, +x);
        Date newDate = calendar.getTime();
        return newDate;
    }

    public Date getDateBeforeXDays(Date date, int x) {
        Calendar calendar = getCalendarInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -x);
        Date newDate = calendar.getTime();
        return newDate;
    }

    public Date getTimeAfterXMinutes(int x) {
        Calendar today = getCalendarInstance();
        today.add(Calendar.MINUTE, +x);
        Date date = today.getTime();
        return date;
    }

    public Date getTimeBeforeXMinutes(int x) {
        Calendar today = getCalendarInstance();
        today.add(Calendar.MINUTE, -x);
        Date date = today.getTime();
        return date;
    }

    public Date getMonthStartDate(Date date) {
        Calendar cal = getCalendarInstance();
        cal.setTime(date);
        cal.setLenient(true);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        cal = getCalendarWithStartTime(cal);
        return cal.getTime();
    }

    public Date getCurrentMonthStartDate() {
        Date date = getNewDate();
        Calendar cal = getCalendarInstance();
        cal.setTime(date);
        cal.setLenient(true);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        cal = getCalendarWithStartTime(cal);
        return cal.getTime();
    }

    public Date getDateByInteger(int val) {
        Calendar today = getCalendarInstance();
        today.add(Calendar.DATE, val);
        Date date = today.getTime();
        return date;
    }

    public Date getDateByMinites(int minite) {
        Calendar today = getCalendarInstance();
        today.add(Calendar.MINUTE, minite);
        Date date = today.getTime();
        return date;
    }

    public Date getDateWithStartTime(Date date) {
        Date newDate = null;
        if (date != null) {
            Calendar cal = getCalendarInstance();
            cal.setTime(date);
            cal = getCalendarWithStartTime(cal);
            newDate = cal.getTime();
        }
        return newDate;
    }

    public Calendar getCalendarWithStartTime(Calendar cal) {
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal;
    }

    public Date getDateWithEndTime(Date date) {
        Date newDate = null;
        if (date != null) {
            Calendar cal = getCalendarInstance();
            cal.setTime(date);
            cal = getCalendarWithEndTime(cal);
            newDate = cal.getTime();
        }
        return newDate;
    }

    public Date getHourWithBeginMinutes(Date date) {
        Date newDate = new Date();
        if (date != null) {
            Calendar calendar = getCalendarInstance();
            calendar.setTime(date);
            calendar.set(Calendar.MINUTE, 00);
            calendar.set(Calendar.SECOND, 00);
            newDate = calendar.getTime();
        }
        return newDate;
    }

    public Date getHourWithEndMinutes(Date date) {
        Date newDate = new Date();
        if (date != null) {
            Calendar calendar = getCalendarInstance();
            calendar.setTime(date);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            newDate = calendar.getTime();
        }
        return newDate;
    }

    public Calendar getCalendarWithEndTime(Calendar cal) {
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 0);
        return cal;
    }

    public Date getDateForToDate(Date date) {
        Date newDate = null;
        if (date != null) {
            Calendar cal = getCalendarInstance();
            cal.setTime(date);
            cal.add(Calendar.DAY_OF_YEAR, 1);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            newDate = cal.getTime();
        }
        return newDate;
    }

    public int getHourOfDay(Date date) {
        int hour = 0;
        if (date != null) {
            Calendar cal = getCalendarInstance();
            cal.setTime(date);
            hour = cal.get(Calendar.HOUR_OF_DAY);
        }
        return hour;
    }

    public int getMinute(Date date) {
        int minute = 0;
        if (date != null) {
            Calendar cal = getCalendarInstance();
            cal.setTime(date);
            minute = cal.get(Calendar.MINUTE);
        }
        return minute;
    }

    public Date getDateWithTime(String dateValue, String timeHour, String timeMM, String dateTimeUnits) {
        Date date = DateUtil.getInstance().parseString(dateValue);
        Calendar cal = getCalendarInstance();
        cal.setTime(date);
        int hour = getHourByAMorPM(timeHour, dateTimeUnits);
        int minute = NumberUtil.getInt(timeMM);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), hour, minute);
        return cal.getTime();
    }

    public int getHourByAMorPM(String timeHH, String timeUnits) {
        int time = 0;
        if (StringUtil.isNotNullOrEmpty(timeHH)) {
            time = NumberUtil.getInt(timeHH);
            if (timeUnits.equalsIgnoreCase("PM") && time != 12) {
                time = time - 12;
            } else if (time == 0) {
                time = 12;
            }
        }
        return time;
    }

    public Date getNextMonthStartDate(Date date) {
        Calendar cal = getCalendarInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 1);
        date = cal.getTime();
        cal.set(Calendar.DATE, cal.getActualMinimum(Calendar.DATE));
        return cal.getTime();
    }

    public Date getPreviousMonthStartDate(Date date) {
        Calendar cal = getCalendarInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);
        date = cal.getTime();
        cal.set(Calendar.DATE, cal.getActualMinimum(Calendar.DATE));
        return cal.getTime();
    }

    public String getAmOrPmByDate(Date date) {
        String amOrPm = "AM";
        if (getHourOfDay(date) >= 12) {
            amOrPm = "PM";
        }
        return amOrPm;
    }

    public Date getMaxDate(Date date1, Date date2) {
        Date maxDate = null;
        if (date1 != null && date2 != null
                && date1.after(date2)) {
            maxDate = date1;
        } else {
            maxDate = date2;
        }
        return maxDate;
    }

    public Date getMinDate(Date date1, Date date2) {
        Date maxDate = null;
        if (date1 != null && date2 != null
                && date1.before(date2)) {
            maxDate = date1;
        } else {
            maxDate = date2;
        }
        return maxDate;
    }

    public Date getPeriodEndDateByPeriodType(String periodType, Date date) {
        Date endDate = date;
        if (StringUtil.isEqual(PERIOD_TYPE_DAILY, periodType)) {
            endDate = DateUtil.getInstance().getDateWithEndTime(date);
        } else if (StringUtil.isEqual(PERIOD_TYPE_MONTHLY, periodType)) {
            endDate = DateUtil.getInstance().getMonthEndDate(date);
        } else if (StringUtil.isEqual(PERIOD_TYPE_YEARLY, periodType)) {
            endDate = DateUtil.getInstance().getYearEndDate(date);
        }
        return endDate;
    }

    public Date getPeriodEndDateByPeriodTypeTagId(String periodTypeTagId, Date date) {
        Date endDate = date;
        if (StringUtil.isEqual(PERIOD_TYPE_DAILY_DB_ID, periodTypeTagId)) {
            endDate = DateUtil.getInstance().getDateWithEndTime(date);
        } else if (StringUtil.isEqual(PERIOD_TYPE_MONTHLY_DB_ID, periodTypeTagId)) {
            endDate = DateUtil.getInstance().getMonthEndDate(date);
        } else if (StringUtil.isEqual(PERIOD_TYPE_YEARLY_DB_ID, periodTypeTagId)) {
            endDate = DateUtil.getInstance().getYearEndDate(date);
        }
        return endDate;
    }

    public Date getPeriodStartDateByPeriodTypeTagId(String periodTypeTagId, Date date) {
        Date startDate = date;
        if (StringUtil.isEqual(PERIOD_TYPE_DAILY_DB_ID, periodTypeTagId)) {
            startDate = DateUtil.getInstance().getDateWithStartTime(date);
        } else if (StringUtil.isEqual(PERIOD_TYPE_MONTHLY_DB_ID, periodTypeTagId)) {
            startDate = DateUtil.getInstance().getMonthStartDate(date);
        } else if (StringUtil.isEqual(PERIOD_TYPE_YEARLY_DB_ID, periodTypeTagId)) {
            startDate = DateUtil.getInstance().getYearStartDate(date, 0);
        }
        return startDate;
    }

    public Date getNextDateByPeriodTypeTagId(String periodTypeTagId, Date date) {
        Date nextDate = date;
        if (StringUtil.isEqual(PERIOD_TYPE_DAILY_DB_ID, periodTypeTagId)) {
            nextDate = DateUtil.getInstance().addDaysToDate(date, 1);
        } else if (StringUtil.isEqual(PERIOD_TYPE_MONTHLY_DB_ID, periodTypeTagId)) {
            nextDate = DateUtil.getInstance().addMonthsToDate(date, 1);
        } else if (StringUtil.isEqual(PERIOD_TYPE_YEARLY_DB_ID, periodTypeTagId)) {
            nextDate = DateUtil.getInstance().addYearsToDate(date, 1);
        }
        return nextDate;
    }

    public Date getPeriodEndDateByPeriodTagId(Date date, String periodTagId, int num) {
        Date endDate = date;
        if (PERIOD_TYPE_DAILY.equalsIgnoreCase(periodTagId)) {
            endDate = DateUtil.getInstance().addDaysToDate(date, num);
            endDate = DateUtil.getInstance().getDateWithEndTime(endDate);
        } else if (PERIOD_TYPE_WEEKLY.equalsIgnoreCase(periodTagId)) {
            int daysToAdd = num * 7;
            endDate = DateUtil.getInstance().addDaysToDate(date, daysToAdd);
            endDate = DateUtil.getInstance().getDateWithEndTime(endDate);
        } else if (PERIOD_TYPE_MONTHLY.equalsIgnoreCase(periodTagId)) {
            endDate = DateUtil.getInstance().addMonthsToDate(date, num);
            endDate = DateUtil.getInstance().getDateWithEndTime(endDate);
        } else if (PERIOD_TYPE_YEARLY.equalsIgnoreCase(periodTagId)) {
            endDate = DateUtil.getInstance().addYearsToDate(date, num);
            endDate = DateUtil.getInstance().getDateWithEndTime(date);
        }
        return endDate;
    }

    public String getMonthNumber(Date date) {
        String monthCount = "";
        Calendar cal = getCalendarInstance();
        cal.setTime(date);
        monthCount = NumberUtil.getString(cal.get(Calendar.MONTH) + 1);
        return monthCount;
    }

    public String getDateNumber(Date date) {
        String monthCount = "";
        Calendar cal = getCalendarInstance();
        cal.setTime(date);
        monthCount = NumberUtil.getString(cal.get(Calendar.DATE));
        return monthCount;
    }

    public String getCurrentWeekCount(Date date) {
        String weekCount = "";
        Calendar cal = getCalendarInstance();
        cal.setTime(date);
        weekCount = NumberUtil.getString(cal.get(Calendar.WEEK_OF_MONTH));
        return weekCount;
    }

    public boolean isDateEqual(Date date1, Date date2) {
        boolean flag = false;
        if (date1 != null || date2 != null) {
            if (date1.compareTo(date2) == 0) {
                flag = true;
            }
        }
        return flag;

    }

    public boolean isDate1AfterDate2(Date date1, Date date2) {
        boolean flag = false;
        if (date1 != null || date2 != null) {
            if (date1.compareTo(date2) > 0) {
                flag = true;
            }
        }
        return flag;

    }

    public boolean isDate1BeforeDate2(Date date1, Date date2) {
        boolean flag = false;
        if (date1 != null || date2 != null) {
            if (date1.compareTo(date2) < 0) {
                flag = true;
            }
        }
        return flag;

    }

    public List<Date> getMonthsBetweenDatesQuarter(Date leastDate, Date latestDate) {
        List<Date> dates = new ArrayList<Date>();
        Calendar cal1 = getCalendarInstance();
        cal1.setTime(leastDate);
        int i = 0;
        while (leastDate.before(latestDate)) {
            cal1.add(Calendar.MONTH, 4);
            dates.add(cal1.getTime());
            i++;
        }
        return dates;
    }

    public List<Date> getQuaterlyDateFromDateToDate(String yearStarts, Date startDate, Date endDate) {
        List<Date> dates = new ArrayList<Date>();
        int yearBegin = 0;
        if (StringUtil.isEqual(yearStarts, "Jan") ||
                StringUtil.isEqual(yearStarts, "January")) {
            yearBegin = 0;
        } else if (StringUtil.isEqual(yearStarts, "Apr") ||
                StringUtil.isEqual(yearStarts, "April")) {
            yearBegin = 3;
        }
        Calendar calendarBegin = getCalendarInstance();
        Calendar calendarEnd = getCalendarInstance();
        Calendar selectedStartDate = getCalendarInstance();
        selectedStartDate.setTime(startDate);

        calendarBegin.set(Calendar.MONTH, yearBegin);
        calendarBegin.set(Calendar.DATE, 1);
        calendarBegin.set(Calendar.YEAR, selectedStartDate.get(Calendar.YEAR));

        calendarEnd.setTime(endDate);
        calendarEnd.setTime(endDate);


        for (; calendarBegin.getTime().before(calendarEnd.getTime()); ) {
            calendarBegin.add(Calendar.MONTH, +3);
            if (calendarEnd.getTime().after(calendarBegin.getTime()) ||
                    calendarEnd.getTime().before(calendarBegin.getTime())) {
                dates.add(calendarBegin.getTime());
            }
        }
        return dates;
    }

    public List<Date> getHalfyearlyDateFromDateToDate(String yearStarts, Date startDate, Date endDate) {
        List<Date> dates = new ArrayList<Date>();
        int yearBegin = 0;
        if (StringUtil.isEqual(yearStarts, "Jan") ||
                StringUtil.isEqual(yearStarts, "January")) {
            yearBegin = 0;
        } else if (StringUtil.isEqual(yearStarts, "Apr") ||
                StringUtil.isEqual(yearStarts, "April")) {
            yearBegin = 3;
        }
        Calendar calendarBegin = getCalendarInstance();
        Calendar calendarEnd = getCalendarInstance();
        Calendar selectedStartDate = getCalendarInstance();
        selectedStartDate.setTime(startDate);

        calendarBegin.set(Calendar.MONTH, yearBegin);
        calendarBegin.set(Calendar.DATE, 1);
        calendarBegin.set(Calendar.YEAR, selectedStartDate.get(Calendar.YEAR));

        calendarEnd.setTime(endDate);
        calendarEnd.setTime(endDate);

        for (; calendarBegin.getTime().before(calendarEnd.getTime()); ) {
            calendarBegin.add(Calendar.MONTH, +6);
            if (calendarEnd.getTime().after(calendarBegin.getTime()) ||
                    calendarEnd.getTime().before(calendarBegin.getTime())) {
                dates.add(calendarBegin.getTime());
            }
        }
        return dates;
    }

    public List<Date> getYearlyDateFromDateToDate(String yearStarts, Date startDate, Date endDate) {
        List<Date> dates = new ArrayList<Date>();
        int yearBegin = 0;
        if (StringUtil.isEqual(yearStarts, "Jan") ||
                StringUtil.isEqual(yearStarts, "January")) {
            yearBegin = 0;
        } else if (StringUtil.isEqual(yearStarts, "Apr") ||
                StringUtil.isEqual(yearStarts, "April")) {
            yearBegin = 3;
        }
        Calendar calendarBegin = getCalendarInstance();
        Calendar calendarEnd = getCalendarInstance();
        Calendar selectedStartDate = getCalendarInstance();
        selectedStartDate.setTime(startDate);

        calendarBegin.set(Calendar.MONTH, yearBegin);
        calendarBegin.set(Calendar.DATE, 1);
        calendarBegin.set(Calendar.YEAR, selectedStartDate.get(Calendar.YEAR));

        calendarEnd.setTime(endDate);
        calendarEnd.setTime(endDate);

        for (; calendarBegin.getTime().before(calendarEnd.getTime()); ) {
            calendarBegin.add(Calendar.MONTH, +12);
            if (calendarEnd.getTime().after(calendarBegin.getTime())) {
                dates.add(calendarBegin.getTime());
            }
        }
        return dates;
    }

    public List<Date> getWeekDaysFromToDate(int WeekStarts, Date fromDate, Date toDate) {
        List<Date> dates = new ArrayList<Date>();
        Calendar calendarStart = getCalendarInstance();
        Calendar calendarEnd = getCalendarInstance();
        calendarStart.setTime(fromDate);
        calendarEnd.setTime(toDate);

        while (calendarStart.getTime().before(calendarEnd.getTime()) ||
                calendarStart.getTime().equals(calendarEnd.getTime())/*calendarStart.compareTo(calendarEnd) <= 0*/) {
            if (calendarStart.get(Calendar.DAY_OF_WEEK) == WeekStarts) {
                dates.add(calendarStart.getTime());
            }
            calendarStart.add(Calendar.DATE, 1);
        }
        return dates;
    }

    public List<Date> getMonthDatesFromToDates(int monthStars, Date fromDate, Date toDate) {
        List<Date> dates = new ArrayList<Date>();

        Calendar calendarStart = getCalendarInstance();
        Calendar calendarEnd = getCalendarInstance();

        calendarStart.setTime(fromDate);
        calendarEnd.setTime(toDate);

        while (calendarStart.getTime().before(calendarEnd.getTime())/*calendarStart.compareTo(calendarEnd) < 0*/) {
            if (calendarStart.get(Calendar.DATE) == monthStars) {
                dates.add(calendarStart.getTime());
            }
            calendarStart.add(Calendar.DATE, 1);
        }
        return dates;
    }

    public String getGreatestDate(List<Date> dateList) {
        Date maxDate = null;
        try {
            maxDate = new SimpleDateFormat("ddMMyyyy").parse("01011970");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (ListUtil.isNotNullOrEmpty(dateList)) {
            if (maxDate != null) {
                for (Date date : dateList) {
                    if (date != null) {
                        if (date.compareTo(maxDate) > 0) {
                            maxDate = date;
                        }
                    }
                }
            }
        }
        return formatDate(maxDate, DD_MMM_YY_HH_MM_AMPM);
    }

    public Date getDateInAmPmFormat(String date) {
        Date formattedDate = null;
        try {
            formattedDate = DateUtil.getInstance().DD_MMM_YYYY_HH_MM_AMPM.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return formattedDate;
    }

    public Date getDateInAmPmNormalFormat(String date) {
        Date formattedDate = null;
        try {
            formattedDate = DateUtil.getInstance().DD_MMM_YYYY_HH_MM_AP.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return formattedDate;
    }

    public List<Date> getAllDatesByGivenMonth(int month, String dateFormat) throws ParseException {
        List<Date> dates = new ArrayList<Date>();
        Date date = null;
        Calendar cal = getCalendarInstance();
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        SimpleDateFormat df = new SimpleDateFormat(dateFormat);
        for (int i = 1; i < maxDay; i++) {
            cal.set(Calendar.DAY_OF_MONTH, i + 1);
            date = (Date) df.parse(df.format(cal.getTime()));
            dates.add(date);
        }

        return dates;

    }

    public List<Date> getStartAndEndDateOfMonth(int monthNumber) {
        Calendar cal = getCalendarInstance();
        Calendar cal2 = getCalendarInstance();

        cal.set(Calendar.MONTH, monthNumber);
        cal.set(Calendar.DATE, cal.getActualMinimum(Calendar.DATE));
        cal.set(Calendar.HOUR, -12);
        cal.set(Calendar.MINUTE, cal.getActualMinimum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getActualMinimum(Calendar.SECOND));

        cal2.set(Calendar.MONTH, monthNumber);
        cal2.set(Calendar.DATE, cal2.getActualMaximum(Calendar.DATE));
        cal2.set(Calendar.HOUR, cal2.getActualMaximum(Calendar.HOUR));
        cal2.set(Calendar.MINUTE, cal2.getActualMaximum(Calendar.MINUTE));
        cal2.set(Calendar.SECOND, cal2.getActualMaximum(Calendar.SECOND));

        List<Date> dateList = new ArrayList<Date>();
        dateList.add(cal.getTime());
        dateList.add(cal2.getTime());
        return dateList;
    }

    public String getWeekDayByGivenDate(Date date) {
        Calendar cal = getCalendarInstance();
        cal.setTime(date);
        int val = cal.get(Calendar.DAY_OF_WEEK);
        String weekday = (new DateFormatSymbols().getWeekdays()[val]);
        return weekday;
    }

    public Date getStartDayOfWeekByDate(Date date) {
        Calendar cal = getCalendarInstance();
        cal.setTime(date);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - cal.getFirstDayOfWeek();
        cal.add(Calendar.DAY_OF_MONTH, -dayOfWeek);
        Date weekStart = cal.getTime();
        return weekStart;
    }

    public Date getEndDayOfWeekByDate(Date date) {
        Calendar c = getCalendarInstance();
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
        c.add(Calendar.DAY_OF_MONTH, -dayOfWeek);
        c.add(Calendar.DAY_OF_MONTH, 6);
        Date weekEnd = c.getTime();
        return weekEnd;
    }

    public int getYearByGivenDate(Date date) {
        Calendar cal = getCalendarInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        return year;
    }

    public Date getDateByMonthAndYear(int month, int year) {
        Calendar calendar = getCalendarInstance();
        calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE));
//		calendar.set(Calendar.HOUR, -12);
        calendar.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
        calendar.set(Calendar.MONTH, month);
//		calendar.add(Calendar.DAY_OF_MONTH, -1);
        calendar.set(Calendar.YEAR, year);
        Date date = calendar.getTime();
        return date;
    }

    public Date getDateByDayMonthYear(int day, int month, int year) {
        Calendar calendar = getCalendarInstance();
        calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE));
        calendar.set(Calendar.HOUR, -12);
        calendar.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
        calendar.set(Calendar.DAY_OF_MONTH, day);
        Date date = calendar.getTime();
        return date;
    }

    public Date getPrevMonthEndDate(Date date) {
        Calendar cal = getCalendarInstance();
        cal.setTime(date);
        cal.setLenient(true);
        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
        cal.add(Calendar.DATE, -1);
        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
        return cal.getTime();
    }

    public Date getDateBeforeXMonths(int x) {
        Calendar cal = getCalendarInstance();
        cal.add(Calendar.MONTH, -x);
        return cal.getTime();
    }


    public String getMonthNameByMonthNumber(int number) {
        String monthName = "";
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();
        String[] months = dateFormatSymbols.getMonths();
        if (number >= 1 && number <= 12) {
            monthName = months[number];
        }
        return monthName;
    }


    public Date getDateWithTimeAppended(String userDate) {
        Date startUserDate = DateUtil.getInstance().parseString(userDate);
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String timeString = df.format(new Date()).substring(10); // 10 is the beginIndex of time here

        DateFormat df2 = new SimpleDateFormat("MM/dd/yyyy");
        String startUserDateString = df2.format(startUserDate);

        startUserDateString = startUserDateString + " " + timeString;
        // you will get this format "MM/dd/yyyy HH:mm:ss"

        //then parse the new date here
        try {
            startUserDate = df.parse(startUserDateString);
            System.out.println(startUserDate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return startUserDate;
    }

    public int getNoOfMonthsBetweenDates(Date date1, Date date2) {
        int months = 0;
        Calendar cal1 = getCalendarInstance();
        cal1.setTime(date1);
        Calendar cal2 = getCalendarInstance();
        cal2.setTime(date2);
        if (cal1.get(Calendar.DATE) == cal2.get(Calendar.DATE)
                && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)) {
            months = Math.abs(cal2.get(Calendar.MONTH) - cal1.get(Calendar.MONTH));
        } else {
            int days = DateUtil.getInstance().getDaysBetweenTwoDates(date1, date2);
            List<Date> dates = new ArrayList<Date>();
            if (days < 30) {
                days = 30;
				/*long interval = 24*1000 * 60 * 60; // 1 hour in millis
				long endTime =date1.getTime() ; // create your endtime here, possibly using Calendar or Date
				long curTime = date2.getTime();
				while (curTime <= endTime) {
				    dates.add(new Date(curTime));
				    curTime += interval;
				}
				days = dates.size();*/
            }
            months = Math.round(days / 30);
        }
        return months;
    }

    public Integer getNearestYear(String yearNo) {
        Integer nearestYear = 0;
        List<Integer> previousYears = getThisAndPreviousYears(10);
        for (Integer previousYear : previousYears) {
            String previousYearStr = Integer.toString(previousYear);
            if (StringUtil.isEqual(StringUtil.getLastLetter(previousYearStr), yearNo)) {
                nearestYear = previousYear;
            }
        }
        return nearestYear;
    }

    public List<Integer> getThisAndPreviousYears(int noOfyears) {
        List<Integer> years = new ArrayList<>();
        Date currentDate = DateUtil.getInstance().getNewDate();
        for (int count = 0; count < noOfyears; count++) {
            Date calcDate = DateUtil.getInstance().addYearsToDate(currentDate, -count);
            int calcYear = DateUtil.getInstance().getYearByGivenDate(calcDate);
            years.add(calcYear);
        }
        return years;
    }

    public String getFiscalQuarterYear(String yearStarts, Date date) {
        String fiscalQuarterNumber = getFiscalQuarter(yearStarts, date);
        int year = DateUtil.getInstance().getYearByGivenDate(date);
        String fiscalQuarterYear = NumberUtil.getString(year) + "Q" + fiscalQuarterNumber;
        return fiscalQuarterYear;
    }

    public String getFiscalQuarter(String yearStarts, Date date) {
        String fiscalQuarterNumber = "";
        List<Date> quarterlyDates = getQuaterlyDatesBetweenDates(yearStarts, DateUtil.getInstance().getYearStartDate(date, 0), DateUtil.getInstance().getYearEndDate(date, 0));
        int quarterlyCount = 1;
        for (Date quarterlyDate : quarterlyDates) {
            if (date.after(quarterlyDate)
                    && date.before(DateUtil.getInstance().addMonthsToDate(quarterlyDate, 3))) {
                fiscalQuarterNumber = NumberUtil.getString(quarterlyCount);
                break;
            }
            quarterlyCount++;
        }
        return fiscalQuarterNumber;
    }

    public List<Date> getQuaterlyDatesBetweenDates(String yearStarts, Date startDate, Date endDate) {
        List<Date> dates = new ArrayList<Date>();
        int yearBegin = 0;
        if (StringUtil.isEqual(yearStarts, "Jan") ||
                StringUtil.isEqual(yearStarts, "January")) {
            yearBegin = 0;
        } else if (StringUtil.isEqual(yearStarts, "Apr") ||
                StringUtil.isEqual(yearStarts, "April")) {
            yearBegin = 3;
        }
        Calendar calendarBegin = getCalendarInstance();
        Calendar calendarEnd = getCalendarInstance();
        Calendar selectedStartDate = getCalendarInstance();
        selectedStartDate.setTime(startDate);

        calendarBegin.set(Calendar.MONTH, yearBegin);
        calendarBegin.set(Calendar.DATE, 1);
        calendarBegin.set(Calendar.YEAR, selectedStartDate.get(Calendar.YEAR));

        calendarEnd.setTime(endDate);
        calendarEnd.setTime(endDate);

        dates.add(calendarBegin.getTime());
        for (; calendarBegin.getTime().before(calendarEnd.getTime()); ) {
            calendarBegin.add(Calendar.MONTH, +3);
            if (calendarEnd.getTime().after(calendarBegin.getTime())) {
                dates.add(calendarBegin.getTime());
            }
        }
        return dates;
    }

    public Integer getWeekNumberFromDate(Date date) {
        int weekNumber = 0;
        Calendar calendar = getCalendarInstance();
        calendar.setTime(date);
        weekNumber = calendar.get(Calendar.WEEK_OF_YEAR);
        return weekNumber;
    }


    public String getWeekCountStartDayMonday(Date date) {
        String weekCount = "";
        Calendar cal = getCalendarInstance();
        cal.setTime(date);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setMinimalDaysInFirstWeek(7);
        weekCount = NumberUtil.getString(cal.get(Calendar.WEEK_OF_YEAR));
        return weekCount;
    }

    public Date getPrevWeekStartDate(Date date) {
        Calendar c = getCalendarInstance();
        c.setTime(date);
        c.setFirstDayOfWeek(Calendar.MONDAY);
        int i = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
        c.add(Calendar.DATE, -i - 7);
        Date start = c.getTime();
        return start;
    }

    public Date getPrevWeekEndDate(Date date) {
        Calendar c = getCalendarInstance();
        c.setTime(date);
        c.setFirstDayOfWeek(Calendar.MONDAY);
        int i = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
        c.add(Calendar.DATE, -i - 7);
        c.add(Calendar.DATE, 6);
        Date end = c.getTime();
        return end;
    }

    public boolean isValidDateField(String cellValue, DateFormat format) {
        boolean flag = false;
        if (StringUtil.isNotNullOrEmpty(cellValue)) {
            Date date = DateUtil.getInstance().parseString(cellValue, format);
            flag = true;
            if (date == null) {
                flag = false;
            }
        }
        return flag;
    }

    public Date getPreviousMonthSecondMondayDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK_IN_MONTH, 2);
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);
        return cal.getTime();
    }

    public boolean isFirstMonth(Date date) {
        boolean isFirstMonth = false;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int monthNumber = cal.get(Calendar.MONTH);
        if (monthNumber == 0) {
            isFirstMonth = true;
        }
        return isFirstMonth;
    }

    public boolean isLastMonth(Date date) {
        boolean isFirstMonth = false;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int monthNumber = cal.get(Calendar.MONTH);
        if (monthNumber == 11) {
            isFirstMonth = true;
        }
        return isFirstMonth;
    }

    public Date getPreviousMonthFirstMondayDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);
        return cal.getTime();
    }

    public Date getCurrentMonthLastMondayDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(GregorianCalendar.DAY_OF_WEEK_IN_MONTH, -1);
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);
        return cal.getTime();
    }

    public Date getNextMonthFirstMondayDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 1);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);
        return cal.getTime();
    }

    public boolean listOfDatesAreEqual(List<Date> dates, Date comparableDate) {
        boolean isEqual = false;
        if (ListUtil.isNotNullOrEmpty(dates)) {
            for (Date date : dates) {
                isEqual = isDateEqual(comparableDate, date);
                if (!isEqual) {
                    break;
                }
            }
        }
        return isEqual;
    }


    public boolean isDayAsSunday(Date date) {
        boolean isGivenDayDate = false;
        if (date != null) {
            Calendar cal = getCalendar(date);
            cal.setTime(date);
            if ((cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
                isGivenDayDate = true;
            }
        }
        return isGivenDayDate;
    }

    public Date setTimeForDate(Date date, String mergetime) {

        String splitedTime[] = mergetime.split(":");
        Calendar cal1 = getCalendar(date);
        cal1.setTime(date);
        cal1.set(Calendar.HOUR_OF_DAY, Integer.parseInt(splitedTime[0]));
        cal1.set(Calendar.MINUTE, Integer.parseInt(splitedTime[1]));
        cal1.set(Calendar.SECOND, Integer.parseInt(splitedTime[2]));
        Date modifiedDate = cal1.getTime();
        return modifiedDate;
    }

    public boolean isGivenDayDate(String dateStr, int day) {
        boolean isGivenDayDate = false;
        Date date = parseString(dateStr);
        if (date != null) {
            Calendar cal = getCalendar(date);
            cal.setTime(date);
            if ((cal.get(Calendar.DAY_OF_WEEK) == day)) {
                isGivenDayDate = true;
            }
        }
        return isGivenDayDate;
    }

    public boolean isGivenDayDate(Date date, int day) {
        boolean isGivenDayDate = false;
        if (date != null) {
            Calendar cal = getCalendar(date);
            cal.setTime(date);
            if ((cal.get(Calendar.DAY_OF_WEEK) == day)) {
                isGivenDayDate = true;
            }
        }
        return isGivenDayDate;
    }

    public boolean isGivenDayDates(List<String> dateList, int day) {
        boolean isGivenDayDates = false;
        if (ListUtil.isNotNullOrEmpty(dateList)) {
            for (String date : dateList) {
                isGivenDayDates = isGivenDayDate(date, day);
                if (isGivenDayDates) {
                    break;
                }
            }
        }
        return isGivenDayDates;
    }

    public String parseDate(Date date, DateFormat dateFormat) {
        String dateString = "";
        if (date != null) {
            dateString = dateFormat != null ? dateFormat.format(date) : parseDate(date);
        }
        return dateString;
    }

    public Date getDateByMonthandWeekOfMonth(String month, int weekOfMonth) throws ParseException {
        Date date;
        date = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(month);
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);
        int monthNumber = cal1.get(Calendar.MONTH);
//		 System.out.println(month);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, monthNumber);
        cal.set(Calendar.WEEK_OF_MONTH, 5);
//			cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        System.out.println(cal.getTime());
        return null;
    }

    public List<Date> sortDatesAsc(List<Date> dates) {
        if (ListUtil.isNotNullOrEmpty(dates)) {
            Collections.sort(dates, new Comparator<Date>() {
                @Override
                public int compare(Date o1, Date o2) {
                    if (o1.after(o2)) {
                        return 1;
                    } else if (o1.before(o2)) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });
        }
        return dates;
    }

    public int getMonthNumber(String month) {
        int monthCount = 0;

        switch (month) {
            case "January":
            case "Jan":
                monthCount = 1;
                break;

            case "Feburary":
            case "Feb":
                monthCount = 2;
                break;

            case "March":
            case "Mar":
                monthCount = 3;
                break;

            case "April":
            case "Apr":
                monthCount = 4;
                break;

            case "May":
                monthCount = 5;
                break;

            case "June":
            case "Jun":
                monthCount = 6;
                break;

            case "July":
            case "Jul":
                monthCount = 7;
                break;

            case "August":
            case "Aug":
                monthCount = 8;
                break;

            case "September":
            case "Sep":
                monthCount = 9;
                break;

            case "October":
            case "Oct":
                monthCount = 10;
                break;

            case "November":
            case "Nov":
                monthCount = 11;
                break;

            case "December":
            case "Dec":
                monthCount = 12;
                break;

            default:
                monthCount = 0;
        }

        return monthCount;
    }

    public int getDayOfWeek(Date date) {
        int dayOfWeek;
        Calendar calendar = getCalendar(date);
        dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek;
    }

    public Date getWeekSaturdayDateByGivenDate(Date currentDate) {
        Calendar cal = getCalendarInstance();
        cal.setTime(currentDate);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        System.out.println(currentDate + "----------" + cal.getTime());
        return cal.getTime();
    }

    public String parseDatewithseconds(Date date) {

        String date2 = null;
        DateFormat formatter;
        formatter = new SimpleDateFormat("dd-MMM-yyyy HHmmss");
        date2 = (String) formatter.format(date);
        //date2.replace(date2, newChar)

        return date2;
    }

    public Date getWeekStartDayAsSunday(Date currentDate) {
        Calendar cal = getCalendarInstance();
        cal.setTime(currentDate);
        cal.setFirstDayOfWeek(Calendar.SUNDAY);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return cal.getTime();
    }

}
