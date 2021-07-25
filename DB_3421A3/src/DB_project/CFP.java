package DB_project;

import java.sql.Date;


public class CFP {
	private String name="";
	private String url="";
	private String text="";
	private String city="";
	private String country="";
	private String date="0000-00-00";
	private String publisher = "";
	private String journalname="";
	private String id=null;
	private String typeString=null;

	
	CFP(Builder builder) {
		this.name = builder.name;
		this.url = builder.url;
		this.text = builder.text;
		this.city = builder.city;
		this.country = builder.country;
		this.date = builder.date;
		this.publisher = builder.publisher;
		this.journalname = builder.journalname;
		this.id = builder.id;
		this.typeString = builder.typeString;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getJournalname() {
		return journalname;
	}
	public void setJournalname(String journalname) {
		this.journalname = journalname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTypeString() {
		return typeString;
	}
	public void setTypeString(String typeString) {
		this.typeString = typeString;
	}
	
	public String display() {
		return "Name: "+name+"\nID: "+id+"\nType: "+typeString+"\nURL: "+url+"\nText: "+text+"\nCity: "+city+"\nCountry: "+country+"\nDate: "+date+"\nPublisher: "+publisher+"\nJournal Name: "+journalname;
	}
	
	/**
	 * Creates builder to build {@link CFP}.
	 * @return created builder
	 */
	public static Builder builder() {
		return new Builder();
	}
	
	
	/**
	 * Builder to build {@link CFP}.
	 */
	public static final class Builder {
		private String name;
		private String url;
		private String text;
		private String city;
		private String country;
		private String date;
		private String publisher;
		private String journalname;
		private String id;
		private String typeString;

		private Builder() {
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withUrl(String url) {
			this.url = url;
			return this;
		}

		public Builder withText(String text) {
			this.text = text;
			return this;
		}

		public Builder withCity(String city) {
			this.city = city;
			return this;
		}

		public Builder withCountry(String country) {
			this.country = country;
			return this;
		}

		public Builder withDate(String date) {
			this.date = date;
			return this;
		}

		public Builder withPublisher(String publisher) {
			this.publisher = publisher;
			return this;
		}

		public Builder withJournalname(String journalname) {
			this.journalname = journalname;
			return this;
		}

		public Builder withId(String id) {
			this.id = id;
			return this;
		}

		public Builder withTypeString(String typeString) {
			this.typeString = typeString;
			return this;
		}

		public CFP build() {
			return new CFP(this);
		}
	}

	
}
