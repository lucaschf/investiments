package tsi.too.investmentcalculation.ext;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class StringExt {
    public static String removeLastChar (final String source) {
        return source.replaceFirst(".$", "");
    }

    /**
     * Parses the string as a [long] number and returns the result.
     * @param str the string to be parsed.
     * @return the long value represented by the string or zero if the string cannot be parsed.
     */
    public static long toLong(final String str) {
        try {
            return Long.parseLong(str.trim());
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    /**
     * Parses the string as a [Int] number and returns the result.
     * @param str the string to be parsed.
     * @return the int value represented by the string or zero if the string cannot be parsed.
     */
    public static int toInt(final String str) {
        try {
            return Integer.parseInt(str.trim());
        } catch (NumberFormatException ex) {
            return 0;
        }
    }
    
    /**
     * Parses the string as a [Double] number and returns the result.
     * @param str the string to be parsed.
     * @return the double value represented by the string or zero if the string cannot be parsed.
     */
    public static double toDouble(final String str) {
    	try {
    		return Double.parseDouble(str.trim());
    	} catch (NumberFormatException ex) {
    		return 0;
    	}
    }

    /**
     * Parses the string as a [float] number and returns the result.
     * @param str the string to be parsed.
     * @return the double value represented by the string or zero if the string cannot be parsed.
     */
    public static float toFloat(final String str) {
        try {
            return Float.parseFloat(str.trim());
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    /**
     * Parses the string as a [BigDecimal] number and returns the result.
     * @param str the string to be parsed.
     *
     * @return the double value represented by the string or zero if the string cannot be parsed.
     */
    public static BigDecimal toBigDecimal(final String str) {
        try {
            return new BigDecimal(str.trim());
        } catch (NumberFormatException ex) {
            return BigDecimal.ZERO;
        }
    }

    /**
	 * Tries to parse a string to a local Date using the Brazilian pattern(dd/MM/yyyy).
	 * 
	 * @param s the string to be parsed
	 * @return the correspondent local date or null if can not be parsed.
	 */
    public static LocalDate toBrazilianLocalDateOrNull(String s) {
		try {
			DateTimeFormatter formater = DateTimeFormatter.ofPattern(LocalDateTimeExt.BRAZILIAN_DATE_PATTERN);
			return LocalDate.parse(s.trim(), formater);
		}catch (Exception e) {
			return null;
		}
	}
}