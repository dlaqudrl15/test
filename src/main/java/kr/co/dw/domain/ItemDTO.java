package kr.co.dw.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ItemDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int iId;
	private String iName;
	private int iPrice;
	private int iDc;
	private int iCount;
	private List<String> ifilenameList;
	private String ifilename;
	private String i_CATEGORY;
	public ItemDTO() {
		// TODO Auto-generated constructor stub
	}
	public ItemDTO(int iId, String iName, int iPrice, int iDc, int iCount, String ifilename,
			String i_CATEGORY) {
		super();
		this.iId = iId;
		this.iName = iName;
		this.iPrice = iPrice;
		this.iDc = iDc;
		this.iCount = iCount;
		this.ifilename = ifilename;
		this.i_CATEGORY = i_CATEGORY;
	}
	public ItemDTO(int iId, String iName, int iPrice, int iDc, int iCount, List<String> ifilenameList, String ifilename,
			String i_CATEGORY) {
		super();
		this.iId = iId;
		this.iName = iName;
		this.iPrice = iPrice;
		this.iDc = iDc;
		this.iCount = iCount;
		this.ifilenameList = ifilenameList;
		this.ifilename = ifilename;
		this.i_CATEGORY = i_CATEGORY;
	}
	public int getiId() {
		return iId;
	}
	public void setiId(int iId) {
		this.iId = iId;
	}
	public String getiName() {
		return iName;
	}
	public void setiName(String iName) {
		this.iName = iName;
	}
	public int getiPrice() {
		return iPrice;
	}
	public void setiPrice(int iPrice) {
		this.iPrice = iPrice;
	}
	public int getiDc() {
		return iDc;
	}
	public void setiDc(int iDc) {
		this.iDc = iDc;
	}
	public int getiCount() {
		return iCount;
	}
	public void setiCount(int iCount) {
		this.iCount = iCount;
	}
	public List<String> getIfilenameList() {
		return ifilenameList;
	}
	public void setIfilenameList(List<String> ifilenameList) {
		this.ifilenameList = ifilenameList;
	}
	public String getIfilename() {
		return ifilename;
	}
	public void setIfilename(String ifilename) {
		this.ifilename = ifilename;
	}
	public String getI_CATEGORY() {
		return i_CATEGORY;
	}
	public void setI_CATEGORY(String i_CATEGORY) {
		this.i_CATEGORY = i_CATEGORY;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(iId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemDTO other = (ItemDTO) obj;
		return iId == other.iId;
	}
	@Override
	public String toString() {
		return "ItemDTO [iId=" + iId + ", iName=" + iName + ", iPrice=" + iPrice + ", iDc=" + iDc + ", iCount=" + iCount
				+ ", ifilenameList=" + ifilenameList + ", ifilename=" + ifilename + ", i_CATEGORY=" + i_CATEGORY + "]";
	}
	
	
	
}
