package tsi.too.investmentcalculation.ext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class LocalDateTimeExt {
	public static final String BRAZILIAN_DATE_PATTERN = "dd/MM/yyy";

	public static String toBrazilianDateString(final LocalDate date) {
		return date.format(DateTimeFormatter.ofPattern(BRAZILIAN_DATE_PATTERN));
	}
}