package com.iktpreobuka.dataaccess.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.dataaccess.entities.Admin;
import com.iktpreobuka.dataaccess.entities.UlogaKorisnik;
import com.iktpreobuka.dataaccess.repositories.AdminRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	public AdminRepository adminRepository;
	
	private final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@RequestMapping(method = RequestMethod.POST)
	public Admin addAdmin (@RequestBody Admin admin) {
		logger.info("Pokrenuta je metoda Admin");
		Admin noviAdmin = new Admin();
		noviAdmin.setIme(admin.getIme());
		noviAdmin.setPrezime(admin.getPrezime());
		noviAdmin.setKorisnickoIme(admin.getKorisnickoIme());
		noviAdmin.setLozinka(admin.getLozinka());
		noviAdmin.setUlogaKorisnik(UlogaKorisnik.Korisnik_ADMIN);
		 adminRepository.save(noviAdmin);
		 return noviAdmin ;
	}
	
	@RequestMapping(method=RequestMethod.GET,value= "/lista administratora")
	public Iterable<Admin>getAdmin(){
		return adminRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/update/{id}")
	public Admin updateAdmin (@RequestBody Admin admin,@PathVariable int id) {
		Admin noviAdmin = new Admin();
		noviAdmin.setId(id);
		noviAdmin.setIme(admin.getIme());
		noviAdmin.setPrezime(admin.getPrezime());
		noviAdmin.setKorisnickoIme(admin.getKorisnickoIme());
		noviAdmin.setLozinka(admin.getLozinka());
		noviAdmin.setUlogaKorisnik(UlogaKorisnik.Korisnik_ADMIN);
		 adminRepository.save(noviAdmin);
		 return noviAdmin ;
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value="/delete/{id}")
	public String delete(@PathVariable int id) {
		adminRepository.deleteById(id);
		return "Admin sa id brojem " + id  + " je izbrisan.";
	}
	

}
