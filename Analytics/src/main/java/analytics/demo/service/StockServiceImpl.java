package analytics.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import analytics.demo.domain.StockPE;
import analytics.demo.repository.StockPERepository;

@Service
public class StockServiceImpl implements StockService {
	@Autowired
	private StockPERepository stockPERepository;
	
	public List<StockPE> getStockPEs(String ticker) {
		ArrayList<StockPE> stockPEs = new ArrayList<StockPE>(6);
		if (ticker.equals("appl")) {
			stockPEs.add((StockPE) stockPERepository.findByTicker("google"));
			stockPEs.add((StockPE) stockPERepository.findByTicker("msft"));
			stockPEs.add((StockPE) stockPERepository.findByTicker("fb"));
			stockPEs.add((StockPE) stockPERepository.findByTicker("baba"));
			stockPEs.add((StockPE) stockPERepository.findByTicker("pypl"));
			stockPEs.add((StockPE) stockPERepository.findByTicker("aapl"));
		}
		return stockPEs;
	}
	public List<StockPE> getAllStocks() {
		return stockPERepository.findAll();
	}
}
