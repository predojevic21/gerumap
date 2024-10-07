package gerumap.app.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import gerumap.app.core.Serializer;
import gerumap.app.repository.composite.MapNode;
import gerumap.app.repository.elements.Pojam;
import gerumap.app.repository.elements.Veza;
import gerumap.app.repository.implementation.Element;
import gerumap.app.repository.implementation.MindMap;
import gerumap.app.repository.implementation.Project;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Annotation;

public class GsonSerializer implements Serializer {

    private final Gson gson;

    public GsonSerializer(){
        RuntimeTypeAdapterFactory<MapNode> adapter=RuntimeTypeAdapterFactory
                .of(MapNode.class)
                .registerSubtype(MindMap.class)
                .registerSubtype(Element.class)
                .registerSubtype(Pojam.class)
                .registerSubtype(Veza.class);

        gson=new GsonBuilder().registerTypeAdapterFactory(adapter).create();

    }


    @Override
    public Project loadProject(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            return gson.fromJson(fileReader, Project.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void saveProject(Project project) {
        try (FileWriter writer = new FileWriter(project.getFilePath())) {
            gson.toJson(project, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveProjectAs(Project project) {
        try (FileWriter writer = new FileWriter(project.getFilePath())) {
            gson.toJson(project, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MindMap loadScheme(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            return gson.fromJson(fileReader, MindMap.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void saveScheme(MindMap node) {
        try (FileWriter writer =
                     new FileWriter("src/main/resources/schemes/" + node.getName() + ".json")) {
            gson.toJson(node, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
