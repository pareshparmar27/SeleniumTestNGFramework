package config;

public class Config {

	private String browser;
	private String application;
	private Long lowWait;
	private Long mediumWait;
	private Long highWait;

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public Long getLowWait() {
		return lowWait;
	}

	public void setLowWait(Long lowWait) {
		this.lowWait = lowWait;
	}

	public Long getMediumWait() {
		return mediumWait;
	}

	public void setMediumWait(Long mediumWait) {
		this.mediumWait = mediumWait;
	}

	public Long getHighWait() {
		return highWait;
	}

	public void setHighWait(Long highWait) {
		this.highWait = highWait;
	}

}
