package thirdparty.com.fasterxml.jackson;

/**
 * POJO
 * 
 * @since 2020-01-17
 * @author fixalot@lotte.net
 */
public class PlainObject {
	private String name;
	private Integer age;
	private boolean dead;

	public PlainObject() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	@Override
	public String toString() {
		return "PlainObject [name=" + name + ", age=" + age + ", dead=" + dead + "]";
	}
}
