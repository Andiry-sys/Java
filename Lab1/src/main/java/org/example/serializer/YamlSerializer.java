package org.example.serializer;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class YamlSerializer<T> implements Serializer{

    private final Yaml yaml ;
    private final Class<T> clazz;

    public YamlSerializer(Class<T> clazz) {
        this.clazz = clazz;
        this.yaml = new Yaml();
    }

    @Override
    public void serialize(Object entity, File file) throws IOException {
        try (FileWriter writer = new FileWriter(file)) {
            yaml.dump(entity, writer);
        } catch (IOException e) {
            // Log the exception or handle it as necessary
            System.err.println("Error while serializing to YAML: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Serialization failed", e);
        }
    }

    @Override
    public T deserialize(File file) throws IOException {
        try (FileReader reader = new FileReader(file)) {
            return yaml.loadAs(reader, clazz);
        }
    }
}
