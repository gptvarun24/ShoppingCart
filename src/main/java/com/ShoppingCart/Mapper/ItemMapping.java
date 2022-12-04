package com.ShoppingCart.Mapper;

import org.springframework.stereotype.Component;

import com.ShoppingCart.Entity.Item;

@Component
public class ItemMapping {

	public Item compareItems(Item dbItem, Item newItem)
	{
		if(!dbItem.getBrand().equals(newItem.getBrand()))
		{
			dbItem.setBrand(newItem.getBrand());
		}
		if(!dbItem.getCategory().equals(newItem.getCategory()))
		{
			dbItem.setCategory(newItem.getCategory());
		}
		if(dbItem.getPrice() !=(newItem.getPrice()))
		{
			dbItem.setPrice(newItem.getPrice());
		}
		if(dbItem.getQuantity() !=(newItem.getQuantity()))
		{
			dbItem.setQuantity(newItem.getQuantity());
		}
		return dbItem;
	}
}
