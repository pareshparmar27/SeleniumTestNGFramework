package utils;

import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class Marshalling {

	public static <K> K from(InputStream inputStream, Class<K> as) {
		Yaml yaml = new Yaml(new Constructor(as));
		return yaml.load(inputStream);
	}

}
