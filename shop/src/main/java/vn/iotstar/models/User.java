package vn.iotstar.models;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int _id;
	private String firstname;
	private String lastname;
	private String slug;
	private String id_card;
	private String email;
	private String phone;
	private int isEmailActive;
	private int isPhoneActive;
	private String hashed_password;
	private String address;
	private int roleid;
	private String avatar;
	private String cover;
	private int point;
	private String e_wallet;
	private Date createdAt;
	
	public User() {
		super();
	}

	public int get_Id() {
		return _id;
	}

	public void set_Id(int id) {
		this._id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getId_card() {
		return id_card;
	}

	public void setId_card(String id_card) {
		this.id_card = id_card;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getIsEmailActive() {
		return isEmailActive;
	}

	public void setIsEmailActive(int isEmailActive) {
		this.isEmailActive = isEmailActive;
	}

	public int getIsPhoneActive() {
		return isPhoneActive;
	}

	public void setIsPhoneActive(int isPhoneActive) {
		this.isPhoneActive = isPhoneActive;
	}

	public String getHashed_password() {
		return hashed_password;
	}

	public void setHashed_password(String hashed_password) {
		this.hashed_password = hashed_password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getE_wallet() {
		return e_wallet;
	}

	public void setE_wallet(String e_wallet) {
		this.e_wallet = e_wallet;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

	public User(int _id, String firstname,String slug, String email, String phone,String hashed_password, int roleid) {
		super();
		this._id = _id;
		this.firstname = firstname;
		this.slug = slug;
		this.email = email;
		this.phone = phone;
		this.hashed_password = hashed_password;
		this.roleid = roleid;
	}

	@Override
	public String toString() {
		return "User [id=" + _id + ", firstname=" + firstname + ", lastname=" + lastname + ", slug=" + slug
				+ ", id_card=" + id_card + ", email=" + email + ", phone=" + phone + ", isEmailActive=" + isEmailActive
				+ ", isPhoneActive=" + isPhoneActive + ", hashed_password=" + hashed_password + ", address=" + address
				+ ", roleid=" + roleid + ", avatar=" + avatar + ", cover=" + cover + ", point=" + point + ", e_wallet="
				+ e_wallet + ", createdAt=" + createdAt + "]";
	}
	
	
	
	
	

}
