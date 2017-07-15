package Asek.Asekapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Asek.Asekapi.User;
import Asek.Asekapi.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Object findAll() {
		return userRepository.findAll();
	}
	public User findById(Long id) {
		return userRepository.findOne(id);
		}
	public User save(User user) {
		return userRepository.save(user);
	}
	public void delete(User user) {
		userRepository.delete(user);
		return;
	}
	public User findByName(String email) {
		return null;
	}
	
}
