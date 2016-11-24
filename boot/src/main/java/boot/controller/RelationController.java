package boot.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.RelationComposition;
import boot.service.RelationCompositionService;

@Controller
public class RelationController {
	@Autowired
	private RelationCompositionService relationCompositionService ;
	
	@GetMapping("relation")
	public String home(HttpServletRequest request){
		request.setAttribute("mode","MODE_HOME");
		return "relation";
	}
	
	@GetMapping("/all-relationCompositions")
	public String allRelationCompositions(HttpServletRequest request){
		request.setAttribute("relation_composition",relationCompositionService.findAll());
		request.setAttribute("mode","MODE_RELATIONS");
		return "relation";
	}
	
	@GetMapping("/new-relationComposition")
	public String newRelationComposition(HttpServletRequest request){
		request.setAttribute("mode","MODE_NEW");
		return "relation";
	}
	@PostMapping("/save-relationComposition")
	public String saveRelationComposition(@ModelAttribute RelationComposition relationComposition,BindingResult bindingResult, HttpServletRequest request){
		relationCompositionService.save(relationComposition);
		request.setAttribute("relation_composition",relationCompositionService.findAll());
		request.setAttribute("mode","MODE_RELATIONS");
		return "relation";
	}
	
	@GetMapping("/update-relationComposition")
	public String updateRelationComposition(@RequestParam int id,HttpServletRequest request){
		request.setAttribute("relationComposition",relationCompositionService.findRelationComposition(id));
		request.setAttribute("mode","MODE_UPDATE");
		return "relation";
	}
	@GetMapping("/delete-relationComposition")
	public String deleteRelationComposition(@RequestParam int id,HttpServletRequest request){
		relationCompositionService.delete(id);
		request.setAttribute("relation_composition",relationCompositionService.findAll());
		request.setAttribute("mode","MODE_RELATIONS");
		return "relation";
	}
}
