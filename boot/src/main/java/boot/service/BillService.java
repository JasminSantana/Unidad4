package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.BillRepository;
import boot.model.Bill;

@Service
@Transactional
public class BillService {
	private final BillRepository billRepository;

	public BillService(BillRepository billRepository) {
		super();
		this.billRepository = billRepository;
	}
	
	public List<Bill>findAll(){
		List<Bill> bills=new ArrayList<Bill>();
		for(Bill bill:billRepository.findAll()){
			bills.add(bill);
		}
		return bills;
	}
	
	public void save(Bill bill){
		billRepository.save(bill);
	}
	public void delete(int id_bill){
		billRepository.delete(id_bill);
	}
	public Bill findBill(int id_bill){
		return billRepository.findOne(id_bill);
	}
	
}
