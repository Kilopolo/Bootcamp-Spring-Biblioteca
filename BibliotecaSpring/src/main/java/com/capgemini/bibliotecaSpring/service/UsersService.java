package com.capgemini.bibliotecaSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.bibliotecaSpring.model.User;
import com.capgemini.bibliotecaSpring.repositorio.UsersRepository;
import com.capgemini.bibliotecaSpring.service.serviceImpl.ServiceImpl;

@Service
public class UsersService extends ServiceImpl<UsersRepository, User>   implements UserService {
	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

//	@PostConstruct
//	public void init() {
//	}
//
//	public Page<User> getUsers(Pageable pageable) {
////		Page<User> users = new PageImpl<User>(new LinkedList<User>());
//
//		Page<User> users = usersRepository.findAll(pageable); // .forEach(users::add)
//		return users;
//	}
//
//	public List<User> getUsers() {
//		List<User> users = new ArrayList<User>();
//
//		usersRepository.findAll().forEach(users::add); //
//		return users;
//	}
//
//	public User getUser(Long id) {
//		return usersRepository.findById(id).get();
//	}
	

	public void addUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		usersRepository.save(user);
	}
//
//	public void editUser(User user) {
//		usersRepository.save(user);
//	}
//
	public User getUserByEmail(String email) {
		return usersRepository.findByEmail(email);
	}
//
//	public void deleteUser(Long id) {
//		usersRepository.deleteById(id);
//	}





}