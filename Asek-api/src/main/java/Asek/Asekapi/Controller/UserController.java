package Asek.Asekapi.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Asek.Asekapi.User;
import Asek.Asekapi.service.UserService;

@RestController
@RequestMapping("/start")
public class UserController {

	@Autowired
	private UserService userService;
	@RequestMapping("lol")
	public String txt() {
		return "papa";
	}
		
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ResponseBody
	public Object index() {
		return userService.findAll();
	}

	@RequestMapping(value = "/create", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String create(@RequestBody User user) {
		String userId = "";
		try {
			userService.save(user);
			userId = String.valueOf(user.getId());
		} catch (Exception ex) {
			return "error creating the user: " + ex.toString();
		}
		return "User succesfully created with id = " + userId;
	}
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public String delete(@PathVariable long id) {
		try {
			User user = userService.findById(id);
			userService.delete(user);
		} catch (Exception ex) {
			return "error deleting user: " + ex.toString();
		}
		return "User succesfully deleted ";
	}
	@RequestMapping("/get-by-email")
	@ResponseBody
	public String getByEmail(String email) {
		String userId ="";
		try {
			User user = userService.findByName(email);
			userId = String.valueOf(user.getId());
		}
		catch (Exception ex) {
			return "User not found";
			}
		return "The user id is: " + userId;
	}

	@RequestMapping("/update/{id}")
	@ResponseBody
	public String updateUser(@RequestBody User user,@PathVariable Long id) {
		try {
			user.setId(id);
			userService.save(user);
			}
		catch (Exception ex) {
			return "error updating the user " +ex.toString();
			}
		return "User updated sucesfully";
	}
}
