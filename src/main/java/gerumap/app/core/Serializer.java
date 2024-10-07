package gerumap.app.core;

import gerumap.app.repository.implementation.MindMap;
import gerumap.app.repository.implementation.Project;

import java.io.File;

public interface Serializer {

    Project loadProject(File file);
    void saveProject(Project node);
    void saveProjectAs(Project node);
    MindMap loadScheme(File file);
    void saveScheme(MindMap node);

}
