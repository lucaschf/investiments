package tsi.too.investmentcalculation.ext;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public abstract class LocalDateTimeExt {
	public static final String BRAZILIAN_DATE_PATTERN = "dd/MM/yyyy";

	public static String toBrazilianDateString(final LocalDate date) {
		return date.format(DateTimeFormatter.ofPattern(BRAZILIAN_DATE_PATTERN));
	}
	
	public static int getIntervalInMonths(final LocalDate date, final LocalDate another) {
		var period = Period.between(date, another); 
		var monthsBetween = Math.abs(period.getMonths()) ;
		var yearsBetween = Math.abs(period.getYears()); 
		
		return monthsBetween + (yearsBetween * 12);
	}
}