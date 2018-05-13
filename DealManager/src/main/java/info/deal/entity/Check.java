package info.deal.entity;

import java.io.FileReader;
import java.io.IOException;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.StrRegEx;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import info.deal.dto.DealDto;

public class Check {

	static final String CSV_FILENAME = "E:\\data.txt";
	private static final CsvPreference PIPE_DELIMITED = new CsvPreference.Builder('"', ';', "\n").build();

	public static void main(String[] args) throws IOException {
		try (ICsvBeanReader beanReader = new CsvBeanReader(new FileReader(CSV_FILENAME), PIPE_DELIMITED)) {
			// the header elements are used to map the values to the bean
			// final String[] headers = beanReader.getHeader(true);
			final String[] headers = new String[] { "orderNumber", "fromDate", "toDate", "amount", "amountPeriod" };
			final CellProcessor[] processors = getProcessors();

			DealDto deal;
			while ((deal = beanReader.read(DealDto.class, headers, processors)) != null) {
				System.out.println(deal);
			}
		}
	}

	/**
	 * Sets up the processors used for the examples.
	 */
	private static CellProcessor[] getProcessors() {

		final CellProcessor[] processors = new CellProcessor[] { 
				new NotNull(), // orderNumber
				new ParseDate("dd-MM-yyyy"), // fromDate
				new ParseDate("dd-MM-yyyy"), // toDate
				new NotNull(), // amount
				new NotNull(), // amountPeriod
//				new NotNull(new ParseInt()) // active
		};
		return processors;
	}
}
