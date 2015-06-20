package ba.bitcamp.task234;

/**
 * Class representing books author.
 * 
 * @author Semir
 *
 */
public class Author {

	private String name;
	private String email;
	private String gender;

	/**
	 * Constructor.
	 * 
	 * @param name
	 *            Author`s name
	 * @param email
	 *            Email address
	 * @param gender
	 *            Gender
	 */
	public Author(String name, String email, String gender) {
		super();
		this.name = name;
		this.email = email;
		this.gender = gender;
	}

	/**
	 * @return Authors name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            Authors name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Authors email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            Authors email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return Authors gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            Authors gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Author [name=" + name + ", email=" + email + ", gender="
				+ gender + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Author))
			return false;
		Author other = (Author) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
