package thrillio.entities;

import thrillio.partners.Sharable;

public class Weblink extends Bookmark implements Sharable{
	private String url;
	private String host;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	@Override
	public String toString() {
		return "Weblink [url=" + url + ", host=" + host + "]";
	}

	@Override
	public boolean isKidFriendly() {
		if(url.contains("porn") || getTitle().contains("porn") || host.contains("adult"))
			return false;
		return true;
	}

	@Override
	public String getItemData() {
		
		StringBuilder xmlData = new StringBuilder();
		
		xmlData.append("<item>");
			xmlData.append("<type>Weblink</type>");
			xmlData.append("<title>"+getTitle()+"</title>");
			xmlData.append("<url>"+url+"</url>");
			xmlData.append("<host>"+host+"</host>");
		xmlData.append("</item>");	
			
		return xmlData.toString();	
	}

}
