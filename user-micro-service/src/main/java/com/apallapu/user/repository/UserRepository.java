/**
 * 
 */
package com.apallapu.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.apallapu.user.domain.User;

/**
 * @author ankamma pallapu
 *
 */
public interface UserRepository extends CrudRepository<User, Integer>{
	
}
