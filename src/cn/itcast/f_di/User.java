package cn.itcast.f_di;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class User {
	// 一般的类型
	private Long id;
	private String name = "无名氏";
	private boolean gender;
	private Date birthday;

	// 引用的其他类型
	private UserDao userDao;

	// 集合的类型
	private Set<String> addressSet; // 指定强类型时，可以自动转型。
	private Set integerSet; // 没有指定强类型时，默认为String型。

	private List<String> addressList;
	private Map<String, String> addressMap;
	private String[] addressArray;
	private Properties myProps;

	public void printInfo() {
		System.out.println("id = " + id);
		System.out.println("name = " + name);
		System.out.println("gender = " + gender);
		System.out.println("birthday = " + new SimpleDateFormat("yyyy-MM-dd").format(birthday));
		System.out.println("userDao = " + userDao);
		System.out.println("addressSet = " + addressSet);
		System.out.println("integerSet = " + integerSet);
		System.out.println(">> " + integerSet.iterator().next().getClass());
		System.out.println("addressList = " + addressList);
		System.out.println("addressMap = " + addressMap);
		System.out.println("addressArray = " + Arrays.toString(addressArray));
		System.out.println("myProps = " + myProps);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Set<String> getAddressSet() {
		return addressSet;
	}

	public void setAddressSet(Set<String> addressSet) {
		this.addressSet = addressSet;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setIntegerSet(Set integerSet) {
		this.integerSet = integerSet;
	}

	public List<String> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<String> addressList) {
		this.addressList = addressList;
	}

	public Map<String, String> getAddressMap() {
		return addressMap;
	}

	public void setAddressMap(Map<String, String> addressMap) {
		this.addressMap = addressMap;
	}

	public Set getIntegerSet() {
		return integerSet;
	}

	public Properties getMyProps() {
		return myProps;
	}

	public void setMyProps(Properties myProps) {
		this.myProps = myProps;
	}

	public String[] getAddressArray() {
		return addressArray;
	}

	public void setAddressArray(String[] addressArray) {
		this.addressArray = addressArray;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
