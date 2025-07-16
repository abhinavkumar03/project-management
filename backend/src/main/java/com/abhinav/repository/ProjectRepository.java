package com.abhinav.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abhinav.model.Project;
import com.abhinav.model.User;

public interface ProjectRepository extends JpaRepository<Project, Long> {
	 List<Project> findByOwner(User owner);



	List<Project> findByNameContainingAndTeamContains(String partialName, User user);
	List<Project> findByNameContainingAndTeamContaining(String partialName, User user);

	@Query("SELECT p FROM Project p JOIN p.team t WHERE t = :user")
	List<Project> findProjectsByTeam(@Param("user") User user);

	List<Project> findByTeamContainingOrOwner(User user,User owner);

}
