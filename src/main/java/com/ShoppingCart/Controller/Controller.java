package com.ShoppingCart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ShoppingCart.Entity.Item;
import com.ShoppingCart.Mapper.ItemMapping;
import com.ShoppingCart.Service.ShoppingCartService;


@RestController
public class Controller {
	
	@Autowired
	private ShoppingCartService cartService;

	
	@PostMapping("/addItem")
	public ResponseEntity<String> addItem(@RequestBody Item item)
	{   
		String response = cartService.addItem(item);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping("/getItems")
	public ResponseEntity<List<Item>> getItems()
	{
		List<Item> items = cartService.getItems();
		return new ResponseEntity<>(items,HttpStatus.OK);
	}
	
	@GetMapping("/brand/{brand}")
	public ResponseEntity<List<Item>> getByBrand(@PathVariable String brand)
	{
		List<Item> items = cartService.getByBrand(brand);
		return new ResponseEntity<>(items,HttpStatus.OK);
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Item>> getByCategory(@PathVariable String category)
	{
		List<Item> items = cartService.getByCategory(category);
		return new ResponseEntity<>(items,HttpStatus.OK);
	}
	
	
	@PostMapping("/deleteItem/{id}")
	public ResponseEntity<String> deleteItem(@PathVariable int id)
	{
		String response = cartService.deleteItem(id);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping("/updateItem")
	public ResponseEntity<String> updateItem(@RequestBody Item item)
	{
		String response = cartService.updateItem(item);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
