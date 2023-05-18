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
import jakarta.servlet.http.Part;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//@Component("dummy")
@Named
@RequestScoped
public class FileUploadViewCore {

    private List<Part> files;
    
    public void submit() {
        for (Part part : files) {
            String name = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            long size = part.getSize();
            System.out.println(name);            
        }
    }
    
    public List<Part> getFiles() {
        return files;
    }
    
    public void setFiles(List<Part> files) {
        this.files = files;
    }


}
