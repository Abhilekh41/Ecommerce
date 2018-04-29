package com.baja.ecommercebackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.baja.ecommercebackend.dao.CategoryDAO;
import com.baja.ecommercebackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categoryList = new ArrayList<Category>();
	static {
		Category category = new Category();
		category.setId(1);
		category.setDescription("This is for Television");
		category.setName("BPL");
		category.setImageURL("CAT_1.png");
		
		Category category2 = new Category();
		category2.setId(2);
		category2.setDescription("This is for Mobile");
		category2.setName("Mobile");
		category2.setImageURL("CAT_2.png");
		
		Category category3 = new Category();
		category3.setId(3);
		category3.setDescription("This is for Laptop");
		category3.setName("Laptop");
		category3.setImageURL("CAT_3.png");
		
		categoryList.add(category);
		categoryList.add(category3);
		categoryList.add(category2);
	}
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categoryList;
	}

}
