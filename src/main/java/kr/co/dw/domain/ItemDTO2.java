//package kr.co.dw.domain;
//
//import java.io.Serializable;
//import java.util.List;
//import java.util.Objects;
//
//public class ItemDTO2 implements Serializable{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private int iId;
//	private String iName;
//	private int iPrice;
//	private int iDc;
//	private int iCount;
//	private List<String> ifilename;
//	private String filename;
//	public ItemDTO2() {
//		// TODO Auto-generated constructor stub
//	}
//
//	
//	public ItemDTO2(int iId, String iName, int iPrice, int iDc, int iCount, String filename) {
//		super();
//		this.iId = iId;
//		this.iName = iName;
//		this.iPrice = iPrice;
//		this.iDc = iDc;
//		this.iCount = iCount;
//		
//		this.ifilename = ifilename;
//	}
//	
//	public ItemDTO2(int iId, String iName, int iPrice, int iDc, int iCount, List<String> ifilename, String filename) {
//		super();
//		this.iId = iId;
//		this.iName = iName;
//		this.iPrice = iPrice;
//		this.iDc = iDc;
//		this.iCount = iCount;
//		this.ifilename = ifilename;
//		this.filename = filename;
//	}
//
//	public int getiId() {
//		return iId;
//	}
//
//	public void setiId(int iId) {
//		this.iId = iId;
//	}
//
//	public String getiName() {
//		return iName;
//	}
//
//	public void setiName(String iName) {
//		this.iName = iName;
//	}
//
//	public int getiPrice() {
//		return iPrice;
//	}
//
//	public void setiPrice(int iPrice) {
//		this.iPrice = iPrice;
//	}
//
//	public int getiDc() {
//		return iDc;
//	}
//
//	public void setiDc(int iDc) {
//		this.iDc = iDc;
//	}
//
//	public int getiCount() {
//		return iCount;
//	}
//
//	public void setiCount(int iCount) {
//		this.iCount = iCount;
//	}
//
//	public List<String> getIfilename() {
//		return ifilename;
//	}
//
//	public void setIfilename(List<String> ifilename) {
//		this.ifilename = ifilename;
//	}
//
//	public String getFilename() {
//		return filename;
//	}
//
//	public void setFilename(String filename) {
//		this.filename = filename;
//	}
//
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(iId);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		ItemDTO2 other = (ItemDTO2) obj;
//		return iId == other.iId;
//	}
//
//	@Override
//	public String toString() {
//		return "ItemDTO [iId=" + iId + ", iName=" + iName + ", iPrice=" + iPrice + ", iDc=" + iDc + ", iCount=" + iCount
//				+ ", ifilename=" + ifilename + ", filename=" + filename + "]";
//	}
//	
//	
//}
