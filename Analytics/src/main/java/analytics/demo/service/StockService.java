package analytics.demo.service;

import java.util.List;

import analytics.demo.domain.StockPE;

public interface StockService {
	public List<StockPE> getStockPEs(String ticker);
	public List<StockPE> getAllStocks();
}
