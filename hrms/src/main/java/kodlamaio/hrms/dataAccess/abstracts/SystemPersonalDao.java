package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.SystemPersonal;

public interface SystemPersonalDao extends JpaRepository<SystemPersonal, Integer>{

}
