package br.com.phptravels.managers;

import br.com.phptravels.data_provider.ConfigFileReader;

public class FileReaderManager {

	private static FileReaderManager FILE_READER_MANAGER = new FileReaderManager();
	private static ConfigFileReader CONFIG_FILE_READER;

	private FileReaderManager() {
	}

	public static FileReaderManager getInstance() {
		return FILE_READER_MANAGER;
	}

	public ConfigFileReader getConfigReader() {
		return (CONFIG_FILE_READER == null) ? new ConfigFileReader() : CONFIG_FILE_READER;
	}
}