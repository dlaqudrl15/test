package kr.co.dw.service.item;

import java.util.List;

import kr.co.dw.domain.ItemDTO;

public interface itemService {

	void insert(ItemDTO iDto);

	List<ItemDTO> select();

	List<String> getfile(int iId);

	ItemDTO read(int iId);

	List<ItemDTO> adminlist();

	List<ItemDTO> categoryList(String category);

	

}
