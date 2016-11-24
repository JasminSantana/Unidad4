package boot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity(name="relation_composition")
public class RelationComposition implements Serializable {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="relation1_id")
	private int relation1Id;
	@Column(name="relation2_id")
	private int relation2Id;
	@Column(name="inferred_relation_id")
	private int inferredRelationId;
	public RelationComposition( int relation1Id, int relation2Id, int inferredRelationId) {
		super();
	
		this.relation1Id = relation1Id;
		this.relation2Id = relation2Id;
		this.inferredRelationId = inferredRelationId;
	}
	public RelationComposition() {
		this(0,0,0);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRelation1Id() {
		return relation1Id;
	}
	public void setRelation1Id(int relation1Id) {
		this.relation1Id = relation1Id;
	}
	public int getRelation2Id() {
		return relation2Id;
	}
	public void setRelation2Id(int relation2Id) {
		this.relation2Id = relation2Id;
	}
	public int getInferredRelationId() {
		return inferredRelationId;
	}
	public void setInferredRelationId(int inferredRelationId) {
		this.inferredRelationId = inferredRelationId;
	}
	@Override
	public String toString() {
		return "RelationComposition [id=" + id + ", relation1Id=" + relation1Id + ", relation2Id=" + relation2Id
				+ ", inferredRelationId=" + inferredRelationId + "]";
	}
	
	
}
