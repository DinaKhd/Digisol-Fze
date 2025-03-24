package com.task.expedia.data;

public class Expedia {

	private OfferInfo offerInfo;

	private UserInfo userInfo;

	private DebugInfo debugInfo;

	private AbInfo abInfo;

	private PricingSummaries pricingSummaries;

	private Offers offers;

	public OfferInfo getOfferInfo() {
		return offerInfo;
	}

	public void setOfferInfo(OfferInfo offerInfo) {
		this.offerInfo = offerInfo;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public DebugInfo getDebugInfo() {
		return debugInfo;
	}

	public void setDebugInfo(DebugInfo debugInfo) {
		this.debugInfo = debugInfo;
	}

	public AbInfo getAbInfo() {
		return abInfo;
	}

	public void setAbInfo(AbInfo abInfo) {
		this.abInfo = abInfo;
	}

	public PricingSummaries getPricingSummaries() {
		return pricingSummaries;
	}

	public void setPricingSummaries(PricingSummaries pricingSummaries) {
		this.pricingSummaries = pricingSummaries;
	}

	public Offers getOffers() {
		return offers;
	}

	public void setOffers(Offers offers) {
		this.offers = offers;
	}

	@Override
	public String toString() {
		return "{" +
				"offerInfo=" + offerInfo +
				", userInfo=" + userInfo +
				", debugInfo=" + debugInfo +
				", abInfo=" + abInfo +
				", pricingSummaries=" + pricingSummaries +
				", offers=" + offers +
				'}';
	}
}
