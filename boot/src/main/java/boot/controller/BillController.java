package boot.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Bill;
import boot.service.BillService;
@Controller
public class BillController {

	@Autowired
	private BillService billService;
	
	@GetMapping("bill")
	public String home(HttpServletRequest request){
		request.setAttribute("mode","MODE_HOME");
		return "bill";
	}
	
	@GetMapping("/all-bills")
	public String allBills(HttpServletRequest request){
		request.setAttribute("bills",billService.findAll());
		request.setAttribute("mode","MODE_BILLS");
		return "bill";
	}
	
	@GetMapping("/new-bill")
	public String newBill(HttpServletRequest request){
		request.setAttribute("mode","MODE_NEW");
		return "bill";
	}
	@PostMapping("/save-bill")
	public String saveBill(@ModelAttribute Bill bill,BindingResult bindingResult, HttpServletRequest request){
		billService.save(bill);
		request.setAttribute("bills",billService.findAll());
		request.setAttribute("mode","MODE_BILLS");
		return "bill";
	}
	
	
	@GetMapping("/update-bill")
	public String updateBill(@RequestParam int id_bill,HttpServletRequest request){
		request.setAttribute("bill",billService.findBill(id_bill));
		request.setAttribute("mode","MODE_UPDATE");
		return "bill";
	}
	@GetMapping("/delete-bill")
	public String deleteBill(@RequestParam int id_bill,HttpServletRequest request){
		billService.delete(id_bill);
		request.setAttribute("bills",billService.findAll());
		request.setAttribute("mode","MODE_BILLS");
		return "index";
	}
	
}
