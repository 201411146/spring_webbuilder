package com.company.people.noteboxdao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.company.people.noteboxdto.PeopleNoteboxDTO;

@Repository
public class PeopleNoteboxDAOImpl implements PeopleNoteboxDAO {

	@Inject
	private SqlSession sql;

	private static String namespace = "com.company.mappers.people.peopleNoteboxMapper";
	
	//지원하기
	@Override
	public void apply(String sitename, PeopleNoteboxDTO dto) {
		// TODO Auto-generated method stub
		
		HashMap data = new HashMap();
		
		data.put("sitename", sitename);
		data.put("boardid", dto.getBoardid());
		data.put("touserid", dto.getTouserid());
		data.put("fromuserid", dto.getFromuserid());
		data.put("title", dto.getTitle());
		//data.put("image", dto.getImage());
		data.put("content", dto.getContent());
		
		sql.insert(namespace + ".apply", data); 
	}

	//받은쪽지함
	@Override
	public List<PeopleNoteboxDTO> receive(String sitename, String userid) {
		// TODO Auto-generated method stub
		HashMap data = new HashMap();
		data.put("sitename", sitename);
		data.put("userid", userid);
		return sql.selectList(namespace + ".receive",data);
	}
}
