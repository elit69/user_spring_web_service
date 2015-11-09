package com.lit.hw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lit.hw.entities.User;
import com.lit.hw.services.UserService;

@RestController
public class JsonsController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> list() {
		List<User> listStudent = userService.list();
		Map<String, Object> map = new HashMap<String, Object>();
		HttpStatus status = null;
		if (listStudent.isEmpty()) {
			map.put("MESSAGE", "USER NOT FOUND...");
			status = HttpStatus.NOT_FOUND;
		} else {
			map.put("RESPONSE_DATA", listStudent);
			status = HttpStatus.OK;
		}
		return new ResponseEntity<Map<String, Object>>(map, status);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> add(@RequestBody User usr) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpStatus status = null;
		if (userService.add(usr)) {
			map.put("MESSAGE", "STUDENT HAS BEEN INSERTED.");
			status = HttpStatus.CREATED;
		} else {
			map.put("MESSAGE", "STUDENT HAS NOT BEEN INSERTED.");
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<Map<String, Object>>(map, status);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpStatus status = null;
		if (userService.delete(id)) {
			map.put("MESSAGE", "STUDENT HAS BEEN DELETED.");
			status = HttpStatus.OK;
		} else {
			map.put("MESSAGE", "STUDENT HAS NOT BEEN DELETED.");
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<Map<String, Object>>(map, status);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Map<String, Object>> update(@RequestBody User usr, @PathVariable("id") int id) {
		usr.setId(id);
		Map<String, Object> map = new HashMap<String, Object>();
		HttpStatus status = null;
		if (userService.update(usr)) {
			map.put("MESSAGE", "STUDENT HAS BEEN UPDATED.");
			status = HttpStatus.OK;
		} else {
			map.put("MESSAGE", "STUDENT HAS NOT BEEN UPDATED.");
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<Map<String, Object>>(map, status);
	}

	@RequestMapping(value = "/search/{type}/{keyword}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> search(
			@PathVariable("type") String type,
			@PathVariable("keyword") String keyword) {
		System.out.println("sdfsdfsdfsdfasdfasd");
		List<User> listUser = userService.search(keyword, type);
		Map<String, Object> map = new HashMap<String, Object>();
		HttpStatus status = null;
		if (listUser.isEmpty()) {
			map.put("MESSAGE", "RECORD NOT FOUND.");
			status = HttpStatus.NOT_FOUND;
		} else {
			map.put("RESPONSE_DATA", listUser);
			status = HttpStatus.OK;
		}
		return new ResponseEntity<Map<String, Object>>(map, status);
	}
}
