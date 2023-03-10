package com.iktpreobuka.dataaccess.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.dataaccess.entities.ZakljucnaOcena;
import com.iktpreobuka.dataaccess.repositories.ZakljucnaOcenaRepository;
@RestController
@RequestMapping("/ZakljucnaOcena")
public class ZakljucnaOcenaController {
		@Autowired
		public ZakljucnaOcenaRepository zakljucnaOcenaRepository;
		
		@RequestMapping(method = RequestMethod.POST)
		public ZakljucnaOcena addZakljucnaOcena (@RequestBody ZakljucnaOcena zakljucnaOcena) {
			ZakljucnaOcena novaZakljucnaOcena = new ZakljucnaOcena();
			novaZakljucnaOcena.setZakljucnaOcena (zakljucnaOcena.getZakljucnaOcena());
			zakljucnaOcenaRepository.save(novaZakljucnaOcena);
			return novaZakljucnaOcena;
		}
		
}
