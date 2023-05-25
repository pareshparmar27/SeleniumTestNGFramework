package utils;

import java.io.InputStream;

import config.Config;

public final class FileUtil {

	public static Config readConfig() {
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.yml");
		return Marshalling.from(inputStream, Config.class);
	}

}
