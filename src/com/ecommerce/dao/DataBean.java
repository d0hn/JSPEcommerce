package com.ecommerce.dao;



import java.io.Serializable;
/**
 * <h2>DataBean</h2>
 * <p>To make Java Bean accessible, setters and getters had to be
 * introduced</p>
 * 
 * 
 * @author Mac
 *
 */
public class DataBean implements Serializable {
	
	private String title;
	private int recordId;
	private int duration;
	private String catName;
	private String artistName;
	private String img;
	private int noTra;
	private float pric;
	private int stockCo;
	private int singleid;
	private String singleTitle;
	private int singleDuration;
	public DataBean() {

	}

	public DataBean(String tit, int recId, int dur, String cat, String artName, 
			String imgPath, int numTracks, float price, int stock, 
			int singlei, int singleDuratio, String singleTitl) {
	title = tit; // Title
	img = imgPath; //Image name
	recordId = recId; //Recording id
	duration = dur; //duration
	catName = cat; //category name
	artistName = artName; //artist Name
	noTra = numTracks; // track number
	pric = price;
	singleid = singlei;
	singleDuration = singleDuratio;
	singleTitle = singleTitl;
	stockCo = stock; //stock count
	}

	public float getPrice() {
		return pric;
	}
	public int getSingleId() {
		return singleid;
	}
	public String getSingleTitle() {
		return singleTitle;
	}
	public int getSignleDuration() {
		return singleDuration;
	}
	public int getTracks() {
		return noTra;
	}
	public int getStock() {
		return stockCo;
	}
	
	public String getTitle() {
		return title;
	}
	public String getImg() {
		return img;
	}
	public String getArtist() {
		return artistName;
	}
	
	public int getRecordId() {
		return recordId;
	}
	public String getCatName() {
		return catName;
	}
	public int getDuration() {
		return duration;
	}
	
	public void setSingleId(int singleid) {
		this.singleid = singleid;
	}
	public void setSingleTitle(String singleTitle) {
		this.singleTitle = singleTitle;
	}
	public void setSingleDuration(int singleDuration) {
		this.singleDuration = singleDuration;
	}
	public void setStock(int stockCo) {
		this.stockCo = stockCo;
	}
	public void setPrice(float pric) {
		this.pric = pric;
	}
	public void setTracks(int noTra) {
		this.noTra = noTra;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	public void setArtist(String artistName) {
		this.artistName = artistName;
	}
	
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		if(title != null && catName == null && duration > 0) {
		return "Music [title=" + title + ", recordId=" + recordId
				+ ", duration=" + duration + ", artist="+ artistName +"]";
		}
		if(title != null && duration != 0) {
			return "Artist [artist=" + artistName + ", RecordId=" + recordId + ", Title= " + title
					+ ", Category= " +catName + ", ImagePath= " + img + ", NoTracks= " + noTra + ", Price= " + pric
					+ ", StockCo= " + stockCo + "]";
		}
		if(catName != null && img == null && singleTitle == null) {
		return "Category [name=" + catName +"]";	
		}
		if(artistName != null && img ==null && singleTitle == null) {
			return "Artist [artist=" + artistName + "]";
		}
		if(img != null) {
			return "Artist [artist=" + artistName + ", RecordId=" + recordId + ", Title= " + title
					+ ", Category= " +catName + ", ImagePath= " + img + ", NoTracks= " + noTra + ", Price= " + pric
					+ ", StockCo= " + stockCo + "]";
		}
		if(singleTitle != null && img==null) {
			return "Single= " + singleid + ", SingleTitle= " +
					singleTitle + ", Duration= " + singleDuration + "]";
		}
		return null;
	}
}
