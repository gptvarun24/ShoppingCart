package com.ShoppingCart.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShoppingCart.Entity.Item;
import com.ShoppingCart.Exception.ShoppingCartException;
import com.ShoppingCart.Mapper.ItemMapping;
import com.ShoppingCart.Repository.ShoppingCartInterface;

@Service
public class ShoppingCartService {
	
	@Autowired
	private ShoppingCartInterface cartRepository;
	
	@Autowired
	private ItemMapping itemMapper;
	
	public String addItem(Item item)
	{
		cartRepository.save(item);
		return "Item saved Succesfully" ;
	}

	public List<Item> getItems()
	{
		List<Item> listItems = cartRepository.findAll();
		return listItems;
	}
	
	public List<Item> getByBrand(String brand)
	{
		List<Item> listItems = cartRepository.findByBrand(brand);
		return listItems;
	}
	
	public List<Item> getByCategory(String category)
	{
		List<Item> listItems = cartRepository.findByCategory(category);
		return listItems;
	}
	
	public String deleteItem(int id)
	{
		Optional<Item> item = cartRepository.findById(id);
		if(item.isPresent())
		{
			cartRepository.deleteById(id);
			return "Item deleted successfully" ;
		}else
		{
			throw new ShoppingCartException("Item details not found");
		}
		
	}
	
	public String updateItem(Item item)
	{
		Optional<Item> optionalItem = cartRepository.findById(item.getId());
		if(optionalItem.isPresent())
		{  
			Item dbItem = optionalItem.get();
			Item itemResponse = itemMapper.compareItems(dbItem,item);
			cartRepository.save(itemResponse);
			return "Item Updated successfully" ;
		}else
		{
			throw new ShoppingCartException("Item details not found");
		}
		
	}
}
