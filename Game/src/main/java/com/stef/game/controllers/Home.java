package com.stef.game.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stef.game.models.Dojo;
import com.stef.game.models.Ninja;
import com.stef.game.services.DojoService;
import com.stef.game.services.NinjaService;

@Controller
public class Home {
	
	private final DojoService dojoServ;
	private final NinjaService ninjaServ;
	public Home(DojoService dojoServ, NinjaService ninjaServ) {
		this.dojoServ = dojoServ;
		this.ninjaServ = ninjaServ;
	}

// --        *    routes     * ----      
	@RequestMapping("/dojos/new")
	public String index(@ModelAttribute("dojo") Dojo dojo, Model model) {
		List<Dojo> dojos = dojoServ.allDojos();
		model.addAttribute("dojos", dojos);
		return "index.jsp";
		}
	@RequestMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoServ.allDojos();
		model.addAttribute("dojos", dojos);
		return "newNinja.jsp";
		}
	@RequestMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoServ.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "showDojo.jsp";
	}
	
	//     --      *      create ninja
	
	
	
	@RequestMapping(value="/createninja", method=RequestMethod.POST)
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
		List<Dojo> dojos = dojoServ.allDojos();// why is the value not used if im passing it on the model and correlating it  the rendering page?
		return "newNinja.jsp";
		} else {
			ninjaServ.createNinja(ninja);
			return "showDojo.jsp";
		}
	}
	//    --     *         create dojo
	@RequestMapping(value="/createdojo", method=RequestMethod.POST)
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if(result.hasErrors()) {

		return "index.jsp";
		} else {
			dojoServ.createDojo(dojo);
			return "showDojo.jsp";
	}
	}
	
}