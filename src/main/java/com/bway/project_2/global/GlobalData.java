package com.bway.project_2.global;

import java.util.ArrayList;
import java.util.List;

import com.bway.project_2.model.Product;

public class GlobalData {
	
	public static List<Product> cart;
	static {
		cart = new ArrayList<Product>();
	}

}
