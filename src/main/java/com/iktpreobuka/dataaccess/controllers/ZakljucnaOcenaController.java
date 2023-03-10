package com.iktpreobuka.dataaccess.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
		
		private final Logger logger = LoggerFactory.getLogger(ZakljucnaOcenaController.class);
		
		@RequestMapping(method = RequestMethod.POST)
		public ZakljucnaOcena addZakljucnaOcena (@RequestBody ZakljucnaOcena zakljucnaOcena) {
			logger.info("Pokrenuta je metoda Zakljucna ocena");
			ZakljucnaOcena novaZakljucnaOcena = new ZakljucnaOcena();
			novaZakljucnaOcena.setZakljucnaOcena (zakljucnaOcena.getZakljucnaOcena());
			zakljucnaOcenaRepository.save(novaZakljucnaOcena);
			return novaZakljucnaOcena;
		}
		
}
