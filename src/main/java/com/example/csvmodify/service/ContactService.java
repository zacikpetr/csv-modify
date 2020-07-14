package com.example.csvmodify.service;

import lombok.SneakyThrows;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

@Slf4j
@Service
public class ContactService {

    public static final String CONTACTS_CSV = "contacts.csv";
    public static final String CONTACTS_ENC = "windows-1250";
    public static final Charset CONTACTS_CS = Charset.forName(CONTACTS_ENC);
    public static final String TMP_DIR = System.getProperty("java.io.tmpdir");
    public static final String EOL = "\r\n";

    @Async
    @Synchronized
    @SneakyThrows
    public void saveContactCSV(String... args) {
        final Path path = Paths.get(TMP_DIR).resolve(CONTACTS_CSV);
        if (!Files.exists(path)) {
            createFile(path);
        }
        final List<String> contacts = Files.readAllLines(path, CONTACTS_CS);
        log.debug("Stored {} contacts: {}", contacts.size() - 1, contacts.toString());
        final String toAdd = String.join(",", args);
        log.debug("We want to add: {}", toAdd);
        if (!contacts.contains(toAdd)) {
            log.info("Adding new record: {}", toAdd);
            Files.writeString(path, toAdd + EOL, CONTACTS_CS, StandardOpenOption.APPEND);
        }
    }

    private void createFile(Path path) throws IOException {
        log.info("Contacts {} file does not exists yet, creating.", path);
        Files.writeString(path, "jmeno,příjmení,email@email.cz" + EOL, CONTACTS_CS, StandardOpenOption.CREATE);
    }
}
