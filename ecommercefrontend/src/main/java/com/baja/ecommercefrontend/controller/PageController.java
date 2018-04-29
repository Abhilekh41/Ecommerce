package com.baja.ecommercefrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baja.ecommercebackend.dao.CategoryDAO;

@Controller
public class PageController {
		
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value= {"/", "/home", "/index"})
	public ModelAndView index()
	{
		
		//passing list of categories
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userClickHome",true);
		return mv;
	}
	
	@RequestMapping(value= {"/about"})
	public ModelAndView about()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About us");
		mv.addObject("userClickAbout",true);
		return mv;
	}
	
	@RequestMapping(value= {"/contact"})
	public ModelAndView contact()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact");
		mv.addObject("userClickContact",true);
		return mv;
	}
	
	
}
