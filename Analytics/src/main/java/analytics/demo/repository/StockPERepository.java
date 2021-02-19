package analytics.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import analytics.demo.domain.StockPE;

@Repository
public interface StockPERepository extends CrudRepository<StockPE, Long> {

	StockPE findByTicker(String ticker);
	StockPE findByCompany(String name);
	List<StockPE> findAll();
	long count();
	
}