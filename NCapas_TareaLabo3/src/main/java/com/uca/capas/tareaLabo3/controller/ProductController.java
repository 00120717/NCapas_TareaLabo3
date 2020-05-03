package com.uca.capas.tareaLabo3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.tareaLabo3.domain.Product;

@Controller
public class ProductController {

	private List<Product> productos = new ArrayList<Product>();
	
	@GetMapping("/comprarProducto")
	public ModelAndView comprarProducto() {
		
		ModelAndView mav = new ModelAndView();
		productos.add(new Product(0, "Fortnite", 40));
		productos.add(new Product(1, "COD Warzone", 20));
		productos.add(new Product(2, "GTA SA", 10));
		productos.add(new Product(3, "Need For Speed", 25));
		productos.add(new Product(4, "Pac-Man :v", 32));
		
		mav.setViewName("productos");
		mav.addObject("product",new Product());
		mav.addObject("producto",productos);
		return mav;
	}
	
	@PostMapping("/validar")
	public ModelAndView validar(Product product) {
		
		ModelAndView mav = new ModelAndView();
		if(productos.get(product.getId()).getCantidad()<product.getCantidad()) {
			mav.addObject("venta",productos.get(product.getId()).getNombre());
			mav.setViewName("/error");
			return mav;
		}else {
			mav.addObject("venta",productos.get(product.getId()).getNombre());	
			mav.setViewName("/compra");
			return mav;
		}
	}
}
