package com.stock.apistock.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.apistock.repository.StockRepository;
import com.stock.apistock.models.Stock;

@RestController
@RequestMapping(value = "/api")
public class StockResource {
	@Autowired
	StockRepository stockRepository;
	
	@GetMapping("/stocks")
	public List<Stock> listaStocks(){
		return stockRepository.findAll();
	}
	
	@GetMapping("/stock/{name}")
	public Stock listaStockUnico(@PathVariable(value = "name") String name){
		return stockRepository.findByName(name);
	}
	
	@PostMapping("/stock")
	public Stock salvaStock(@RequestBody Stock stock) {
		return stockRepository.save(stock);
	}
	
	@DeleteMapping("/stock")
	public void deletaStock(@RequestBody Stock stock) {
		stockRepository.delete(stock);
	}
	
	@PutMapping("/stock")
	public Stock atualizaStock(@RequestBody Stock stock) {
		return stockRepository.save(stock);
	}
	
	@PatchMapping("/stock/{name}")
	public Stock patchStock(@PathVariable(value = "name") String name, @RequestBody Stock stock) {
		Stock obj = stockRepository.findByName(name);
		obj.getQuotes().addAll(stock.getQuotes());
		return stockRepository.save(obj);
	}
}
