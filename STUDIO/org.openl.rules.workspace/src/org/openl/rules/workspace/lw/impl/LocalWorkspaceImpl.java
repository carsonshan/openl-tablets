package org.openl.rules.workspace.lw.impl;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.*;

import org.openl.rules.common.ArtefactPath;
import org.openl.rules.common.ProjectException;
import org.openl.rules.project.abstraction.AProject;
import org.openl.rules.project.abstraction.AProjectArtefact;
import org.openl.rules.project.impl.local.LocalRepository;
import org.openl.rules.repository.api.FileData;
import org.openl.rules.repository.exceptions.RRepositoryException;
import org.openl.rules.workspace.WorkspaceUser;
import org.openl.rules.workspace.lw.LocalWorkspace;
import org.openl.rules.workspace.lw.LocalWorkspaceListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalWorkspaceImpl implements LocalWorkspace {
    private final Logger log = LoggerFactory.getLogger(LocalWorkspaceImpl.class);

    private final WorkspaceUser user;
    private final File location;
    private final Map<String, AProject> localProjects;
    private final List<LocalWorkspaceListener> listeners = new ArrayList<>();
    private final FileFilter localWorkspaceFolderFilter;
    private final FileFilter localWorkspaceFileFilter;
    private final LocalRepository localRepository;

    public LocalWorkspaceImpl(WorkspaceUser user, File location, FileFilter localWorkspaceFolderFilter,
                              FileFilter localWorkspaceFileFilter) {
        this.user = user;
        this.location = location;
        this.localWorkspaceFolderFilter = localWorkspaceFolderFilter;
        this.localWorkspaceFileFilter = localWorkspaceFileFilter;

        localProjects = new HashMap<>();
        localRepository = new LocalRepository(location);
        try {
            localRepository.initialize();
        } catch (RRepositoryException e) {
            throw new IllegalStateException(e);
        }

        loadProjects();
    }

    public void addWorkspaceListener(LocalWorkspaceListener listener) {
        listeners.add(listener);
    }

    @Override
    public LocalRepository getRepository() {
        return localRepository;
    }

    public AProjectArtefact getArtefactByPath(ArtefactPath artefactPath) throws ProjectException {
        String projectName = artefactPath.segment(0);
        AProject lp = getProject(projectName);

        ArtefactPath pathInProject = artefactPath.withoutFirstSegment();
        return lp.getArtefactByPath(pathInProject);
    }

    public File getLocation() {
        return location;
    }

    public AProject getProject(String name) throws ProjectException {
        AProject lp;
        synchronized (localProjects) {
            lp = localProjects.get(name);
        }
        if (lp == null) {
            throw new ProjectException("Cannot find project ''{0}''!", null, name);
        }

        return lp;
    }

    public Collection<AProject> getProjects() {
        synchronized (localProjects) {
            return localProjects.values();
        }
    }

    protected WorkspaceUser getUser() {
        return user;
    }

    public boolean hasProject(String name) {
        synchronized (localProjects) {
            return (localProjects.get(name) != null);
        }
    }

    private void loadProjects() {
        File[] folders = location.listFiles(localWorkspaceFolderFilter);
        if (folders != null) {
            for (File f : folders) {
                String name = f.getName();

                AProject lpi;
                FileData fileData = localRepository.getProjectState(name).getFileData();
                if (fileData == null) {
                    String version = localRepository.getProjectState(name).getProjectVersion();
                    lpi = new AProject(getRepository(), name, version, true);
                } else {
                    lpi = new AProject(getRepository(), fileData, true);
                }
                synchronized (localProjects) {
                    localProjects.put(name, lpi);
                }
            }
        }
    }

    private void notifyRemoved(AProject project) {
        synchronized (localProjects) {
            localProjects.remove(project.getName());
        }
    }

    public void refresh() {
        // check existing
        synchronized (localProjects) {
            localProjects.clear();
        }
        loadProjects();
    }

    public void release() {
        synchronized (localProjects) {
            localProjects.clear();
        }

        try {
            localRepository.close();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        for (LocalWorkspaceListener lwl : new ArrayList<>(listeners)) {
            lwl.workspaceReleased(this);
        }
    }

    public void removeProject(String name) throws ProjectException {
        AProject project = getProject(name);
        notifyRemoved(project);
        project.delete(user);
    }

    public boolean removeWorkspaceListener(LocalWorkspaceListener listener) {
        return listeners.remove(listener);
    }

    public FileFilter getLocalWorkspaceFileFilter() {
        return localWorkspaceFileFilter;
    }
}
