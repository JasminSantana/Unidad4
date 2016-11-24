package boot.dao;

import org.springframework.data.repository.CrudRepository;

import boot.model.Bill;

public interface BillRepository extends CrudRepository<Bill, Integer>{

}
