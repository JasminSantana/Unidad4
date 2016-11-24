package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.RelationCompositionRepository;
import boot.model.Bill;
import boot.model.RelationComposition;

@Service
@Transactional
public class RelationCompositionService {

	private final RelationCompositionRepository  relationCompositionRepository;

	public RelationCompositionService(RelationCompositionRepository relationCompositionRepository) {
		super();
		this.relationCompositionRepository = relationCompositionRepository;
	} 
	
	public  List<RelationComposition>findAll(){
		List<RelationComposition> relationCompositions=new ArrayList<RelationComposition>();
		for(RelationComposition relationComposition:relationCompositionRepository.findAll()){
			relationCompositions.add(relationComposition);
		}
		return relationCompositions;
	}
	
	public void save(RelationComposition relationComposition){
		relationCompositionRepository.save(relationComposition);
	}
	
	public void delete(int id){
		relationCompositionRepository.delete(id);
	}
	public RelationComposition findRelationComposition(int id){
		return relationCompositionRepository.findOne(id);
	}
	
	
}
