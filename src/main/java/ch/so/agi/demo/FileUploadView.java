package ch.so.agi.demo;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FilesUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.model.file.UploadedFiles;
import org.springframework.stereotype.Component;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//@Component("dummy")
@Named
@RequestScoped
public class FileUploadView {

    private UploadedFile file;
    private UploadedFiles files;
    
    private List<String> foo = new ArrayList<>();

    public String getText() {
        return "Hello from Spring: " + LocalDateTime.now();
    }
    
    
    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        System.out.println(Thread.currentThread().getId());
        System.out.println(event.getFile().getFileName());
        System.out.println(event.getSource());
        System.out.println(event.getComponent());
        System.out.println(event.getFacesContext());
        
        foo.add(event.getFile().getFileName());
    }

    public int getSize() {
        return foo.size();
    }
    
    public void handleFilesUpload(FilesUploadEvent event) {
        for (UploadedFile f : event.getFiles().getFiles()) {
            FacesMessage message = new FacesMessage("Successful", f.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

}
