package com.neusoft.cargo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import net.sf.oval.constraint.NotEmpty;

//'#########################################################################
//'#                            CHANGE LOG
//'#########################################################################
//'# Author      : 段旭东
//'# Auditor     : jane.gu[Double Checker] /审计员
//'# Modified    : 2009-1-12 16:00
//'# Task No     : 90033 [MYZHAOPINA注册时检查用户EMAIL是否可用BUG]
//'# Requirement : [需求人-技术部 赵永江]
//'# Purpose     : 进行用户EMAIL检测提交时增加当前时间参数
//'# Scope       : My.zhaopin.com
//'# Risk        : [修改带来的潜在风险]
//'# Approved by : [ruud.zhao]
//'########################################################################

/*
	可以增加一个账号属性
	    '0' : '登录成功!',
        '11' : '密码至少应包含 6 个字符！',
        '13' : '您的IP已经被列为黑名单！',
        '14' : '您的邮箱已经被列为黑名单！',
        '15' : '您的邮箱域名已经被列为黑名单',
        '21' : '登录过于频繁！',
        '22' : '账号不存在，请确认后重新输入',
        '23' : '您输入的密码与账号不匹配！',
        '30' : '未注册的Email地址！',
        '33' : '您的账户已经被冻结！',
        '34' : '您的账户已经被注销！',
        '35' : '您的账户已经被锁定！',
        '36' : '您的IP已经被锁定！',
        '37' : '用户名密码输入超过3次需要弹出验证码输入框!',//您的操作过于频繁，请输入验证码
        '38' : '请输入正确的验证码！',
        '51' : '手机登录失败！',
        //前端自定义错误信息 code  errormsg
        '$001' : '请输入账号！',
        '$002' : '登录名至少应包含 5 个字符！',
        '$003' : '请输入密码！',
        '$004' : '密码至少应包含 6 个字符！',
        '$005' : '请输入验证码！'
 */
@Entity(name="User")
public class User implements Serializable {

	public User() {
	}

	public User(String username, String password, String phone, String email, String ID_NUM, String TRUE_NAME,
			String salt, boolean authentication) {

		this.password = password;
		this.phone = phone;
		this.username = username;
		this.email = email;
		this.ID_NUM = ID_NUM;
		this.TRUE_NAME = TRUE_NAME;
		this.hasauthentication = authentication;
	}

	/*
	 * 是否经过验证
	 */
	private boolean hasauthentication;

	public boolean isHasauthentication() {
		return hasauthentication;
	}

	public void setHasauthentication(boolean hasauthentication) {
		this.hasauthentication = hasauthentication;
	}


	//
	private String img;
	
	
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	private static final long serialVersionUID = 1L;
	@Id
	// Auto 主键由程序控制
	// IDENTITY 主键由数据库自动生成（主要是自动增长型）
	// SEQUENCE 根据底层数据库的序列来生成主键，条件是数据库支持序列
	// Table 使用一个特定的数据库表格来保存主键
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid")
	private Long id;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotEmpty(message = "用户名不能为空")
	@Column(unique = true)
	private String username;
	@NotNull
	private String phone;
	@NotNull
	private String password;
	@NotNull
	private String email;
	@Enumerated(EnumType.STRING)
	private UserType usertype;
	// 通常情况下，当字段经过散列处理（如MD5），会生成一段散列值，而散列后的值一般是无法通过特定算法
	// 得到原始字段的。但是某些情况，比如一个大型的彩虹表，通过在表中搜索该MD5值，很有可能在极短的时间
	// 内找到该散列值对应的真实字段内容。
	// 加盐后的散列值，可以极大的降低由于用户数据被盗而带来的密码泄漏风险，即使通过彩虹表寻找到了散列后
	// 的数值所对应的原始内容，但是由于经过了加盐，插入的字符串扰乱了真正的密码，使得获得真实密码的概率大大降低。
	private String salt;
	private Boolean locked = Boolean.FALSE;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", nullable = true, columnDefinition = "timestamp default current_timestamp")
	private Date createDate = new Date();

	
	/*
	 * cascade：为级联操作，里面有级联保存，级联删除等，all为所有 fetch：加载类型，有lazy和eager二种，
	 * eager为急加载，意为立即加载，在类加载时就加载，lazy为慢加载，第一次调用的时候再加载，由于数据量太大，onetomany一般为lazy
	 * mappedBy：这个为manytoone中的对象名，这个不要变哦 Set<role>：这个类型有两种，一种为list另一种为set
	 */
	@OneToMany(targetEntity = Role.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Role> roles = new HashSet<>(); // 一个用户具有多个角色

	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Car> cars = new ArrayList<Car>();

	
	@OneToMany(mappedBy = "toperson", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Message> ToMessages = new ArrayList<Message>();

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private  UserAuthInfo userAuthInfo;
	

	public UserAuthInfo getUserAuthInfo() {
		return userAuthInfo;
	}

	public void setUserAuthInfo(UserAuthInfo userAuthInfo) {
		this.userAuthInfo = userAuthInfo;
	}

	public List<Message> getToMessages() {
		return ToMessages;
	}

	public void setToMessages(List<Message> toMessages) {
		ToMessages = toMessages;
	}

	@OneToMany(fetch=FetchType.EAGER,mappedBy = "_user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CargoResource> CargoResources = new ArrayList<CargoResource>();

	public void addCar(Car phone) {
		cars.add(phone);
		phone.setUser(this);
	}

	public void removeCar(Car phone) {
		cars.remove(phone);
		phone.setUser(null);
	}

	// cascade属性的可能值有
	// all: 所有情况下均进行关联操作，即save-update和delete。
	// none: 所有情况下均不进行关联操作。这是默认值。
	// save-update: 在执行save/update/saveOrUpdate时进行关联操作。
	// delete: 在执行delete 时进行关联操作。
	// all-delete-orphan:
	// 当一个节点在对象图中成为孤儿节点时，删除该节点。比如在一个一对多的关系中，Student包含多个book，当在对象关系中删除一个book时，此book即成为孤儿节点。
	// 像你的问题，设置成save-update就可以了
	// @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public List<CargoResource> getCargoResources() {
		return CargoResources;
	}

	public void setCargoResources(List<CargoResource> cargoResources) {
		CargoResources = cargoResources;
	}

	public Set<Role> getRoleList() {
		return roles;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	@Transient
	public Set<String> getRolesName() {
		Set<Role> roles = getRoleList();
		Set<String> set = new HashSet<String>();
		for (Role role : roles) {
			set.add(role.getRole());
		}
		return set;
	}

	// 新添加 身份证号 和真实姓名

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getCredentialsSalt() {
		return username + salt;
	}

	public Boolean getLocked() {
		return locked;
	}

	private String ID_NUM;

	public String getID_NUM() {
		return ID_NUM;
	}

	public void setID_NUM(String iD_NUM) {
		ID_NUM = iD_NUM;
	}

	public String getTRUE_NAME() {
		return TRUE_NAME;
	}

	public void setTRUE_NAME(String tRUE_NAME) {
		TRUE_NAME = tRUE_NAME;
	}

	@Column(name = "TRUE_NAME", nullable = true, length = 32)
	private String TRUE_NAME;

	public UserType getUsertype() {
		return usertype;
	}

	public void setUsertype(UserType usertype) {
		this.usertype = usertype;
	}

	public static enum UserType {
		DRIVER, OWNER
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}
	
	

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		User user = (User) o;

		if (id != null ? !id.equals(user.id) : user.id != null)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + ", salt='"
				+ salt + '\'' + ", locked=" + locked + '}';
	}

}
