package kr.co.dw.repository.item;

import java.util.List;

import kr.co.dw.domain.ItemDTO;

public interface ItemDAO {

	void insert(ItemDTO iDto);

	void upload(int iId, String filename);

	List<ItemDTO> select();

	List<String> getfile(int iId);

	ItemDTO read(int iId);

	List<ItemDTO> adminlist();

	List<ItemDTO> categoryList(String category);

	

	

}
