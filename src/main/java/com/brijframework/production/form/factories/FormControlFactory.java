package com.brijframework.production.form.factories;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ConcurrentHashMap;

import com.brijframework.production.form.FormControl;
import com.brijframework.production.schema.factories.JsonSchemaMetaFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FormControlFactory {

	private static final String CLASSES = "classes";

	private static final String REPLACEMENT = "/";

	private static final String REGEX = "\\\\";

	final ConcurrentHashMap<String, FormControl> cache = new ConcurrentHashMap<String, FormControl>();

	final String beans = "/meta/form";

	// singleton pattern
	private static FormControlFactory instance = null;

	public ConcurrentHashMap<String, FormControl> getCache() {
		return cache;
	}

	public static FormControlFactory getInstance() {
		synchronized (FormControlFactory.class) {
			if (instance == null) {
				instance = new FormControlFactory();
			}
			return instance;
		}
	}

	private FormControlFactory() {
		this.init();
	}

	private void init() {
		URL resource = FormControlFactory.class.getResource(beans);
		try {
			Files.list(Paths.get(resource.toURI())).forEach(file -> {
				String resourcepath = file.toAbsolutePath().toString().split(CLASSES)[1];
				load(resourcepath);
			});
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	private void load(String resourcepath) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			resourcepath=resourcepath.replaceAll(REGEX, REPLACEMENT);
			InputStream inJson = JsonSchemaMetaFactory.class.getResourceAsStream(resourcepath);
			FormControl formControl = objectMapper.readValue(inJson, FormControl.class);
			getCache().put(formControl.getId(), formControl);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		FormControlFactory instance = FormControlFactory.getInstance();
		System.out.println(instance.getCache());
	}
}
