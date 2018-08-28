package info.deal.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import info.deal.builder.DealBuilder;
import info.deal.dao.DealDAO;
import info.deal.entity.Deal;
import info.deal.entity.Systems;

/**
 * 
 * @author Andrzej
 * 
 *         Service layer of the application.
 *
 */
@Service
@Transactional
public class DealServiceImpl implements DealService {

	final static Logger logger = Logger.getLogger(DealServiceImpl.class);

	@Autowired
	DealDAO dealDAO;

	public List<Deal> getDeals() {
		logger.info("Entering to DealServiceImpl, getDeals()");
		return dealDAO.getDeals();
	}

	public List<Deal> getActiveDeals() {
		logger.info("Entering to DealServiceImpl, getActiveDeals()");
		return dealDAO.getActiveDeals();
	}

	public Deal findById(long theId) {
		logger.info("Entering to DealServiceImpl, findById()");
		return dealDAO.findById(theId);
	}

	public Deal saveDeal(Deal theDeal) {
		logger.info("Entering to DealServiceImpl, saveDeal()");
		dealDAO.saveDeal(theDeal);
		return theDeal;
	}

	public Deal disableDeal(long theId) {
		logger.info("Entering to DealServiceImpl, disableDeal()");
		Deal theDeal = dealDAO.findById(theId);
		if (theDeal != null) {
			theDeal.setActive(0);
		}
		return theDeal;
	}

	public List<DealBuilder> importCsv() throws FileNotFoundException, IOException {
		final String CSV_FILENAME = "E:\\data.txt";
		final CsvPreference PIPE_DELIMITED = new CsvPreference.Builder('"', ';', "\n").build();
		logger.info("Entering to DealServiceImpl, importCsv()");

		List<DealBuilder> results = new ArrayList<DealBuilder>();// list to display results of conversion

		try (ICsvBeanReader beanReader = new CsvBeanReader(new FileReader(CSV_FILENAME), PIPE_DELIMITED)) {
			final String[] headers = beanReader.getHeader(true);
			final CellProcessor[] processors = getProcessors();
			DealBuilder dealDto;
			while ((dealDto = beanReader.read(DealBuilder.class, headers, processors)) != null) {
				results.add(dealDto);
				Deal deal = new Deal();
				deal.setOrderNumber(dealDto.getOrderNumber());
				deal.setFromDate(dealDto.getFromDate());
				deal.setToDate(dealDto.getToDate());
				deal.setAmount(dealDto.getAmount());
				deal.setAmountPeriod(dealDto.getAmountPeriod());
				deal.setActive(dealDto.getActive());
				Systems system = new Systems();
				system.setId(dealDto.getSystems());
				deal.setSystems(system);
				dealDAO.saveDeal(deal);
			}
		} catch (FileNotFoundException e) {
			logger.info("File not found to Mapping from Csv to Java Bean");
			e.printStackTrace();
		} catch (IOException e) {
			logger.info("I/O exception at import occur");
			e.printStackTrace();
		}
		return results;
	}

	private CellProcessor[] getProcessors() {
		final CellProcessor[] processors = new CellProcessor[] { new NotNull(), // orderNumber
				new NotNull(new ParseDate("dd-MM-yyyy")), // fromDate
				new NotNull(new ParseDate("dd-MM-yyyy")), // toDate
				new NotNull(), // amount
				new NotNull(), // amountPeriod
				new NotNull(new ParseInt()), // active
				new NotNull(new ParseLong()),// systemId
		};
		return processors;
	}

}
