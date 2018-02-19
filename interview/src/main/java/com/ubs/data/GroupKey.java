package com.ubs.data;

public class GroupKey {
	private String cityOrCountry = null;
	private String creditRating = null;
	
	public GroupKey(String city,String country,  String creditRating) {
		this.cityOrCountry = country;
		if(cityOrCountry == null || cityOrCountry.trim().length() == 0) {
			this.cityOrCountry = city;
		}
		
		this.creditRating = creditRating;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cityOrCountry == null) ? 0 : cityOrCountry.hashCode());
		result = prime * result + ((creditRating == null) ? 0 : creditRating.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupKey other = (GroupKey) obj;
		if (cityOrCountry == null) {
			if (other.cityOrCountry != null)
				return false;
		} else if (!cityOrCountry.equals(other.cityOrCountry))
			return false;
		if (creditRating == null) {
			if (other.creditRating != null)
				return false;
		} else if (!creditRating.equals(other.creditRating))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "GroupKey [countryOrCity=" + cityOrCountry + ", creditRating=" + creditRating + "]";
	}

	
}
